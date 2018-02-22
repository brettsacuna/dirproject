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

import dao.AdelantoDao;
import entity.Adelanto;

/**
 * Servlet implementation class AdelantoController
 */
@WebServlet("/AdelantoController")
public class AdelantoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Adelanto adelanto;
	AdelantoDao adelantoDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdelantoController() {
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

		if (opcion.equals("listar_adelanto")) {

			adelanto = new Adelanto();

			adelanto.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));

			try {

				adelantoDao = new AdelantoDao();

				List<Adelanto> adendas = adelantoDao.Filtrar(adelanto);

				String json = new Gson().toJson(adendas);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			adelanto = new Adelanto();

			adelanto.setId_adelanto(Integer.parseInt(request.getParameter("id_adelanto")));

			try {

				adelantoDao = new AdelantoDao();

				adelanto = adelantoDao.Buscar(adelanto);

				String json = new Gson().toJson(adelanto);

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

			adelanto = new Adelanto();
								
			if (!(request.getParameter("id_adelanto").equals(""))) {

				adelanto.setId_adelanto(Integer.parseInt(request.getParameter("id_adelanto")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				adelanto.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			adelanto.setAdelanto_descipcion(request.getParameter("adelanto_descipcion"));
			
			if (!(request.getParameter("fecha_solicitud_adelanto").equals(""))) {

				adelanto.setFecha_solicitud_adelanto(fechaToTexto(textoTofecha(request.getParameter("fecha_solicitud_adelanto"))));
			}
			
			if (!(request.getParameter("monto_adelanto").equals(""))) {

				adelanto.setMonto_adelanto(Double.parseDouble(request.getParameter("monto_adelanto")));
			}
			
			adelanto.setTipo_adelanto(request.getParameter("tipo_adelanto"));
					
			adelanto.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				adelantoDao = new AdelantoDao();

				if (operacion.equals("registrar")) {

					adelantoDao.Grabar(adelanto);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					adelantoDao.Modificar(adelanto);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			adelanto = new Adelanto();

			adelanto.setId_adelanto(Integer.parseInt(request.getParameter("id_adelanto")));
			
			try {
				
				adelantoDao = new AdelantoDao();
				
				adelantoDao.Eliminar(adelanto);
				
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
