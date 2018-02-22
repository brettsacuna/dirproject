
<%@page import="entity.Datos_proyecto"%>
<%@page import="java.util.List"%>
<%@page import="dao.Datos_proyectoDao"%>
<%@page import="entity.UsuarioView"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page session="true" %>
				
	
	<!-- <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">  -->
	
		
<body>
<%
	HttpSession session_rcp = request.getSession();
	UsuarioView usuarioView = new UsuarioView();
	
	if(session_rcp.getAttribute("id_usuario")!=null && session_rcp.getAttribute("usuario")!=null && session_rcp.getAttribute("tipo_usuario")!=null && session_rcp.getAttribute("nombrecompleto")!= null){
		usuarioView.setId_usuario(Integer.parseInt(session_rcp.getAttribute("id_usuario").toString()));
		usuarioView.setUsuario(session_rcp.getAttribute("usuario").toString());
		usuarioView.setNombrecompleto(session_rcp.getAttribute("nombrecompleto").toString());
		usuarioView.setTipo_usuario(session_rcp.getAttribute("tipo_usuario").toString());
		
	}else{
		
		out.print("<script>location.replace('login.jsp');</script>");
		
	}
%>
<!-- variables temporales -->	
<input type="hidden" id="id_usuario" value="<%=usuarioView.getId_usuario()%>">
<input type="hidden" id="usuario" value="<%=usuarioView.getUsuario()%>">
<input type="hidden" id="tipo_usuario" value="<%=usuarioView.getTipo_usuario()%>">    

