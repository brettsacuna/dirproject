<%@page import="entity.Datos_proyecto"%>
<%@page import="java.util.List"%>
<%@page import="dao.Datos_proyectoDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page session="true" %>
    
<br>	
		<div class="row text-center">
			<div class="col-md-12">				
				<h3 class="text-primary"><strong>Generador de Reportes</strong></h3>					
			</div>
		</div>
		<hr/>
		<div class="row">
			<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h6 class="panel-title">Reportes</h6>
					</div>
					<div class="panel-body">
						<form action="reportepdf.jsp" id="formulario">
								<div class="row">
									<div class="col-md-12">
								        <div class="form-group">              					
									        <label class="control-label" for="codigo_snip">Codigo SNIP :</label>
									        	<div class="input-group">	
									        		<input type="text" class="form-control" id="codigo_snip" name="codigo_snip" autocomplete="off" readonly="readonly">
									        		<span class="input-group-addon"  data-toggle="modal" data-target="#modal_lista_proyectos"><i class="glyphicon glyphicon-search"></i></span> 
								            	</div>
								         </div>              				
								 	</div>
								 </div>
								 <div class="row">
								    <div class="col-md-12">
								        <div class="form-group">										             					
						              				<label class="control-label" for="opcion_reporte_">Seleccione un reporte:</label>
						              				<select class="form-control" id="opcion_reporte_" name="opcion_reporte">
						              					<option value="1">Preinversion</option>
						              					<option value="2">Expediente Técnico</option>						              		
						              					<option value="3">Valorizaciones</option>
						              				</select>
										</div>              				
								    </div>						    					    
								</div>
								<br>
								<div class="row">
									<div class="col-md-2">
								    	<button type="submit" class="btn btn-success" id="btn_generar_reporte">Generar&nbsp;&nbsp;<i class="glyphicon glyphicon-file"></i></button>
								    </div>	
								</div>
						  </form>
					</div>
				</div>
			</div>			
		</div>
		
<!-- INICIO DEL MODAL LISTA PROYECTOS -->

<div class="modal fade"  id="modal_lista_proyectos" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Proyectos Registrados</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Lista de proyectos
						</div>
						<div class="panel panel-body">
							<div class="row">
								<div class="col-md-12">	
										<div class="table-responsive">								
											<table class="table table-hover" id="tabla_lista_proyectos">
												<thead>											
													<tr class="info">												
														<th class="col-sm-3 text-center">Cod. SNIP</th>
														<th class="col-sm-3 text-center">Cod. Proy.</th>
														<th class="col-sm-4 text-center">Nombre del Proyecto</th>
																																			
													</tr>
													
												</thead>
												<tbody>												
													<%
														Datos_proyectoDao datos_proyectoDao = new Datos_proyectoDao();
														List<Datos_proyecto> datos_proyectos = datos_proyectoDao.Listar();
														for(Datos_proyecto dp : datos_proyectos){
													%>
													<tr onclick="selecciona_proyecto('<%=dp.getCodigo_snip()%>')" data-dismiss="modal" class="warning" >
													
														<td class="text-center"><%=dp.getCodigo_snip()%></td>
														<td class="text-center"><%=dp.getCodigo_proyecto()%></td>
														<td><%=dp.getNombre_pip()%></td>																							
														
													</tr>												
													<% 
														}
													%>
													
												</tbody>
											</table>	     
									  </div>
								</div>
							</div>
						</div>
					</div>
				</div>      	
	      	</div>
	        <div id="mensaje">
	        </div>
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN DEL MODAL LISTA PROYECTOS -->	

<script>
$(document).ready(function() {

	$('#tabla_lista_proyectos').dataTable();	
	$('#btn_generar_reporte').attr('disabled',true);
});

function selecciona_proyecto(codigo_snip){
	
	$('#codigo_snip').val(codigo_snip);
	$('#btn_generar_reporte').attr('disabled',false);
	
}

</script>
		
		