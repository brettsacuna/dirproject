function lista_incidencia(id_contrato_proceso_seleccion_item){
	
	var opcionVar = "listar_incidencia";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
		
	$.get('IncidenciaController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar
		
	},function(response){
			
			$('#listado_incidencias').empty();
			
			var body = "";
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, incidencia){
				
				if(usuario == incidencia.usuario || tipo_usuario == "Administrador" ){
					
					body += `
							<tr class="warning">					  
								<td class="text-center">${index+1}</td>
								<td>${incidencia.detalle_incidencia}</td>																	
								<td class="text-center"><button type="button"  class="btn btn-primary"  onclick="ver_datos_incidencia(${incidencia.id_incidencia})" data-toggle="modal" data-target="#modal_incidencia" ><i class="glyphicon glyphicon-eye-open"></i></button> 
														<button type="button"  class="btn btn-default" onclick="editar_datos_incidencia(${incidencia.id_incidencia})" data-toggle="modal" data-target="#modal_incidencia"><i class="glyphicon glyphicon-edit"></i></button>
														<button type="button"  class="btn btn-danger" onclick="carga_incidencia_eliminar(${incidencia.id_incidencia})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
								</td>
						    </tr>						
					`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${incidencia.detalle_incidencia}</td>																	
							<td class="text-center">
													<button type="button"  class="btn btn-primary"  onclick="ver_datos_incidencia(${incidencia.id_incidencia})" data-toggle="modal" data-target="#modal_incidencia" ><i class="glyphicon glyphicon-eye-open"></i></button>													
							</td>
					    </tr>						
				`;
					
				}
																	
			});
			
			$('#listado_incidencias').html(body);
						
	});
	
}

function carga_incidencia_eliminar(id_incidencia){
	
	$('#id_incidencia').val(id_incidencia);
	$('#id_eliminar_objeto').val('incidencia');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar la incidencia seleccionada?</strong>?</h5>');
}

function elimina_incidencia(id_incidencia){
		
		var opcionVar = 'eliminar';
	
		$.post('IncidenciaController',{
			
			opcion: opcionVar,
			id_incidencia : id_incidencia
			
		},function(response){
			
			if(response == 1){
				
				lista_incidencia($('#id_contrato_proceso_seleccion_item').val());
				$('#id_incidencia').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}


function guardar_incidencia(){
	
	var opcionVar = "guardar";

	var id_incidenciaVar = $('#id_incidencia').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_incidenciaVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var detalle_incidenciaVar = $('#detalle_incidencia').val();	
	var motivoVar = $('#motivo_incidencia').val();	
	var asiento_cuaderno_obraVar = $('#asiento_cuaderno_obra_incidencia').val();	
	var fecha_eventoVar = $('#fecha_evento').val();		
	var fecha_asientoVar = $('#fecha_asiento').val();	
	var accionesVar = $('#acciones_incidencia').val();	
	var documento_emitidoVar = $('#documento_emitido').val();	
	var sumillaVar = $('#sumilla').val();	
	var objeto_incidenciaVar = $('#objeto_incidencia').val();
	
	var usuarioVar = $('#usuario').val();
	
	$.post('IncidenciaController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_incidencia : id_incidenciaVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						
						detalle_incidencia : detalle_incidenciaVar,
						motivo : motivoVar,
						asiento_cuaderno_obra : asiento_cuaderno_obraVar,
						fecha_evento : fecha_eventoVar,
						fecha_asiento : fecha_asientoVar,
						acciones : accionesVar,
						documento_emitido : documento_emitidoVar,
						sumilla : sumillaVar,
						objeto_incidencia : objeto_incidenciaVar,
						
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_incidencia(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_incidencia').html('<div class="alert alert-success" align="center" role="alert">Incidencia grabada con éxito</div>');
							$('#btn_grabar_incidencia').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_incidencia').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_incidencia(id_incidencia) {

	var opcionVar = "buscar";
	var id_incidenciaVar = id_incidencia;

	$.get('IncidenciaController', {

		opcion : opcionVar,
		id_incidencia : id_incidenciaVar

	}, function(response) {
		
		$('#id_incidencia').val(response.id_incidencia);
		
		$('#detalle_incidencia').val(response.detalle_incidencia);	
		$('#motivo_incidencia').val(response.motivo);	
		$('#asiento_cuaderno_obra_incidencia').val(response.asiento_cuaderno_obra);	
		$('#fecha_evento').val(response.fecha_evento);		
		$('#fecha_asiento').val(response.fecha_asiento);	
		$('#acciones_incidencia').val(response.acciones);	
		$('#documento_emitido').val(response.documento_emitido);	
		$('#sumilla').val(response.sumilla);	
		$('#objeto_incidencia').val(response.objeto_incidencia);
		
	});

}

function ver_datos_incidencia(id_incidencia){
	
	limpiar_form_incidencia();
	
	cargar_datos_incidencia(id_incidencia);	

	$('#detalle_incidencia').attr('disabled',true);
	$('#motivo_incidencia').attr('disabled',true);
	$('#asiento_cuaderno_obra_incidencia').attr('disabled',true);
	$('#fecha_evento').attr('disabled',true);
	$('#fecha_asiento').attr('disabled',true);
	$('#acciones_incidencia').attr('disabled',true);
	$('#documento_emitido').attr('disabled',true);
	$('#sumilla').attr('disabled',true);
	$('#objeto_incidencia').attr('disabled',true);
		
	$('#btn_grabar_incidencia').hide();
	
}

function editar_datos_incidencia(id_incidencia){
	
    limpiar_form_incidencia();
	
	cargar_datos_incidencia(id_incidencia);	

	$('#detalle_incidencia').attr('disabled',false);
	$('#motivo_incidencia').attr('disabled',false);
	$('#asiento_cuaderno_obra_incidencia').attr('disabled',false);
	$('#fecha_evento').attr('disabled',false);
	$('#fecha_asiento').attr('disabled',false);
	$('#acciones_incidencia').attr('disabled',false);
	$('#documento_emitido').attr('disabled',false);
	$('#sumilla').attr('disabled',false);
	$('#objeto_incidencia').attr('disabled',false);
		
	$('#btn_grabar_incidencia').show();
	
};
