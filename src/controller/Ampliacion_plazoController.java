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

import dao.Ampliacion_plazoDao;
import entity.Ampliacion_plazo;

/**
 * Servlet implementation class Ampliacion_plazoController
 */
@WebServlet("/Ampliacion_plazoController")
public class Ampliacion_plazoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    Ampliacion_plazo ampliacion;
    Ampliacion_plazoDao aPlazo;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ampliacion_plazoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_ampliacion_plazo")) {

			ampliacion = new Ampliacion_plazo();

			ampliacion.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));

			try {

				aPlazo = new Ampliacion_plazoDao();

				List<Ampliacion_plazo> ampliaciones = aPlazo.Filtrar(ampliacion);

				String json = new Gson().toJson(ampliaciones);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			ampliacion = new Ampliacion_plazo();

			ampliacion.setId_ampliacion_plazo(Integer.parseInt(request.getParameter("id_ampliacion_plazo")));

			try {

				aPlazo = new Ampliacion_plazoDao();

				ampliacion = aPlazo.Buscar(ampliacion);

				String json = new Gson().toJson(ampliacion);

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

			ampliacion = new Ampliacion_plazo();
						
			if (!(request.getParameter("id_ampliacion_plazo").equals(""))) {

				ampliacion.setId_ampliacion_plazo(Integer.parseInt(request.getParameter("id_ampliacion_plazo")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				ampliacion.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			ampliacion.setResolucion_aprobacion_ampliacion_plazo(request.getParameter("resolucion_aprobacion_ampliacion_plazo"));
			
			if (!(request.getParameter("fecha_resolucion_aprobacion_ampliacion_plazo").equals(""))) {

				ampliacion.setFecha_resolucion_aprobacion_ampliacion_plazo(fechaToTexto(textoTofecha(request.getParameter("fecha_resolucion_aprobacion_ampliacion_plazo"))));
			}
			
			if (!(request.getParameter("plazo_otorgado").equals(""))) {

				ampliacion.setPlazo_otorgado(Integer.parseInt(request.getParameter("plazo_otorgado")));
			}
			
			ampliacion.setMotivo_generado(request.getParameter("motivo_generado"));	
			
			ampliacion.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				aPlazo = new Ampliacion_plazoDao();

				if (operacion.equals("registrar")) {

					aPlazo.Grabar(ampliacion);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					aPlazo.Modificar(ampliacion);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		}  else if(opcion.equals("eliminar")){
			
			ampliacion = new Ampliacion_plazo();

			ampliacion.setId_ampliacion_plazo(Integer.parseInt(request.getParameter("id_ampliacion_plazo")));
			
			try {
				aPlazo = new Ampliacion_plazoDao();
				
				aPlazo.Eliminar(ampliacion);
				
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
