package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


import dao.UsuarioDao;
import entity.Usuario;
import entity.UsuarioView;
import utilities.Encriptacion;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDao usuarioDao;
	UsuarioView usuarioView;
	Usuario usu;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		String cerrar = request.getParameter("cerrar");

		if (cerrar != null) {
			request.getSession().removeAttribute("id_usuario");
			request.getSession().removeAttribute("usuario");
			request.getSession().removeAttribute("tipo_usuario");
			request.getSession().removeAttribute("nombrecompleto");
			request.getSession().invalidate();
			response.sendRedirect("index.html");

		}else if (opcion.equals("listar_usuarios")) {
			
			usuarioView = new UsuarioView();
			
			try {
				
				usuarioDao= new UsuarioDao();
				
				List<UsuarioView> usuarios= usuarioDao.ListarView();
				
				String json = new Gson().toJson(usuarios);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (opcion.equals("buscar")) {

			usu = new Usuario();
			usu.setId_usuario(Integer.parseInt(request.getParameter("id_usuario").toString()));

			try {
				usuarioDao = new UsuarioDao();
				usu = usuarioDao.Buscar(usu);
				usu.setContrasena(Encriptacion.Desencriptar(usu.getContrasena()));

				String json = new Gson().toJson(usu);
				response.setContentType("aplication/json");
				response.setCharacterEncoding("UTF-8");

				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (opcion.equals("eliminar")) {

			usu = new Usuario();
			usu.setId_usuario(Integer.parseInt(request.getParameter("id_usuario").toString()));

			PrintWriter out = response.getWriter();

			try {
				usuarioDao = new UsuarioDao();

				usuarioDao.Eliminar(usu);

				out.println(1);

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String login = request.getParameter("login");
		String opcion = request.getParameter("opcion");

		HttpSession sesion = request.getSession();

		if (login != null) {
			usu = new Usuario();
			usu.setUsuario(request.getParameter("txtUsuario").toString());
			usu.setContrasena(Encriptacion.Encriptar(request.getParameter("txtContrasena").toString()));
						
			try {
				usuarioDao = new UsuarioDao();
				usuarioView = new UsuarioView();
				usuarioView = usuarioDao.Autenticar(usu);
				if (usuarioView.getNombrecompleto() != null) {

					sesion.setAttribute("id_usuario", usuarioView.getId_usuario());
					sesion.setAttribute("usuario", usuarioView.getUsuario());
					sesion.setAttribute("nombrecompleto", usuarioView.getNombrecompleto());
					sesion.setAttribute("tipo_usuario", usuarioView.getTipo_usuario());
					response.sendRedirect("home.jsp");

				} else {

					response.sendRedirect("index.html");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (opcion.equals("actualizar")) {

			usu = new Usuario();
			usu.setId_usuario(Integer.parseInt(request.getParameter("id_usuario").toString()));
			usu.setNombrecompleto(request.getParameter("nombrecompleto").toString());
			usu.setUsuario(request.getParameter("usuario").toString());
			usu.setId_tipo_usuario(Integer.parseInt(request.getParameter("id_tipo_usuario").toString()));
			usu.setContrasena(Encriptacion.Encriptar(request.getParameter("contrasena")));
			usu.setEmail(request.getParameter("email").toString());

			try {
				usuarioDao = new UsuarioDao();

				usuarioDao.Modificar(usu);

				out.println(1);

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if (opcion.equals("registrar")) {
			usu = new Usuario();
			usu.setUsuario(request.getParameter("usuario").toString());
			usu.setContrasena(Encriptacion.Encriptar(request.getParameter("contrasena").toString()));
			usu.setNombrecompleto(request.getParameter("nombrecompleto").toString());
			usu.setEmail(request.getParameter("email").toString());
			usu.setId_tipo_usuario(Integer.parseInt(request.getParameter("id_tipo_usuario").toString()));
			try {
				usuarioDao = new UsuarioDao();
				Usuario usuarioTemporal = new Usuario();
				usuarioTemporal.setUsuario(usuarioDao.ValidaUsuario(usu));
				usuarioTemporal.setEmail(usuarioDao.ValidaEmail(usu));

				if (usuarioTemporal.getUsuario() == null) {
					if (usuarioTemporal.getEmail() == null) {
						// Retorna 1 para grabar nuevo usuario
						usuarioDao.Grabar(usu);
						out.println(1);
					} else {
						// Retorna 0 para indicar email existente
						out.println(0);
					}
				} else {
					// Retorna 2 para indicar usuario existente
					out.println(2);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (opcion.equals("cambiar_contrasena")) {
			
			usu = new Usuario();
			usu.setId_usuario(Integer.parseInt(request.getParameter("id_usuario").toString()));
			usu.setContrasena(Encriptacion.Encriptar(request.getParameter("contrasena").toString()));
			
			try {
				usuarioDao = new UsuarioDao();
				
				usuarioDao.CambiarContrasena(usu);
				
				out.println(1);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				out.println(0);
			
			}

		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
