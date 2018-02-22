<%@page import="entity.Tabla_snip"%>
<%@page import="entity.Datos_proyecto"%>
<%@page import="dao.Datos_proyectoDao"%>
<%@page import="entity.UsuarioView"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page session="true" %>
	
	<!-- Otros estilos -->
	<link href="assets/css/otrosestilos.css" rel="stylesheet">	
			
<body>
<%
	HttpSession sesion_ = request.getSession();
	UsuarioView usuarioView = new UsuarioView();
	
	if(sesion_.getAttribute("id_usuario")!=null &&  sesion_.getAttribute("usuario")!=null && sesion_.getAttribute("tipo_usuario")!=null && sesion_.getAttribute("nombrecompleto")!= null){
		usuarioView.setId_usuario(Integer.parseInt(sesion_.getAttribute("id_usuario").toString()));
		usuarioView.setUsuario(sesion_.getAttribute("usuario").toString());
		usuarioView.setNombrecompleto(sesion_.getAttribute("nombrecompleto").toString());
		usuarioView.setTipo_usuario(sesion_.getAttribute("tipo_usuario").toString());
		
	}else{
		
		out.print("<script>location.replace('login.jsp');</script>");
		
	}
%>

<input type="hidden" id="id_proyecto" value="">
<input type="hidden" id="id_usuario" value="<%=usuarioView.getId_usuario()%>">
<input type="hidden" id="usuario" value="<%=usuarioView.getUsuario()%>">
<input type="hidden" id="tipo_usuario" value="<%=usuarioView.getTipo_usuario()%>">