<input type="hidden" id="id_proyecto" value="">
<input type="hidden" id="id_proceso_seleccion" value="">              					             					
<input type="hidden" id="id_proceso_seleccion_item" value="">              					
<input type="hidden" id="id_contrato_proceso_seleccion_item" value="">						              					              					
<input type="hidden" id="id_expediente_tecnico" value="">
<input type="hidden" id="id_adenda" value="">	
<input type="hidden" id="id_adicional" value="">	
<input type="hidden" id="id_adelanto" value="">
<input type="hidden" id="id_ampliacion_plazo" value="">
<input type="hidden" id="id_valorizacion" value="">
<input type="hidden" id="id_defecto_constructivo" value="">
<input type="hidden" id="id_acta" value="">
<input type="hidden" id="id_garantia" value="">		
<input type="hidden" id="id_incidencia" value="">
<input type="hidden" id="id_resolucion" value="">
<input type="hidden" id="id_otro_documento" value="">		
  
 <!-- Fin variables temporales -->	               
                
                <div class="row">
                    <div class="col-md-12">
                     	<h3 class="text-primary"><strong>Ejecución del Proyecto</strong></h3>   
                    </div>                  
                </div>              
                 <!-- /. ROW  -->
                 <!--Linea  hr-->
                   <hr>
                 <div class="panel panel-primary">
                 	<div class="panel-heading">
	                 	<h6 class="panel-title">
	                 		Ciclo del Proyecto
	                 	</h6>                 		
                 	</div>
                 	<div class="panel-body">
                 		<div class="panel panel-info">
                 			<div class="panel panel-heading">
                 				Proyecto a Ejecutar
                 			</div>
                 			<div class="panel panel-body">
		                 			<div class="row">
						              	<div class="col-md-12">
						              		<div class="row">
						              			<div class="col-md-2">
						              				<div class="form-group">              					
							              					<label class="control-label" for="codigo_snip">Cod SNIP:</label>
							              				<div class="input-group">	
							              					<input type="text" class="form-control" id="codigo_snip" autocomplete="off" readonly="readonly">
							              					<span class="input-group-addon"  id="btn_buscar_proyecto" data-toggle="modal" data-target="#modal_proyectos"><i class="glyphicon glyphicon-search"></i></span> 
						              					</div>
						              				</div>              				
						              			</div>
						              			<div class="col-md-2">
						              				<div class="form-group">              					
							              					<label class="control-label" for="codigo_proyecto">Cod Proyecto:</label>	              				
							              					<input type="text" class="form-control" id="codigo_proyecto" autocomplete="off" readonly="readonly">
						              				</div>              				
						              			</div>           			
						              			
						              			<div class="col-md-8">
						              				<div class="form-group">
						              					<label class="control-label" for="consultor_preinversion">Consultor Preinversión:</label>
						              					<input class="form-control" id="consultor_preinversion" autocomplete="off" readonly="readonly"> 
						              				</div>              				
						              			</div>      			
						              		</div>
						              		<div class="row">              			
						              			<div class="col-md-12">
						              				<div class="form-group">
						              					<label class="control-label" for="nombre_pip">Nombre del PIP:</label>
						              					<textarea class="form-control" id="nombre_pip" name="nombre_pip" rows="3" readonly="readonly"></textarea>
						              				</div>              				
						              			</div>
						              		</div>              		
						              	</div>
					              </div>
                 				</div>                 			
                 			 </div> 
                 			 <div class="panel panel-primary" id="panel_expediente_tecnico">
                 			 	<div class="panel-heading">
                 			 		<h6 class="panel-title">
                 			 			<a data-toggle="collapse" href="#panel_expediente_tecnico_cinta">Datos del Expediente Técnico</a>
                 			 		</h6>
                 			 	</div>
                 			 		<div id="panel_expediente_tecnico_cinta" class="panel-collapse collapse">
		                 			 	<div class="panel-body">
		                 			 	 	<div class="row">
		                 			 	 		<div class="col-md-12">											    			
													  <div class="row">
													  		<div class="col-md-2 text-left">
													    		<button type="button" id="btn_agregar_expediente" class="btn btn-success" data-toggle="modal" data-target="#modal_expediente_tecnico">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>
													    	</div>											    	
													  </div>												  
													   <div class="row">
													    	<div class="col-md-12">
													    		<div class="table-responsive">
																	<table class="table table-hover table-bordered table-striped" id="lista_expediente_tecncico">
																		<thead>
																			<tr>
																				<caption><h4 class="form-section">Expediente técnico del Proyecto</h4></caption>
																			</tr>																						
																			<tr class="success">																						
																				<th class="col-sm-1 text-center">N°</th>
																				<th class="col-sm-3 text-center">Item</th>
																				<th class="col-sm-2 text-center">N° Proceso</th>																				
																				<th class="col-sm-2 text-center">Opciones</th>																																										
																			</tr>																					
																		</thead>
																	    <tbody id="listado_expediente_tecnico">												    																							
																		</tbody>
																	</table>	     
																</div>
													    	</div>
													   	</div>                                	                          		
								                </div>
		                 			 	 	</div>
		                 			 	</div>		                 			 	
		                 			</div>			                 			 	
                 			 </div>                 			             			 
                 			 <div class="panel panel-primary" id="panel_detalle_proyecto">
                 				<div class="panel-heading">
                 					<h6 class="panel-title">
                 						<a data-toggle="collapse" href="#cinta_detalle_proyecto">Procesos de Seleccion, Contratos y Datos Relacionados</a>
                 					</h6>
                 				</div>
                 					<div id="cinta_detalle_proyecto" class="panel-collapse collapse">
		                 				<div class="panel-body">
		                 					 <div id = "panel_tabs" class="row">
								                <div class="col-md-12">
								                	<ul class="nav nav-tabs" id="tabs_proyecto">
								                		<li role="presentation" class="active"><a href="#procesos_seleccion" aria-controls="procesos_seleccion" role="tab" data-toggle="tab">Procesos de Selección&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
								                		<li role="presentation"><a href="#eventos" aria-controls="eventos" role="tab" data-toggle="tab" id="pestana_eventos">Eventos&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
												  	</ul>	
												 <div class="tab-content">										  											  	
												  	  <div class="tab-pane fade in active" id="procesos_seleccion">										  	  										  	  
												    	<div class="col-md-12">	
												    	</br>										    
													    		<div class="row">
													    			<div class="col-md-12 text-left">
													    				<button type="button" id="btn_agregar_proceso_seleccion" class="btn btn-success" data-toggle="modal" data-target="#modal_proceso_seleccion">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>
													    				<button type="button" id="btn_replegar_todo" class="btn btn-warning" onclick="replegar()">Replegar&nbsp;&nbsp;<i class="glyphicon glyphicon-list"></i></button>
													    			</div>
													    		</div>					    		
								                               	<div class="row">
								                               		<div class="col-md-12">                               			
													    				<div class="table-responsive">
																			<table class="table table-hover table-bordered table-striped"  id="lista_proceso_seleccion">
																				<thead>	
																					<tr>
																						<caption><h4 class="form-section">Procesos de Selección</h4></caption>
																					</tr>																				
																					<tr class="success">																						
																						<th class="text-center">N°</th>
																						<th class="text-center">N° Proceso</th>																						
																						<th class="text-center">Objeto Conv.</th>																						
																						<th class="text-center" >Opciones</th>																																		
																					</tr>																					
																				</thead>
																				<tbody id="listado_procesos">
																				</tbody>
																			</table>	     
																		</div>			    						     			
								                               		</div>                               		
								                               	</div> 
								                         	 </div> 		                       		
												  		</div>
												  		<div class="tab-pane fade" id="eventos">
												  			</br>
												  			<div class="panel panel-primary">
												  				<div class="panel-body">
									                 					<div class="row">
									                 						<div class="col-md-4">
																				<div class="form-group">										             					
																       				<label class="control-label" for="numero_contrato_seleccion">Numero Contrato:</label>	              				
																       				<input type="text" class="form-control input" id="numero_contrato_seleccion" autocomplete="off">		              					
																				</div>
																			</div>
																			<div class="col-md-8">
									                 							<div class="form-group">										             					
																       				<label class="control-label" for="contratista_seleccionado">Contratista:</label>	              				
																       				<input type="text" class="form-control input" id="contratista_seleccionado" autocomplete="off">		              					
																				</div>
									                 						</div>
									                 					</div>
									                 					<div class="row">
									                 						<div class="col-md-4">
									                 							<label class="control-label" for="ruc_contratista_seleccionado">R.U.C:</label>	              				
																       			<input type="text" class="form-control input" id="ruc_contratista_seleccionado" autocomplete="off">	
									                 						</div>
									                 						<div class="col-md-4">
									                 							<div class="form-group">
																					<label class="control-label" for="monto_adjudicado_seleccionado">Monto Adjudicado: </label>
																					<div class="input-group">
																					 	 <span class="input-group-addon">S/</span>
																						  <input type="text" class="form-control" id="monto_adjudicado_seleccionado" name="monto_adjudicado_seleccionado" placeholder="#.##">
																					</div>
																				</div>
									                 						</div>
									                 						<div class="col-md-4">
									                 							<div class="form-group">										             					
														              				<label class="control-label" for="fecha_adjudicacion_seleccionado">Fecha Adjudicación:</label>
														              					<div class="input-group">	              				
														              						<input type="text" class="form-control input" id="fecha_adjudicacion_seleccionado" autocomplete="off" placeholder="mm/dd/yyyy">
														              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
														              					</div>	              					
																				</div>	
									                 						</div>
									                 					</div>
									                 			  </div>
									                 		</div>
									                 		<div id="panel_tabs_eventos" class="row">
									                 			<div class="col-md-12">
									                 				<ul class="nav nav-tabs" id="tabs_eventos_contrato">
									                 					<li role="presentation" class="active"><a href="#adenda" aria-controls="adenda" role="tab" data-toggle="tab">Adendas&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
								                						<li role="presentation"><a href="#adicional" aria-controls="adicional" role="tab" data-toggle="tab">Adicionales&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
									                 					<li role="presentation"><a href="#adelanto" aria-controls="adelanto" role="tab" data-toggle="tab">Adelanto&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
																		<li role="presentation"><a href="#ampliacion_plazo" aria-controls="ampliacion_plazo" role="tab" data-toggle="tab">Ampliaciones de Plazo&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>									                 				
									                 					<li role="presentation"><a href="#valorizacion" aria-controls="valorizacion" role="tab" data-toggle="tab">Valorizaciones&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
									                 					<li role="presentation"><a href="#defecto_constructivo" aria-controls="defecto_constructivo" role="tab" data-toggle="tab">Defecto Constructivo&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
									                 					<li role="presentation"><a href="#acta" aria-controls="acta" role="tab" data-toggle="tab">Actas&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
									                 					<li role="presentation"><a href="#garantia" aria-controls="garantia" role="tab" data-toggle="tab">Garantías&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
									                 					<li role="presentation"><a href="#incidencia" aria-controls="incidencia" role="tab" data-toggle="tab">Incidencias&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
									                 					<li role="presentation"><a href="#resolucion" aria-controls="resolucion" role="tab" data-toggle="tab">Resoluciones&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
									                 					<li role="presentation"><a href="#otros_documentos" aria-controls="otros_documentos" role="tab" data-toggle="tab">Otros Documentos&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
									                 				</ul>
									                 				</br>
									                 				<div class="tab-content">										  											  	
												  	 					<div class="tab-pane fade in active" id="adenda">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_adenda" class="btn btn-success" data-toggle="modal" data-target="#modal_adenda">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Adendas del Contrato</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Descripción</th>													    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_adendas">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 					<div class="tab-pane fade" id="adicional">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_adicional" class="btn btn-success" data-toggle="modal" data-target="#modal_adicional">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Adicionales del Contrato</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Resolución de Aprobación</th>													    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_adicionales">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 					<div class="tab-pane fade" id="adelanto">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_adelanto" class="btn btn-success" data-toggle="modal" data-target="#modal_adelanto">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Adelantos del Contrato</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Descripcion del Adelanto</th>													    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_adelantos">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 					<div class="tab-pane fade" id="ampliacion_plazo">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_ampliacion_plazo" class="btn btn-success" data-toggle="modal" data-target="#modal_ampliacion_plazo">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Ampliaciones de Plazo</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Resolución de Ampliación de Plazo</th>													    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_ampliaciones_plazo">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 					<div class="tab-pane fade" id="valorizacion">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_valorizacion" class="btn btn-success" data-toggle="modal" data-target="#modal_valorizacion">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    							<button type="button" id="btn_recalcular_valorizacion" class="btn btn-info" onClick="javascript:recalcular()">Recalcular&nbsp;&nbsp;<i class="glyphicon glyphicon-refresh"></i></button>
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Valorizaciones de Ejecución Física</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Periodo</th>
													    												<th class="text-center">Val. Prog.</th>
													    												<th class="text-center">Val. Ejec.</th>
													    												<th class="text-center">Val. Acum.</th>
													    												<th class="text-center">Porc. Val. Acum. (%) </th>													    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_valorizaciones">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 					<div class="tab-pane fade" id="defecto_constructivo">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_defecto_constructivo" class="btn btn-success" data-toggle="modal" data-target="#modal_defecto_constructivo">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Defectos Constructivos</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Defecto</th>													    																									    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_defecto_constructivo">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 					<div class="tab-pane fade" id="acta">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_acta" class="btn btn-success" data-toggle="modal" data-target="#modal_acta">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Actas</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Descripción del Acta</th>													    																									    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_actas">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 					<div class="tab-pane fade" id="garantia">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_garantia" class="btn btn-success" data-toggle="modal" data-target="#modal_garantia">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Garantías</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Descripción de la Garantía</th>													    																									    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_garantias">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 					<div class="tab-pane fade" id="incidencia">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_incidencia" class="btn btn-success" data-toggle="modal" data-target="#modal_incidencia">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Incidencias</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Detalle de la Incidencia</th>													    																									    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_incidencias">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 					<div class="tab-pane fade" id="resolucion">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_resolucion" class="btn btn-success" data-toggle="modal" data-target="#modal_resolucion">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Resoluciones</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Nombre de la Resolución</th>													    																									    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_resoluciones">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 					<div class="tab-pane fade" id="otros_documentos">
												  	 						<div class="col-md-12">
												  	 							<div class="col-md-12 text-left">
													    							<button type="button" id="btn_agregar_otros_documentos" class="btn btn-success" data-toggle="modal" data-target="#modal_otros_documentos">Agregar&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>													    							
													    						</div>
													    						</br>
													    						<div class="row">
													    							<div class="col-md-12">
													    								<div class="table-responsive">
													    									<table class="table table-hover table-bordered table-striped">
													    										<thead>
													    											<tr>
													    												<caption><h4 class="form-section">Otros Documentos</h4></caption>
													    											</tr>
													    											<tr class="active">
													    												<th class="text-center">N°</th>
													    												<th class="text-center">Nombre del Documento</th>													    																									    																								    												
													    												<th class="text-center">Opciones</th>												    												
													    											</tr>
													    										</thead>
													    										<tbody id="listado_otros_documentos">
													    										</tbody>													    								
													    									</table>
													    								</div>
													    							</div>
													    						</div>
												  	 						</div>
												  	 					</div>
												  	 				</div>
									                 			</div>
									                 		</div>
												  		</div>										  													   
													</div>																						
								       			</div>
					  						</div>
		                 				</div>
		                 			</div>
                 			</div>                 			            			 
               			</div>                 			
               		</div>

                 
  <!-- INICIO MODAL LISTA PROYECTOS  -->
  <div class="modal fade"  id="modal_proyectos" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
											<table class="table table-hover" id="tabla_proyectos">
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

