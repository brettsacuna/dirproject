$(document).ready(function(){
		
		//$('#btn_actualizar').hide();
				
		lista_usuarios();
						
		$('#formUsuario').validator({
			disable : false
		}).on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
		    console.log("Im here");
		  } else {
		    e.preventDefault();
		    
		    	var id_usuarioVar = $('#id_usuario_').val();
		    	
		    	var opcionVar = '';
		    	
		    	if(id_usuarioVar == ''){
		    		
		    		opcionVar = "registrar";
		    		
		    	}else{
		    		
		    		opcionVar = "actualizar";
		    		
		    	}
		    
				var nombrecompletoVar = $('#nombrecompleto').val();					
				var usuarioVar = $('#usuario_').val();
				var contrasenaVar = $('#contrasena').val();
				var emailVar = $('#email').val();
				var id_tipo_usuarioVar = $('#id_tipo_usuario').val();			
				
				// Inicio de Post
				$.post('UsuarioController', {
							
							opcion : opcionVar,
							id_usuario: id_usuarioVar,
							nombrecompleto : nombrecompletoVar,
							usuario : usuarioVar,
							contrasena : contrasenaVar,
							email : emailVar,
							id_tipo_usuario : id_tipo_usuarioVar
						

						}, function(response) {
							
							if(response == 1){
								$('div .form-group').removeClass('has-error');
								lista_usuarios();
								$('#panel_mensaje').html('<div class="alert alert-success" role="alert">Usuario grabado con éxito</div>');
								$('#btnregistrarme').hide();							
								
							}else if(response == 2){
							
								$('div .form-group').removeClass('has-error');
								$('#div_usuario').addClass('has-error');
								$('#panel_mensaje').html('<div class="alert alert-warning" role = "alert">¡Usuario existente!</h5>');
							
							}else if(response == 0){
								
								$('div .form-group').removeClass('has-error');
								$('#div_email').addClass('has-error');
								$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡E-mail existente!</div>');
							
							}
						});				
					
		  }
		  
		});
	
	});

function lista_usuarios(){
	
	var opcionVar = "listar_usuarios";
			
	$.get('UsuarioController', {
		
		opcion : opcionVar		
		
	},function(response){
			
			$('#listado_usuarios').empty();
			
			var body = "";
						
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, usuario_response){
				
				if(usuario_response.nombrecompleto != "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${usuario_response.nombrecompleto}</td>
							<td>${usuario_response.usuario}</td>
							<td>${usuario_response.tipo_usuario}</td>																	
							<td class="text-center"><button type="button" id="btn_ver_datos_usuario" class="btn btn-primary"  onclick="ver_datos_usuario(${usuario_response.id_usuario})"><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" id="btn_editar_datos_usuario" class="btn btn-default" onclick="editar_datos_usuario(${usuario_response.id_usuario})"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" id="btn_eliminar_usuario" class="btn btn-danger" onclick="carga_usuario_eliminar(${usuario_response.id_usuario})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
						
						`;
					
				}else{
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${usuario_response.nombrecompleto}</td>
							<td>${usuario_response.usuario}</td>
							<td>${usuario_response.tipo_usuario}</td>																	
							<td class="text-center"><button type="button" id="btn_ver_datos_usuario" class="btn btn-primary"  onclick="ver_datos_usuario(${usuario_response.id_usuario})"><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" id="btn_editar_datos_usuario" class="btn btn-default" onclick="editar_datos_usuario(${usuario_response.id_usuario})"><i class="glyphicon glyphicon-edit"></i></button>
							</td>
					    </tr>						
						
						`;
									
				}
														
			});
			
			$('#listado_usuarios').html(body);
			$('#tabla_usuarios').dataTable();			
						
	});
	
}



function carga_usuario(id_usuario){
	
	var opcionVar = 'buscar';
	var id_usuarioVar = id_usuario;
	
	$.get('UsuarioController',{
		
			opcion : opcionVar,
			id_usuario : id_usuarioVar 
		
	}, function(response){
		
		$('#id_usuario_').val(response.id_usuario);
		
		$('#nombrecompleto').val(response.nombrecompleto);
		$('#usuario_').val(response.usuario);
		$('#contrasena').val(response.contrasena);
		$('#id_tipo_usuario option[value="'+response.id_tipo_usuario+'"]').attr('selected',true)
		
		$('#email').val(response.email);			
			
		$('#tabs_usuario a:first').tab('show');
		
	});
	
}

function ver_datos_usuario(id_usuario){
	
	limpiar_form_usuario();
	
	carga_usuario(id_usuario);
	
	inhabilita_controles_usuario();
	
	$('#btnregistrarme').hide();
	
}

function editar_datos_usuario(id_usuario){
	
	limpiar_form_usuario();
	
	carga_usuario(id_usuario);
	
	habilita_controles_usuario();
	
	$('#btnregistrarme').show();
	
};


function carga_usuario_eliminar(id_usuario){
	
	$('#id_usuario_eliminar').val(id_usuario);
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar al usuario seleccionado?</h5>');
}

function elimina_usuario(id_usuario){
		
		var opcionVar = 'eliminar';
	
		$.get('UsuarioController',{
			
			opcion: opcionVar,
			id_usuario : id_usuario
			
		},function(response){
			
			if(response == 1){
				
				lista_usuarios();
								
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

$('#btneliminar').click(function(event){
	
	var id_usuario = $('#id_usuario_eliminar').val();
	
	if(id_usuario == $('#id_usuario_sesion').val()){
		
		elimina_usuario(id_usuario);
		
		window.location = $("#cerrar_sesion").attr("href");
		
	}else{
		
		elimina_usuario(id_usuario);
	}
	
});

$('#btncancelar').click(function(event){
	
	$('#id_usuario_eliminar').val('');
});


function limpiar_form_usuario(){
	
	$('#formUsuario').trigger('reset');	
	$('#id_usuario_').val('');
	$('#panel_mensaje').html('');
	habilita_controles_usuario();
	$('#btnregistrarme').show();
	$('#tabs_usuario a:first').tab('show');
	
}

function habilita_controles_usuario(){
	
	$('#nombrecompleto').attr('disabled',false);
	$('#usuario_').attr('disabled',false);
	$('#contrasena').attr('disabled',false);
	$('#id_tipo_usuario').attr('disabled',false)
	
	$('#email').attr('disabled',false);			
}


function inhabilita_controles_usuario(){
	
	$('#nombrecompleto').attr('disabled',true);
	$('#usuario_').attr('disabled',true);
	$('#contrasena').attr('disabled',true);
	$('#id_tipo_usuario').attr('disabled',true)
	
	$('#email').attr('disabled',true);			
}