<input type="hidden" id="id_item_proyecto" value="">
<input type="hidden" id="id_componente" value="">
<input type="hidden" id="id_documento_preinversion" value="">

                <div class="row">
                    <div class="col-md-12">
                     	<h3 class="text-primary"><strong>Registro de Proyectos</strong></h3>   
                    </div>
                </div>              
                 <!-- /. ROW  -->
                  <hr />
              <div class="row">
                <div class="col-md-12">
                	<div class="panel with-nav-tabs panel-primary">
                		<div class="panel-heading">
		                	<ul class="nav nav-tabs" id="tabs_proyecto">
						    	<li role="presentation" class="active"><a href="#registro_proyectos" aria-controls="registro_proyectos" role="tab" data-toggle="tab">Datos del Proyecto&nbsp;&nbsp;<i class="glyphicon glyphicon-plus"></i></a></li>
						    	<li role="presentation"><a href="#proyectos_registrados" aria-controls="proyectos_registrados" role="tab" data-toggle="tab">Proyectos Registrados&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
						  	</ul>
						</div>
						<div class="panel-body">
						  	<div class="tab-content">
							    <div role="tabpanel" class="tab-pane active" id="registro_proyectos">
							    	<div class="col-md-12" style="">
		                                  <!--   <h3>Basic Form Examples</h3> --> 
		                                 
		                                    <form id="formulario_registro_proyecto" role="form">
		                                    <div class="row">
		                                    	<div class="col-md-6">
		                                    		<caption><h4 class="form-section">Datos Generales</h4></caption>	
		                                    		</br>	                                    		
		                                    		<div class="row">
				                                    	<div class="col-md-4">
				                                    		<div class="form-group" id="div_codigo_snip">
				                                              <label class="control-label" for="codigo_snip">Cod. SNIP:</label>
				                                               <input class="form-control" id="codigo_snip" placeholder="SNIP" autocomplete="off" name="codigo_snip">                                                                            
				                                            </div>
				                                    	</div>
				                                    	<div class="col-md-4">
				                                    	  <div class="form-group" id="div_codigo_proyecto">
				                                            <label for="numero_documento">Cod. Proyecto:</label>
				                                            <input class="form-control" id="codigo_proyecto" placeholder="######" autocomplete="off" name="codigo_proyecto"/>
				                                          </div>                                   			
				                              	       	</div>
				                              	       	<div class="col-md-4">
								                   			<div class="form-group" id="div_presupuesto_viabilidad">
																<label class="control-label" for="presupuesto_viabilidad">Ppto. Viabilidad: </label>
																<div class="input-group">
																  <span class="input-group-addon">S/</span>
																  <input type="text" class="form-control" id="presupuesto_viabilidad" name="presupuesto_viabilidad" placeholder="##.##">
																</div>
															</div>
								                   		</div>				                              	       	
				                                    </div>				                                    
				                                    <div class="row">
				                                        <div class="col-md-12" >
				                                          <div class="form-group" id="div_nombre_pip">
				                                           <label class="control-label" for="nombre_pip">Nombre del PIP:</label>
				                                             <textarea class="form-control" id="nombre_pip" name="nombre_pip" rows="3" placeholder="Nombre del proyecto"></textarea>
				                                          </div>
				                                      	</div>
				                                    </div>
				                                    <div class="row">
		                                    			<div class="col-md-6">
								                   			 <div class="form-group" id="div_consultor_preinversion">
						                                        <label class="control-label" for="consultor_preinversion">Consultor Pre-inversión:</label>
						                                        <div class="input-group">
																  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
																  <input class="form-control" id="consultor_preinversion" name="consultor_preinversion" placeholder="Nombres completos"/>
																</div>
						                                     </div>
								                   		</div>
								                   		<div class="col-md-6">
								                   			 <div class="form-group" id="div_consultor_expediente_tecnico">
						                                     	<label class="control-label" for="consultor_expediente_tecnico">Consultor Exp. Técnico:</label>
						                                     	<div class="input-group">
																  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
																  <input class="form-control" id="consultor_expediente_tecnico" name="consultor_expediente_tecnico" placeholder="Nombres completos"/>
																</div>
						                                          <!--    <p class="help-block">Help text here.</p> -->
						                                     </div>
								                   		</div>			
		                                    		</div>
		                                    		<div class="row">
												 		<div class="col-md-12">
									                 		<div class="form-group" id="div_beneficiarios_directos">
									                            <label class="control-label" for="beneficiarios_directos">Beneficiarios directos:</label>
									                            <input class="form-control" id="beneficiarios_directos" name="beneficiarios_directos" placeholder="Beneficiarios directos"/>
									                        </div>
									                 	</div>												 		
												 	</div>
		                                    	</div>		                                    			                                    	
		                                    	<div class="col-md-6">
		                                    		<caption><h4 class="form-section">Datos Complementarios</h4></caption>
		                                    		</br>	                                    	
		                                    		
		                                    		<div class="row">
		                                    			<div class="col-md-8">
								                   			 <div class="form-group" id="div_resolucion_aprobacion_expediente_tecnico">
						                                     	<label class="control-label" for="resolucion_aprobacion_expediente_tecnico">Resolución de Aprobación del Exp. Técnico:</label>
						                                        <input class="form-control" id="resolucion_aprobacion_expediente_tecnico" name="resolucion_aprobacion_expediente_tecnico" placeholder="Resolución de aprobación"/>
						                                          <!--    <p class="help-block">Help text here.</p> -->
						                                     </div>
								                   		</div>
								                   		<div class="col-md-4" >
								                            <div class="form-group" id="div_fecha_resolucion_aprobacion_expediente_tecnico">
								                                <label class="control-label" for="fecha_resolucion_aprobacion_expediente_tecnico">Fecha. Resol.:</label>
								                                <div class="input-group">
																  <input class="form-control" id="fecha_resolucion_aprobacion_expediente_tecnico" name="fecha_resolucion_aprobacion_expediente_tecnico" placeholder="mm/dd/yyyy"/>
																  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
																</div>
								                             </div>
								                       	</div>
		                                    		</div>
		                                    		<div class="row">
		                                    			<div class="col-md-8">
								                   			 <div class="form-group" id="div_resolucion_aprobacion_valor_referencial">
						                                           <label class="control-label" for="resolucion_aprobacion_valor_referencial">Resolución de Aprobación Val. Referencial:</label>
						                                            <input class="form-control" id="resolucion_aprobacion_valor_referencial" name="resolucion_aprobacion_valor_referencial" placeholder="Resolución de aprobación"/>
						                                          <!--    <p class="help-block">Help text here.</p> -->
						                                     </div>
								                   		</div>
								                   		<div class="col-md-4">
								                   			 <div class="form-group" id="div_fecha_resolucion_aprobacion_valor_referencial">
						                                           <label class="control-label" for="fecha_resolucion_aprobacion_valor_referencial">Fecha Resol.:</label>
						                                           <div class="input-group">
																	  <input class="form-control" id="fecha_resolucion_aprobacion_valor_referencial" name="fecha_resolucion_aprobacion_valor_referencial" placeholder="mm/dd/yyyy"/>
																	  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
																	</div>
						                                          <!--    <p class="help-block">Help text here.</p> -->
						                                     </div>
								                   		</div>
		                                    		</div>
		                                    		<div class="row">
		                                    			<div class="col-md-8">
									                 		<div class="form-group" id="div_resolucion_actualizacion_valor_referencial">
									                            <label class="control-label" for="resolucion_actualizacion_valor_referencial">Resolución Act. Valor Referencial:</label>
									                              <input class="form-control" id="resolucion_actualizacion_valor_referencial" name="resolucion_actualizacion_valor_referencial" placeholder="Resolución de actualización"/>
									                        </div>
									                 	</div>
									                 	<div class="col-md-4">
									                 		<div class="form-group" id="div_fecha_resolucion_actualizacion_valor_referencial">
									                           <label class="control-label" for="fecha_resolucion_actualizacion_valor_referencial">Fecha Resol.:</label>
									                           <div class="input-group">
																  <input class="form-control" id="fecha_resolucion_actualizacion_valor_referencial" name="fecha_resolucion_actualizacion_valor_referencial" placeholder="mm/dd/yyyy"/>
																  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
																</div>
									                        </div>
									                 	</div>
		                                    		</div>
		                                    		<div class="row">
		                                    			<div class="col-md-8">
									                 		<div class="form-group" id="div_informe_tecnico_declaratoria_viabilidad">
									                            <label class="control-label" for="informe_tecnico_declaratoria_viabilidad">Informe. Téc. Dec. Viab:</label>
									                              <input class="form-control" id="informe_tecnico_declaratoria_viabilidad" name="informe_tecnico_declaratoria_viabilidad" placeholder="Informe técnico"/>
									                        </div>
									                 	</div>
									                 	<div class="col-md-4">
									                 		<div class="form-group" id="div_fecha_informe_tecnico_declaratoria_viabilidad">
									                            <label class="control-label" for="fecha_informe_tecnico_declaratoria_viabilidad">Fecha Inf.:</label>
									                            <div class="input-group">
																  <input class="form-control" id="fecha_informe_tecnico_declaratoria_viabilidad" name="fecha_informe_tecnico_declaratoria_viabilidad" placeholder="mm/dd/yyyy"/>
																  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
																</div>
									                        </div>
									                 	</div>
		                                    		</div>		                                    		
		                                    	</div>
		                                    </div>
		 
										 	<!-- INICIO DE LA FILA 7 VACIA -->
										 	<div class="row">
										 		<div class="col-md-12">
										 			<div class="form-group" id="panel_mensaje">
										 				
										 			</div>
										 		</div>
										 	</div>
										 	
										 	<!-- INICIO DE LA FILA 8 CONTROLES -->
										 	<div class="row">
										 		<div class="col-lg-12 text-right">
										 			<button type="button" id="btn_guardar" class="btn btn-primary">Guardar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>											
													<button type="button" id="btn_nuevo" class="btn btn-default">Nuevo&nbsp;&nbsp;<i class="glyphicon glyphicon-plus"></i></button>
																												
										 		</div>
										 	</div>
										 	</br>
										 	<!-- FIN DE LA FILA 8 CONTROLES -->
										 											 	
											 <!-- FIN DE LA FILA 9 ITEMS PROYECTO -->
											<div class="row">
												<div class="col-md-12">
													<div class="panel panel-primary" id="panel_item_proyecto">
														<div class="panel-body">
															<div class="row">
																<div class="col-md-2 text-left">
													    			<button type="button" id="btn_agregar_item_proyecto" class="btn btn-success" data-toggle="modal" data-target="#modal_item_proyecto">Agregar Item proyecto&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>
													    		</div>	
															</div>															
															<div class="row">																
																<div class="col-md-12">
																	<div class="table-responsive">
																		<table class="table table-hover table-bordered table-striped">
																			<thead>
																				<tr>
																					<caption><h4 class="form-section">Items Expediente Técnico del Proyecto</h4></caption>
																				</tr>
																				<tr class="active">
																					<th class="text-center">Nro</th>
																					<th class="text-center">Ubicación</th>
																					<th class="text-center">Opciones</th>
																				</tr>
																			</thead>
																			<tbody id="listado_item_proyecto">
																			</tbody>																			
																		</table>
																	</div>
																</div>
															</div>
														</div>														
													</div>
												</div>
											</div>
										<!-- INICIO DE LA FILA COMPONENTES -->
											<div class="row">
												<div class="col-md-12">
													<div class="panel panel-primary" id="panel_componentes">
														<div class="panel-body">
															<div class="row">
																<div class="col-md-2 text-left">
													    			<button type="button" id="btn_agregar_componentes" class="btn btn-success" data-toggle="modal" data-target="#modal_componentes">Agregar Componentes&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>
													    		</div>	
															</div>															
															<div class="row">																
																<div class="col-md-12">
																	<div class="table-responsive">
																		<table class="table table-hover table-bordered table-striped">
																			<thead>
																				<tr>
																					<caption><h4 class="form-section">Componentes del Proyecto</h4></caption>
																				</tr>
																				<tr class="active">
																					<th class="text-center">Nro</th>
																					<th class="text-center">Componente</th>
																					<th class="text-center">Total x Comp. (S/.)</th>
																					<th class="text-center">Opciones</th>
																				</tr>
																			</thead>
																			<tbody id="listado_componentes">																				
																			</tbody>
																			<tfoot id="total_componentes">																				
																			</tfoot>																			
																		</table>
																	</div>
																</div>
															</div>
														</div>														
													</div>
												</div>
											</div>
		 			<!-- FIN DE LA FILA COMPONENTES -->
		 			
		 			<!-- INICIO DE LA FILA DOCUMENTOS PREINVERSION -->
											<div class="row">
												<div class="col-md-12">
													<div class="panel panel-primary" id="panel_documentos_preinversion">
														<div class="panel-body">
															<div class="row">
																<div class="col-md-2 text-left">
													    			<button type="button" id="btn_agregar_documento_preinversion" class="btn btn-success" data-toggle="modal" data-target="#modal_documento_preinversion">Agregar Documento&nbsp;&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></button>
													    		</div>	
															</div>															
															<div class="row">																
																<div class="col-md-12">
																	<div class="table-responsive">
																		<table class="table table-hover table-bordered table-striped">
																			<thead>
																				<tr>
																					<caption><h4 class="form-section">Documentos de Preinversión</h4></caption>
																				</tr>
																				<tr class="active">
																					<th class="text-center">Nro</th>
																					<th class="text-center">Tipo de Documento</th>
																					<th class="text-center">Descripción</th>
																					<th class="text-center">Opciones</th>
																				</tr>
																			</thead>
																			<tbody id="listado_documentos_preinversion">																				
																			</tbody>																																					
																		</table>
																	</div>
																</div>
															</div>
														</div>														
													</div>
												</div>
											</div>
		 			<!-- FIN DE LA FILA DOCUMENTOS PREINVERSION -->
									         </form>
									                                      
									    </div>
							    </div>
							    <div role="tabpanel" class="tab-pane" id="proyectos_registrados">
							    	<div class="col-md-12">
							    			<h4 class="form-section">Listado general de proyectos registrados</h4>
		                                	<div class="table-responsive">
												<table class="table table-hover table-bordered table-striped" id="tabla_proyectos">
													<thead>													
														<tr class="info">														
															<th class="col-md-2 text-center">Código SNIP</th>
															<th class="col-md-2 text-center">Código Proy</th>
															<th class="col-md-6 text-left">Nombre del Proyecto</th>															
															<th class="col-md-2 text-center">Opciones</th>														
														</tr>														
													</thead>
													<tbody id="lista_general_proyectos">
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
  