<!-- FIN MODAL LISTA PROYECTOS  -->

<!-- INICIO MODAL PROCESO SELECCION  -->

<div class="modal fade"  id="modal_proceso_seleccion" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Proceso de Selección</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Proceso de Selección
						</div>
						<div class="panel panel-body">
							<form id="formulario_proceso_seleccion" role="form">
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="proceso_seleccion_pertenencia">Objeto de la Convocatoria:</label>
				              				<select class="form-control" id="proceso_seleccion_pertenencia">
				              					<option value="1">Bien</option>
				              					<option value="2">Consultoría de Obra</option>
				              					<option value="3">Obra</option>
				              					<option value="4">Servicio</option>
				              				</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="numero_proceso">Número de Proceso:</label>	              				
				              				<input type="text" class="form-control input" id="numero_proceso" autocomplete="off">		              					
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="valor_referencial_proceso_seleccion">Val. Referencial:</label>	              				
				              				<input type="text" class="form-control input" id="valor_referencial_proceso_seleccion" autocomplete="off">		              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="fecha_valor_referencial">Fecha:</label>
				              					<div class="input-group">	              				
				              						<input type="text" class="form-control input" id="fecha_valor_referencial" autocomplete="off" placeholder="mm/dd/yyyy">
				              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              					</div>	              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="plazo_ejecucion">Plazo Ejecución:</label>	              				
				              				<input type="text" class="form-control input" id="plazo_ejecucion" autocomplete="off">		              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="modalidad_contratacion">Modalidad Contratación:</label>
				              				<select class="form-control" id="modalidad_contratacion">
				              					<option value="1">Suma alzada</option>
				              					<option value="2">Costos unitarios</option>
				              					<option value="3">Equipamiento</option>
				              				</select>
										</div>
									</div>																
								</div>
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_proceso_seleccion">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_proceso_seleccion" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_proceso_seleccion()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL PROCESO SELECCION  -->

<!-- INICIO MODAL PROCESO SELECCION  ITEM -->

<div class="modal fade"  id="modal_proceso_seleccion_item" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Items </strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Item
						</div>
						<div class="panel panel-body">
							<form id="formulario_proceso_seleccion_item" role="form">								
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
							            	<label class="control-label" for="id_item_proyecto_">Item:</label>
							              		<select class="form-control" id="id_item_proyecto_">
							              			<option></option>							              					
							              		</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="valor_referencial_proceso_seleccion_item">Val. Referencial:</label>	              				
				              				<input type="text" class="form-control input" id="valor_referencial_proceso_seleccion_item" autocomplete="off">		              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="fecha_valor_referencial_proceso_seleccion_item">Fecha:</label>
				              					<div class="input-group">	              				
				              						<input type="text" class="form-control input" id="fecha_valor_referencial_proceso_seleccion_item" autocomplete="off" placeholder="mm/dd/yyyy">
				              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              					</div>	              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
				              				<label class="control-label" for="plazo_ejecucion_proceso_seleccion_item">Plazo Ejecución:</label>    				
				              				<input type="text" class="form-control input" id="plazo_ejecucion_proceso_seleccion_item" autocomplete="off">              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="situacion">Situación:</label>
				              				<select class="form-control" id="situacion">
				              					<option value="1">Adjudicado</option>
				              					<option value="2">Desierto</option>
				              					<option value="3">Cancelado</option>
				              					<option value="4">Revertido</option>
				              				</select>
										</div>
									</div>																
								</div>
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_proceso_seleccion_item">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_proceso_seleccion_item" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_proceso_seleccion_item()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL PROCESO SELECCION ITEM -->

<!-- INICIO MODAL CONTRATO PROCESO SELECCION ITEM -->

