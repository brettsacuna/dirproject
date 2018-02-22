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

import dao.Item_proyectoDao;
import entity.Item_proyecto;


/**
 * Servlet implementation class Item_proyectoController
 */
@WebServlet("/Item_proyectoController")
public class Item_proyectoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Item_proyecto item_proyecto;
	Item_proyectoDao iDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Item_proyectoController() {
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

		if (opcion.equals("listar_item_proyecto")) {

			item_proyecto = new Item_proyecto();

			item_proyecto.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));

			try {

				iDao = new Item_proyectoDao();

				List<Item_proyecto> items = iDao.Filtrar(item_proyecto);

				String json = new Gson().toJson(items);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			item_proyecto = new Item_proyecto();
		
			item_proyecto.setId_item_proyecto(Integer.parseInt(request.getParameter("id_item_proyecto")));

			try {

				iDao = new Item_proyectoDao();

				item_proyecto = iDao.Buscar(item_proyecto);

				String json = new Gson().toJson(item_proyecto);

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

			item_proyecto = new Item_proyecto();

			if (!(request.getParameter("id_item_proyecto").equals(""))) {

				item_proyecto.setId_item_proyecto(Integer.parseInt(request.getParameter("id_item_proyecto")));
			}

			if (!(request.getParameter("id_proyecto").equals(""))) {

				item_proyecto.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));
			}

			if (!(request.getParameter("valor_referencial").equals(""))) {

				item_proyecto.setValor_referencial(Double.parseDouble(request.getParameter("valor_referencial")));
			}
			
			if (!(request.getParameter("presupuesto_expediente_tecnico").equals(""))) {
				
				item_proyecto.setPresupuesto_expediente_tecnico(Double.parseDouble(request.getParameter("presupuesto_expediente_tecnico")));
			}
			
			if (!(request.getParameter("etapa_proyecto").equals(""))) {

				item_proyecto.setEtapa_proyecto(Integer.parseInt(request.getParameter("etapa_proyecto")));
			}
			
			if (!(request.getParameter("estado_proyecto").equals(""))) {

				item_proyecto.setEstado_proyecto(Integer.parseInt(request.getParameter("estado_proyecto")));
			}
			
			item_proyecto.setUbicacion(request.getParameter("ubicacion"));
			item_proyecto.setItem_descripcion(request.getParameter("item_descripcion"));
			item_proyecto.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				iDao = new Item_proyectoDao();

				if (operacion.equals("registrar")) {

					iDao.Grabar(item_proyecto);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					iDao.Modificar(item_proyecto);
					
					out.println(1);
					
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			item_proyecto = new Item_proyecto();

			item_proyecto.setId_proyecto(Integer.parseInt(request.getParameter("id_item_proyecto")));
			
			try {
				
				iDao = new Item_proyectoDao();
				
				iDao.Eliminar(item_proyecto);
				
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