<!-- INICIO MODAL ITEM PROYECTO  -->

<div class="modal fade"  id="modal_item_proyecto" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Item del Proyecto</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Item del Proyecto
						</div>
						<div class="panel panel-body">
							<form id="formulario_item_proyecto" role="form">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="item_descripcion">Item Descripción:</label>	              				
				              				<input type="text" class="form-control input" id="item_descripcion" autocomplete="off">		              					
										</div>
									</div>
								</div>						
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
						            		<label class="control-label" for="ubicacion">Ubicación:</label>
						            		<textarea class="form-control" id="ubicacion" name="ubicacion"></textarea>             		
						            	</div>										
									</div>
								</div>								
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">										             					
				              				<label class="control-label" for="etapa_proyecto">Etapa del Proyecto:</label>	              				
				              				<select class="form-control" id="etapa_proyecto">
				              					<option value="1">En Curso</option>
				              					<option value="2">Sin Ejecución</option>
				              					<option value="3">Paralizado</option>
				              					<option value="4">Desierto</option>
				              					<option value="5">Finalizado</option>
				              				</select>		              					
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">										             					
				              				<label class="control-label" for="estado_proyecto">Estado del Proyecto:</label>	              				
				              				<select class="form-control" id="estado_proyecto">
				              					<option value="1">Activo</option>
				              					<option value="2">Inactivo</option>
				              					
				              				</select>		              					
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label" for="presupuesto_expediente_tecnico">Ppto. Exp. Tec: </label>
											<div class="input-group">
											      <span class="input-group-addon">S/</span>
												  <input type="text" class="form-control" id="presupuesto_expediente_tecnico" name="presupuesto_expediente_tecnico" placeholder="##.##">
											</div>
										</div>	
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<label class="control-label" for="valor_referencial">Val. Referencial: </label>
											<div class="input-group">
											      <span class="input-group-addon">S/</span>
												  <input type="text" class="form-control" id="valor_referencial" name="valor_referencial" placeholder="##.##">
											</div>
										</div>
									</div>																							
								</div>
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_item_proyecto">
										</div>
									</div>
								</div>
								</br>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_item_proyecto" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_item_proyecto()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL ITEM PROYECTO  -->

