function guardar_contrato_proceso_seleccion_item(){
	
	var opcionVar = "guardar";
	
	var id_proceso_seleccion_itemVar = $('#id_proceso_seleccion_item').val();
	
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();
	
	if (id_contrato_proceso_seleccion_itemVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}
	
	var numero_contrato_proceso_seleccion_itemVar = $('#numero_contrato_proceso_seleccion_item').val();
	var contratista_adjudicado_contrato_proceso_seleccion_itemVar = $('#contratista_adjudicado_contrato_proceso_seleccion_item').val();
	var ruc_contratista_contrato_proceso_seleccion_itemVar = $('#ruc_contratista_contrato_proceso_seleccion_item').val();
	var fecha_adjudicacion_contrato_proceso_seleccion_itemVar = $('#fecha_adjudicacion_contrato_proceso_seleccion_item').val();
	var fecha_firma_contrato_proceso_seleccion_itemVar = $('#fecha_firma_contrato_proceso_seleccion_item').val();
	
	var monto_adjudicado_contrato_proceso_seleccion_itemVar = $('#monto_adjudicado_contrato_proceso_seleccion_item').val();
	var monto_pagado_contrato_proceso_seleccion_itemVar = $('#monto_pagado_contrato_proceso_seleccion_item').val();
		
	var porcentaje_pagado_contrato_proceso_seleccion_itemVar = $('#porcentaje_pagado_contrato_proceso_seleccion_item').val();

	var fecha_entrega_terreno_contrato_proceso_seleccion_itemVar = $('#fecha_entrega_terreno_contrato_proceso_seleccion_item').val();
	var plazo_ejecucion_contrato_proceso_seleccion_itemVar = $('#plazo_ejecucion_contrato_proceso_seleccion_item').val();
	var fecha_inicio_plazo_contractual_proceso_seleccion_itemVar = $('#fecha_inicio_plazo_contractual_proceso_seleccion_item').val();

	var total_dias_ampliacion_plazo_contrato_proceso_seleccion_itemVar = $('#total_dias_ampliacion_plazo_contrato_proceso_seleccion_item').val();
	var total_adendas_contrato_proceso_seleccion_itemVar = $('#total_adendas_contrato_proceso_seleccion_item').val();
	var monto_prestaciones_adicionales_contrato_proceso_seleccion_itemVar = $('#monto_prestaciones_adicionales_contrato_proceso_seleccion_item').val();

	var observaciones_contrato_proceso_seleccion_obraVar = $('#observaciones_contrato_proceso_seleccion_obra').val();
	var liquidacion_contrato_proceso_seleccion_itemVar = $('#liquidacion_contrato_proceso_seleccion_item').val();
	
	var usuarioVar = $('#usuario').val();
	
	$.post('Contrato_proceso_seleccion_itemController',
			
					{

						opcion : opcionVar,
						operacion : operacionVar,
												
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						id_proceso_seleccion_item : id_proceso_seleccion_itemVar,
												
						numero_contrato : numero_contrato_proceso_seleccion_itemVar,
						contratista_adjudicado : contratista_adjudicado_contrato_proceso_seleccion_itemVar, 
						ruc_contratista : ruc_contratista_contrato_proceso_seleccion_itemVar,
						fecha_adjudicacion : fecha_adjudicacion_contrato_proceso_seleccion_itemVar, 
						fecha_firma_contrato : fecha_firma_contrato_proceso_seleccion_itemVar,

						monto_adjudicado : monto_adjudicado_contrato_proceso_seleccion_itemVar, 
						monto_pagado : monto_pagado_contrato_proceso_seleccion_itemVar,
						porcentaje_pagado : porcentaje_pagado_contrato_proceso_seleccion_itemVar,

						fecha_entrega_terreno : fecha_entrega_terreno_contrato_proceso_seleccion_itemVar,
						plazo_ejecucion : plazo_ejecucion_contrato_proceso_seleccion_itemVar,
						fecha_inicio_plazo_contractual : fecha_inicio_plazo_contractual_proceso_seleccion_itemVar,

						total_dias_ampliacion_plazo : total_dias_ampliacion_plazo_contrato_proceso_seleccion_itemVar,
						total_adendas : total_adendas_contrato_proceso_seleccion_itemVar,
						monto_prestaciones_adicionales : monto_prestaciones_adicionales_contrato_proceso_seleccion_itemVar,

						observaciones : observaciones_contrato_proceso_seleccion_obraVar,
						liquidacion : liquidacion_contrato_proceso_seleccion_itemVar,
												
						usuario : usuarioVar

					},
					
					function(response) {

						if (response == 1) {
							
							lista_contrato_proceso_seleccion_item(id_proceso_seleccion_itemVar);
																					
							$('#panel_mensaje_contrato_proceso_seleccion_item').html('<div class="alert alert-success" align="center" role="alert">Contrato guardado con éxito</div>');
							$('#btn_grabar_contrato_proceso_seleccion_item').hide();
						} else if (response == 0) {
							$('#panel_mensaje_contrato_proceso_seleccion_item').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});
	
}


function lista_contrato_proceso_seleccion_item(id_proceso_seleccion_item){
		
	var opcionVar = "listar_contrato_proceso_seleccion_item";
	
	var id_proceso_seleccion_itemVar = id_proceso_seleccion_item;
		
	$.get('Contrato_proceso_seleccion_itemController', {
		
		opcion : opcionVar,		
		id_proceso_seleccion_item : id_proceso_seleccion_itemVar
		
	},function(response){
														
			$('#listado_contrato_proceso_item_'+id_proceso_seleccion_item).empty();
								
			var body = "";
			
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, contrato_proceso_seleccion_item){
				
				if(usuario == contrato_proceso_seleccion_item.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">
							<td class="text-center">${index+1}</td>
							<td>${contrato_proceso_seleccion_item.numero_contrato}</td>							
							<td class="text-center"><button type="button" class="btn btn-warning" onclick="selecciona_contrato(${contrato_proceso_seleccion_item.id_contrato_proceso_seleccion_item})"><i class="glyphicon glyphicon-ok"></i></button> 
													<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_contrato_proceso_seleccion_item" onclick="ver_datos_contrato_proceso_seleccion_item(${contrato_proceso_seleccion_item.id_contrato_proceso_seleccion_item})"><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" class="btn btn-default" onclick="editar_datos_contrato_proceso_seleccion_item(${contrato_proceso_seleccion_item.id_contrato_proceso_seleccion_item},${contrato_proceso_seleccion_item.id_proceso_seleccion_item})" data-toggle="modal" data-target="#modal_contrato_proceso_seleccion_item"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" class="btn btn-danger" onclick="carga_contrato_eliminar(${contrato_proceso_seleccion_item.id_contrato_proceso_seleccion_item})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
						</tr>
					`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">
							<td class="text-center">${index+1}</td>
							<td>${contrato_proceso_seleccion_item.numero_contrato}</td>							
							<td class="text-center"><button type="button" class="btn btn-warning" onclick="selecciona_contrato(${contrato_proceso_seleccion_item.id_contrato_proceso_seleccion_item})"><i class="glyphicon glyphicon-ok"></i></button>
													<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_contrato_proceso_seleccion_item" onclick="ver_datos_contrato_proceso_seleccion_item(${contrato_proceso_seleccion_item.id_contrato_proceso_seleccion_item})"><i class="glyphicon glyphicon-eye-open"></i></button> 
							</td>
						</tr>
					`;
					
				}	
									
			});
			
			$('#listado_contrato_proceso_item_'+id_proceso_seleccion_item).html(body);
			$('#contrato_proceso_item_'+id_proceso_seleccion_item).show();		
	});			
}