<div class="modal fade"  id="modal_contrato_proceso_seleccion_item" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Contrato</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Contrato
						</div>
						<div class="panel panel-body">
							<form id="formulario_contrato_proceso_seleccion_item" role="form">								
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="numero_contrato_proceso_seleccion_item">Numero Contrato:</label>	              				
				              				<input type="text" class="form-control input" id="numero_contrato_proceso_seleccion_item" autocomplete="off">		              					
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="contratista_adjudicado_contrato_proceso_seleccion_item">Contratista Adjudicado:</label>	              				
				              				<input type="text" class="form-control input" id="contratista_adjudicado_contrato_proceso_seleccion_item" autocomplete="off">		              					
										</div>
									</div>																						
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">										             					
				              				<label class="control-label" for="ruc_contratista_contrato_proceso_seleccion_item">R.U.C</label>	              				
				              				<input type="text" class="form-control input" id="ruc_contratista_contrato_proceso_seleccion_item" maxlength="11" autocomplete="off">		              					
										</div>
									</div>		
									<div class="col-md-4">
										<div class="form-group">										             					
				              				<label class="control-label" for="fecha_adjudicacion_contrato_proceso_seleccion_item">Fecha Adjudicación:</label>
				              					<div class="input-group">	              				
				              						<input type="text" class="form-control input" id="fecha_adjudicacion_contrato_proceso_seleccion_item" autocomplete="off" placeholder="mm/dd/yyyy">
				              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              					</div>	              					
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">										             					
				              				<label class="control-label" for="fecha_firma_contrato_proceso_seleccion_item">Fecha Firma de Contrato:</label>
				              					<div class="input-group">	              				
				              						<input type="text" class="form-control input" id="fecha_firma_contrato_proceso_seleccion_item" autocomplete="off" placeholder="mm/dd/yyyy">
				              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              					</div>	              					
										</div>
									</div>																			
								</div>	
								<div class="row">
									<div class="col-md-4">
										<div class="form-group" id="div_monto_adjudicado">
											<label class="control-label" for="monto_adjudicado_contrato_proceso_seleccion_item">Monto Adjudicado: </label>
											<div class="input-group">
											 	 <span class="input-group-addon">S/</span>
												  <input type="text" class="form-control" id="monto_adjudicado_contrato_proceso_seleccion_item" name="monto_adjudicado_contrato_proceso_seleccion_item" placeholder="#.##" onkeyup="calcular_porcentaje_pagado()">
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" id="div_monto_adjudicado">
											<label class="control-label" for="monto_pagado_contrato_proceso_seleccion_item">Monto Pagado: </label>
											<div class="input-group">
											 	 <span class="input-group-addon">S/</span>
												  <input type="text" class="form-control" id="monto_pagado_contrato_proceso_seleccion_item" name="monto_adjudicado_contrato_proceso_seleccion_item" placeholder="#.##" onkeyup="calcular_porcentaje_pagado()">
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" id="div_monto_adjudicado">
											<label class="control-label" for="porcentaje_pagado_contrato_proceso_seleccion_item">Porcentaje Pagado: </label>
											<div class="input-group">
											 	 <span class="input-group-addon">%</span>
												  <input type="text" class="form-control" id="porcentaje_pagado_contrato_proceso_seleccion_item" name="monto_adjudicado_contrato_proceso_seleccion_item" placeholder="#.##">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">										             					
				              				<label class="control-label" for="fecha_entrega_terreno_contrato_proceso_seleccion_item">Fecha Entrega Terreno:</label>
				              					<div class="input-group">	              				
				              						<input type="text" class="form-control input" id="fecha_entrega_terreno_contrato_proceso_seleccion_item" autocomplete="off" placeholder="mm/dd/yyyy">
				              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              					</div>	              					
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">										             					
				              				<label class="control-label" for="plazo_ejecucion_contrato_proceso_seleccion_item">Plazo ejecución (Días)</label>	              				
				              				<input type="text" class="form-control input" id="plazo_ejecucion_contrato_proceso_seleccion_item" autocomplete="off">		              					
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">										             					
				              				<label class="control-label" for="fecha_inicio_plazo_contractual_proceso_seleccion_item">Fecha Inicio Plazo Contractual:</label>
				              					<div class="input-group">	              				
				              						<input type="text" class="form-control input" id="fecha_inicio_plazo_contractual_proceso_seleccion_item" autocomplete="off" placeholder="mm/dd/yyyy">
				              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              					</div>	              					
										</div>
									</div>									
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">										             					
				              				<label class="control-label" for="total_dias_ampliacion_plazo_contrato_proceso_seleccion_item">Total Ampl. Plazo</label>	              				
				              				<input type="text" class="form-control input" id="total_dias_ampliacion_plazo_contrato_proceso_seleccion_item" autocomplete="off">		              					
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">										             					
				              				<label class="control-label" for="total_adendas_contrato_proceso_seleccion_item">Total Adendas</label>	              				
				              				<input type="text" class="form-control input" id="total_adendas_contrato_proceso_seleccion_item" autocomplete="off">		              					
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" id="div_monto_prestaciones_adicionales">
											<label class="control-label" for="monto_prestaciones_adicionales_contrato_proceso_seleccion_item">Monto Prest. Adicionales: </label>
											<div class="input-group">
											 	 <span class="input-group-addon">S/</span>
												  <input type="text" class="form-control" id="monto_prestaciones_adicionales_contrato_proceso_seleccion_item" name="monto_adjudicado_contrato_proceso_seleccion_item" placeholder="#.##">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
						            	<div class="form-group">
						            		<label class="control-label" for="observaciones_contrato_proceso_seleccion_obra">Observaciones:</label>
						            		<textarea class="form-control" id="observaciones_contrato_proceso_seleccion_obra" name="observaciones_contrato_proceso_seleccion_obra" rows="3"></textarea>             		
						            	</div>              				
						            </div>								
								</div>
								<div class="row">									
									<div class="col-md-3">
										<div class="form-group">										             					
					              			<label class="control-label" for="liquidacion_contrato_proceso_seleccion_item">Liquidación:</label>
					              			<select class="form-control" id="liquidacion_contrato_proceso_seleccion_item">
					              				<option value="0">No</option>
					              				<option value="1">Si</option>
					              			</select>
										</div>
									</div>									
								</div>					
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_contrato_proceso_seleccion_item">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_contrato_proceso_seleccion_item" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_contrato_proceso_seleccion_item()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL CONTRATO PROCESO SELECCION ITEM -->


