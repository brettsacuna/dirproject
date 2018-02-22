function lista_otros_documentos(id_contrato_proceso_seleccion_item){
	
	var opcionVar = "listar_otros_documentos";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
		
	$.get('Otros_documentosController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar
		
	},function(response){
			
			$('#listado_otros_documentos').empty();
			
			var body = "";
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, otros_documentos){
				
				if(usuario == otros_documentos.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${otros_documentos.informacion_especifica}</td>																	
							<td class="text-center"><button type="button" class="btn btn-primary"  onclick="ver_datos_otros_documentos(${otros_documentos.id_otro_documento})" data-toggle="modal" data-target="#modal_otros_documentos" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" class="btn btn-default" onclick="editar_datos_otros_documentos(${otros_documentos.id_otro_documento})" data-toggle="modal" data-target="#modal_otros_documentos"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" class="btn btn-danger" onclick="carga_otro_documento_eliminar(${otros_documentos.id_otro_documento})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
				`;	
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${otros_documentos.informacion_especifica}</td>																	
							<td class="text-center">
													<button type="button"  class="btn btn-primary"  onclick="ver_datos_otros_documentos(${otros_documentos.id_otro_documento})" data-toggle="modal" data-target="#modal_otros_documentos" ><i class="glyphicon glyphicon-eye-open"></i></button>
													
							</td>
					    </tr>						
				`;
					
				}
														
			});
			
			$('#listado_otros_documentos').html(body);
						
	});
	
}

function carga_otro_documento_eliminar(id_otro_documento){
	
	$('#id_otro_documento').val(id_otro_documento);
	$('#id_eliminar_objeto').val('otro_documento');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar el documento seleccionado?</strong>?</h5>');
}

function elimina_otro_documento(id_otro_documento){
		
		var opcionVar = 'eliminar';
	
		$.post('Otros_documentosController',{
			
			opcion: opcionVar,
			id_otro_documento : id_otro_documento
			
		},function(response){
			
			if(response == 1){
				
				lista_otros_documentos($('#id_contrato_proceso_seleccion_item').val());
				$('#id_otro_documento').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function guardar_otros_documentos(){
	
	var opcionVar = "guardar";

	var id_otro_documentoVar = $('#id_otro_documento').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_otro_documentoVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var informacion_especificaVar = $('#informacion_especifica').val();
	var fecha_informeVar = $('#fecha_informe_otros_documentos').val();
	var detalleVar = $('#detalle_otros_documentos').val();
	var motivo_generadoVar = $('#motivo_generado_otros_documentos').val();	
	
	var usuarioVar = $('#usuario').val();
	
	$.post('Otros_documentosController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_otro_documento : id_otro_documentoVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						
						informacion_especifica : informacion_especificaVar,
						fecha_informe : fecha_informeVar,
						detalle : detalleVar,
						motivo_generado : motivo_generadoVar,
						
						
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_otros_documentos(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_otros_documentos').html('<div class="alert alert-success" align="center" role="alert">Documento grabado con éxito</div>');
							$('#btn_grabar_otros_documentos').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_otros_documentos').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_otros_documentos(id_otro_documento) {

	var opcionVar = "buscar";
	var id_otro_documentoVar = id_otro_documento;

	$.get('Otros_documentosController', {

		opcion : opcionVar,
		id_otro_documento : id_otro_documentoVar

	}, function(response) {
		
		$('#id_otro_documento').val(response.id_otro_documento);
		
		$('#informacion_especifica').val(response.informacion_especifica);
		$('#fecha_informe_otros_documentos').val(response.fecha_informe);
		$('#detalle_otros_documentos').val(response.detalle);
		$('#motivo_generado_otros_documentos').val(response.motivo_generado);	
		
	});

}

function ver_datos_otros_documentos(id_otro_documento){
	
	limpiar_form_otros_documentos();
	
	cargar_datos_otros_documentos(id_otro_documento);
	
	$('#informacion_especifica').attr('disabled',true);
	$('#fecha_informe_otros_documentos').attr('disabled',true);
	$('#detalle_otros_documentos').attr('disabled',true);
	$('#motivo_generado_otros_documentos').attr('disabled',true);
	
	$('#btn_grabar_otros_documentos').hide();
	
}

function editar_datos_otros_documentos(id_otro_documento){
	
	limpiar_form_otros_documentos();
	
	cargar_datos_otros_documentos(id_otro_documento);
	
	$('#informacion_especifica').attr('disabled',false);
	$('#fecha_informe_otros_documentos').attr('disabled',false);
	$('#detalle_otros_documentos').attr('disabled',false);
	$('#motivo_generado_otros_documentos').attr('disabled',false);
	
	$('#btn_grabar_otros_documentos').show();
		
};
