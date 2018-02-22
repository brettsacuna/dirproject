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

import dao.ActaDao;
import entity.Acta;

/**
 * Servlet implementation class ActaController
 */
@WebServlet("/ActaController")
public class ActaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Acta acta;
       ActaDao actaDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_acta")) {

			acta = new Acta();

			acta.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));

			try {

				actaDao = new ActaDao();

				List<Acta> actas = actaDao.Filtrar(acta);

				String json = new Gson().toJson(actas);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			acta = new Acta();

			acta.setId_acta(Integer.parseInt(request.getParameter("id_acta")));

			try {

				actaDao = new ActaDao();

				acta = actaDao.Buscar(acta);

				String json = new Gson().toJson(acta);

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

			acta = new Acta();
								
			if (!(request.getParameter("id_acta").equals(""))) {

				acta.setId_acta(Integer.parseInt(request.getParameter("id_acta")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				acta.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			acta.setActa_descripcion(request.getParameter("acta_descripcion"));
			
			if (!(request.getParameter("fecha_acta").equals(""))) {

				acta.setFecha_acta(fechaToTexto(textoTofecha(request.getParameter("fecha_acta"))));
			}
			
			acta.setDetalle_acta(request.getParameter("detalle_acta"));
			acta.setMotivo_generado(request.getParameter("motivo_generado"));
							
			acta.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				actaDao = new ActaDao();

				if (operacion.equals("registrar")) {

					actaDao.Grabar(acta);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					actaDao.Modificar(acta);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			acta = new Acta();

			acta.setId_acta(Integer.parseInt(request.getParameter("id_acta")));
			
			try {
				actaDao = new ActaDao();
				
				actaDao.Eliminar(acta);
				
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
