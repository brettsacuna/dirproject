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

import dao.IncidenciaDao;
import entity.Incidencia;

/**
 * Servlet implementation class IncidenciaController
 */
@WebServlet("/IncidenciaController")
public class IncidenciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Incidencia incidencia;
    IncidenciaDao incidenciaDao;	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncidenciaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		
		if (opcion.equals("listar_incidencia")) {
			
			incidencia = new Incidencia();
			
			incidencia.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			
			try {
				
				incidenciaDao = new IncidenciaDao();
				
				List<Incidencia> incidencias = incidenciaDao.Filtrar(incidencia);
				
				String json = new Gson().toJson(incidencias);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			incidencia = new Incidencia();

			incidencia.setId_incidencia(Integer.parseInt(request.getParameter("id_incidencia")));

			try {

				incidenciaDao = new IncidenciaDao();

				incidencia = incidenciaDao.Buscar(incidencia);

				String json = new Gson().toJson(incidencia);

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
			
			incidencia = new Incidencia();
						
			if (!(request.getParameter("id_incidencia").equals(""))) {

				incidencia.setId_incidencia(Integer.parseInt(request.getParameter("id_incidencia")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				incidencia.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			incidencia.setDetalle_incidencia(request.getParameter("detalle_incidencia"));
			incidencia.setMotivo(request.getParameter("motivo"));
			incidencia.setAsiento_cuaderno_obra(request.getParameter("asiento_cuaderno_obra"));
			
			if (!(request.getParameter("fecha_evento").equals(""))) {

				incidencia.setFecha_evento(fechaToTexto(textoTofecha(request.getParameter("fecha_evento"))));
			}
			
		

			incidencia.setFecha_asiento(request.getParameter("fecha_asiento"));			
			incidencia.setAcciones(request.getParameter("acciones"));
			incidencia.setDocumento_emitido(request.getParameter("documento_emitido"));
			incidencia.setSumilla(request.getParameter("sumilla"));
			incidencia.setObjeto_incidencia(request.getParameter("objeto_incidencia"));
					
			incidencia.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				incidenciaDao = new IncidenciaDao();

				if (operacion.equals("registrar")) {

					incidenciaDao.Grabar(incidencia);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					incidenciaDao.Modificar(incidencia);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		}else if(opcion.equals("eliminar")){
			
			incidencia = new Incidencia();

			incidencia.setId_incidencia(Integer.parseInt(request.getParameter("id_incidencia")));
			
			try {
				incidenciaDao = new IncidenciaDao();
				
				incidenciaDao.Eliminar(incidencia);
				
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
