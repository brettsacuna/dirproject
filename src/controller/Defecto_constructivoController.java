package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Defecto_constructivoDao;
import entity.Defecto_constructivo;

/**
 * Servlet implementation class Defecto_constructivoController
 */
@WebServlet("/Defecto_constructivoController")
public class Defecto_constructivoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Defecto_constructivo defecto;
	Defecto_constructivoDao defectoDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Defecto_constructivoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_defecto_constructivo")) {

			defecto = new Defecto_constructivo();

			defecto.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));

			try {

				defectoDao = new Defecto_constructivoDao();

				List<Defecto_constructivo> defectos = defectoDao.Filtrar(defecto);

				String json = new Gson().toJson(defectos);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			defecto = new Defecto_constructivo();

			defecto.setId_defecto_constructivo(Integer.parseInt(request.getParameter("id_defecto_constructivo")));

			try {

				defectoDao = new Defecto_constructivoDao();

				defecto = defectoDao.Buscar(defecto);

				String json = new Gson().toJson(defecto);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();

		String opcion = request.getParameter("opcion");

		if (opcion.equals("guardar")) {

			defecto = new Defecto_constructivo();
					
			if (!(request.getParameter("id_defecto_constructivo").equals(""))) {

				defecto.setId_defecto_constructivo(Integer.parseInt(request.getParameter("id_defecto_constructivo")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				defecto.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			defecto.setAsiento_cuaderno_obra(request.getParameter("asiento_cuaderno_obra"));
			defecto.setDefecto_constructivo(request.getParameter("defecto_constructivo"));
			
			if (!(request.getParameter("fecha_encontrado").equals(""))) {

				defecto.setFecha_encontrado(fechaToTexto(textoTofecha(request.getParameter("fecha_encontrado"))));
			}
			
			defecto.setEstado_defecto(request.getParameter("estado_defecto"));
			defecto.setAcciones(request.getParameter("acciones"));
			
			defecto.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				defectoDao = new Defecto_constructivoDao();

				if (operacion.equals("registrar")) {

					defectoDao.Grabar(defecto);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					defectoDao.Modificar(defecto);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		}else if(opcion.equals("eliminar")){
			
			defecto = new Defecto_constructivo();

			defecto.setId_defecto_constructivo(Integer.parseInt(request.getParameter("id_defecto_constructivo")));
			
			try {
				defectoDao = new Defecto_constructivoDao();
				
				defectoDao.Eliminar(defecto);
				
				out.println(1);
				
			} catch (Exception e) {
				
				out.println(0);
				
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public String fechaToTexto(Date d) {

		String fechaconvertida = "";
		SimpleDateFormat formato;

		try {
			formato = new SimpleDateFormat("yyyy-MM-dd");
			fechaconvertida = formato.format(d);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fechaconvertida;
	}

	public Date textoTofecha(String d) {
		Date fechaconvertida = null;
		SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
		try {
			fechaconvertida = formato.parse(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fechaconvertida;
	}


}
