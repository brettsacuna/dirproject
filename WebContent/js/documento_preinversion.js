function guardar_documento_preinversion() {

	var opcionVar = "guardar";

	var id_documento_preinversionVar = $('#id_documento_preinversion').val();
	var id_proyectoVar = $('#id_proyecto').val();

	if (id_documento_preinversionVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var id_tipo_documento_preinversionVar = $('#id_tipo_documento_preinversion').val();
	var tipo_documento_preinversionVar = $('#id_tipo_documento_preinversion option:selected').text();
	var documento_preinversionVar = $('#documento_preinversion').val();
		
	var usuarioVar = $('#usuario').val();

	$.post('Documento_preinversionController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_proyecto : id_proyectoVar,
						id_documento_preinversion : id_documento_preinversionVar,
						id_tipo_documento_preinversion : id_tipo_documento_preinversionVar,
						tipo_documento_preinversion : tipo_documento_preinversionVar,
						documento_preinversion : documento_preinversionVar,
						
						usuario : usuarioVar

					},
					
					function(response) {

						if (response == 1) {
							
							$('#panel_mensaje_documento_preinversion').html('<div class="alert alert-success" align="center" role="alert">¡Documento guardado con éxito!</h5>');
							lista_documentos_preinversion(id_proyectoVar,'show');	
							$('#btn_grabar_documento_preinversion').hide();
							
						} else if (response == 0) {
							
							$('#panel_mensaje_documento_preinversion').html('<div class="alert alert-success" align="center" role="alert">¡Error!</h5>');

						} 

					});

}

function lista_documentos_preinversion(id_proyecto,opcion_btn){
	
	var opcionVar = "listar_documento_preinversion";
	var id_proyectoVar = id_proyecto;
		
	$.get('Documento_preinversionController', {
		
		opcion : opcionVar,		
		id_proyecto: id_proyectoVar
		
	},function(response){
			
			$('#listado_documentos_preinversion').empty();
					
			var body = "";
									
			$.each(response, function(index, documento_preinversion){
							
				if(opcion_btn == "show"){
					
				body += `					
						<tr class="success">						  
							<td class="text-center">${index+1}</td>
							<td>${documento_preinversion.tipo_documento_preinversion}</td>
							<td>${documento_preinversion.documento_preinversion}</td>												
							<td class="text-center"><button type="button" id="btn_ver_documento_preinversion" class="btn btn-primary"  onclick="ver_datos_documento_preinversion(${documento_preinversion.id_documento_preinversion})" data-toggle="modal" data-target="#modal_documento_preinversion"><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" class="btn btn-default" id="btn_editar_documento_preinversion" onclick="editar_datos_documento_preinversion(${documento_preinversion.id_documento_preinversion})" data-toggle="modal" data-target="#modal_documento_preinversion"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" id="btn_eliminar_documento_preinversion" class="btn btn-danger" onclick="carga_documento_preinversion_eliminar(${documento_preinversion.id_documento_preinversion})" data-toggle="modal" data-target="#modal_confirma_eliminar_preinversion"><i class="glyphicon glyphicon-remove"></i></button>
							</td>					     
						</tr>	
						
						`;
				
				}else if(opcion_btn == "hide"){
					
					body += `
						<tr class="success">						  
							<td class="text-center">${index+1}</td>
							<td>${documento_preinversion.tipo_documento_preinversion}</td>
							<td>${documento_preinversion.documento_preinversion}</td>												
							<td class="text-center">
								<button type="button" id="btn_ver_documento_preinversion" class="btn btn-primary"  onclick="ver_datos_documento_preinversion(${documento_preinversion.id_documento_preinversion})" data-toggle="modal" data-target="#modal_documento_preinversion"><i class="glyphicon glyphicon-eye-open"></i></button> 
							</td>					     
						</tr>	
						`;				
				}
														
			});
			
			
			$('#listado_documentos_preinversion').html(body);		
						
	});
	
}

function carga_documento_preinversion_eliminar(id_documento_preinversion){
	
	$('#id_documento_preinversion').val(id_documento_preinversion);
	$('#id_eliminar_objeto_preinversion').val('documento_preinversion');
	$('#panel_mensaje_confirma_preinversion').html('<h5>¿Confirma eliminar el documento seleccionado?</h5>');
}

function elimina_datos_documento_preinversion(id_documento_preinversion){
		
		var opcionVar = 'eliminar';
	
		$.post('Documento_preinversionController',{
			
			opcion: opcionVar,
			id_documento_preinversion : id_documento_preinversion
			
		},function(response){
			
			if(response == 1){
				
				lista_documentos_preinversion($('#id_proyecto').val(),'show');					
				$('#id_documento_preinversion').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function cargar_datos_documento_preinversion(id_documento_preinversion) {

	var opcionVar = "buscar";
	var id_documento_preinversionVar = id_documento_preinversion;

	$.get('Documento_preinversionController', {

		opcion : opcionVar,
		id_documento_preinversion : id_documento_preinversionVar

	}, function(response) {

		$('#id_documento_preinversion').val(response.id_documento_preinversion);
		document.ready = document.getElementById("id_tipo_documento_preinversion").value = response.id_tipo_documento_preinversion;
		$('#documento_preinversion').val(response.documento_preinversion);
					
	});
	
}

function ver_datos_documento_preinversion(id_documento_preinversion) {
		
	cargar_datos_documento_preinversion(id_documento_preinversion);

	$('#id_tipo_documento_preinversion').attr('disabled',true);
	$('#documento_preinversion').attr('disabled',true);	
		
	$('#btn_grabar_documento_preinversion').hide();
	
}

function editar_datos_documento_preinversion(id_documento_preinversion) {

	cargar_datos_documento_preinversion(id_documento_preinversion);

	$('#componid_tipo_documento_preinversionente').attr('disabled',false);
	$('#documento_preinversion').attr('disabled',false);
			
	$('#btn_grabar_documento_preinversion').show();
	
}