<!-- INICIO MODAL COMPONENTES -->

<div class="modal fade"  id="modal_componentes" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Componentes</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Componente
						</div>
						<div class="panel panel-body">
							<form id="formulario_componentes" role="form">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="id_tipo_componente">Componente:</label>	              				
				              				<select class="form-control" id="id_tipo_componente">
				              					<option value="1">Estudios de Preinversion</option>
				              					<option value="2">Expediente Técnico</option>
				              					<option value="3">Infraestructura</option>
				              					<option value="4">Equipamiento</option>
				              					<option value="5">Supervisión</option>
				              					<option value="6">Gestión del Proyecto</option>
				              					<option value="7">Capacitación y Asistencia Técnica</option>
				              					<option value="8">Fortalecimiento de Capacidades</option>
				              					<option value="9">Transferencia Tecnológica</option>
				              					<option value="10">Estudio de Impacto Ambiental</option>
				              					<option value="11">Evaluación Expost</option>
				              					<option value="12">Estudio de Linea Base</option>
				              				</select>		              					
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<label class="control-label" for="monto_componente_viable">Monto Viable: </label>
											<div class="input-group">
											      <span class="input-group-addon">S/</span>
												  <input type="text" class="form-control" id="monto_componente_viable" name="monto_componente_viable" placeholder="##.##">
											</div>
										</div>
									</div>																							
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="observacion_componente">Observaciones:</label>	              				
				              				<input type="text" class="form-control input" id="observacion_componente" autocomplete="off">		              					
										</div>
									</div>																							
								</div>
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_componentes">
										</div>
									</div>
								</div>
								</br>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_componentes" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_componentes()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL COMPONENTES -->

 <!-- INICIO DE MODAL DE CONFIRMACION ELIMINAR -->
 <div class="modal fade"  id="modal_confirma_eliminar_preinversion" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-ms">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" ><strong>Confirmación</strong></h5>                
      </div>
      <div class="modal-body">
      	<div class="row">
			<div class="col-sm-12">
				<div id="panel_mensaje_confirma_preinversion">
				</div>
			</div>
      	</div>       
      </div>
      <div class="modal-footer">      
         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar" id="btn_cancelar_objeto_preinversion">
         <input type="button" class="btn btn-danger" data-dismiss="modal" value="Eliminar" id="btn_eliminar_objeto_preinversion">
         <input type="hidden" id="id_eliminar_objeto_preinversion" value="">	       
      </div>
    </div>
  </div>
