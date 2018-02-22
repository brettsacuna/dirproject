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

import dao.Expediente_tecnicoDao;
import entity.Expediente_tecnico;

/**
 * Servlet implementation class Expediente_tecnicoController
 */
@WebServlet("/Expediente_tecnicoController")
public class Expediente_tecnicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Expediente_tecnico expediente;
	Expediente_tecnicoDao expedienteDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Expediente_tecnicoController() {
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

		if (opcion.equals("listar_expediente_tecnico")) {

			expediente = new Expediente_tecnico();

			expediente.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));
			
			try {

				expedienteDao = new Expediente_tecnicoDao();

				List<Expediente_tecnico> expedientes = expedienteDao.Filtrar(expediente);

				String json = new Gson().toJson(expedientes);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			expediente = new Expediente_tecnico();
		
			expediente.setId_expediente_tecnico(Integer.parseInt(request.getParameter("id_expediente_tecnico")));

			try {

				expedienteDao = new Expediente_tecnicoDao();

				expediente = expedienteDao.Buscar(expediente);

				String json = new Gson().toJson(expediente);

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

			expediente = new Expediente_tecnico();
		
			if (!(request.getParameter("id_expediente_tecnico").equals(""))) {

				expediente.setId_expediente_tecnico(Integer.parseInt(request.getParameter("id_expediente_tecnico")));
			}
			
			if (!(request.getParameter("id_item_proyecto").equals(""))) {

				expediente.setId_item_proyecto(Integer.parseInt(request.getParameter("id_item_proyecto")));
			}
			
			
			if (!(request.getParameter("id_proyecto").equals(""))) {

				expediente.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));
			}
			
			if (!(request.getParameter("id_tipo_informe_tecnico").equals(""))) {

				expediente.setId_tipo_informe_tecnico(Integer.parseInt(request.getParameter("id_tipo_informe_tecnico")));
			}
			
			expediente.setInforme_tecnico_modificaciones_etapa_inversion(request.getParameter("informe_tecnico_modificaciones_etapa_inversion"));
			
			if (!(request.getParameter("monto_informe_tecnico_etapa_inversion").equals(""))) {

				expediente.setMonto_informe_tecnico_etapa_inversion(Double.parseDouble(request.getParameter("monto_informe_tecnico_etapa_inversion")));
			}
			
			if (!(request.getParameter("fecha_informe_tecnico_etapa_inversion").equals(""))) {

				expediente.setFecha_informe_tecnico_etapa_inversion(fechaToTexto(textoTofecha(request.getParameter("fecha_informe_tecnico_etapa_inversion"))));
			}
			
			expediente.setNumero_proceso_expediente_tecnico(request.getParameter("numero_proceso_expediente_tecnico"));
			
			if (!(request.getParameter("valor_referencial").equals(""))) {

				expediente.setValor_referencial(Double.parseDouble(request.getParameter("valor_referencial")));
			}
			
			expediente.setModalidad_contratacion(request.getParameter("modalidad_contratacion"));
			
			if (!(request.getParameter("fecha_presupuesto_base").equals(""))) {

				expediente.setFecha_presupuesto_base(fechaToTexto(textoTofecha(request.getParameter("fecha_presupuesto_base"))));
			}
			expediente.setPostores(request.getParameter("postores"));
			
			if (!(request.getParameter("monto_adjudicado").equals(""))) {

				expediente.setMonto_adjudicado(Double.parseDouble(request.getParameter("monto_adjudicado")));
			}
			
			expediente.setContratista_adjudicado(request.getParameter("contratista_adjudicado"));
			expediente.setRuc_contratista_adjudicado(request.getParameter("ruc_contratista_adjudicado"));
			expediente.setItem_descripcion(request.getParameter("item_descripcion"));
			
			if (!(request.getParameter("fecha_otorgamiento").equals(""))) {

				expediente.setFecha_otorgamiento(fechaToTexto(textoTofecha(request.getParameter("fecha_otorgamiento"))));
			}
			
			expediente.setNumero_contrato(request.getParameter("numero_contrato"));
			
			if (!(request.getParameter("fecha_firma_contrato").equals(""))) {

				expediente.setFecha_firma_contrato(fechaToTexto(textoTofecha(request.getParameter("fecha_firma_contrato"))));
			}
			
			if (!(request.getParameter("plazo_ejecucion_expediente_tecnico").equals(""))) {

				expediente.setPlazo_ejecucion_expediente_tecnico(Integer.parseInt(request.getParameter("plazo_ejecucion_expediente_tecnico")));
			}
			
			expediente.setTipo_ejecucion(request.getParameter("tipo_ejecucion"));
			expediente.setObservaciones(request.getParameter("observaciones"));
			expediente.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				expedienteDao = new Expediente_tecnicoDao();

				if (operacion.equals("registrar")) {

					expedienteDao.Grabar(expediente);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					expedienteDao.Modificar(expediente);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			expediente = new Expediente_tecnico();

			expediente.setId_expediente_tecnico(Integer.parseInt(request.getParameter("id_expediente_tecnico")));
			
			try {
				expedienteDao = new Expediente_tecnicoDao();
				
				expedienteDao.Eliminar(expediente);
				
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
