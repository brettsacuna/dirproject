<%@page import="entity.UsuarioView"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="entity.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="dao.TipoUsuarioDao"%>
<%@page import="entity.TipoUsuario"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page session="true" %>
    
    
 <%
	HttpSession sesion_nu = request.getSession();
	UsuarioView usuarioView = new UsuarioView();
	
	if(sesion_nu.getAttribute("id_usuario")!= null && sesion_nu.getAttribute("usuario")!=null && sesion_nu.getAttribute("tipo_usuario")!=null && sesion_nu.getAttribute("nombrecompleto")!= null){
		usuarioView.setId_usuario(Integer.parseInt(sesion_nu.getAttribute("id_usuario").toString()));
		usuarioView.setUsuario(sesion_nu.getAttribute("usuario").toString());
		usuarioView.setNombrecompleto(sesion_nu.getAttribute("nombrecompleto").toString());
		usuarioView.setTipo_usuario(sesion_nu.getAttribute("tipo_usuario").toString());
		
	}else{
		
		out.print("<script>location.replace('login.jsp');</script>");
	}
%>

<input type="hidden" id="id_usuario_sesion" value="<%=usuarioView.getId_usuario()%>">
<input type="hidden" id="tipo_usuario" value="<%=usuarioView.getTipo_usuario()%>">
<input type="hidden" id="id_usuario_" value="">
<input type="hidden" id="id_usuario_eliminar" value="">    

<br>	
		<div class="row text-left">
			<div class="col-md-12">				
				<h3 class="text-primary"><strong>Registro de usuario</strong></h3>					
			</div>
		</div>
		<hr/>
		<div class="row">		
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-12">
						<div class="panel with-nav-tabs panel-primary">
							<div class="panel-heading">
								<ul class="nav nav-tabs" id="tabs_usuario">
						    		<li role="presentation" class="active"><a href="#registro_usuario" aria-controls="registro_usuario" role="tab" data-toggle="tab">Datos del usuario&nbsp;&nbsp;<i class="glyphicon glyphicon-plus"></i></a></li>
						    		<li role="presentation"><a href="#usuarios_registrados" aria-controls="usuarios_registrados" role="tab" data-toggle="tab">Usuarios registrados&nbsp;&nbsp;<i class="glyphicon glyphicon-list-alt"></i></a></li>
						  		</ul>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active" id="registro_usuario">
										<form id="formUsuario" role="form">
											<div class="row">
												<div class="col-sm-6">
													<div class="form-group has-feedback">
														<label class="control-label">Nombres completos</label>
														<div class="input-group" id="div_nombrecompleto">
															<span class="input-group-addon"><i class="fa fa-user"></i></span> 
															<input type="text" class="form-control" id="nombrecompleto" placeholder="Nombres y apellidos" data-error="Ingrese nombres completos" required />															
														 </div>
						    							<div class="help-block with-errors"></div>
													</div>
												</div>
												<div class="col-sm-6">
													<div class="form-group has-feedback">
														<label class="control-label">Nombre de usuario</label>
														<div class="input-group" id="div_usuario">
															<span class="input-group-addon"><i class="fa fa-user"></i></span>
															<input type="text" id="usuario_" class="form-control" placeholder="Nombre de usuario" data-error="Ingrese usuario" required />
														</div>
														<div class="help-block with-errors"></div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-6">										
														<div class="form-group has-feedback">
															<label class="control-label">E-mail</label>
															<div class="input-group" id="div_email">
																<span class="input-group-addon">@</span> <input type="email"
																	class="form-control" id="email" placeholder="E-mail" data-error="Ingrese correo electrónico" required />
															</div>
															<div class="help-block with-errors"></div>
														</div>
												</div>
												<div class="col-sm-6">
														<div class="form-group has-feedback">
															<label class="control-label">Tipo de usuario</label>
															<div class="input-group" id="div_id_tipo_usuario">
																<span class="input-group-addon"><i class="fa fa-flash"></i></span>
																<select class="form-control" id="id_tipo_usuario" data-error="Seleccione tipo de usuario" required>
																 	<% 
																 		TipoUsuarioDao tipoUsuarioDao = new TipoUsuarioDao();
																 		List<TipoUsuario> tipousuarios = tipoUsuarioDao.Listar();
																 		
																 		for(TipoUsuario tipoUsuario: tipousuarios){								 		
																 	%>
																 		<option value="<%=tipoUsuario.getTipo_usuario_id()%>"><%=tipoUsuario.getTipo_usuario()%></option>
																 	<% 
																 		}
																 	%>
																 </select>										
															</div>
															<div class="help-block with-errors"></div>
														</div>
												</div>
											</div>
											  <div class="row">
												<div class="col-sm-6">
														<div class="form-group has-feedback">
															<label class="control-label">Contraseña</label>
															<div class="input-group" id="div_contrasena">
																<span class="input-group-addon"><i class="fa fa-lock"></i></span>
																<input type="password" id="contrasena" class="form-control"
																	placeholder="Escriba un acontraseña" data-required-error="Ingrese contraseña" data-minlength="6" data-minlength-error="La contraseña debe tener al menos 6 caracteres" required />
															</div>
															<div class="help-block with-errors"></div>
														</div>
												</div>
												<div class="col-sm-6">
														<div class="form-group has-feedback">
															<label class="control-label">Confirme su contraseña</label>
															<div class="input-group" id="div_confirma_contrasena">
																<span class="input-group-addon"><i class="fa fa-lock"></i></span>
																<input type="password" id="confirmcontrasena" class="form-control"
																	placeholder="Confirme su contraseña" data-match="#contrasena" data-required-error="Ingrese contraseña" data-match-error="Las contraseñas no coinciden" required />
															</div>
															<div class="help-block with-errors"></div>
														</div>
												</div>
											</div>
										<div class="row">
											<div class="col-sm-12">
												<div class="form-group" id ="panel_mensaje">									
												</div>
											</div>
										</div>
										<div class="row">				 
											 <div class="col-sm-12 text-left">						
												<button type="submit" class="btn btn-primary" id="btnregistrarme">Guardar&nbsp;&nbsp;<i class="fa fa-save"></i></button>
												<button type="button" class="btn btn-default" id="btnnuevo" onclick="limpiar_form_usuario()" >Nuevo&nbsp;&nbsp;<i class="fa fa-plus"></i></button>										
												
											</div>												
										</div>
											<hr />
											Para ingresar el nuevo usuario, haga clic <a id="cerrar_sesion" href="UsuarioController?cerrar=true">aquí</a>
										</form>
									</div>
									<div role="tabpanel" class="tab-pane" id="usuarios_registrados">
										<div class="row">
											<div class="col-sm-12">
												<div class="table-responsive">
													<table class="table table-hover table-bordered table-striped" id="tabla_usuarios">
														<thead>
															<tr class="info">
																<th class="text-center">N°</th>
																<th class="text-center">Nombres</th>
																<th class="text-center">Usuario</th>
																<th class="text-center">Tipo</th>																
																<th class="text-center">Opciones</th>
															</tr>
														</thead>
														<tbody id="listado_usuarios">													
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
         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar" id="btncancelar">
         <input type="button" class="btn btn-danger" data-dismiss="modal" value="Eliminar" id="btneliminar">        
      </div>
    </div>
  </div>
</div>
 <!-- FIN DE MODAL DE CONFIRMACION ELIMINAR -->
  
 
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<script src="js/usuario.js"></script>
	<!-- JQUERY SCRIPTS -->

	
</body>