<!-- INICIO MODAL EXPEDIENTE TECNICO -->
<div class="modal fade"  id="modal_expediente_tecnico" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Expediente Técnico </strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Expediente Técnico
						</div>					
						<div class="panel panel-body">
							<form id="formulario_expediente_tecnico" role="form">
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-info">
											<div class="panel panel-heading">
												Informe Técnico
											</div>
											<div class="panel panel-body">
												<div class="col-md-12">
													<div class="form-group">
							              				<label class="control-label" for="item_descripcion_proyecto">Item:</label>
							              				<select class="form-control" id="item_descripcion_proyecto">
							              					<option></option>							              					
							              				</select>
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">										             					
							              				<label class="control-label" for="id_tipo_informe_tecnico">Informe Técnico Etapa Inversión:</label>
							              				<select class="form-control" id="id_tipo_informe_tecnico">
							              					<option value="1">Formato-14</option>
							              					<option value="2">Formato-15</option>
							              					<option value="3">Formato-16</option>
							              					<option value="3">Formato-17</option>
							              				</select>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
							              				<label class="control-label" for="monto_informe_tecnico_etapa_inversion">Monto (S/.):</label>    				
							              				<input type="text" class="form-control input" id="monto_informe_tecnico_etapa_inversion" autocomplete="off">              					
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
							              				<label class="control-label" for="fecha_informe_tecnico_etapa_inversion">Fecha:</label>    				
							              				<div class="input-group">	              				
						              						<input type="text" class="form-control input" id="fecha_informe_tecnico_etapa_inversion" autocomplete="off" placeholder="mm/dd/yyyy">
						              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              							</div>	             					
													</div>
												</div>												
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-info">
											<div class="panel panel-heading">
												Proceso de Selección
											</div>
											<div class="panel panel-body">
												<div class="col-md-12">
													<div class="form-group">
							              				<label class="control-label" for="numero_proceso_expediente_tecnico">Número Proceso:</label>    				
							              				<input type="text" class="form-control input" id="numero_proceso_expediente_tecnico" autocomplete="off">              					
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
							              				<label class="control-label" for="valor_referencial_expediente_tecnico">Valor Referencial:</label>    				
							              				<input type="text" class="form-control input" id="valor_referencial_expediente_tecnico" autocomplete="off">              					
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">										             					
							              				<label class="control-label" for="modalidad_contratacion_expediente_tecnico">Modalidad:</label>
							              				<select class="form-control" id="modalidad_contratacion_expediente_tecnico">
							              					<option value="1">Administración Directa</option>
							              					<option value="2">Proceso de Selección</option>
							              				</select>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
							              				<label class="control-label" for="fecha_presupuesto_base">Fecha Presup. Base:</label>    				
							              				<div class="input-group">	              				
						              						<input type="text" class="form-control input" id="fecha_presupuesto_base" autocomplete="off" placeholder="mm/dd/yyyy">
						              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              							</div>	             					
													</div>
												</div>
												<div class="col-md-12">
						              				<div class="form-group">
						              					<label class="control-label" for="postores">Postores:</label>
						              					<textarea class="form-control" id="postores" name="postores" rows="3"></textarea>             		
						              				</div>              				
						              			</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-info">
											<div class="panel panel-heading">
												Adjudicación
											</div>
											<div class="panel panel-body">
												<div class="col-md-12">
													<div class="form-group">
							              				<label class="control-label" for="numero_contrato_expediente_tecnico">Número Contrato:</label>    				
							              				<input type="text" class="form-control input" id="numero_contrato_expediente_tecnico" autocomplete="off">              					
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
							              				<label class="control-label" for="contratista_adjudicado_expediente_tecnico">Contratista Adjudicado:</label>    				
							              				<input type="text" class="form-control input" id="contratista_adjudicado_expediente_tecnico" autocomplete="off">              					
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
							              				<label class="control-label" for="ruc_contratista_adjudicado_expediente_tecnico">R.U.C Contratista (S/.):</label>    				
							              				<input type="text" class="form-control input" id="ruc_contratista_adjudicado_expediente_tecnico" autocomplete="off">              					
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
							              				<label class="control-label" for="monto_adjudicado_expediente_tecnico">Monto Adjudicado (S/.):</label>    				
							              				<input type="text" class="form-control input" id="monto_adjudicado_expediente_tecnico" autocomplete="off">              					
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
							              				<label class="control-label" for="fecha_firma_contrato_expediente_tecnico">Fecha Firma Contrato:</label>    				
							              				<div class="input-group">	              				
						              						<input type="text" class="form-control input" id="fecha_firma_contrato_expediente_tecnico" autocomplete="off" placeholder="mm/dd/yyyy">
						              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              							</div>	             					
													</div>
												</div>												
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-info">
											<div class="panel panel-heading">
												Buena Pro
											</div>
											<div class="panel panel-body">
												<div class="col-md-3">
													<div class="form-group">
							              				<label class="control-label" for="fecha_otorgamiento">Fecha Otorgamiento:</label>    				
							              				<div class="input-group">	              				
						              						<input type="text" class="form-control input" id="fecha_otorgamiento" autocomplete="off" placeholder="mm/dd/yyyy">
						              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              							</div>	             					
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
							              				<label class="control-label" for="plazo_ejecucion_expediente_tecnico">Plzo. Ejecución:</label> 
						              						<input type="text" class="form-control input" id="plazo_ejecucion_expediente_tecnico" autocomplete="off">
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">										             					
							              				<label class="control-label" for="tipo_ejecucion_expediente_tecnico">Tipo de ejecución:</label>
							              				<select class="form-control" id="tipo_ejecucion_expediente_tecnico">
							              					<option value="1">Administración Directa</option>
							              					<option value="2">Proceso de Selección</option>
							              				</select>
													</div>
												</div>
												<div class="col-md-12">
						              				<div class="form-group">
						              					<label class="control-label" for="observaciones_expediente_tecnico">Observaciones:</label>
						              					<textarea class="form-control " id="observaciones_expediente_tecnico" name="observaciones_expediente_tecnico" rows="3"></textarea>             		
						              				</div>              				
						              			</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_expediente_tecnico">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_expediente_tecnico" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>											
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <button type="button" class="btn btn-default" data-dismiss="modal" onclick="limpiar_form_expediente_tecnico()">Cerrar</button>       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL EXPEDIENTE TECNICO -->

<!-- INICIO MODAL ADENDA -->

<div class="modal fade"  id="modal_adenda" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Adenda </strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos de la Adenda
						</div>
						<div class="panel panel-body">
							<form id="formulario_adenda" role="form">								
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="adenda_descripcion">Descripción de la Adenda:</label>	              				
				              				<input type="text" class="form-control input" id="adenda_descripcion" autocomplete="off">		              					
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="fecha_suscripcion_adenda">Fecha Suscripcion</label>
				              					<div class="input-group">	              				
				              						<input type="text" class="form-control input" id="fecha_suscripcion_adenda" autocomplete="off" placeholder="mm/dd/yyyy">
				              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              					</div>	              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
				              				<label class="control-label" for="plazo_otorgado_adenda">Plzo. Otorg:</label>    				
				              				<input type="text" class="form-control input" id="plazo_otorgado_adenda" autocomplete="off">              					
										</div>
									</div>																																	
								</div>
								<div class="row">
									<div class="col-md-12">																
										<div class="form-group">
						              		<label class="control-label" for="motivo_generado_adenda">Motivo Generado:</label>
						              	    <textarea class="form-control " id="motivo_generado_adenda" name="motivo_generado_adenda" rows="3"></textarea>             		
						              	</div>
									</div>	
								</div>
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_adenda">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_adenda" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_adenda()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL ADENDA -->

