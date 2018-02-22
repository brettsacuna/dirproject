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

import dao.ResolucionDao;
import entity.Resolucion;

/**
 * Servlet implementation class ResolucionController
 */
@WebServlet("/ResolucionController")
public class ResolucionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Resolucion resolucion;
	ResolucionDao resolucionDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResolucionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		if (opcion.equals("listar_resolucion")) {
			
			resolucion = new Resolucion();
			
			resolucion.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			
			try {
				
				resolucionDao= new ResolucionDao();
				
				List<Resolucion> resoluciones = resolucionDao.Filtrar(resolucion);
				
				String json = new Gson().toJson(resoluciones);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			resolucion = new Resolucion();
			resolucion.setId_resolucion(Integer.parseInt(request.getParameter("id_resolucion")));

			try {

				resolucionDao = new ResolucionDao();

				resolucion = resolucionDao.Buscar(resolucion);

				String json = new Gson().toJson(resolucion);

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
		
		PrintWriter out = response.getWriter();
	
		String opcion = request.getParameter("opcion");		
	
		if (opcion.equals("guardar")) {

			resolucion = new Resolucion();
						
			if (!(request.getParameter("id_resolucion").equals(""))) {

				resolucion.setId_resolucion(Integer.parseInt(request.getParameter("id_resolucion")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				resolucion.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			resolucion.setResolucion_conformacion_comite(request.getParameter("resolucion_conformacion_comite"));
			
			if (!(request.getParameter("fecha_resolucion").equals(""))) {

				resolucion.setFecha_resolucion(fechaToTexto(textoTofecha(request.getParameter("fecha_resolucion"))));
			}
			
			resolucion.setMiembros(request.getParameter("miembros"));
			resolucion.setMotivo_generado(request.getParameter("motivo_generado"));
		
			resolucion.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				resolucionDao = new ResolucionDao();

				if (operacion.equals("registrar")) {

					resolucionDao.Grabar(resolucion);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					resolucionDao.Modificar(resolucion);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			resolucion = new Resolucion();

			resolucion.setId_resolucion(Integer.parseInt(request.getParameter("id_resolucion")));
			
			try {
				resolucionDao = new ResolucionDao();
				
				resolucionDao.Eliminar(resolucion);
				
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
