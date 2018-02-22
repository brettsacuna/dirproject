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

import dao.Contrato_proceso_seleccion_itemDao;
import entity.Contrato_proceso_seleccion_item;

/**
 * Servlet implementation class Contrato_proceso_seleccion_itemController
 */
@WebServlet("/Contrato_proceso_seleccion_itemController")
public class Contrato_proceso_seleccion_itemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Contrato_proceso_seleccion_item contrato;
	Contrato_proceso_seleccion_itemDao contratoDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contrato_proceso_seleccion_itemController() {
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

		if (opcion.equals("listar_contrato_proceso_seleccion_item")) {

			contrato = new Contrato_proceso_seleccion_item();

			contrato.setId_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_proceso_seleccion_item")));

			try {

				contratoDao = new Contrato_proceso_seleccion_itemDao();

				List<Contrato_proceso_seleccion_item> contratos = contratoDao.Filtrar(contrato);

				String json = new Gson().toJson(contratos);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			contrato = new Contrato_proceso_seleccion_item();

			contrato.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));

			try {

				contratoDao = new Contrato_proceso_seleccion_itemDao();

				contrato = contratoDao.Buscar(contrato);

				String json = new Gson().toJson(contrato);

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
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String opcion = request.getParameter("opcion");

		if (opcion.equals("guardar")) {

			contrato = new Contrato_proceso_seleccion_item();

			if (!(request.getParameter("id_contrato_proceso_seleccion_item").equals(""))) {

				contrato.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			}
			
			if (!(request.getParameter("id_proceso_seleccion_item").equals(""))) {

				contrato.setId_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_proceso_seleccion_item")));
			}
			
			if (!(request.getParameter("fecha_adjudicacion").equals(""))) {

				contrato.setFecha_adjudicacion(fechaToTexto(textoTofecha(request.getParameter("fecha_adjudicacion"))));
			}
			
			if (!(request.getParameter("monto_adjudicado").equals(""))) {

				contrato.setMonto_adjudicado((Double.parseDouble(request.getParameter("monto_adjudicado"))));
			}
			
			if (!(request.getParameter("monto_pagado").equals(""))) {

				contrato.setMonto_pagado((Double.parseDouble(request.getParameter("monto_pagado"))));
			}
			
			if (!(request.getParameter("porcentaje_pagado").equals(""))) {

				contrato.setPorcentaje_pagado((Double.parseDouble(request.getParameter("porcentaje_pagado"))));
			}
			
			if (!(request.getParameter("fecha_firma_contrato").equals(""))) {

				contrato.setFecha_firma_contrato(fechaToTexto(textoTofecha(request.getParameter("fecha_firma_contrato"))));
			}
			
			if (!(request.getParameter("fecha_entrega_terreno").equals(""))) {

				contrato.setFecha_entrega_terreno(fechaToTexto(textoTofecha(request.getParameter("fecha_entrega_terreno"))));
			}
			
			if (!(request.getParameter("plazo_ejecucion").equals(""))) {

				contrato.setPlazo_ejecucion(Integer.parseInt(request.getParameter("plazo_ejecucion")));
			}
			
			if (!(request.getParameter("fecha_inicio_plazo_contractual").equals(""))) {

				contrato.setFecha_inicio_plazo_contractual(fechaToTexto(textoTofecha(request.getParameter("fecha_inicio_plazo_contractual"))));
			}
			
			if (!(request.getParameter("total_dias_ampliacion_plazo").equals(""))) {

				contrato.setTotal_dias_ampliacion_plazo(Integer.parseInt(request.getParameter("total_dias_ampliacion_plazo")));
			}
			
			if (!(request.getParameter("total_adendas").equals(""))) {

				contrato.setTotal_adendas(Integer.parseInt(request.getParameter("total_adendas")));
			}
			
			if (!(request.getParameter("monto_prestaciones_adicionales").equals(""))) {

				contrato.setMonto_prestaciones_adicionales((Double.parseDouble(request.getParameter("monto_prestaciones_adicionales"))));
			}
			
			contrato.setContratista_adjudicado(request.getParameter("contratista_adjudicado"));
			
			contrato.setRuc_contratista(request.getParameter("ruc_contratista"));
			contrato.setNumero_contrato(request.getParameter("numero_contrato"));
			contrato.setObservaciones(request.getParameter("observaciones"));
			contrato.setLiquidacion(request.getParameter("liquidacion"));
			
			contrato.setUsuario(request.getParameter("usuario"));

			String operacion = request.getParameter("operacion");

			try {

				contratoDao = new Contrato_proceso_seleccion_itemDao();

				if (operacion.equals("registrar")) {

					contratoDao.Grabar(contrato);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					contratoDao.Modificar(contrato);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		}else if(opcion.equals("eliminar")){
			
			contrato = new Contrato_proceso_seleccion_item();

			contrato.setId_contrato_proceso_seleccion_item(Integer.parseInt(request.getParameter("id_contrato_proceso_seleccion_item")));
			
			try {
				contratoDao = new Contrato_proceso_seleccion_itemDao();
				
				contratoDao.Eliminar(contrato);
				
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
