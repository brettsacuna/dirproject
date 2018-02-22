<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>:: Inicio de Sesion ::</title>
<!-- BOOTSTRAP STYLES-->

<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	
</head>
<body>

<div class="container">
    <br>
    </br>
    <div class="row">
			<div class="col-md-12" align="center">
			<!-- <img src="assets/img/logo_dee.png" class="user-image img-responsive"/> -->				
			<!--  <img src="assets/img/logo_dee.png" class="img-responsive"> -->
			<img src="assets/img/dee_itp.png" class="img-responsive">
						
			</div>
		</div>
        <div class="row text-center ">
            <div class="col-md-12">
              <!--   <br /><br />  -->
               <h3 class="text-primary" ><strong>Inicio de Sesión</strong></h3>		
				<br />               
            
            </div>
        </div>
         <div class="row ">
               
                  <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                        <strong>   Ingrese usuario y contraseña </strong>  
                            </div>
                            <div class="panel-body">
                                <form role="form" action="UsuarioController" method="Post">
                                       <br />
                                     <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <input type="text" class="form-control" placeholder="Nombre de usuario " name="txtUsuario" id="usuario" />
                                        </div>
                                         <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                            <input type="password" class="form-control"  placeholder="Contraseña" name="txtContrasena" id="contrasena"/>
                                        </div>
                                        <div class="form-group" id ="panelmensaje">									
								         </div>
                                    <div class="form-group" align="right">
                                            <label class="checkbox-inline">
                                                <input type="checkbox" /> Recordarme
                                            </label>
                                        <!--     
                                            <span class="pull-right">
                                                   <a href="#" >Forget password ? </a> 
                                            </span>
                                         -->
                                        </div>
                                     
                                    <!--     <a href="#" class="btn btn-primary " id = "btnIniciarSesion">Iniciar Sesión</a> --> 
                                    	<input type="submit" class="btn btn-primary " id = "btnIniciarSesion" name= "login" value = "Iniciar Sesión"> 
                                    <hr />
                                 <!--     ¿Aún no está registrado? <a href="nuevo_usuario.jsp" >Regístrese </a> -->
                                    </form>                                  
                                    
                            </div>
                           
                        </div>
                    </div>              
                
        </div>
    </div>


	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	
	<script src="assets/js/jquery-1.10.2.js"></script>
	
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assets/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
<!--  	<script src="assets/js/custom.js"></script> -->
	<script src="http://code.jquery.com/jquery-latest.js"></script>	

</body>
</html>