
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.sql.Connection"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>    
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="net.sf.jasperreports.view.JasperDesignViewer"%>
<%@ page import="javax.servlet.ServletResponse"%>
<%@page import="database.DataAccess"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Reporteador</title>
</head>
<body>
	<%
		Connection cn = null;
	
		cn = DataAccess.getConnection();
		
		String cod_snip = request.getParameter("codigo_snip");
		int opcion = Integer.parseInt(request.getParameter("opcion_reporte"));
		
		String nombre_reporte = null;
		
		if(opcion == 1){
			
			nombre_reporte = "reporte_preinversion.jasper";
			
		}else if(opcion == 2){
			
			nombre_reporte = "reporte_expediente_tecnico.jasper";
		
		}else if(opcion == 3){
			
			nombre_reporte = "reporte_valorizaciones.jasper";
		}
		
		
		File reportfile = new File (application.getRealPath("reportes/"+nombre_reporte));
		
		Map<String, Object> parameter = new HashMap<String,Object>();
		
		System.out.println(cod_snip);
		System.out.println(opcion);
		
		parameter.put("codigo_snip", cod_snip);
		
		byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter,cn);
		
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outputstream = response.getOutputStream();
		outputstream.write(bytes,0,bytes.length);
		
		outputstream.flush();
		outputstream.close();
		
	%>
</body>
</html>