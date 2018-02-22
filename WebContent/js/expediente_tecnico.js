function guardar_expediente_tecnico(){
	
	var opcionVar = "guardar";

	var id_expediente_tecnicoVar = $('#id_expediente_tecnico').val();
	
	var id_proyectoVar = $('#id_proyecto').val();

	if (id_expediente_tecnicoVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}
		
	var id_item_proyectoVar = $('#item_descripcion_proyecto').val();
	var item_descripcionVar = $('#item_descripcion_proyecto option:selected').text();
	
	var id_tipo_informe_tecnicoVar = $('#id_tipo_informe_tecnico').val();
	var informe_tecnico_modificaciones_etapa_inversionVar = $('#id_tipo_informe_tecnico option:selected').text();
	
	var monto_informe_tecnico_etapa_inversionVar = $('#monto_informe_tecnico_etapa_inversion').val(); 
	var fecha_informe_tecnico_etapa_inversionVar = $('#fecha_informe_tecnico_etapa_inversion').val(); 
	var numero_proceso_expediente_tecnicoVar = $('#numero_proceso_expediente_tecnico').val();
	var valor_referencialVar = $('#valor_referencial_expediente_tecnico').val();
	var modalidad_contratacionVar = $('#modalidad_contratacion_expediente_tecnico').val();
	var fecha_presupuesto_baseVar = $('#fecha_presupuesto_base').val();
	var postoresVar = $('#postores').val(); 
	var monto_adjudicadoVar = $('#monto_adjudicado_expediente_tecnico').val();
	var contratista_adjudicadoVar = $('#contratista_adjudicado_expediente_tecnico').val(); 
	var ruc_contratista_adjudicadoVar = $('#ruc_contratista_adjudicado_expediente_tecnico').val(); 
	var fecha_otorgamientoVar = $('#fecha_otorgamiento').val(); 
	var numero_contratoVar = $('#numero_contrato_expediente_tecnico').val(); 
	var fecha_firma_contratoVar = $('#fecha_firma_contrato_expediente_tecnico').val(); 
	var plazo_ejecucion_expediente_tecnicoVar = $('#plazo_ejecucion_expediente_tecnico').val(); 
	var tipo_ejecucionVar = $('#tipo_ejecucion_expediente_tecnico').val(); 
	var observacionesVar = $('#observaciones_expediente_tecnico').val();
	var usuarioVar = $('#usuario').val();

	$.post('Expediente_tecnicoController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_proyecto : id_proyectoVar,
						id_expediente_tecnico : id_expediente_tecnicoVar,
						id_item_proyecto : id_item_proyectoVar,
						item_descripcion : item_descripcionVar,
						id_tipo_informe_tecnico : id_tipo_informe_tecnicoVar,
						informe_tecnico_modificaciones_etapa_inversion	: informe_tecnico_modificaciones_etapa_inversionVar,
						monto_informe_tecnico_etapa_inversion : monto_informe_tecnico_etapa_inversionVar,
						fecha_informe_tecnico_etapa_inversion : fecha_informe_tecnico_etapa_inversionVar,
						numero_proceso_expediente_tecnico : numero_proceso_expediente_tecnicoVar,
						valor_referencial : valor_referencialVar,
						modalidad_contratacion : modalidad_contratacionVar,
						fecha_presupuesto_base : fecha_presupuesto_baseVar,
						postores : postoresVar,
						monto_adjudicado : monto_adjudicadoVar ,
						contratista_adjudicado : contratista_adjudicadoVar  ,
						ruc_contratista_adjudicado : ruc_contratista_adjudicadoVar ,
						fecha_otorgamiento : fecha_otorgamientoVar ,
						numero_contrato : numero_contratoVar ,
						fecha_firma_contrato : fecha_firma_contratoVar  ,
						plazo_ejecucion_expediente_tecnico : plazo_ejecucion_expediente_tecnicoVar ,
						tipo_ejecucion : tipo_ejecucionVar,
						observaciones : observacionesVar,
						
						usuario : usuarioVar

					},
					
					function(response) {

						if (response == 1) {
														
							lista_expediente_tecnico(id_proyectoVar);							
							$('#panel_mensaje_expediente_tecnico').html('<div class="alert alert-success" align="center" role="alert">Expediente técnico registrado con éxito</div>');
														
							$('#btn_grabar_expediente_tecnico').hide();
							
						} else if (response == 0) {
							
							$('#panel_mensaje_expediente_tecnico').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});
	
}

