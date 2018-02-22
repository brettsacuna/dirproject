function lista_acta(id_contrato_proceso_seleccion_item){
	
	var opcionVar = "listar_acta";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
		
	$.get('ActaController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar
		
	},function(response){
			
			$('#listado_actas').empty();
			
			var body = "";
			
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, acta){
				
				if(usuario == acta.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${acta.acta_descripcion}</td>																	
							<td class="text-center"><button type="button"  class="btn btn-primary"  onclick="ver_datos_acta(${acta.id_acta})" data-toggle="modal" data-target="#modal_acta" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button"  class="btn btn-default" onclick="editar_datos_acta(${acta.id_acta})" data-toggle="modal" data-target="#modal_acta"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button"  class="btn btn-danger" onclick="carga_acta_eliminar(${acta.id_acta})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
						
						`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${acta.acta_descripcion}</td>																	
							<td class="text-center">
													<button type="button" class="btn btn-primary"  onclick="ver_datos_acta(${acta.id_acta})" data-toggle="modal" data-target="#modal_acta" ><i class="glyphicon glyphicon-eye-open"></i></button>
							</td>
					    </tr>						
						
						`;
				}
														
			});
			
			$('#listado_actas').html(body);
						
	});
	
}

function carga_acta_eliminar(id_acta){
	
	$('#id_acta').val(id_acta);
	$('#id_eliminar_objeto').val('acta');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar el acta seleccionada?</strong>?</h5>');
}

function elimina_acta(id_acta){
		
		var opcionVar = 'eliminar';
	
		$.post('ActaController',{
			
			opcion: opcionVar,
			id_acta : id_acta
			
		},function(response){
			
			if(response == 1){
				
				lista_acta($('#id_contrato_proceso_seleccion_item').val());
				$('#id_acta').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function guardar_acta(){
	
	var opcionVar = "guardar";

	var id_actaVar = $('#id_acta').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_actaVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var acta_descripcionVar = $('#acta_descripcion').val();
	var fecha_actaVar = $('#fecha_acta').val();
	var detalle_actaVar = $('#detalle_acta').val();
	var motivo_generadoVar = $('#motivo_generado_acta').val();
	
	var usuarioVar = $('#usuario').val();
	
	$.post('ActaController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_acta : id_actaVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						
						acta_descripcion : acta_descripcionVar,
						fecha_acta : fecha_actaVar,
						detalle_acta : detalle_actaVar,
						motivo_generado : motivo_generadoVar,
						
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_acta(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_acta').html('<div class="alert alert-success" align="center" role="alert">Acta grabada con éxito</div>');
							$('#btn_grabar_acta').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_acta').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_acta(id_acta) {

	var opcionVar = "buscar";
	var id_actaVar = id_acta;

	$.get('ActaController', {

		opcion : opcionVar,
		id_acta : id_actaVar

	}, function(response) {
		
		$('#id_acta').val(response.id_acta);
		
		$('#acta_descripcion').val(response.acta_descripcion);
		$('#fecha_acta').val(response.fecha_acta);
		$('#detalle_acta').val(response.detalle_acta);
		$('#motivo_generado_acta').val(response.motivo_generado);
		
	});

}

function ver_datos_acta(id_acta){
	
	limpiar_form_acta();
	
	cargar_datos_acta(id_acta);
		
	$('#acta_descripcion').attr('disabled',true);
	$('#fecha_acta').attr('disabled',true);
	$('#detalle_acta').attr('disabled',true);
	$('#motivo_generado_acta').attr('disabled',true);
	
	$('#btn_grabar_acta').hide();
	
}

function editar_datos_acta(id_acta){
	

	limpiar_form_acta();
	
	cargar_datos_acta(id_acta);
		
	$('#acta_descripcion').attr('disabled',false);
	$('#fecha_acta').attr('disabled',false);
	$('#detalle_acta').attr('disabled',false);
	$('#motivo_generado_acta').attr('disabled',false);
	
	$('#btn_grabar_acta').show();
	
};

