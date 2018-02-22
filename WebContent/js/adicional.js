function lista_adicional(id_contrato_proceso_seleccion_item){
	
	var opcionVar = "listar_adicional";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
		
	$.get('AdicionalController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar
		
	},function(response){
			
			$('#listado_adicionales').empty();
			
			var body = "";
			
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, adicional){
				
				if(usuario == adicional.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${adicional.resolucion_aprobacion_adicional}</td>																	
							<td class="text-center"><button type="button" class="btn btn-primary"  onclick="ver_datos_adicional(${adicional.id_adicional})" data-toggle="modal" data-target="#modal_adicional" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" class="btn btn-default" onclick="editar_datos_adicional(${adicional.id_adicional})" data-toggle="modal" data-target="#modal_adicional"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button"  class="btn btn-danger" onclick="carga_adicional_eliminar(${adicional.id_adicional})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
						`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${adicional.resolucion_aprobacion_adicional}</td>																	
							<td class="text-center"><button type="button" class="btn btn-primary"  onclick="ver_datos_adicional(${adicional.id_adicional})" data-toggle="modal" data-target="#modal_adicional" ><i class="glyphicon glyphicon-eye-open"></i></button>
													
							</td>
					    </tr>						
						`;
					
				}
				
														
			});
			
			$('#listado_adicionales').html(body);
						
	});
	
}

function carga_adicional_eliminar(id_adicional){
	
	$('#id_adicional').val(id_adicional);
	$('#id_eliminar_objeto').val('adicional');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar el adicional seleccionado?</h5>');
}

function elimina_adicional(id_adicional){
		
		var opcionVar = 'eliminar';
	
		$.post('AdicionalController',{
			
			opcion: opcionVar,
			id_adicional : id_adicional
			
		},function(response){
			
			if(response == 1){
				
				lista_adicional($('#id_contrato_proceso_seleccion_item').val());
				$('#id_adicional').val('');
								
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function guardar_adicional(){
	
	var opcionVar = "guardar";

	var id_adicionalVar = $('#id_adicional').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_adicionalVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var resolucion_aprobacion_adicionalVar = $('#resolucion_aprobacion_adicional').val();
	var fecha_resolucion_aprobacion_adicionalVar = $('#fecha_resolucion_aprobacion_adicional').val();
	var monto_adicional_otorgadoVar = $('#monto_adicional_otorgado').val();
	var motivo_generadoVar = $('#motivo_generado_adicional').val();
	
	var usuarioVar = $('#usuario').val();
	
	$.post('AdicionalController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_adicional : id_adicionalVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						
						resolucion_aprobacion_adicional : resolucion_aprobacion_adicionalVar,
						fecha_resolucion_aprobacion_adicional : fecha_resolucion_aprobacion_adicionalVar,
						
						monto_adicional_otorgado : monto_adicional_otorgadoVar,
						motivo_generado : motivo_generadoVar,
						
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_adicional(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_adicional').html('<div class="alert alert-success" align="center" role="alert">Adicional grabado con éxito</div>');
							$('#btn_grabar_adicional').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_adicional').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_adicional(id_adicional) {

	var opcionVar = "buscar";
	var id_adicionalVar = id_adicional;

	$.get('AdicionalController', {

		opcion : opcionVar,
		id_adicional : id_adicionalVar

	}, function(response) {
		
		$('#id_adicional').val(response.id_adicional);
		
		$('#resolucion_aprobacion_adicional').val(response.resolucion_aprobacion_adicional);
		$('#fecha_resolucion_aprobacion_adicional').val(response.fecha_resolucion_aprobacion_adicional);
		$('#monto_adicional_otorgado').val(response.monto_adicional_otorgado);
		$('#motivo_generado_adicional').val(response.motivo_generado);
		
	});

}

function ver_datos_adicional(id_adicional){
	
	limpiar_form_adicional();
	
	cargar_datos_adicional(id_adicional);
	
	$('#resolucion_aprobacion_adicional').attr('disabled',true);
	$('#fecha_resolucion_aprobacion_adicional').attr('disabled',true);
	$('#monto_adicional_otorgado').attr('disabled',true);
	$('#motivo_generado_adicional').attr('disabled',true);
	
	$('#btn_grabar_adicional').hide();
	
}

function editar_datos_adicional(id_adicional){
	
	limpiar_form_adicional();
	
	cargar_datos_adicional(id_adicional);
	
	$('#resolucion_aprobacion_adicional').attr('disabled',false);
	$('#fecha_resolucion_aprobacion_adicional').attr('disabled',false);
	$('#monto_adicional_otorgado').attr('disabled',false);
	$('#motivo_generado_adicional').attr('disabled',false);
	
	$('#btn_grabar_adicional').show();
	
};