function carga_contrato_eliminar(id_contrato_proceso_seleccion_item){
	
	$('#id_contrato_proceso_seleccion_item').val(id_contrato_proceso_seleccion_item);
	$('#id_eliminar_objeto').val('contrato_proceso_seleccion_item');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar el contrato seleccionado?</h5>');
}

function elimina_contrato(id_contrato_proceso_seleccion_item){
		
		var opcionVar = 'eliminar';
	
		$.post('Contrato_proceso_seleccion_itemController',{
			
			opcion: opcionVar,
			id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_item
			
		},function(response){
			
			if(response == 1){
				
				replegar();								
				$('#id_contrato_proceso_seleccion_item').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function cargar_datos_contrato_proceso_seleccion_item(id_contrato_proceso_seleccion_item) {

	var opcionVar = "buscar";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;

	$.get('Contrato_proceso_seleccion_itemController', {

		opcion : opcionVar,
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar

	}, function(response) {
				
		$('#id_contrato_proceso_seleccion_item').val(response.id_contrato_proceso_seleccion_item);
		
		$('#numero_contrato_proceso_seleccion_item').val(response.numero_contrato);
		$('#contratista_adjudicado_contrato_proceso_seleccion_item').val(response.contratista_adjudicado);
		$('#ruc_contratista_contrato_proceso_seleccion_item').val(response.ruc_contratista);
		$('#fecha_adjudicacion_contrato_proceso_seleccion_item').val(response.fecha_adjudicacion);
		$('#fecha_firma_contrato_proceso_seleccion_item').val(response.fecha_firma_contrato);
		
		$('#monto_adjudicado_contrato_proceso_seleccion_item').val(response.monto_adjudicado);
		$('#monto_pagado_contrato_proceso_seleccion_item').val(response.monto_pagado);
			
		$('#porcentaje_pagado_contrato_proceso_seleccion_item').val(response.porcentaje_pagado);

		$('#fecha_entrega_terreno_contrato_proceso_seleccion_item').val(response.fecha_entrega_terreno);
		$('#plazo_ejecucion_contrato_proceso_seleccion_item').val(response.plazo_ejecucion);
		$('#fecha_inicio_plazo_contractual_proceso_seleccion_item').val(response.fecha_inicio_plazo_contractual);

		$('#total_dias_ampliacion_plazo_contrato_proceso_seleccion_item').val(response.total_dias_ampliacion_plazo);
		$('#total_adendas_contrato_proceso_seleccion_item').val(response.total_adendas);
		$('#monto_prestaciones_adicionales_contrato_proceso_seleccion_item').val(response.monto_prestaciones_adicionales);

		$('#observaciones_contrato_proceso_seleccion_obra').val(response.observaciones);

		document.ready = document.getElementById("liquidacion_contrato_proceso_seleccion_item").value = response.liquidacion;
			
	});

}

function selecciona_contrato(id_contrato_proceso_seleccion_item) {

	var opcionVar = "buscar";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;

	$.get('Contrato_proceso_seleccion_itemController', {

		opcion : opcionVar,
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar

	}, function(response) {
		
		$('#id_contrato_proceso_seleccion_item').val(response.id_contrato_proceso_seleccion_item);
		
		$('#numero_contrato_seleccion').val(response.numero_contrato);
		$('#contratista_seleccionado').val(response.contratista_adjudicado);
		$('#ruc_contratista_seleccionado').val(response.ruc_contratista);
		$('#fecha_adjudicacion_seleccionado').val(response.fecha_adjudicacion);
		$('#monto_adjudicado_seleccionado').val(response.monto_adjudicado);
		
		
		lista_acta(response.id_contrato_proceso_seleccion_item);
		lista_adendas(response.id_contrato_proceso_seleccion_item);
		lista_adicional(response.id_contrato_proceso_seleccion_item);
		lista_adelanto(response.id_contrato_proceso_seleccion_item);
		lista_ampliacion_plazo(response.id_contrato_proceso_seleccion_item);
		lista_valorizacion(response.id_contrato_proceso_seleccion_item);
		lista_defecto_constructivo(response.id_contrato_proceso_seleccion_item);
		lista_garantia(response.id_contrato_proceso_seleccion_item);
		lista_incidencia(response.id_contrato_proceso_seleccion_item);
		lista_otros_documentos(response.id_contrato_proceso_seleccion_item);
		lista_resolucion(response.id_contrato_proceso_seleccion_item);
		
		muestra_pestana_eventos();							
		
		$('#tabs_proyecto #pestana_eventos').tab('show');
		
		
	});

}

function ver_datos_contrato_proceso_seleccion_item(id_contrato_proceso_seleccion_item){
	
	limpiar_form_contrato_proceso_seleccion_item();
	
	cargar_datos_contrato_proceso_seleccion_item(id_contrato_proceso_seleccion_item);
	
	$('#numero_contrato_proceso_seleccion_item').attr('readonly',true);
	$('#contratista_adjudicado_contrato_proceso_seleccion_item').attr('readonly',true);
	$('#ruc_contratista_contrato_proceso_seleccion_item').attr('readonly',true);
	$('#fecha_adjudicacion_contrato_proceso_seleccion_item').attr('disabled',true);
	$('#fecha_firma_contrato_proceso_seleccion_item').attr('disabled',true);
	
	$('#monto_adjudicado_contrato_proceso_seleccion_item').attr('readonly',true);
	$('#monto_pagado_contrato_proceso_seleccion_item').attr('readonly',true);
		
	$('#porcentaje_pagado_contrato_proceso_seleccion_item').attr('readonly',true);

	$('#fecha_entrega_terreno_contrato_proceso_seleccion_item').attr('disabled',true);
	$('#plazo_ejecucion_contrato_proceso_seleccion_item').attr('readonly',true);
	$('#fecha_inicio_plazo_contractual_proceso_seleccion_item').attr('disabled',true);

	$('#total_dias_ampliacion_plazo_contrato_proceso_seleccion_item').attr('readonly',true);
	$('#total_adendas_contrato_proceso_seleccion_item').attr('readonly',true);
	$('#monto_prestaciones_adicionales_contrato_proceso_seleccion_item').attr('readonly',true);

	$('#observaciones_contrato_proceso_seleccion_obra').attr('readonly',true);
	$('#liquidacion_contrato_proceso_seleccion_item').attr('disabled',true);
	
	$('#btn_grabar_contrato_proceso_seleccion_item').hide();
		
}

function editar_datos_contrato_proceso_seleccion_item(id_contrato_proceso_seleccion_item,id_proceso_seleccion_item){
	
	limpiar_form_contrato_proceso_seleccion_item();
		
	cargar_datos_contrato_proceso_seleccion_item(id_contrato_proceso_seleccion_item);
	
	$('#id_proceso_seleccion_item').val(id_proceso_seleccion_item);
	
	$('#btn_grabar_contrato_proceso_seleccion_item').show();
	
	$('#id_contrato_proceso_seleccion_item').val(id_contrato_proceso_seleccion_item);
	
}

function calcular_porcentaje_pagado(){
	
	$('#porcentaje_pagado_contrato_proceso_seleccion_item').val('');
	
	var monto_adjudicado = ($('#monto_adjudicado_contrato_proceso_seleccion_item').val()*1);
	var monto_pagado = ($('#monto_pagado_contrato_proceso_seleccion_item').val()*1);
	var porcentaje_pagado = ((monto_pagado * 1)/(monto_adjudicado * 1)*100);
	
	if(monto_pagado <= monto_adjudicado){
		
		$('#porcentaje_pagado_contrato_proceso_seleccion_item').val(porcentaje_pagado.toFixed(2));
		$('#panel_mensaje_contrato_proceso_seleccion_item').html('');
		$('#btn_grabar_contrato_proceso_seleccion_item').show();
		
	}else{
	
		$('#panel_mensaje_contrato_proceso_seleccion_item').html('<div class="alert alert-danger" align="center" role="alert">El monto pagado no puede ser mayor que el monto adjudicado</div>');
		$('#btn_grabar_contrato_proceso_seleccion_item').hide();
	}
		
}