<!-- INICIO MODAL ADICIONAL -->

<div class="modal fade"  id="modal_adicional" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Adicionales </strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Adicional
						</div>
						<div class="panel panel-body">
							<form id="formulario_adicional" role="form">														
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="resolucion_aprobacion_adicional">Resolución de Aprobación del Adicional:</label>	              				
				              				<input type="text" class="form-control input" id="resolucion_aprobacion_adicional" autocomplete="off">		              					
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="fecha_resolucion_aprobacion_adicional">Fecha:</label>
				              					<div class="input-group">	              				
				              						<input type="text" class="form-control input" id="fecha_resolucion_aprobacion_adicional" autocomplete="off" placeholder="mm/dd/yyyy">
				              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              					</div>	              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group" >
											<label class="control-label" for="monto_adicional_otorgado">Monto Adic. Otorgado:</label>
											<div class="input-group">
											 	 <span class="input-group-addon">S/.</span>
												  <input type="text" class="form-control" id="monto_adicional_otorgado" name="monto_adicional_otorgado" placeholder="#.##">
											</div>
										</div>
									</div>																																	
								</div>
								<div class="row">
									<div class="col-md-12">																
										<div class="form-group">
						              		<label class="control-label" for="motivo_generado_adicional">Motivo Generado</label>
						              	    <textarea class="form-control " id="motivo_generado_adicional" name="motivo_generado_adicional" rows="3"></textarea>             		
						              	</div>
									</div>	
								</div>
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_adicional">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_adicional" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_adicional()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL ADICIONAL -->

<!-- INICIO MODAL ADELANTO -->

<div class="modal fade"  id="modal_adelanto" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Adelantos</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Adelanto
						</div>
						<div class="panel panel-body">
							<form id="formulario_adelanto" role="form">
																		
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="adelanto_descipcion">Descripción del Adelanto:</label>	              				
				              				<input type="text" class="form-control input" id="adelanto_descipcion" autocomplete="off">		              					
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="fecha_solicitud_adelanto">Fecha Solic. Adelanto:</label>
				              					<div class="input-group">	              				
				              						<input type="text" class="form-control input" id="fecha_solicitud_adelanto" autocomplete="off" placeholder="mm/dd/yyyy">
				              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              					</div>	              					
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">										             					
							              	<label class="control-label" for="tipo_adelanto">Tipo de Adelanto:</label>
							              		<select class="form-control" id="tipo_adelanto">
							              				<option value="1">Adelanto del Costo Directo</option>
							              				<option value="2">Adelanto de Materiales</option>
							              		</select>
										</div>
									</div>									
									<div class="col-md-3">
										<div class="form-group" >
											<label class="control-label" for="monto_adelanto">Monto del Adelanto:</label>
											<div class="input-group">
											 	 <span class="input-group-addon">S/.</span>
												  <input type="text" class="form-control" id="monto_adelanto" name="monto_adelanto" placeholder="#.##" onkeyup="valida_monto_adjudicado()">
											</div>
										</div>
									</div>																																	
								</div>								
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_adelanto">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_adelanto" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_adelanto()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL ADELANTO -->

<!-- INCICIO MODAL AMPLIACION PLAZO -->

<div class="modal fade"  id="modal_ampliacion_plazo" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Ampliaciones de Plazo</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos de la Ampliación de Plazo
						</div>
						<div class="panel panel-body">
							<form id="formulario_ampliacion_plazo" role="form">																						
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="resolucion_aprobacion_ampliacion_plazo">Resolución de Aprobación:</label>	              				
				              				<input type="text" class="form-control input" id="resolucion_aprobacion_ampliacion_plazo" autocomplete="off">		              					
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">										             					
				              				<label class="control-label" for="fecha_resolucion_aprobacion_ampliacion_plazo">Fecha de Aprobación:</label>
				              					<div class="input-group">	              				
				              						<input type="text" class="form-control input" id="fecha_resolucion_aprobacion_ampliacion_plazo" autocomplete="off" placeholder="mm/dd/yyyy">
				              						<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				              					</div>	              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">					             					
				              				<label class="control-label" for="plazo_otorgado_ampliacion_plazo">Plazo Otorg. (Días):</label>	              				
				              				<input type="text" class="form-control input" id="plazo_otorgado_ampliacion_plazo" autocomplete="off">
										</div>
									</div>																															
								</div>
								<div class="row">
									<div class="col-md-12">																
										<div class="form-group">
						              		<label class="control-label" for="motivo_generado_ampliacion_plazo">Motivo Generado</label>
						              	    <textarea class="form-control " id="motivo_generado_ampliacion_plazo" name="motivo_generado_ampliacion_plazo" rows="3"></textarea>             		
						              	</div>
									</div>	
								</div>								
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_ampliacion_plazo">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_ampliacion_plazo" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
								
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_ampliacion_plazo()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL AMPLIACION PLAZO -->

<!-- INICIO MODAL VALORIZACION -->

<div class="modal fade"  id="modal_valorizacion" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Valorizaciones</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos de la Valorizacion
						</div>
						<div class="panel panel-body">
							<form id="formulario_valorizacion" role="form">																						
								<div class="row">
									<div class="col-md-3">									
										<div class="form-group">										             					
					              			<label class="control-label" for="periodo">Periodo:</label>
					              			<div class="input-group">	              				
					              				<input type="text" class="form-control input" id="periodo" autocomplete="off" placeholder="mm/dd/yyyy">
					              				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					              			</div>	              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group" >
											<label class="control-label" for="valorizacion_programada">Val. Programada:</label>
											<div class="input-group">
											 	 <span class="input-group-addon">S/.</span>
												  <input type="text" class="form-control" id="valorizacion_programada" name="valorizacion_programada" placeholder="#.##">
											</div>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group" >
											<label class="control-label" for="valorizacion_ejecutada">Val. Ejecutada:</label>
											<div class="input-group">
											 	 <span class="input-group-addon">S/.</span>
												  <input type="text" class="form-control" id="valorizacion_ejecutada" name="valorizacion_ejecutada" placeholder="#.##">
											</div>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group" id="div_valorizacion_acumulada">
											<label class="control-label" for="valorizacion_acumulada">Val. Acumulada:</label>
											<div class="input-group">
											 	 <span class="input-group-addon">S/.</span>
												  <input type="text" class="form-control" id="valorizacion_acumulada" name="valorizacion_acumulada" placeholder="#.##">
											</div>
										</div>									
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group" id="div_porcentaje_valorizacion_acumulada">					             					
				              				<label class="control-label" for="porcentaje_valorizado_acumulado">Porcent. Val. Acum. (%):</label>	              				
				              				<input type="text" class="form-control input" id="porcentaje_valorizado_acumulado" autocomplete="off">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">					             					
				              				<label class="control-label" for="observacion_valorizacion">Observacion: </label>	              				
				              				<input type="text" class="form-control input" id="observacion_valorizacion" autocomplete="off">
										</div>
									</div>
								</div>																						
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_valorizacion">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_valorizacion" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
								
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_valorizacion()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL VALORIZACION  -->

