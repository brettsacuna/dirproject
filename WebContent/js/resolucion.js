function lista_resolucion(id_contrato_proceso_seleccion_item){
	
	var opcionVar = "listar_resolucion";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
		
	$.get('ResolucionController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar
		
	},function(response){
			
			$('#listado_resoluciones').empty();
			
			var body = "";
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, resolucion){
				
				if(usuario == resolucion.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${resolucion.resolucion_conformacion_comite}</td>																	
							<td class="text-center"><button type="button" id="btn_ver_resolucion" class="btn btn-primary"  onclick="ver_datos_resolucion(${resolucion.id_resolucion})" data-toggle="modal" data-target="#modal_resolucion" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" id="btn_editar_resolucion" class="btn btn-default" onclick="editar_datos_resolucion(${resolucion.id_resolucion})" data-toggle="modal" data-target="#modal_resolucion"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" id="btn_eliminar_resolucion" class="btn btn-danger" onclick="carga_resolucion_eliminar(${resolucion.id_resolucion})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
				`;
					
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${resolucion.resolucion_conformacion_comite}</td>																	
							<td class="text-center">
													<button type="button" id="btn_ver_resolucion" class="btn btn-primary"  onclick="ver_datos_resolucion(${resolucion.id_resolucion})" data-toggle="modal" data-target="#modal_resolucion" ><i class="glyphicon glyphicon-eye-open"></i></button>													
							</td>
					    </tr>						
				`;
					
				}
																		
			});
			
			$('#listado_resoluciones').html(body);
						
	});
	
}

function carga_resolucion_eliminar(id_resolucion){
	
	$('#id_resolucion').val(id_resolucion);
	$('#id_eliminar_objeto').val('resolucion');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar la resolucion seleccionada?</strong>?</h5>');
}

function elimina_resolucion(id_resolucion){
		
		var opcionVar = 'eliminar';
	
		$.post('ResolucionController',{
			
			opcion: opcionVar,
			id_resolucion : id_resolucion
			
		},function(response){
			
			if(response == 1){
				
				lista_resolucion($('#id_contrato_proceso_seleccion_item').val());
				$('#id_resolucion').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function guardar_resolucion(){
	
	var opcionVar = "guardar";

	var id_resolucionVar = $('#id_resolucion').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_resolucionVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var resolucion_conformacion_comiteVar = $('#resolucion_conformacion_comite').val();
	var fecha_resolucionVar = $('#fecha_resolucion').val();
	var miembrosVar = $('#miembros').val();
	var motivo_generadoVar = $('#motivo_generado_resolucion').val();

	
	var usuarioVar = $('#usuario').val();
	
	$.post('ResolucionController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_resolucion : id_resolucionVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						
						resolucion_conformacion_comite : resolucion_conformacion_comiteVar,
						fecha_resolucion : fecha_resolucionVar,
						miembros : miembrosVar,
						motivo_generado : motivo_generadoVar,
												
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_resolucion(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_resolucion').html('<div class="alert alert-success" align="center" role="alert">Resolución grabada con éxito</div>');
							$('#btn_grabar_resolucion').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_resolucion').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_resolucion(id_resolucion) {

	var opcionVar = "buscar";
	var id_resolucionVar = id_resolucion;

	$.get('ResolucionController', {

		opcion : opcionVar,
		id_resolucion : id_resolucionVar

	}, function(response) {
		
		$('#id_resolucion').val(response.id_resolucion);
		
		$('#resolucion_conformacion_comite').val(response.resolucion_conformacion_comite);
		$('#fecha_resolucion').val(response.fecha_resolucion);
		$('#miembros').val(response.miembros);
		$('#motivo_generado_resolucion').val(response.motivo_generado);
		
		
	});

}

function ver_datos_resolucion(id_resolucion){
	
	limpiar_form_resolucion();
	
	cargar_datos_resolucion(id_resolucion);	
	
	$('#resolucion_conformacion_comite').attr('disabled',true);
	$('#fecha_resolucion').attr('disabled',true);
	$('#miembros').attr('disabled',true);
	$('#motivo_generado_resolucion').attr('disabled',true);
		
	$('#btn_grabar_resolucion').hide();
	
}

function editar_datos_resolucion(id_resolucion){
	
	limpiar_form_resolucion();
	
	cargar_datos_resolucion(id_resolucion);	
	
	$('#resolucion_conformacion_comite').attr('disabled',false);
	$('#fecha_resolucion').attr('disabled',false);
	$('#miembros').attr('disabled',false);
	$('#motivo_generado_resolucion').attr('disabled',false);
		
	$('#btn_grabar_resolucion').show();
	
};