function ver_datos_expediente_tecnico(id_expediente_tecnico){
	
	limpiar_form_expediente_tecnico();
	
	cargar_datos_expediente_tecnico(id_expediente_tecnico);
	
	$('#item_descripcion_proyecto').attr('disabled',true);
	$('#id_tipo_informe_tecnico').attr('readonly',true);
	$('#monto_informe_tecnico_etapa_inversion').attr('readonly',true); 
	$('#fecha_informe_tecnico_etapa_inversion').attr('disabled',true); 
	$('#numero_proceso_expediente_tecnico').attr('readonly',true);
	$('#valor_referencial_expediente_tecnico').attr('readonly',true);
	
	$('#modalidad_contratacion_expediente_tecnico').attr('disabled',true);
	
	$('#fecha_presupuesto_base').attr('disabled',true);
	$('#postores').attr('readonly',true); 
	$('#monto_adjudicado_expediente_tecnico').attr('readonly',true);
	$('#contratista_adjudicado_expediente_tecnico').attr('readonly',true); 
	$('#ruc_contratista_adjudicado_expediente_tecnico').attr('readonly',true); 
	$('#fecha_otorgamiento').attr('disabled',true); 
	$('#numero_contrato_expediente_tecnico').attr('readonly',true); 
	$('#fecha_firma_contrato_expediente_tecnico').attr('disabled',true); 
	$('#plazo_ejecucion_expediente_tecnico').attr('readonly',true);
		
	$('#tipo_ejecucion_expediente_tecnico').attr('disabled',true);
	
	$('#observaciones_expediente_tecnico').attr('readonly',true);
	
	$('#btn_grabar_expediente_tecnico').hide();
	
}

function editar_datos_expediente_tecnico(id_expediente_tecnico){
	
	limpiar_form_expediente_tecnico();
	
	cargar_datos_expediente_tecnico(id_expediente_tecnico);
	
	$('#btn_grabar_expediente_tecnico').show();
	
};

function cargar_datos_expediente_tecnico(id_expediente_tecnico) {

	var opcionVar = "buscar";
	var id_expediente_tecnicoVar = id_expediente_tecnico;

	$.get('Expediente_tecnicoController', {

		opcion : opcionVar,
		id_expediente_tecnico : id_expediente_tecnicoVar

	}, function(response) {
				
		$('#id_expediente_tecnico').val(response.id_expediente_tecnico);
		
		console.log(response.id_expediente_tecnico);
		
		document.ready = document.getElementById("id_tipo_informe_tecnico").value = response.id_tipo_informe_tecnico;
		
		$('#monto_informe_tecnico_etapa_inversion').val(response.monto_informe_tecnico_etapa_inversion); 
		$('#fecha_informe_tecnico_etapa_inversion').val(response.fecha_informe_tecnico_etapa_inversion); 
		$('#numero_proceso_expediente_tecnico').val(response.numero_proceso_expediente_tecnico);
		$('#valor_referencial_expediente_tecnico').val(response.valor_referencial);
		
		document.ready = document.getElementById("modalidad_contratacion_expediente_tecnico").value = response.modalidad_contratacion;
		
		$('#fecha_presupuesto_base').val(response.fecha_presupuesto_base);
		$('#postores').val(response.postores); 
		$('#monto_adjudicado_expediente_tecnico').val(response.monto_adjudicado);
		$('#contratista_adjudicado_expediente_tecnico').val(response.contratista_adjudicado); 
		$('#ruc_contratista_adjudicado_expediente_tecnico').val(response.ruc_contratista_adjudicado); 
		$('#fecha_otorgamiento').val(response.fecha_otorgamiento); 
		$('#numero_contrato_expediente_tecnico').val(response.numero_contrato); 
		$('#fecha_firma_contrato_expediente_tecnico').val(response.fecha_firma_contrato); 
		$('#plazo_ejecucion_expediente_tecnico').val(response.plazo_ejecucion_expediente_tecnico); 
		
		document.ready = document.getElementById("tipo_ejecucion_expediente_tecnico").value = response.tipo_ejecucion; 
		document.ready = document.getElementById("item_descripcion_proyecto").value = response.id_item_proyecto; 
		
		$('#observaciones_expediente_tecnico').val(response.observaciones);
				
	});

}