<!-- INICIO MODAL DEFECTO CONSTRUCTIVO  -->

<div class="modal fade"  id="modal_defecto_constructivo" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Defectos Constructivos</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Defecto Constructivo
						</div>
						<div class="panel panel-body">
							<form id="formulario_defecto_constructivo" role="form">				
							 	<div class="row">
							 		<div class="col-md-12">									
										<div class="form-group">										             					
					              			<label class="control-label" for="asiento_cuaderno_obra">Asiento del Cuaderno de Obra</label>					              			              				
					              			<input type="text" class="form-control" id="asiento_cuaderno_obra" autocomplete="off">
										</div>
									</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">																
										<div class="form-group">
						              		<label class="control-label" for="defecto_constructivo_defecto">Defecto Constructivo: </label>
						              	    <textarea class="form-control " id="defecto_constructivo_defecto" name="defecto_constructivo_defecto" rows="3"></textarea>             		
						              	</div>
									</div>
							 	</div>																				
								<div class="row">
									<div class="col-md-3">									
										<div class="form-group">										             					
					              			<label class="control-label" for="fecha_encontrado">Fecha Encontrado:</label>
					              			<div class="input-group">	              				
					              				<input type="text" class="form-control input" id="fecha_encontrado" autocomplete="off" placeholder="mm/dd/yyyy">
					              				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					              			</div>	              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">										             					
					              			<label class="control-label" for="estado_defecto">Estado del Defecto : </label>					              			              				
					              			<input type="text" class="form-control" id="estado_defecto" autocomplete="off">
										</div>
									</div>									
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">					             					
				              				<label class="control-label" for="acciones">Acciones : </label>	              				
				              				<textarea class="form-control " id="acciones" name="acciones" rows="3"></textarea>
										</div>
									</div>
								</div>																						
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_defecto_constructivo">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_defecto_constructivo" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
								
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_defecto_constructivo()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL DEFECTO CONSTRUCTIVO  -->

<!-- INICIO MODAL ACTA -->

<div class="modal fade"  id="modal_acta" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Actas</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Acta
						</div>
						<div class="panel panel-body">
							<form id="formulario_acta" role="form">							
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">										             					
					              			<label class="control-label" for="acta_descripcion">Descripción del Acta: </label>					              			              				
					              			<input type="text" class="form-control" id="acta_descripcion" autocomplete="off">
										</div>
							 		</div>
							 	</div>																					
								<div class="row">
									<div class="col-md-3">									
										<div class="form-group">										             					
					              			<label class="control-label" for="fecha_acta">Fecha del Acta:</label>
					              			<div class="input-group">	              				
					              				<input type="text" class="form-control input" id="fecha_acta" autocomplete="off" placeholder="mm/dd/yyyy">
					              				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					              			</div>	              					
										</div>
									</div>																		
								</div>
								<div class="row">
									<div class="col-md-12">																
										<div class="form-group">
						              		<label class="control-label" for="detalle_acta">Detalle del Acta: </label>
						              	    <textarea class="form-control " id="detalle_acta" name="detalle_acta" rows="3"></textarea>             		
						              	</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">																
										<div class="form-group">
						              		<label class="control-label" for="motivo_generado_acta">Motivo Generado: </label>
						              	    <textarea class="form-control " id="motivo_generado_acta" name="motivo_generado_acta" rows="3"></textarea>             		
						              	</div>
									</div>
								</div>																						
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_acta">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_acta" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
								
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_acta()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL ACTA -->

<!-- INICIO MODAL GARANTIAS -->

<div class="modal fade"  id="modal_garantia" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Garantías</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos de la Garantía
						</div>
						<div class="panel panel-body">
							<form id="formulario_garantia" role="form">	
											
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">										             					
					              			<label class="control-label" for="descripcion_garantia">Descripción de la Garantía: </label>					              			              				
					              			<input type="text" class="form-control" id="descripcion_garantia" autocomplete="off">
										</div>
							 		</div>
							 	</div>																					
								<div class="row">
									<div class="col-md-3">									
										<div class="form-group">										             					
					              			<label class="control-label" for="factura">Factura: </label>					              			              				
					              			<input type="text" class="form-control" id="factura" autocomplete="off">
										</div>
									</div>
									<div class="col-md-3">																
										<div class="form-group">										             					
					              			<label class="control-label" for="fecha_factura">Fecha Factura:</label>
					              			<div class="input-group">	              				
					              				<input type="text" class="form-control input" id="fecha_factura" autocomplete="off" placeholder="mm/dd/yyyy">
					              				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					              			</div>	              					
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">										             					
							              	<label class="control-label" for="tipo_garantia">Tipo de Garantía:</label>
							              		<select class="form-control" id="tipo_garantia">
							              				<option value="1">Carta Fianza</option>
							              				<option value="2">Póliza de Caución</option>							              				
							              		</select>
										</div>
									</div>
									<div class="col-md-3">									
										<div class="form-group">										             					
					              			<label class="control-label" for="institucion_financiera">Institución Financiera: </label>					              			              				
					              			<input type="text" class="form-control" id="institucion_financiera" autocomplete="off">
										</div>
									</div>																											
								</div>								
								<div class="row">
									<div class="col-md-3">																
										<div class="form-group">										             					
					              			<label class="control-label" for="numero_documento_garantia">N° del Documento: </label>					              			              				
					              			<input type="text" class="form-control" id="numero_documento_garantia" autocomplete="off">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group" >
											<label class="control-label" for="monto_adelanto_garantia">Monto del Adelanto:</label>
											<div class="input-group">
											 	 <span class="input-group-addon">S/.</span>
												  <input type="text" class="form-control" id="monto_adelanto_garantia" name="monto_adelanto_garantia" placeholder="#.##">
											</div>
										</div>									
									</div>
									<div class="col-md-3">
										<div class="form-group" >
											<label class="control-label" for="monto_carta_fianza">Monto Carta Fianza:</label>
											<div class="input-group">
											 	 <span class="input-group-addon">S/.</span>
												  <input type="text" class="form-control" id="monto_carta_fianza" name="monto_carta_fianza" placeholder="#.##">
											</div>
										</div>									
									</div>
									<div class="col-md-3">																
										<div class="form-group">										             					
					              			<label class="control-label" for="fecha_creacion">Fecha de Creación:</label>
					              			<div class="input-group">	              				
					              				<input type="text" class="form-control input" id="fecha_creacion" autocomplete="off" placeholder="mm/dd/yyyy">
					              				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					              			</div>	              					
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">																
										<div class="form-group">										             					
					              			<label class="control-label" for="fecha_vencimiento">Fecha de Vencimiento:</label>
					              			<div class="input-group">	              				
					              				<input type="text" class="form-control input" id="fecha_vencimiento" autocomplete="off" placeholder="mm/dd/yyyy">
					              				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					              			</div>	              					
										</div>
									</div>									
								</div>																						
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_garantia">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_garantia" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
								
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_garantia()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL GARANTIAS -->

