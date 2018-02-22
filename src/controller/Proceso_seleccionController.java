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

import dao.Proceso_seleccionDao;
import entity.Proceso_seleccion;

/**
 * Servlet implementation class Proceso_seleccionController
 */
@WebServlet("/Proceso_seleccionController")
public class Proceso_seleccionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	Proceso_seleccion proceso_seleccion;
	Proceso_seleccionDao pDao;

	public Proceso_seleccionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		// PrintWriter out = response.getWriter();

		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_proceso_seleccion")) {

			proceso_seleccion = new Proceso_seleccion();

			proceso_seleccion.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));

			try {

				pDao = new Proceso_seleccionDao();

				List<Proceso_seleccion> proceso_seleccions = pDao.Filtrar(proceso_seleccion);

				String json = new Gson().toJson(proceso_seleccions);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			proceso_seleccion = new Proceso_seleccion();
		
			proceso_seleccion.setId_proceso_seleccion(Integer.parseInt(request.getParameter("id_proceso_seleccion")));

			try {

				pDao = new Proceso_seleccionDao();

				proceso_seleccion = pDao.Buscar(proceso_seleccion);

				String json = new Gson().toJson(proceso_seleccion);

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

			proceso_seleccion = new Proceso_seleccion();

			if (!(request.getParameter("id_proceso_seleccion").equals(""))) {

				proceso_seleccion
						.setId_proceso_seleccion(Integer.parseInt(request.getParameter("id_proceso_seleccion")));
			}

			if (!(request.getParameter("plazo_ejecucion").equals(""))) {

				proceso_seleccion.setPlazo_ejecucion(Integer.parseInt(request.getParameter("plazo_ejecucion")));
			}

			if (!(request.getParameter("valor_referencial").equals(""))) {

				proceso_seleccion.setValor_referencial(Double.parseDouble(request.getParameter("valor_referencial")));
			}
			if (!(request.getParameter("fecha_valor_referencial").equals(""))) {

				proceso_seleccion.setFecha_valor_referencial(
						fechaToTexto(textoTofecha(request.getParameter("fecha_valor_referencial"))));
			}

			proceso_seleccion.setNumero_proceso(request.getParameter("numero_proceso"));
			proceso_seleccion.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));
			proceso_seleccion.setProceso_seleccion_pertenencia(request.getParameter("proceso_seleccion_pertenencia"));
			proceso_seleccion.setModalidad_contratacion(request.getParameter("modalidad_contratacion"));
			proceso_seleccion.setUsuario(request.getParameter("usuario"));

			String operacion = request.getParameter("operacion");

			try {

				pDao = new Proceso_seleccionDao();

				if (operacion.equals("registrar")) {

					pDao.Grabar(proceso_seleccion);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					pDao.Modificar(proceso_seleccion);
					
					out.println(1);
					
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			proceso_seleccion = new Proceso_seleccion();

			proceso_seleccion.setId_proceso_seleccion(Integer.parseInt(request.getParameter("id_proceso_seleccion")));
			
			try {
				pDao = new Proceso_seleccionDao();
				
				pDao.Eliminar(proceso_seleccion);
				
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
