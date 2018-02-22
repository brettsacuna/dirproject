function lista_defecto_constructivo(id_contrato_proceso_seleccion_item){
	
	var opcionVar = "listar_defecto_constructivo";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
		
	$.get('Defecto_constructivoController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar
		
	},function(response){
			
			$('#listado_defecto_constructivo').empty();
			
			var body = "";
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, defecto_constructivo){
				
				if(usuario == defecto_constructivo.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${defecto_constructivo.defecto_constructivo}</td>																	
							<td class="text-center"><button type="button" id="btn_ver_defecto_constructivo" class="btn btn-primary"  onclick="ver_datos_defecto_constructivo(${defecto_constructivo.id_defecto_constructivo})" data-toggle="modal" data-target="#modal_defecto_constructivo" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" id="btn_editar_defecto_constructivo" class="btn btn-default" onclick="editar_datos_defecto_constructivo(${defecto_constructivo.id_defecto_constructivo})" data-toggle="modal" data-target="#modal_defecto_constructivo"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" id="btn_eliminar_defecto_constructivo" class="btn btn-danger" onclick="carga_defecto_constructivo_eliminar(${defecto_constructivo.id_defecto_constructivo})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
						`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${defecto_constructivo.defecto_constructivo}</td>																	
							<td class="text-center"><button type="button" id="btn_ver_defecto_constructivo" class="btn btn-primary"  onclick="ver_datos_defecto_constructivo(${defecto_constructivo.id_defecto_constructivo})" data-toggle="modal" data-target="#modal_defecto_constructivo" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													
							</td>
					    </tr>						
						`;
					
				}
														
			});
			
			$('#listado_defecto_constructivo').html(body);
						
	});
	
}

function carga_defecto_constructivo_eliminar(id_defecto_constructivo){
	
	$('#id_defecto_constructivo').val(id_defecto_constructivo);
	$('#id_eliminar_objeto').val('defecto_constructivo');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar el defecto constructivo seleccionado?</h5>');
}

function elimina_defecto_constructivo(id_defecto_constructivo){
		
		var opcionVar = 'eliminar';
	
		$.post('Defecto_constructivoController',{
			
			opcion: opcionVar,
			id_defecto_constructivo : id_defecto_constructivo
			
		},function(response){
			
			if(response == 1){
				
				lista_defecto_constructivo($('#id_contrato_proceso_seleccion_item').val());
				$('#id_defecto_constructivo').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function guardar_defecto_constructivo(){
	
	var opcionVar = "guardar";

	var id_defecto_constructivoVar = $('#id_defecto_constructivo').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_defecto_constructivoVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var asiento_cuaderno_obraVar = $('#asiento_cuaderno_obra').val();
	var defecto_constructivoVar = $('#defecto_constructivo_defecto').val();
	var fecha_encontradoVar = $('#fecha_encontrado').val();
	var estado_defectoVar = $('#estado_defecto').val();
	var accionesVar = $('#acciones').val();
	
	var usuarioVar = $('#usuario').val();
	
	$.post('Defecto_constructivoController',
					{
						
						opcion : opcionVar,
						operacion : operacionVar,

						id_defecto_constructivo : id_defecto_constructivoVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						
						asiento_cuaderno_obra : asiento_cuaderno_obraVar,
						defecto_constructivo : defecto_constructivoVar,
						
						fecha_encontrado : fecha_encontradoVar,
						estado_defecto : estado_defectoVar,
						acciones : accionesVar,
						
						usuario : usuarioVar
					
					},
					function(response) {

						if (response == 1) {
																					
							lista_defecto_constructivo(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_defecto_constructivo').html('<div class="alert alert-success" align="center" role="alert">Defecto constructivo grabado con éxito</div>');
							$('#btn_grabar_defecto_constructivo').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_defecto_constructivo').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_defecto_constructivo(id_defecto_constructivo) {

	var opcionVar = "buscar";
	var id_defecto_constructivoVar = id_defecto_constructivo;

	$.get('Defecto_constructivoController', {

		opcion : opcionVar,
		id_defecto_constructivo : id_defecto_constructivoVar

	}, function(response) {
		
		$('#id_defecto_constructivo').val(response.id_defecto_constructivo);
		
		$('#asiento_cuaderno_obra').val(response.asiento_cuaderno_obra);
		$('#defecto_constructivo_defecto').val(response.defecto_constructivo);
		$('#fecha_encontrado').val(response.fecha_encontrado);
		$('#estado_defecto').val(response.estado_defecto);
		$('#acciones').val(response.acciones);
		
	});

}

function ver_datos_defecto_constructivo(id_defecto_constructivo){
	
	limpiar_form_defecto_constructivo();
	
	cargar_datos_defecto_constructivo(id_defecto_constructivo);
	
	$('#asiento_cuaderno_obra').attr('disabled',true);
	$('#defecto_constructivo_defecto').attr('disabled',true);
	$('#fecha_encontrado').attr('disabled',true);
	$('#estado_defecto').attr('disabled',true);
	$('#acciones').attr('disabled',true);;
	
	$('#btn_grabar_defecto_constructivo').hide();
	
}

function editar_datos_defecto_constructivo(id_defecto_constructivo){
	
	limpiar_form_defecto_constructivo();
	
	cargar_datos_defecto_constructivo(id_defecto_constructivo);
	
	$('#asiento_cuaderno_obra').attr('disabled',false);
	$('#defecto_constructivo_defecto').attr('disabled',false);
	$('#fecha_encontrado').attr('disabled',false);
	$('#estado_defecto').attr('disabled',false);
	$('#acciones').attr('disabled',false);
	
	$('#btn_grabar_defecto_constructivo').show();
	
};