<!-- INICIO MODAL INCIDENCIA -->

<div class="modal fade"  id="modal_incidencia" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Incidencias</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos de la Incidencia
						</div>
						<div class="panel panel-body">
							<form id="formulario_incidencia" role="form">								
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="detalle_incidencia">Detalle de la Incidencia: </label>
						              	    <textarea class="form-control " id="detalle_incidencia" name="detalle_incidencia" rows="3"></textarea>             		
						              	</div>
							 		</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="motivo_incidencia">Motivo_incidencia: </label>
						              	    <textarea class="form-control " id="motivo_incidencia" name="motivo" rows="3"></textarea>             		
						              	</div>
							 		</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">									
										<div class="form-group">										             					
					              			<label class="control-label" for="asiento_cuaderno_obra_incidencia">Asiento del cuaderno de obra: </label>					              			              				
					              			<input type="text" class="form-control" id="asiento_cuaderno_obra_incidencia" autocomplete="off">
										</div>
									</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-3">																
										<div class="form-group">										             					
					              			<label class="control-label" for="fecha_evento">Fecha del Evento:</label>
					              			<div class="input-group">	              				
					              				<input type="text" class="form-control input" id="fecha_evento" autocomplete="off" placeholder="mm/dd/yyyy">
					              				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					              			</div>	              					
										</div>
									</div>																		
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">																
										<div class="form-group">
						              		<label class="control-label" for="fecha_asiento">Fecha Asiento: </label>
						              	    <textarea class="form-control " id="fecha_asiento" name="fecha_asiento" rows="3"></textarea>             		
						              	</div>
									</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="acciones_incidencia">Acciones tomadas: </label>
						              	    <textarea class="form-control " id="acciones_incidencia" name="acciones_incidencia" rows="3"></textarea>             		
						              	</div>
							 		</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">									
										<div class="form-group">										             					
					              			<label class="control-label" for="documento_emitido">Documento Emitido:</label>					              			              				
					              			<input type="text" class="form-control" id="documento_emitido" autocomplete="off">
										</div>
									</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="sumilla">Sumilla: </label>
						              	    <textarea class="form-control " id="sumilla" name="sumilla" rows="5"></textarea>             		
						              	</div>
							 		</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="objeto_incidencia">Objeto de la Incidencia: </label>
						              	    <textarea class="form-control " id="objeto_incidencia" name="objeto_incidencia" rows="3"></textarea>             		
						              	</div>
							 		</div>
							 	</div>																	
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_incidencia">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_incidencia" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
								
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_incidencia()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL INCIDENCIA -->

<!-- INICIO MODAL RESOLUCION -->

<div class="modal fade"  id="modal_resolucion" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Resoluciónes</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos de la Resolución
						</div>
						<div class="panel panel-body">
							<form id="formulario_resolucion" role="form">							
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="resolucion_conformacion_comite">Resolución: </label>
						              	    <textarea class="form-control " id="resolucion_conformacion_comite" name="resolucion_conformacion_comite" rows="3"></textarea>             		
						              	</div>
							 		</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-3">																
										<div class="form-group">										             					
					              			<label class="control-label" for="fecha_resolucion">Fecha Resolución:</label>
					              			<div class="input-group">	              				
					              				<input type="text" class="form-control input" id="fecha_resolucion" autocomplete="off" placeholder="mm/dd/yyyy">
					              				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					              			</div>	              					
										</div>
									</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="miembros">Miembros: </label>
						              	    <textarea class="form-control " id="miembros" name="miembros" rows="3"></textarea>             		
						              	</div>
							 		</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="motivo_generado_resolucion">Motivo: </label>
						              	    <textarea class="form-control " id="motivo_generado_resolucion" name="motivo_generado_resolucion" rows="3"></textarea>             		
						              	</div>
							 		</div>
							 	</div>							 			
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_resolucion">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_resolucion" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
								
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_resolucion()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL RESOLUCION  -->

<!-- INICIO MODAL OTROS DOCUMENTOS -->

<div class="modal fade"  id="modal_otros_documentos" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Documentos</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Documento
						</div>
						<div class="panel panel-body">
							<form id="formulario_otros_documentos" role="form">										
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="informacion_especifica">Información Específica: </label>
						              	    <textarea class="form-control " id="informacion_especifica" name="informacion_especifica" rows="3"></textarea>             		
						              	</div>
							 		</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-3">																
										<div class="form-group">										             					
					              			<label class="control-label" for="fecha_informe_otros_documentos">Fecha Informe:</label>
					              			<div class="input-group">	              				
					              				<input type="text" class="form-control input" id="fecha_informe_otros_documentos" autocomplete="off" placeholder="mm/dd/yyyy">
					              				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					              			</div>	              					
										</div>
									</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="detalle_otros_documentos">Detalle: </label>
						              	    <textarea class="form-control " id="detalle_otros_documentos" name="detalle_otros_documentos" rows="3"></textarea>             		
						              	</div>
							 		</div>
							 	</div>
							 	<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group">
						              		<label class="control-label" for="motivo_generado_otros_documentos">Motivo: </label>
						              	    <textarea class="form-control " id="motivo_generado_otros_documentos" name="motivo_generado_otros_documentos" rows="3"></textarea>             		
						              	</div>
							 		</div>
							 	</div>							 			
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_otros_documentos">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_otros_documentos" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>								
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_otros_documentos()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL OTROS DOCUMENTOS -->

 <!-- INICIO DE MODAL DE CONFIRMACION ELIMINAR -->
 <div class="modal fade"  id="modal_confirma_eliminar" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-ms">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" ><strong>Confirmación</strong></h5>                
      </div>
      <div class="modal-body">
      	<div class="row">
			<div class="col-sm-12">
				<div id="panel_mensaje_confirma">
				</div>
			</div>
      	</div>       
      </div>
      <div class="modal-footer">      
         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar" id="btn_cancelar_objeto">
         <input type="button" class="btn btn-danger" data-dismiss="modal" value="Eliminar" id="btn_eliminar_objeto">
         <input type="hidden" id="id_eliminar_objeto" value="">	       
      </div>
    </div>
  </div>
</div>
 <!-- FIN DE MODAL DE CONFIRMACION ELIMINAR -->
 
 


<!-- js para el funcionamiento de la ventana  -->
<script src="js/registro_ciclo_proyecto.js"></script>

<script src="js/proceso_seleccion.js"></script>
<script src="js/proceso_seleccion_item.js"></script>
<script src="js/contrato_proceso_seleccion_item.js"></script>
<script src="js/expediente_tecnico.js"></script>
<script src="js/adenda.js"></script>
<script src="js/adicional.js"></script>
<script src="js/adelanto.js"></script>
<script src="js/ampliacion_plazo.js"></script>
<script src="js/valorizacion.js"></script>
<script src="js/defecto_constructivo.js"></script>
<script src="js/acta.js"></script>
<script src="js/garantia.js"></script>
<script src="js/incidencia.js"></script>
<script src="js/resolucion.js"></script>
<script src="js/otros_documentos.js"></script>


</body>
