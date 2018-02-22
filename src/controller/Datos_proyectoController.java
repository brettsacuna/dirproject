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

import dao.Datos_proyectoDao;
import entity.Datos_proyecto;


/**
 * Servlet implementation class Datos_proyectoController
 */
@WebServlet("/Datos_proyectoController")
public class Datos_proyectoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Datos_proyecto datos_proyecto;
	Datos_proyectoDao datos_proyectoDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Datos_proyectoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		if (opcion.equals("listar_proyectos")) {

			datos_proyecto = new Datos_proyecto();
			
			try {

				datos_proyectoDao = new Datos_proyectoDao();

				List<Datos_proyecto> proyectos = datos_proyectoDao.Listar();

				String json = new Gson().toJson(proyectos);

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

		PrintWriter out = response.getWriter();
		String opcion = request.getParameter("opcion");

		// REGISTRAR

		if (opcion.equals("guardar")) {

			datos_proyecto = new Datos_proyecto();

			
			if (!(request.getParameter("id_proyecto").equals(""))) {
				
				datos_proyecto.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));
				
			}
			

			datos_proyecto.setCodigo_snip(request.getParameter("codigo_snip"));
			datos_proyecto.setCodigo_proyecto(request.getParameter("codigo_proyecto"));
	
			datos_proyecto.setNombre_pip(request.getParameter("nombre_pip"));

			if (!(request.getParameter("presupuesto_viabilidad").equals(""))) {
				datos_proyecto
						.setPresupuesto_viabilidad(Double.parseDouble(request.getParameter("presupuesto_viabilidad")));
			}

			datos_proyecto.setConsultor_preinversion(request.getParameter("consultor_preinversion"));
			datos_proyecto.setConsultor_expediente_tecnico(request.getParameter("consultor_expediente_tecnico"));
			datos_proyecto.setResolucion_aprobacion_expediente_tecnico(
					request.getParameter("resolucion_aprobacion_expediente_tecnico"));

			if (!(request.getParameter("fecha_resolucion_aprobacion_expediente_tecnico").equals(""))) {
				datos_proyecto.setFecha_resolucion_aprobacion_expediente_tecnico(fechaToTexto(
						textoTofecha(request.getParameter("fecha_resolucion_aprobacion_expediente_tecnico"))));
			}

			datos_proyecto.setResolucion_aprobacion_valor_referencial(
					request.getParameter("resolucion_aprobacion_valor_referencial"));

			if (!(request.getParameter("fecha_resolucion_aprobacion_valor_referencial").equals(""))) {
				datos_proyecto.setFecha_resolucion_aprobacion_valor_referencial(fechaToTexto(
						textoTofecha(request.getParameter("fecha_resolucion_aprobacion_valor_referencial"))));
			}

			datos_proyecto.setResolucion_actualizacion_valor_referencial(
					request.getParameter("resolucion_actualizacion_valor_referencial"));

			if (!(request.getParameter("fecha_resolucion_actualizacion_valor_referencial").equals(""))) {
				datos_proyecto.setFecha_resolucion_actualizacion_valor_referencial(fechaToTexto(
						textoTofecha(request.getParameter("fecha_resolucion_actualizacion_valor_referencial"))));
			}

			datos_proyecto.setInforme_tecnico_declaratoria_viabilidad(
					request.getParameter("informe_tecnico_declaratoria_viabilidad"));

			if (!(request.getParameter("fecha_informe_tecnico_declaratoria_viabilidad").equals(""))) {
				datos_proyecto.setFecha_informe_tecnico_declaratoria_viabilidad(fechaToTexto(
						textoTofecha(request.getParameter("fecha_informe_tecnico_declaratoria_viabilidad"))));
			}

			datos_proyecto.setBeneficiarios_directos(request.getParameter("beneficiarios_directos"));

			datos_proyecto.setUsuario(request.getParameter("usuario"));

			String operacion = request.getParameter("operacion");

			try {
				datos_proyectoDao = new Datos_proyectoDao();

				if (operacion.equals("actualizar")) {

					datos_proyectoDao.Modificar(datos_proyecto);
					out.println(1);
					System.out.println(1);

				} else if (operacion.equals("registrar")) {

					Datos_proyecto datos_proyectoTemp = new Datos_proyecto();

					datos_proyectoTemp = datos_proyectoDao.Buscar(datos_proyecto);

					if (datos_proyectoTemp.getCodigo_snip() == null) {

						datos_proyectoTemp = datos_proyectoDao.BuscarPorCodigoProyecto(datos_proyecto);

						if (datos_proyectoTemp.getCodigo_proyecto() == null) {

							datos_proyectoDao.Grabar(datos_proyecto);

							// Retorna 1 para indicar guardado satisfactorio
							out.println(1);
							System.out.println(1);

						} else {
							// Retorna 0 para indicar codigo_proyecto existente
							out.println(0);
							System.out.println(0);

						}
					} else {
						// Retorna 2 para indicar codigo_snip existente
						out.println(2);
						System.out.println(2);
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			// BUSCAR

		} else if (opcion.equals("buscar")) {

			datos_proyecto = new Datos_proyecto();
			datos_proyecto.setCodigo_snip(request.getParameter("codigo_snip"));

			try {
				datos_proyectoDao = new Datos_proyectoDao();
				datos_proyecto = datos_proyectoDao.Buscar(datos_proyecto);

				String json = new Gson().toJson(datos_proyecto);
				response.setContentType("aplication/json");
				response.setCharacterEncoding("UTF-8");

				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if(opcion.equals("eliminar")){
			
			datos_proyecto = new Datos_proyecto();

			datos_proyecto.setId_proyecto(Integer.parseInt(request.getParameter("id_proyecto")));
			
			try {
				datos_proyectoDao = new Datos_proyectoDao();
				
				datos_proyectoDao.Eliminar(datos_proyecto);
				
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