function lista_expediente_tecnico(id_proyecto){
	
	var opcionVar = "listar_expediente_tecnico";

	var id_proyectoVar = id_proyecto;
			
	$.get('Expediente_tecnicoController', {
		
		opcion : opcionVar,	
		id_proyecto: id_proyectoVar
		
	},function(response){
			
			$('#listado_expediente_tecnico').empty();
			
			var body = "";
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, expediente_tecnico){
				
				var modalidad_contratacion = "";
				
				switch (expediente_tecnico.modalidad_contratacion) {
				
				case '1' : modalidad_contratacion = "Administración Directa";
					break;	
				case '2' : modalidad_contratacion = "Proceso de Seleccion";
					break;	
										
				}	
				
				if(usuario == expediente_tecnico.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">
						  
							<td class="text-center">${index+1}</td>
							<td>${expediente_tecnico.item_descripcion}</td>
							<td class="text-center">${expediente_tecnico.numero_proceso_expediente_tecnico}</td>													
							<td class="text-center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_expediente_tecnico" onclick="ver_datos_expediente_tecnico(${expediente_tecnico.id_expediente_tecnico})"><i class="glyphicon glyphicon-eye-open"></i></button>
													<button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal_expediente_tecnico" onclick="editar_datos_expediente_tecnico(${expediente_tecnico.id_expediente_tecnico})"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" class="btn btn-danger" onclick="carga_expediente_tecnico_eliminar(${expediente_tecnico.id_expediente_tecnico})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					     
						</tr>
						
						`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
				
					body += `
						<tr class="warning">
						  
							<td class="text-center">${index+1}</td>
							<td>${expediente_tecnico.item_descripcion}</td>
							<td class="text-center">${expediente_tecnico.numero_proceso_expediente_tecnico}</td>													
							<td class="text-center"><button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#modal_expediente_tecnico" onclick="ver_datos_expediente_tecnico(${expediente_tecnico.id_expediente_tecnico})"><i class="glyphicon glyphicon-eye-open"></i></button>
													
							</td>
					     
						</tr>
						
						`;
					
				}
								
			});
			
			$("#listado_expediente_tecnico").html(body);
							
	});
	
}

function carga_expediente_tecnico_eliminar(id_expediente_tecnico){
	
	$('#id_expediente_tecnico').val(id_expediente_tecnico);
	$('#id_eliminar_objeto').val('expediente_tecnico');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar el expediente técnico seleccionado?</h5>');
}

function elimina_expediente_tecnico(id_expediente_tecnico){
		
		var opcionVar = 'eliminar';
	
		$.post('Expediente_tecnicoController',{
			
			opcion: opcionVar,
			id_expediente_tecnico : id_expediente_tecnico
			
		},function(response){
			
			if(response == 1){
				
				lista_expediente_tecnico($('#id_proyecto').val());
				$('#id_expediente_tecnico').val('');
								
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function lista_item_descripcion_proyecto(id_proyecto){
	
	var opcionVar = "listar_item_proyecto";
	var id_proyectoVar = id_proyecto;
		
	$.get('Item_proyectoController', {
		
		opcion : opcionVar,		
		id_proyecto: id_proyectoVar
		
	},function(response){			
		
			$('#item_descripcion_proyecto').empty();	
			
			$.each(response, function(index, item_proyecto){
										
					$('#item_descripcion_proyecto').append('<option value ="'+item_proyecto.id_item_proyecto+'">'+item_proyecto.item_descripcion+'</option>');
																		
			});
							
	});
	
}
