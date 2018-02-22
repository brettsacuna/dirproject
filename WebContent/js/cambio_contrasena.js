$(document).ready(function(){
			
	$('#formulario_cambio_contrasena').validator({
		disable : false
	}).on('submit', function (e) {
	  if (e.isDefaultPrevented()) {
	    console.log("Im here");
	  } else {
	    e.preventDefault();
	    
	    cambiar_contrasena();
				
	  }
	  
	});		
				
});

function cambiar_contrasena(){
	
	var opcionVar = "cambiar_contrasena";
	var id_usuarioVar = $('#id_usuario').val();
	var contrasenaVar = $('#nueva_contrasena').val();
	
	$.post('UsuarioController',
			{

				opcion : opcionVar,
				
				id_usuario : id_usuarioVar,
				contrasena : contrasenaVar

			},
			function(response) {

				if (response == 1) {
					$('#panel_mensaje_cambio_contrasena').html('<div class="alert alert-success" align="center" role="alert">Contraseña cambiada con éxito</div>');														
					window.location = $("#menu_cerrar_sesion").attr("href");
					
				} else if (response == 0) {
					$('#panel_mensaje_cambio_contrasena').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

				} 

			});
	
}

function limpiar_form_cambio_contrasena(){
	
	$('#formulario_cambio_contrasena').trigger('reset');
	
}

