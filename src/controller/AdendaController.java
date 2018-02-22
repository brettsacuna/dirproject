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

import dao.AdendaDao;
import entity.Adenda;


/**
 * Servlet implementation class AdendaController
 */
@WebServlet("/AdendaController")
public class AdendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	Adenda adenda;
	AdendaDao adendaDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdendaController() {
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

		if (opcion.equals("listar_adendas")) {

			adenda = new Adenda();

			adenda.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));

			try {

				adendaDao = new AdendaDao();

				List<Adenda> adendas = adendaDao.Filtrar(adenda);

				String json = new Gson().toJson(adendas);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			adenda = new Adenda();

			adenda.setId_adenda(Integer.parseInt(request.getParameter("id_adenda")));

			try {

				adendaDao = new AdendaDao();

				adenda = adendaDao.Buscar(adenda);

				String json = new Gson().toJson(adenda);

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

			adenda = new Adenda();
						
			if (!(request.getParameter("id_adenda").equals(""))) {

				adenda.setId_adenda(Integer.parseInt(request.getParameter("id_adenda")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				adenda.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			adenda.setAdenda_descripcion(request.getParameter("adenda_descripcion"));
			
			if (!(request.getParameter("fecha_suscripcion").equals(""))) {

				adenda.setFecha_suscripcion(fechaToTexto(textoTofecha(request.getParameter("fecha_suscripcion"))));
			}
						
			if (!(request.getParameter("plazo_otorgado").equals(""))) {

				adenda.setPlazo_otorgado(Integer.parseInt(request.getParameter("plazo_otorgado")));
			}
			
			adenda.setMotivo_generado(request.getParameter("motivo_generado"));						
			adenda.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				adendaDao = new AdendaDao();

				if (operacion.equals("registrar")) {

					adendaDao.Grabar(adenda);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					adendaDao.Modificar(adenda);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		}else if(opcion.equals("eliminar")){
			
			adenda = new Adenda();

			adenda.setId_adenda(Integer.parseInt(request.getParameter("id_adenda")));
			
			try {
				
				adendaDao = new AdendaDao();				
				adendaDao.Eliminar(adenda);
				
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
