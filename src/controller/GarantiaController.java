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

import dao.GarantiaDao;
import entity.Garantia;

/**
 * Servlet implementation class GarantiaController
 */
@WebServlet("/GarantiaController")
public class GarantiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Garantia garantia;
	GarantiaDao garantiaDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GarantiaController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String opcion = request.getParameter("opcion");
			
		if (opcion.equals("listar_garantia")) {
			
			garantia = new Garantia();
			
			garantia.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			
			try {
				
				garantiaDao= new GarantiaDao();
				
				List<Garantia> garantias = garantiaDao.Filtrar(garantia);
				
				String json = new Gson().toJson(garantias);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			garantia = new Garantia();

			garantia.setId_garantia(Integer.parseInt(request.getParameter("id_garantia")));

			try {

				garantiaDao = new GarantiaDao();

				garantia = garantiaDao.Buscar(garantia);

				String json = new Gson().toJson(garantia);

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

			garantia = new Garantia();
						
			if (!(request.getParameter("id_garantia").equals(""))) {

				garantia.setId_garantia(Integer.parseInt(request.getParameter("id_garantia")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				garantia.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			garantia.setDescripcion_garantia(request.getParameter("descripcion_garantia"));
			garantia.setFactura(request.getParameter("factura"));
			
			if (!(request.getParameter("fecha_factura").equals(""))) {

				garantia.setFecha_factura(fechaToTexto(textoTofecha(request.getParameter("fecha_factura"))));
			}
			
			garantia.setTipo_garantia(request.getParameter("tipo_garantia"));
			garantia.setInstitucion_financiera(request.getParameter("institucion_financiera"));
			garantia.setNumero_documento(request.getParameter("numero_documento"));
			
			if (!(request.getParameter("monto_adelanto").equals(""))) {

				garantia.setMonto_adelanto(Double.parseDouble(request.getParameter("monto_adelanto")));
			}
			
			if (!(request.getParameter("monto_carta_fianza").equals(""))) {

				garantia.setMonto_carta_fianza(Double.parseDouble(request.getParameter("monto_carta_fianza")));
			}
			
			if (!(request.getParameter("fecha_creacion").equals(""))) {

				garantia.setFecha_creacion(fechaToTexto(textoTofecha(request.getParameter("fecha_creacion"))));
			}
			
			if (!(request.getParameter("fecha_vencimiento").equals(""))) {

				garantia.setFecha_vencimiento(fechaToTexto(textoTofecha(request.getParameter("fecha_vencimiento"))));
			}
		
			garantia.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				garantiaDao = new GarantiaDao();

				if (operacion.equals("registrar")) {

					garantiaDao.Grabar(garantia);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					garantiaDao.Modificar(garantia);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			garantia = new Garantia();

			garantia.setId_garantia(Integer.parseInt(request.getParameter("id_garantia")));
			
			try {
				garantiaDao = new GarantiaDao();
				
				garantiaDao.Eliminar(garantia);
				
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
