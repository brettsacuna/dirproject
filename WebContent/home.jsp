<%@page import="entity.UsuarioView"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8"/>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>:: Proyectos ITP ::</title>
	<!-- BOOTSTRAP STYLES-->	
       
    <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
	<link href="assets/css/datepicker.css" rel="stylesheet">
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
     <!-- MORRIS CHART STYLES-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" /> 
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   
   <link href="assets/css/bootstrap-tab.css" rel="stylesheet" />
  
  <!-- STYLES DATATABLES JQUERY -->

   
</head>
<body>
<%
	HttpSession sesion = request.getSession();
	UsuarioView usuarioView = new UsuarioView();
	
	if(sesion.getAttribute("id_usuario")!= null && sesion.getAttribute("usuario")!=null && sesion.getAttribute("tipo_usuario")!=null && sesion.getAttribute("nombrecompleto")!= null){
		usuarioView.setId_usuario(Integer.parseInt(sesion.getAttribute("id_usuario").toString()));
		usuarioView.setUsuario(sesion.getAttribute("usuario").toString());
		usuarioView.setNombrecompleto(sesion.getAttribute("nombrecompleto").toString());
		usuarioView.setTipo_usuario(sesion.getAttribute("tipo_usuario").toString());
		
	}else{
		
		out.print("<script>location.replace('login.jsp');</script>");
	}
%>

<input type="hidden" id="id_usuario" value="<%=usuarioView.getId_usuario()%>">
<input type="hidden" id="usuario" value="<%=usuarioView.getUsuario()%>">
<input type="hidden" id="tipo_usuario" value="<%=usuarioView.getTipo_usuario()%>"> 

    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>                
           <a class="navbar-brand" href="home.jsp">ITP Proyectos</a>
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;">Sesión: <%=usuarioView.getNombrecompleto()%> &nbsp;</div>
        </nav>   
           <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				    <li class="text-center">
                         <img src="assets/img/dee_itp_tran.png" class="user-image img-responsive"/>
					</li>
						
                    <li id="menu_registro_usuario">
                        <a href="#" onclick="cargacontenido('nuevo_usuario.jsp')"><i class="fa fa-user fa-3x" ></i> Usuarios</a>
                    </li>
                     
                    <li>
                        <a  href="#" ><i class="fa fa-list-alt fa-3x"></i> Registros<span class="fa arrow"></span></a>
                   		<ul class="nav nav-second-level">
                   			<li>
                   				<a href="#" onclick="cargacontenido('registro_proyecto.jsp')">Preinversión</a>
                   			</li>
                   			<li>
                   				<a href="#" onclick="cargacontenido('registro_ciclo_proyecto.jsp')">Ejecución</a>
                   			</li>
                   		</ul>                   
                    </li>
                     <li  >
                        <a  href="#" onclick="cargacontenido('reportes.jsp')"><i class="fa fa-file fa-3x"></i> Reportes</a>
                    </li>
                     <li>
                        <a  href="#" data-toggle="modal" data-target="#modal_cambiar_contrasena"><i class="glyphicon glyphicon-edit fa-3x" ></i> Cambiar Contraseña</a>
                    </li>	                    			
					 <li >
                        <a id="menu_cerrar_sesion" href="UsuarioController?cerrar=true"><i class="glyphicon glyphicon-log-out fa-3x"></i> Cerrar Sesión</a>
                    </li>	                     
				
                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
    
                 <!-- /. ROW  -->           
            </div>
             <!-- /. PAGE INNER  -->
        </div>
         <!-- /. PAGE WRAPPER  -->
     </div>
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
 
 <!--INICIO MODAL CAMBIAR CONTRASEÑA -->
 
 <div class="modal fade"  id="modal_cambiar_contrasena" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
	 <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" ><strong>Cambio de Contraseña </strong></h5>                
	      </div>
	      <div class="modal-body">
	      	<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<div class="panel panel-heading">
							Datos de la Nueva Contraseña
						</div>
						<div class="panel panel-body">
							<form id="formulario_cambio_contrasena" role="form">								
								<div class="row">
									<div class="col-md-6">
										<div class="form-group has-feedback">										             					
				              				<label class="control-label" for="item_descripcion">Nueva Contraseña:</label>	              				
				              				<input type="password" class="form-control input" id="nueva_contrasena" autocomplete="off" data-required-error="Ingrese la nueva contraseña" data-minlength="6" data-minlength-error="La contraseña debe tener al menos 6 caracteres" required >
				              				<div class="help-block with-errors"></div>		              					
										</div>
										
									</div>
									<div class="col-md-6">
										<div class="form-group has-feedback">										             					
				              				<label class="control-label" for="item_descripcion">Confirme la Nueva Contraseña:</label>	              				
				              				<input type="password" class="form-control input" id="confirma_nueva_contrasena" autocomplete="off" data-required-error="Ingrese contraseña" data-match="#nueva_contrasena" data-match-error="Las contraseñas no coinciden" required>		              					
											<div class="help-block with-errors"></div>
										</div>
									</div>
								</div>								
								<div class="row">
									<div class="col-md-12">
										<div id="panel_mensaje_cambio_contrasena">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 text-left">
										<button type="submit" id="btn_cambiar_contrasena" class="btn btn-primary">Grabar&nbsp;&nbsp;<i class="glyphicon glyphicon-floppy-disk"></i></button>										
									</div>
								</div>
							</form>								
						</div>
					</div>
				</div>      	
	      	</div>	       
	      </div>
	      <div class="modal-footer">      
	         <button type="button" class="btn btn-default" data-dismiss="modal" onclick="limpiar_form_cambio_contrasena()">Cerrar</button>       
	      </div>
	   </div>
	</div>
</div>

<!--FIN MODAL CAMBIAR CONTRASEÑA -->
   
  <!-- <script src="assets/js/jquery-1.10.2.js"></script>  -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
     <!-- MORRIS CHART SCRIPTS -->
     <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
     <script src="assets/js/dataTables/jquery.dataTables.js"></script>
     <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
   <!--  <script src="assets/js/morris/morris.js"></script>  -->
      <!-- CUSTOM SCRIPTS -->
   <!--  <script src="assets/js/custom.js"></script>  -->
   
    <script src="assets/js/cargapanel.js"></script>    
    <script src="assets/js/decimal/jquery.numeric.js"></script>
    <script src="assets/js/decimal/jquery.numeric.min.js"></script>
    <script src="assets/js/bootstrap-datepicker.js"></script>
    <script src="assets/js/custom.js"></script>
    <script src="js/cambio_contrasena.js"></script>
   
   	<script type="text/javascript">
		$(document).ready(function(){
			
			var tipo_usuario = "<%=usuarioView.getTipo_usuario()%>";
			
			if(tipo_usuario == 'Administrador'){
				
				$('#menu_registro_usuario').show();
				
				console.log(tipo_usuario);
				
			}else if(tipo_usuario == 'Usuario' || tipo_usuario == 'Operador'){
				
				$('#menu_registro_usuario').hide();
				console.log(tipo_usuario);
			}		
				
		});
	</script>
   
    <script>
    
    
    $(function() {
    	  
    	  // elementos de la lista
    	     var menues = $(".nav li a"); 

    	  // manejador de click sobre todos los elementos
    	     menues.click(function() {
    	     // eliminamos active de todos los elementos
    	     menues.removeClass("active-menu");
    	     // activamos el elemento clicado.
    	     $(this).addClass("active-menu");
    	  });

    	});
    
    </script>
    
   </body> 
</html>