function lista_ampliacion_plazo(id_contrato_proceso_seleccion_item){
	
	var opcionVar = "listar_ampliacion_plazo";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
		
	$.get('Ampliacion_plazoController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar
		
	},function(response){
			
			$('#listado_ampliaciones_plazo').empty();
			
			var body = "";
			
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, ampliacion_plazo){
				
				if(usuario == ampliacion_plazo.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${ampliacion_plazo.resolucion_aprobacion_ampliacion_plazo}</td>																	
							<td class="text-center"><button type="button"  class="btn btn-primary"  onclick="ver_datos_ampliacion_plazo(${ampliacion_plazo.id_ampliacion_plazo})" data-toggle="modal" data-target="#modal_ampliacion_plazo" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button"  class="btn btn-default" onclick="editar_datos_ampliacion_plazo(${ampliacion_plazo.id_ampliacion_plazo})" data-toggle="modal" data-target="#modal_ampliacion_plazo"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button"  class="btn btn-danger" onclick="carga_ampliacion_plazo_eliminar(${ampliacion_plazo.id_ampliacion_plazo})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
						`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${ampliacion_plazo.resolucion_aprobacion_ampliacion_plazo}</td>																	
							<td class="text-center"><button type="button" class="btn btn-primary" onclick="ver_datos_ampliacion_plazo(${ampliacion_plazo.id_ampliacion_plazo})" data-toggle="modal" data-target="#modal_ampliacion_plazo" ><i class="glyphicon glyphicon-eye-open"></i></button>
													
							</td>
					    </tr>						
						`;
					
				}
														
			});
			
			$('#listado_ampliaciones_plazo').html(body);
						
	});
	
}

function carga_ampliacion_plazo_eliminar(id_ampliacion_plazo){
	
	$('#id_ampliacion_plazo').val(id_ampliacion_plazo);
	$('#id_eliminar_objeto').val('ampliacion_plazo');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar la ampliacion de plazo seleccionada?</h5>');
}

function elimina_ampliacion_plazo(id_ampliacion_plazo){
		
		var opcionVar = 'eliminar';
	
		$.post('Ampliacion_plazoController',{
			
			opcion: opcionVar,
			id_ampliacion_plazo : id_ampliacion_plazo
			
		},function(response){
			
			if(response == 1){
				
				lista_ampliacion_plazo($('#id_contrato_proceso_seleccion_item').val());
				$('#id_ampliacion_plazo').val('');
								
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function guardar_ampliacion_plazo(){
	
	var opcionVar = "guardar";

	var id_ampliacion_plazoVar = $('#id_ampliacion_plazo').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_ampliacion_plazoVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var resolucion_aprobacion_ampliacion_plazoVar = $('#resolucion_aprobacion_ampliacion_plazo').val();
	var fecha_resolucion_aprobacion_ampliacion_plazoVar = $('#fecha_resolucion_aprobacion_ampliacion_plazo').val();
	var plazo_otorgadoVar = $('#plazo_otorgado_ampliacion_plazo').val();
	var motivo_generadoVar = $('#motivo_generado_ampliacion_plazo').val();
	
	var usuarioVar = $('#usuario').val();
	
	$.post('Ampliacion_plazoController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_ampliacion_plazo : id_ampliacion_plazoVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						
						resolucion_aprobacion_ampliacion_plazo : resolucion_aprobacion_ampliacion_plazoVar,
						fecha_resolucion_aprobacion_ampliacion_plazo : fecha_resolucion_aprobacion_ampliacion_plazoVar,
						plazo_otorgado : plazo_otorgadoVar,
						motivo_generado : motivo_generadoVar,
						
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_ampliacion_plazo(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_ampliacion_plazo').html('<div class="alert alert-success" align="center" role="alert">Ampliacion de plazo grabada con éxito</div>');
							$('#btn_grabar_ampliacion_plazo').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_ampliacion_plazo').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_ampliacion_plazo(id_ampliacion_plazo) {

	var opcionVar = "buscar";
	var id_ampliacion_plazoVar = id_ampliacion_plazo;

	$.get('Ampliacion_plazoController', {

		opcion : opcionVar,
		id_ampliacion_plazo : id_ampliacion_plazoVar

	}, function(response) {
		
		$('#id_ampliacion_plazo').val(response.id_ampliacion_plazo);
		
		$('#resolucion_aprobacion_ampliacion_plazo').val(response.resolucion_aprobacion_ampliacion_plazo);
		$('#fecha_resolucion_aprobacion_ampliacion_plazo').val(response.fecha_resolucion_aprobacion_ampliacion_plazo);
		$('#plazo_otorgado_ampliacion_plazo').val(response.plazo_otorgado);
		$('#motivo_generado_ampliacion_plazo').val(response.motivo_generado);
		
	});

}

function ver_datos_ampliacion_plazo(id_ampliacion_plazo){
	
	limpiar_form_ampliacion_plazo();
	
	cargar_datos_ampliacion_plazo(id_ampliacion_plazo);
	
	$('#resolucion_aprobacion_ampliacion_plazo').attr('disabled',true);
	$('#fecha_resolucion_aprobacion_ampliacion_plazo').attr('disabled',true);
	$('#plazo_otorgado_ampliacion_plazo').attr('disabled',true);
	$('#motivo_generado_ampliacion_plazo').attr('disabled',true);
	
	$('#btn_grabar_ampliacion_plazo').hide();
	
}

function editar_datos_ampliacion_plazo(id_ampliacion_plazo){
	
	limpiar_form_ampliacion_plazo();
	
	cargar_datos_ampliacion_plazo(id_ampliacion_plazo);
	
	$('#resolucion_aprobacion_ampliacion_plazo').attr('disabled',false);
	$('#fecha_resolucion_aprobacion_ampliacion_plazo').attr('disabled',false);
	$('#plazo_otorgado_ampliacion_plazo').attr('disabled',false);
	$('#motivo_generado_ampliacion_plazo').attr('disabled',false);
	
	$('#btn_grabar_ampliacion_plazo').show();
	
};