</div>
<!-- FIN DE MODAL DE CONFIRMACION ELIMINAR -->

<!-- INICIO DE MODAL DOCUMENTO PREINVERSION-->

<div class="modal fade"  id="modal_documento_preinversion" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Registro de Documentos de Preinversión</strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos del Documento de Preinversión
						</div>
						<div class="panel panel-body">
							<form id="formulario_documento_preinversion" role="form">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">										             					
				              				<label class="control-label" for="id_tipo_documento_preinversion">Tipo de documento:</label>	              				
				              				<select class="form-control" id="id_tipo_documento_preinversion">
				              					<option value="1">Saneamiento Físico Legal</option>
				              					<option value="2">Certificación Ambiental</option>
				              					<option value="3">Factibilidad de Servicio</option>
				              					<option value="4">CIRA</option>
				              					<option value="5">Otros</option>
				              				</select>		              					
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
						            		<label class="control-label" for="documento_preinversion">Documento:</label>
						            		<textarea class="form-control" id="documento_preinversion" name="documento_preinversion"></textarea>             		
						            	</div>
									</div>																							
								</div>
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_documento_preinversion">
										</div>
									</div>
								</div>
								</br>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="button" id="btn_grabar_documento_preinversion" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cerrar" onclick="limpiar_form_documento_preinversion()">       
	      </div>
	   </div>
	</div>
</div>

<!-- FIN MODAL DOCUMENTO_PREINVERSION -->
            
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->

<!-- JQUERY DATATABLES -->
<script src="assets/js/dataTables/jquery.dataTables.js"></script>
<script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
<!-- Lógica de funcionamiento para registro_proyecto.jsp -->
<script src="js/datos_proyecto.js"></script>
<script src="js/registro_proyecto.js"></script>

<script src="js/item_proyecto.js"></script>
<script src="js/componentes.js"></script>
<script src="js/documento_preinversion.js"></script>

</body>
