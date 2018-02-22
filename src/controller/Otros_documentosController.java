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

import dao.Otros_documentosDao;
import entity.Otros_documentos;

/**
 * Servlet implementation class Otros_documentosController
 */
@WebServlet("/Otros_documentosController")
public class Otros_documentosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Otros_documentos otros_documentos;
	Otros_documentosDao oDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Otros_documentosController() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		if (opcion.equals("listar_otros_documentos")) {
			
			otros_documentos = new Otros_documentos();
			
			otros_documentos.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			
			try {
				
				oDao= new Otros_documentosDao();
				
				List<Otros_documentos> otros = oDao.Filtrar(otros_documentos);
				
				String json = new Gson().toJson(otros);
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			otros_documentos = new Otros_documentos();
			otros_documentos.setId_otro_documento(Integer.parseInt(request.getParameter("id_otro_documento")));

			try {

				oDao = new Otros_documentosDao();

				otros_documentos = oDao.Buscar(otros_documentos);

				String json = new Gson().toJson(otros_documentos);

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

			otros_documentos = new Otros_documentos();
						
			if (!(request.getParameter("id_otro_documento").equals(""))) {

				otros_documentos.setId_otro_documento(Integer.parseInt(request.getParameter("id_otro_documento")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				otros_documentos.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
						
			otros_documentos.setInformacion_especifica(request.getParameter("informacion_especifica"));
			
			if (!(request.getParameter("fecha_informe").equals(""))) {

				otros_documentos.setFecha_informe(fechaToTexto(textoTofecha(request.getParameter("fecha_informe"))));
			}
			
			otros_documentos.setDetalle(request.getParameter("detalle"));
			otros_documentos.setMotivo_generado(request.getParameter("motivo_generado"));
			
			otros_documentos.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				oDao = new Otros_documentosDao();

				if (operacion.equals("registrar")) {

					oDao.Grabar(otros_documentos);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					oDao.Modificar(otros_documentos);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			otros_documentos = new Otros_documentos();

			otros_documentos.setId_otro_documento(Integer.parseInt(request.getParameter("id_otro_documento")));
			
			try {
				oDao = new Otros_documentosDao();
				
				oDao.Eliminar(otros_documentos);
				
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
