package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ComponentesDao;
import entity.Componentes;

/**
 * Servlet implementation class ComponentesController
 */
@WebServlet("/ComponentesController")
public class ComponentesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Componentes componente;
	ComponentesDao componenteDao;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComponentesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		// PrintWriter out = response.getWriter();

		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_componentes")) {

			componente = new Componentes();

			componente.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));

			try {

				componenteDao = new ComponentesDao();

				List<Componentes> componentes = componenteDao.Filtrar(componente);

				String json = new Gson().toJson(componentes);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			componente = new Componentes();

			componente.setId_componente(Integer.parseInt(request.getParameter("id_componente")));

			try {

				componenteDao = new ComponentesDao();

				componente = componenteDao.Buscar(componente);

				String json = new Gson().toJson(componente);

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

			componente = new Componentes();
						
			if (!(request.getParameter("id_componente").equals(""))) {

				componente.setId_componente(Integer.parseInt(request.getParameter("id_componente")));
			}
			
			if (!(request.getParameter("id_proyecto").equals(""))) {

				componente.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));
			}
			
			if (!(request.getParameter("id_tipo_componente").equals(""))) {

				componente.setId_tipo_componente(Integer.parseInt(request.getParameter("id_tipo_componente")));
			}
			
			componente.setComponente(request.getParameter("componente"));
			componente.setObservacion(request.getParameter("observacion"));
			
			if (!(request.getParameter("monto_componente_viable").equals(""))) {

				componente.setMonto_componente_viable(Double.parseDouble(request.getParameter("monto_componente_viable")));
			}
											
			componente.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				componenteDao = new ComponentesDao();

				if (operacion.equals("registrar")) {

					componenteDao.Grabar(componente);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					componenteDao.Modificar(componente);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			componente = new Componentes();

			componente.setId_componente(Integer.parseInt(request.getParameter("id_componente")));
			
			try {
				componenteDao = new ComponentesDao();
				
				componenteDao.Eliminar(componente);
				
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

}
