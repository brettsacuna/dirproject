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

import dao.Proceso_seleccion_itemDao;
import entity.Proceso_seleccion_item;

/**
 * Servlet implementation class Proceso_seleccion_itemController
 */
@WebServlet("/Proceso_seleccion_itemController")
public class Proceso_seleccion_itemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Proceso_seleccion_item proceso_seleccion_item;
	Proceso_seleccion_itemDao psDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Proceso_seleccion_itemController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		// PrintWriter out = response.getWriter();

		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_proceso_seleccion_item")) {

			proceso_seleccion_item = new Proceso_seleccion_item();

			proceso_seleccion_item.setId_proceso_seleccion(Integer.parseInt(request.getParameter("id_proceso_seleccion")));

			try {

				psDao = new Proceso_seleccion_itemDao();

				List<Proceso_seleccion_item> proceso_seleccion_items = psDao.Filtrar(proceso_seleccion_item);

				String json = new Gson().toJson(proceso_seleccion_items);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			proceso_seleccion_item = new Proceso_seleccion_item();

			proceso_seleccion_item.setId_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_proceso_seleccion_item")));

			try {

				psDao = new Proceso_seleccion_itemDao();

				proceso_seleccion_item = psDao.Buscar(proceso_seleccion_item);

				String json = new Gson().toJson(proceso_seleccion_item);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String opcion = request.getParameter("opcion");

		if (opcion.equals("guardar")) {

			proceso_seleccion_item = new Proceso_seleccion_item();

			if (!(request.getParameter("id_proceso_seleccion_item").equals(""))) {

				proceso_seleccion_item.setId_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_proceso_seleccion_item")));
				
			}

			if (!(request.getParameter("plazo_ejecucion").equals(""))) {

				proceso_seleccion_item.setPlazo_ejecucion(Integer.parseInt(request.getParameter("plazo_ejecucion")));
			}

			if (!(request.getParameter("valor_referencial").equals(""))) {

				proceso_seleccion_item.setValor_referencial(Double.parseDouble(request.getParameter("valor_referencial")));
			}
			if (!(request.getParameter("fecha_valor_referencial").equals(""))) {

				proceso_seleccion_item.setFecha_valor_referencial(fechaToTexto(textoTofecha(request.getParameter("fecha_valor_referencial"))));
			}
			
			if (!(request.getParameter("id_item_proyecto").equals(""))) {

				proceso_seleccion_item.setId_item_proyecto(Integer.parseInt(request.getParameter("id_item_proyecto")));
			}
			
			proceso_seleccion_item.setId_proceso_seleccion(Integer.parseInt(request.getParameter("id_proceso_seleccion")));
			proceso_seleccion_item.setItem_descripcion(request.getParameter("item_descripcion"));			
			proceso_seleccion_item.setSituacion(request.getParameter("situacion"));
			proceso_seleccion_item.setUsuario(request.getParameter("usuario"));

			String operacion = request.getParameter("operacion");

			try {

				psDao = new Proceso_seleccion_itemDao();

				if (operacion.equals("registrar")) {

					psDao.Grabar(proceso_seleccion_item);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					psDao.Modificar(proceso_seleccion_item);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			proceso_seleccion_item = new Proceso_seleccion_item();

			proceso_seleccion_item.setId_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_proceso_seleccion_item")));
			
			try {
				psDao = new Proceso_seleccion_itemDao();
				
				psDao.Eliminar(proceso_seleccion_item);
				
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
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
