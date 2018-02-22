function guardar_adenda(){
	
	var opcionVar = "guardar";

	var id_adendaVar = $('#id_adenda').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_adendaVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var adenda_descripcionVar = $('#adenda_descripcion').val();
	var fecha_suscripcionVar = $('#fecha_suscripcion_adenda').val();
	var plazo_otorgadoVar = $('#plazo_otorgado_adenda').val();
	var motivo_generadoVar = $('#motivo_generado_adenda').val();
	
	var usuarioVar = $('#usuario').val();
	
	$.post('AdendaController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_adenda : id_adendaVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						adenda_descripcion : adenda_descripcionVar,
						fecha_suscripcion : fecha_suscripcionVar,
						plazo_otorgado : plazo_otorgadoVar,
						motivo_generado : motivo_generadoVar,
						
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_adendas(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_adenda').html('<div class="alert alert-success" align="center" role="alert">Adenda grabada con éxito</div>');
							$('#btn_grabar_adenda').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_adenda').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function lista_adendas(id_contrato_proceso_seleccion_item){
	
	var opcionVar = "listar_adendas";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
	
	
	$.get('AdendaController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar
		
	},function(response){
			
			$('#listado_adendas').empty();
			
			var body = "";
			
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, adenda){
				
				if(usuario == adenda.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${adenda.adenda_descripcion}</td>																
							<td class="text-center"><button type="button" class="btn btn-primary"  onclick="ver_datos_adenda(${adenda.id_adenda})" data-toggle="modal" data-target="#modal_adenda" ><i class="glyphicon glyphicon-eye-open"></i></button>
													<button type="button"  class="btn btn-default" onclick="editar_datos_adenda(${adenda.id_adenda})" data-toggle="modal" data-target="#modal_adenda"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button"  class="btn btn-danger" onclick="carga_adenda_eliminar(${adenda.id_adenda})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
				`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${adenda.adenda_descripcion}</td>																	
							<td class="text-center"><button type="button"  class="btn btn-primary"  onclick="ver_datos_adenda(${adenda.id_adenda})" data-toggle="modal" data-target="#modal_adenda" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													
							</td>
					    </tr>						
				`;
					
				}
														
			});
			
			$('#listado_adendas').html(body);
						
	});
	
}

function carga_adenda_eliminar(id_adenda){
	
	$('#id_adenda').val(id_adenda);
	$('#id_eliminar_objeto').val('adenda');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar la adenda seleccionada?</strong>?</h5>');
}

function elimina_adenda(id_adenda){
		
		var opcionVar = 'eliminar';
	
		$.post('AdendaController',{
			
			opcion: opcionVar,
			id_adenda : id_adenda
			
		},function(response){
			
			if(response == 1){
				
				lista_adendas($('#id_contrato_proceso_seleccion_item').val());
				$('#id_adenda').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function cargar_datos_adenda(id_adenda) {

	var opcionVar = "buscar";
	var id_adendaVar = id_adenda;

	$.get('AdendaController', {

		opcion : opcionVar,
		id_adenda : id_adendaVar

	}, function(response) {
		
		$('#id_adenda').val(response.id_adenda);
		
		$('#adenda_descripcion').val(response.adenda_descripcion);
		$('#fecha_suscripcion_adenda').val(response.fecha_suscripcion);
		$('#plazo_otorgado_adenda').val(response.plazo_otorgado);
		$('#motivo_generado_adenda').val(response.motivo_generado);
		
	});

}

function ver_datos_adenda(id_adenda){
	
	limpiar_form_adenda();
	
	cargar_datos_adenda(id_adenda);
	

	$('#adenda_descripcion').attr('disabled',true);
	$('#fecha_suscripcion_adenda').attr('disabled',true);
	$('#plazo_otorgado_adenda').attr('disabled',true);
	$('#motivo_generado_adenda').attr('disabled',true);
	
	$('#btn_grabar_adenda').hide();
	
}

function editar_datos_adenda(id_adenda){
	
	limpiar_form_adenda();
	
	cargar_datos_adenda(id_adenda);
		
	$('#adenda_descripcion').attr('disabled',false);
	$('#fecha_suscripcion_adenda').attr('disabled',false);
	$('#plazo_otorgado_adenda').attr('disabled',false);
	$('#motivo_generado_adenda').attr('disabled',false);
	
	$('#btn_grabar_adenda').show();
	
};

