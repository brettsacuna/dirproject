function lista_adelanto(id_contrato_proceso_seleccion_item){
	
	var opcionVar = "listar_adelanto";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
		
	$.get('AdelantoController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar
		
	},function(response){
			
			$('#listado_adelantos').empty();
			
			var body = "";
			
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, adelanto){
				
				if(usuario == adelanto.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${adelanto.adelanto_descipcion}</td>																	
							<td class="text-center"><button type="button"  class="btn btn-primary"  onclick="ver_datos_adelanto(${adelanto.id_adelanto})" data-toggle="modal" data-target="#modal_adelanto" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button"  class="btn btn-default" onclick="editar_datos_adelanto(${adelanto.id_adelanto})" data-toggle="modal" data-target="#modal_adelanto"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button"  class="btn btn-danger" onclick="carga_adelanto_eliminar(${adelanto.id_adelanto})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
				`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td>${adelanto.adelanto_descipcion}</td>																	
							<td class="text-center"><button type="button"  class="btn btn-primary"  onclick="ver_datos_adelanto(${adelanto.id_adelanto})" data-toggle="modal" data-target="#modal_adelanto" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													
							</td>
					    </tr>						
				`;
					
				}
														
			});
			
			$('#listado_adelantos').html(body);
						
	});
	
}

function carga_adelanto_eliminar(id_adelanto){
	
	$('#id_adelanto').val(id_adelanto);
	$('#id_eliminar_objeto').val('adelanto');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar el adelanto seleccionado?</strong>?</h5>');
}

function elimina_adelanto(id_adelanto){
		
		var opcionVar = 'eliminar';
	
		$.post('AdelantoController',{
			
			opcion: opcionVar,
			id_adelanto : id_adelanto
			
		},function(response){
			
			if(response == 1){
				
				lista_adelanto($('#id_contrato_proceso_seleccion_item').val());
				$('#id_adelanto').val('');
								
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function guardar_adelanto(){
	
	var opcionVar = "guardar";

	var id_adelantoVar = $('#id_adelanto').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_adelantoVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var adelanto_descipcionVar = $('#adelanto_descipcion').val();
	var fecha_solicitud_adelantoVar = $('#fecha_solicitud_adelanto').val();
	var tipo_adelantoVar = $('#tipo_adelanto').val();
	var monto_adelantoVar = $('#monto_adelanto').val();
	
	var usuarioVar = $('#usuario').val();
	
	
	
	$.post('AdelantoController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_adelanto : id_adelantoVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						
						adelanto_descipcion : adelanto_descipcionVar,
						fecha_solicitud_adelanto : fecha_solicitud_adelantoVar,
						tipo_adelanto : tipo_adelantoVar,
						monto_adelanto : monto_adelantoVar,
						
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_adelanto(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_adelanto').html('<div class="alert alert-success" align="center" role="alert">Adelanto grabado con éxito</div>');
							$('#btn_grabar_adelanto').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_adelanto').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_adelanto(id_adelanto) {

	var opcionVar = "buscar";
	var id_adelantoVar = id_adelanto;

	$.get('AdelantoController', {

		opcion : opcionVar,
		id_adelanto : id_adelantoVar

	}, function(response) {
		
		$('#id_adelanto').val(response.id_adelanto);
		
		$('#adelanto_descipcion').val(response.adelanto_descipcion);
		$('#fecha_solicitud_adelanto').val(response.fecha_solicitud_adelanto);
		
		document.ready = document.getElementById("tipo_adelanto").value = response.tipo_adelanto;
		
		$('#monto_adelanto').val(response.monto_adelanto);
		
	});

}

function ver_datos_adelanto(id_adelanto){
	
	limpiar_form_adelanto();
	
	cargar_datos_adelanto(id_adelanto);
	

	$('#adelanto_descipcion').attr('disabled',true);
	$('#fecha_solicitud_adelanto').attr('disabled',true);
	$('#tipo_adelanto').attr('disabled',true);
	$('#monto_adelanto').attr('disabled',true);
	
	$('#btn_grabar_adelanto').hide();
	
}

function editar_datos_adelanto(id_adelanto){
	
	limpiar_form_adelanto();
	
	cargar_datos_adelanto(id_adelanto);
	
	
	$('#adelanto_descipcion').attr('disabled',false);
	$('#fecha_solicitud_adelanto').attr('disabled',false);
	$('#tipo_adelanto').attr('disabled',false);
	$('#monto_adelanto').attr('disabled',false);
	
	$('#btn_grabar_adelanto').show();
	
};

function valida_monto_adjudicado(){
	
	var monto_adelanto = ($('#monto_adelanto').val()*1) ;
	var monto_adjudicado_seleccionado = ($('#monto_adjudicado_seleccionado').val()*0.3);
	
	if( monto_adelanto > monto_adjudicado_seleccionado ){
		
		$('#panel_mensaje_adelanto').html('<div class="alert alert-danger" align="center" role="alert">El monto del adelanto excede 30% del monto adjudicado</div>');
		$('#btn_grabar_adelanto').attr('disabled',true);
	
	}else{
		
		$('#panel_mensaje_adelanto').html('');
		$('#btn_grabar_adelanto').attr('disabled',false);
		
	}
	
}
