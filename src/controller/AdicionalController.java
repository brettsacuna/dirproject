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

import dao.AdicionalDao;
import entity.Adicional;

/**
 * Servlet implementation class AdicionalController
 */
@WebServlet("/AdicionalController")
public class AdicionalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Adicional adicional;
    AdicionalDao adao;
    
    public AdicionalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_adicional")) {

			adicional = new Adicional();

			adicional.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));

			try {

				adao = new AdicionalDao();

				List<Adicional> adicionales = adao.Filtrar(adicional);

				String json = new Gson().toJson(adicionales);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			adicional = new Adicional();

			adicional.setId_adicional(Integer.parseInt(request.getParameter("id_adicional")));

			try {

				adao = new AdicionalDao();

				adicional = adao.Buscar(adicional);

				String json = new Gson().toJson(adicional);

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

			adicional = new Adicional();
						
			if (!(request.getParameter("id_adicional").equals(""))) {

				adicional.setId_adicional(Integer.parseInt(request.getParameter("id_adicional")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				adicional.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			adicional.setResolucion_aprobacion_adicional(request.getParameter("resolucion_aprobacion_adicional"));
			
			if (!(request.getParameter("fecha_resolucion_aprobacion_adicional").equals(""))) {

				adicional.setFecha_resolucion_aprobacion_adicional(fechaToTexto(textoTofecha(request.getParameter("fecha_resolucion_aprobacion_adicional"))));
			}
						
			if (!(request.getParameter("monto_adicional_otorgado").equals(""))) {

				adicional.setMonto_adicional_otorgado(Double.parseDouble(request.getParameter("monto_adicional_otorgado")));
			}
			
			adicional.setMotivo_generado(request.getParameter("motivo_generado"));		
			adicional.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				adao = new AdicionalDao();

				if (operacion.equals("registrar")) {

					adao.Grabar(adicional);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					adao.Modificar(adicional);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		}  else if(opcion.equals("eliminar")){
			
			adicional = new Adicional();

			adicional.setId_adicional(Integer.parseInt(request.getParameter("id_adicional")));
			
			try {
				adao = new AdicionalDao();
				
				adao.Eliminar(adicional);
				
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
