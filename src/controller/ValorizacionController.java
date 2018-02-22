package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ValorizacionDao;
import entity.Valorizacion;

/**
 * Servlet implementation class ValorizacionController
 */
@WebServlet("/ValorizacionController")
public class ValorizacionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
     Valorizacion valorizacion;
     ValorizacionDao vDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValorizacionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		String opcion = request.getParameter("opcion");			

		if (opcion.equals("listar_valorizacion")) {
			int bandera = Integer.parseInt(request.getParameter("bandera"));
			valorizacion = new Valorizacion();

			valorizacion.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));

			try {

				if (bandera == 1) {
					if(Traer_valorizacion(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")))){
						vDao = new ValorizacionDao();

						List<Valorizacion> valorizaciones = vDao.Filtrar(valorizacion);

						String json = new Gson().toJson(valorizaciones);

						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						response.getWriter().write(json);
					}
				} else {
					vDao = new ValorizacionDao();

					List<Valorizacion> valorizaciones = vDao.Filtrar(valorizacion);

					String json = new Gson().toJson(valorizaciones);

					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			valorizacion = new Valorizacion();

			valorizacion.setId_valorizacion(Integer.parseInt(request.getParameter("id_valorizacion")));

			try {

				vDao = new ValorizacionDao();

				valorizacion = vDao.Buscar(valorizacion);

				String json = new Gson().toJson(valorizacion);

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

			valorizacion = new Valorizacion();
								
			if (!(request.getParameter("id_valorizacion").equals(""))) {

				valorizacion.setId_valorizacion(Integer.parseInt(request.getParameter("id_valorizacion")));
			}
			
			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				valorizacion.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			if (!(request.getParameter("periodo").equals(""))) {

				valorizacion.setPeriodo(fechaToTexto(textoTofecha(request.getParameter("periodo"))));
			}
			
			if (!(request.getParameter("valorizacion_programada").equals(""))) {

				valorizacion.setValorizacion_programada(Double.parseDouble(request.getParameter("valorizacion_programada")));
			}
			
			if (!(request.getParameter("valorizacion_ejecutada").equals(""))) {

				valorizacion.setValorizacion_ejecutada(Double.parseDouble(request.getParameter("valorizacion_ejecutada")));
			}
			
			if (!(request.getParameter("valorizacion_acumulada").equals(""))) {

				valorizacion.setValorizacion_acumulada(Double.parseDouble(request.getParameter("valorizacion_acumulada")));
			}
			
			if (!(request.getParameter("porcentaje_valorizado_acumulado").equals(""))) {

				valorizacion.setPorcentaje_valorizado_acumulado(Double.parseDouble(request.getParameter("porcentaje_valorizado_acumulado")));
			}
			valorizacion.setObservacion(request.getParameter("observacion"));
			valorizacion.setUsuario(request.getParameter("usuario"));
						
			String operacion = request.getParameter("operacion");

			try {

				vDao = new ValorizacionDao();

				if (operacion.equals("registrar")) {

					vDao.Grabar(valorizacion);
					
					if (Traer_valorizacion(valorizacion.getId_contrato_proceso_seleccion_item())) {
						out.println(1);
					}

				} else if (operacion.equals("actualizar")) {

					vDao.Modificar(valorizacion);
					
					if (Traer_valorizacion(valorizacion.getId_contrato_proceso_seleccion_item())) {
						out.println(1);
					}
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		}	else if(opcion.equals("eliminar")){
			
			valorizacion = new Valorizacion();

			valorizacion.setId_valorizacion(Integer.parseInt(request.getParameter("id_valorizacion")));
			
			try {
				
				vDao = new ValorizacionDao();
				
				vDao.Eliminar(valorizacion);
				
				if (Traer_valorizacion(valorizacion.getId_contrato_proceso_seleccion_item())) {
					out.println(1);
				}
				
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
	
	private boolean Traer_valorizacion(int id_contrato) throws Exception{
		valorizacion = new Valorizacion();
		
		valorizacion.setId_contrato_proceso_seleccion_item(id_contrato);
		
		List<Valorizacion> lista_valorizacion = new ArrayList<Valorizacion>();
		
		try {
			
			vDao = new ValorizacionDao();
			
			 lista_valorizacion = vDao.Filtrar(valorizacion);
			 
			 if(lista_valorizacion.size() == 1){
				 
				 for (Valorizacion val : lista_valorizacion) {
					
					 val.setValorizacion_acumulada(val.getValorizacion_ejecutada());
					 val.setPorcentaje_valorizado_acumulado(100);
					 
					 vDao.Recalcular_valorizacion(val);
										 
				}
				 
			 }else{
				 	
				 	double acumulador = 0.0;
				 	
				 	for (Valorizacion val : lista_valorizacion) {
						
				 		acumulador = acumulador + val.getValorizacion_ejecutada();
				 		
					}	
				 	
				 	for(int i = 0; i < lista_valorizacion.size() ;i++){
				 		
				 		if(i == 0){
				 			
				 			Valorizacion v = new Valorizacion();
				 			v =	lista_valorizacion.get(i);
				 			v.setValorizacion_acumulada(v.getValorizacion_ejecutada());
				 			v.setPorcentaje_valorizado_acumulado(v.getValorizacion_acumulada()/acumulador*100);
				 			
				 			vDao.Recalcular_valorizacion(v);
				 			
				 		}else if(i == lista_valorizacion.size()-1){
				 			
				 			Valorizacion v = new Valorizacion();
				 			v =	lista_valorizacion.get(i);
				 			v.setValorizacion_acumulada(acumulador);
				 			v.setPorcentaje_valorizado_acumulado(100);
				 			
				 			vDao.Recalcular_valorizacion(v);
				 			
				 		}else{
				 			
				 			Valorizacion v_anterior = new Valorizacion();
				 			Valorizacion v_actual = new Valorizacion();
				 			
				 			v_anterior = lista_valorizacion.get(i-1);				 			
				 			v_actual = lista_valorizacion.get(i);
				 			
				 			v_actual.setValorizacion_acumulada(v_anterior.getValorizacion_acumulada()+v_actual.getValorizacion_ejecutada());
				 			v_actual.setPorcentaje_valorizado_acumulado(v_actual.getValorizacion_acumulada()/acumulador*100);
				 			
				 			vDao.Recalcular_valorizacion(v_actual);
				 		}
				 		
				 	}
				 
			 }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
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
