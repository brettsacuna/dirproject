//Inicializa elementos del formulario

$(document).ready(function(){
	
	oculta_pestana_eventos();
	oculta_paneles();
	
	inhabilita_controles_contrato_seleccion();
	
	$('#panel_tabs').hide();
	
	$('#fecha_valor_referencial').datepicker({
		endDate : "0d"
	});
	$('#fecha_valor_referencial_proceso_seleccion_item').datepicker({
		endDate : "0d"
	});
	$('#fecha_informe_tecnico_etapa_inversion').datepicker({
		endDate : "0d"
	});
	$('#fecha_presupuesto_base').datepicker({
		endDate : "0d"
	});
	$('#fecha_firma_contrato_expediente_tecnico').datepicker({
		endDate : "0d"
	});
	$('#fecha_otorgamiento').datepicker({
		endDate : "0d"
	});
	$('#fecha_adjudicacion_contrato_proceso_seleccion_item').datepicker({
		endDate : "0d"
	});
	$('#fecha_firma_contrato_proceso_seleccion_item').datepicker({
		endDate : "0d"
	});
	$('#fecha_entrega_terreno_contrato_proceso_seleccion_item').datepicker({
		endDate : "0d"
	});
	$('#fecha_inicio_plazo_contrato_proceso_seleccion_item').datepicker();
	$('#fecha_suscripcion_adenda').datepicker({
		endDate : "0d"
	});
	$('#fecha_resolucion_aprobacion_adicional').datepicker({
		endDate : "0d"
	});
	$('#fecha_solicitud_adelanto').datepicker({
		endDate : "0d"
	});
	$('#fecha_resolucion_aprobacion_ampliacion_plazo').datepicker({
		endDate : "0d"
	});
	$('#fecha_encontrado').datepicker({
		endDate : "0d"
	});
	$('#periodo').datepicker();
	$('#fecha_acta').datepicker({
		endDate : "0d"
	});
	$('#fecha_factura').datepicker({
		endDate : "0d"
	});
	$('#fecha_creacion').datepicker();
	$('#fecha_vencimiento').datepicker();
	$('#fecha_evento').datepicker({
		endDate : "0d"
	});
	$('#fecha_resolucion').datepicker({
		endDate : "0d"
	});
	$('#fecha_informe_otros_documentos').datepicker({
		endDate : "0d"
	});
			
	$('#tabla_proyectos').dataTable();
	
	$('#plazo_ejecucion_expediente_tecnico').numeric();
	$('#plazo_ejecucion').numeric();
	$('#plazo_ejecucion_proceso_seleccion_item').numeric();
	$('#plazo_ejecucion_contrato_proceso_seleccion_item').numeric();
	$('#plazo_otorgado_adenda').numeric();
	$('#plazo_otorgado_ampliacion_plazo').numeric();
		
	$('#monto_informe_tecnico_etapa_inversion').numeric();
	$('#valor_referencial_expediente_tecnico').numeric();
	$('#monto_adjudicado_expediente_tecnico').numeric();
	
	$('#valor_referencial_proceso_seleccion').numeric();
	
	$('#valor_referencial_proceso_seleccion_item').numeric();
	
	$('#monto_adjudicado_contrato_proceso_seleccion_item').numeric();
	$('#monto_pagado_contrato_proceso_seleccion_item').numeric();
	$('#porcentaje_pagado_contrato_proceso_seleccion_item').numeric();
	$('#total_dias_ampliacion_plazo_contrato_proceso_seleccion_item').numeric();
	$('#total_adendas_contrato_proceso_seleccion_item').numeric();
	$('#monto_prestaciones_adicionales_contrato_proceso_seleccion_item').numeric();
	
	$('#monto_adelanto').numeric();
	
	$('#monto_adicional_otorgado').numeric();
	
	$('#valorizacion_programada').numeric();
	$('#valorizacion_ejecutada').numeric();
	$('#valorizacion_acumulada').numeric();
	$('#porcentaje_valorizado_acumulado').numeric();
	
	$('#monto_adelanto_garantia').numeric();
	$('#monto_carta_fianza').numeric();
	
	
	if($('#tipo_usuario').val() == "Usuario" ){
		
		$('#btn_agregar_expediente').hide();
		$('#btn_agregar_proceso_seleccion').hide();
		$('#btn_agregar_adenda').hide();
		$('#btn_agregar_adicional').hide();
		$('#btn_agregar_adelanto').hide();
		$('#btn_agregar_ampliacion_plazo').hide();
		$('#btn_agregar_valorizacion').hide();
		$('#btn_agregar_defecto_constructivo').hide();
		$('#btn_agregar_acta').hide();
		$('#btn_agregar_garantia').hide();
		$('#btn_agregar_incidencia').hide();
		$('#btn_agregar_resolucion').hide();
		$('#btn_agregar_otros_documentos').hide();
		
	}else{
		
		$('#btn_agregar_expediente').show();
		$('#btn_agregar_proceso_seleccion').show();
		$('#btn_agregar_adenda').show();
		$('#btn_agregar_adicional').show();
		$('#btn_agregar_adelanto').show();
		$('#btn_agregar_ampliacion_plazo').show();
		$('#btn_agregar_valorizacion').show();
		$('#btn_agregar_defecto_constructivo').show();
		$('#btn_agregar_acta').show();
		$('#btn_agregar_garantia').show();
		$('#btn_agregar_incidencia').show();		
		$('#btn_agregar_resolucion').show();
		$('#btn_agregar_otros_documentos').show();
		
	}
	
	$('#div_valorizacion_acumulada').hide();
	$('#div_porcentaje_valorizacion_acumulada').hide();
			
});

$('#btn_agregar_proceso_seleccion').click(function(event){
	
	$('#id_proceso_seleccion').val('');
	
});

$('#btn_grabar_proceso_seleccion').click(function(event) {

	guardar_proceso_seleccion();
	limpiar_form_proceso_seleccion();

});

$('#btn_grabar_contrato_proceso_seleccion_item').click(function(event){
	
	guardar_contrato_proceso_seleccion_item();
	limpiar_form_contrato_proceso_seleccion_item();
	
});

$('#btn_grabar_proceso_seleccion_item').click(function(event) {

	guardar_proceso_seleccion_item();
	limpiar_form_proceso_seleccion_item();

});

$('#btn_grabar_expediente_tecnico').click(function(event) {

	guardar_expediente_tecnico();
	limpiar_form_expediente_tecnico();

});

$('#btn_grabar_adenda').click(function(event) {

	guardar_adenda();
	limpiar_form_adenda();

});

$('#btn_grabar_adicional').click(function(event) {

	guardar_adicional();
	limpiar_form_adicional();

});

$('#btn_grabar_adelanto').click(function(event) {

	guardar_adelanto();
	limpiar_form_adelanto();

});

$('#btn_grabar_ampliacion_plazo').click(function(event) {

	guardar_ampliacion_plazo();
	limpiar_form_ampliacion_plazo();

});

$('#btn_grabar_valorizacion').click(function(event) {

	guardar_valorizacion();
	limpiar_form_valorizacion();

});

$('#btn_grabar_defecto_constructivo').click(function(event) {

	guardar_defecto_constructivo();
	limpiar_form_defecto_constructivo();

});

$('#btn_grabar_acta').click(function(event) {

	guardar_acta();
	limpiar_form_acta();

});

$('#btn_grabar_garantia').click(function(event) {

	guardar_garantia();
	limpiar_form_garantia();

});

$('#btn_grabar_incidencia').click(function(event) {

	guardar_incidencia();
	limpiar_form_incidencia();

});

$('#btn_grabar_resolucion').click(function(event) {

	guardar_resolucion();
	limpiar_form_resolucion();

});

$('#btn_grabar_otros_documentos').click(function(event) {

	guardar_otros_documentos();
	limpiar_form_otros_documentos();

});


$('#btn_eliminar_objeto').click(function(event){
	
	if($('#id_eliminar_objeto').val() == 'acta'){
		
		elimina_acta($('#id_acta').val());
		
	}else if($('#id_eliminar_objeto').val() == 'adelanto'){
		
		elimina_adelanto($('#id_adelanto').val());
		
	}else if($('#id_eliminar_objeto').val() == 'adenda'){
		
		elimina_adenda($('#id_adenda').val());
		
	} else if($('#id_eliminar_objeto').val() == 'adicional'){
		
		elimina_adicional($('#id_adicional').val());
	
	}else if($('#id_eliminar_objeto').val() == 'ampliacion_plazo'){
		
		elimina_ampliacion_plazo($('#id_ampliacion_plazo').val());
		
	}else if($('#id_eliminar_objeto').val() == 'contrato_proceso_seleccion_item'){
		
		elimina_contrato($('#id_contrato_proceso_seleccion_item').val());
		
	}else if($('#id_eliminar_objeto').val() == 'defecto_constructivo'){
		
		elimina_defecto_constructivo($('#id_defecto_constructivo').val());
		
	}else if($('#id_eliminar_objeto').val() == 'expediente_tecnico'){
		
		elimina_expediente_tecnico($('#id_expediente_tecnico').val());
		
	}else if($('#id_eliminar_objeto').val() == 'garantia'){
		
		elimina_garantia($('#id_garantia').val());
		
	}else if($('#id_eliminar_objeto').val() == 'incidencia'){
		
		elimina_incidencia($('#id_incidencia').val());
		
	}else if($('#id_eliminar_objeto').val() == 'otro_documento'){
		
		elimina_otro_documento($('#id_otro_documento').val());
		
	}else if($('#id_eliminar_objeto').val() == 'proceso_seleccion_item'){
		
		elimina_proceso_seleccion_item($('#id_proceso_seleccion_item').val());
		
	}else if($('#id_eliminar_objeto').val() == 'proceso_seleccion'){
		
		elimina_proceso_seleccion($('#id_proceso_seleccion').val());
		
	}else if($('#id_eliminar_objeto').val() == 'resolucion'){
		
		elimina_resolucion($('#id_resolucion').val());
		
	}else if($('#id_eliminar_objeto').val() == 'valorizacion'){
		
		elimina_valorizacion($('#id_valorizacion').val());
		
	}
				
	$('#id_objeto_eliminar').val('');
	
});

$('#btn_cancelar_objeto').click(function(event){
	
	$('#id_acta').val('');
	$('#id_adelanto').val('');
	$('#id_adicional').val('');
	$('#id_defecto_constructivo').val('');
	$('#id_ampliacion_plazo').val('');	
	$('#id_expediente_tecnico').val('');
	$('#id_garantia').val('');
	$('#id_incidencia').val('');
	$('#id_otro_documento').val('');
	
	$('#id_proceso_seleccion').val('');
	$('#id_proceso_seleccion_item').val('');
	$('#id_contrato_proceso_seleccion_item').val('');
		
	$('#id_resolucion').val('');
	$('#id_valorizacion').val('');
	
	$('#id_objeto_eliminar').val('');
	
});


function cargar_datos_proyecto(codigo_snip) {

	var opcionVar = "buscar";
	var codigo_snipVar = codigo_snip;

	$.post('Datos_proyectoController', {

		opcion : opcionVar,
		codigo_snip : codigo_snipVar

	}, function(response) {
		
		var estado_proyecto = "";
		
		switch (response.estado_proyecto) {
														
	}


		$('#id_proyecto').val(response.id_proyecto);

		$('#codigo_snip').val(response.codigo_snip);
		$('#codigo_proyecto').val(response.codigo_proyecto);
		$('#nombre_pip').val(response.nombre_pip);
		$('#estado_proyecto').val(estado_proyecto);			
		$('#consultor_preinversion').val(response.consultor_preinversion);
		$('#valor_referencial').val(response.valor_referencial);
		
		lista_proceso_seleccion(response.id_proyecto);	
		lista_expediente_tecnico(response.id_proyecto);
		lista_item_descripcion_proyecto(response.id_proyecto);
		lista_item_proyecto_item(response.id_proyecto);
		
		mostrar_paneles();
		
	});

}


function selecciona_proyecto(codigo_snip) {
	
	cargar_datos_proyecto(codigo_snip);
	$('#panel_detalle_proyecto').show();
	$('#panel_tabs').show();
	
		
}

function oculta_pestana_eventos(){
	
	$('#pestana_eventos').hide();
		
}

function muestra_pestana_eventos(){
	
	$('#pestana_eventos').show();
		
}

function oculta_paneles(){
	
	$('#panel_expediente_tecnico').hide();
	$('#panel_componentes').hide();
	$('#panel_detalle_proyecto').hide();
}



function mostrar_paneles(){
	
	$('#panel_expediente_tecnico').show();
	$('#panel_componentes').show();
	$('#panel_detalle_proyecto').show();
}


function limpiar_form_expediente_tecnico(){
		
	$('#item_descripcion_proyecto').attr('disabled',false);
	$('#id_tipo_informe_tecnico').attr('readonly',false);
	$('#monto_informe_tecnico_etapa_inversion').attr('readonly',false); 
	$('#fecha_informe_tecnico_etapa_inversion').attr('disabled',false); 
	$('#numero_proceso_expediente_tecnico').attr('readonly',false);
	$('#valor_referencial_expediente_tecnico').attr('readonly',false);
	
	$('#modalidad_contratacion_expediente_tecnico').attr('disabled',false);
	
	$('#fecha_presupuesto_base').attr('disabled',false);
	$('#postores').attr('readonly',false); 
	$('#monto_adjudicado_expediente_tecnico').attr('readonly',false);
	$('#contratista_adjudicado_expediente_tecnico').attr('readonly',false); 
	$('#ruc_contratista_adjudicado_expediente_tecnico').attr('readonly',false); 
	$('#fecha_otorgamiento').attr('disabled',false); 
	$('#numero_contrato_expediente_tecnico').attr('readonly',false); 
	$('#fecha_firma_contrato_expediente_tecnico').attr('disabled',false); 
	$('#plazo_ejecucion_expediente_tecnico').attr('readonly',false);
		
	$('#tipo_ejecucion_expediente_tecnico').attr('disabled',false);
	
	$('#observaciones_expediente_tecnico').attr('readonly',false);
	
	$('#btn_grabar_expediente_tecnico').show();
	$('#panel_mensaje_expediente_tecnico').html('');
	
	$('#formulario_expediente_tecnico').trigger('reset');
	
	$('#id_expediente_tecnico').val('');
}

function limpiar_form_proceso_seleccion(){
		
	$('#numero_proceso').attr('readonly',false);
	$('#valor_referencial_proceso_seleccion').attr('readonly',false);
	$('#fecha_valor_referencial').attr('disabled',false);
	$('#modalidad_contratacion').attr('disabled',false);
	$('#plazo_ejecucion').attr('readonly',false);
	
	$('#proceso_seleccion_pertenencia').attr('disabled',false);
	
	$('#btn_grabar_proceso_seleccion').show();	
	$('#panel_mensaje_proceso_seleccion').html('');
	
	$('#formulario_proceso_seleccion').trigger('reset');
	
	$('#id_proceso_seleccion').val('');
}

function limpiar_form_proceso_seleccion_item(){
			
	$('#item_descripcion').attr('readonly',false);
	$('#valor_referencial_proceso_seleccion_item').attr('readonly',false);
	$('#fecha_valor_referencial_proceso_seleccion_item').attr('disabled',false);
	$('#situacion').attr('disabled',false);
	$('#plazo_ejecucion_proceso_seleccion_item').attr('readonly',false);
	
	$('#btn_grabar_proceso_seleccion_item').show();
	$('#panel_mensaje_proceso_seleccion_item').html('');
	
	$('#formulario_proceso_seleccion_item').trigger('reset');
	
	$('#id_proceso_seleccion_item').val('');
}

function limpiar_form_contrato_proceso_seleccion_item(){
	
	$('#numero_contrato_proceso_seleccion_item').attr('readonly',false);
	$('#contratista_adjudicado_contrato_proceso_seleccion_item').attr('readonly',false);
	$('#ruc_contratista_contrato_proceso_seleccion_item').attr('readonly',false);
	$('#fecha_adjudicacion_contrato_proceso_seleccion_item').attr('disabled',false);
	$('#fecha_firma_contrato_proceso_seleccion_item').attr('disabled',false);
	
	$('#monto_adjudicado_contrato_proceso_seleccion_item').attr('readonly',false);
	$('#monto_pagado_contrato_proceso_seleccion_item').attr('readonly',false);
		
	$('#porcentaje_pagado_contrato_proceso_seleccion_item').attr('readonly',false);

	$('#fecha_entrega_terreno_contrato_proceso_seleccion_item').attr('disabled',false);
	$('#plazo_ejecucion_contrato_proceso_seleccion_item').attr('readonly',false);
	$('#fecha_inicio_plazo_contractual_proceso_seleccion_item').attr('disabled',false);

	$('#total_dias_ampliacion_plazo_contrato_proceso_seleccion_item').attr('readonly',false);
	$('#total_adendas_contrato_proceso_seleccion_item').attr('readonly',false);
	$('#monto_prestaciones_adicionales_contrato_proceso_seleccion_item').attr('readonly',false);

	$('#observaciones_contrato_proceso_seleccion_obra').attr('readonly',false);
	$('#liquidacion_contrato_proceso_seleccion_item').attr('disabled',false);	
	
	$('#btn_grabar_contrato_proceso_seleccion_item').show();
	
	$('#panel_mensaje_contrato_proceso_seleccion_item').html('');
	
	$('#formulario_contrato_proceso_seleccion_item').trigger('reset');
	
	$('#id_contrato_proceso_seleccion_item').val('');
}

function limpiar_form_adenda(){
	
	$('#formulario_adenda').trigger('reset');
	
	$('#id_adenda').attr('disabled',false);
	$('#adenda_descripcion').attr('disabled',false);
	$('#fecha_suscripcion_adenda').attr('disabled',false);
	$('#plazo_otorgado_adenda').attr('disabled',false);
	$('#motivo_generado_adenda').attr('disabled',false);
	
	$('#panel_mensaje_adenda').html('');
	
	$('#id_adenda').val('');
	
	$('#btn_grabar_adenda').show();
	
}

function limpiar_form_adicional(){
	
	$('#formulario_adicional').trigger('reset');
	
	$('#resolucion_aprobacion_adicional').attr('disabled',false);
	$('#fecha_resolucion_aprobacion_adicional').attr('disabled',false);
	$('#monto_adicional_otorgado').attr('disabled',false);
	$('#motivo_generado_adicional').attr('disabled',false);
	
	$('#panel_mensaje_adicional').html('');
	
	$('#id_adicional').val('');
	
	$('#btn_grabar_adicional').show();
}

function limpiar_form_adelanto(){
	
	$('#formulario_adelanto').trigger('reset');
	
	$('#adelanto_descipcion').attr('disabled',false);
	$('#fecha_solicitud_adelanto').attr('disabled',false);
	$('#tipo_adelanto').attr('disabled',false);
	$('#monto_adelanto').attr('disabled',false);
	
	$('#panel_mensaje_adelanto').html('');
	
	$('#id_adelanto').val('');
	
	$('#btn_grabar_adelanto').show();
	
}

function limpiar_form_ampliacion_plazo(){
	
	$('#formulario_ampliacion_plazo').trigger('reset');
	
	$('#resolucion_aprobacion_ampliacion_plazo').attr('disabled',false);
	$('#fecha_resolucion_aprobacion_ampliacion_plazo').attr('disabled',false);
	$('#plazo_otorgado_ampliacion_plazo').attr('disabled',false);
	$('#motivo_generado_ampliacion_plazo').attr('disabled',false);
	
	$('#panel_mensaje_ampliacion_plazo').html('');
	
	$('#id_ampliacion_plazo').val('');
	
	$('#btn_grabar_ampliacion_plazo').show();
	
}

function limpiar_form_valorizacion(){
	
	$('#formulario_valorizacion').trigger('reset');
	
	$('#periodo').attr('disabled',false);
	$('#valorizacion_programada').attr('disabled',false);
	$('#valorizacion_ejecutada').attr('disabled',false);
	$('#valorizacion_acumulada').attr('disabled',false);
	$('#porcentaje_valorizado_acumulado').attr('disabled',false);
	
	$('#panel_mensaje_valorizacion').html('');
	
	$('#id_valorizacion').val('');
	
	$('#btn_grabar_valorizacion').show();
	
}

function limpiar_form_defecto_constructivo(){
	
	$('#formulario_defecto_constructivo').trigger('reset');
	
	$('#asiento_cuaderno_obra').attr('disabled',false);
	$('#defecto_constructivo_defecto').attr('disabled',false);
	$('#fecha_encontrado').attr('disabled',false);
	$('#estado_defecto').attr('disabled',false);
	$('#acciones').attr('disabled',false);
	
	$('#panel_mensaje_defecto_constructivo').html('');
	
	$('#id_defecto_constructivo').val('');
	
	$('#btn_grabar_defecto_constructivo').show();
	
}

function limpiar_form_acta(){
	
	$('#formulario_acta').trigger('reset');
	
	$('#acta_descripcion').attr('disabled',false);
	$('#fecha_acta').attr('disabled',false);
	$('#detalle_acta').attr('disabled',false);
	$('#motivo_generado_acta').attr('disabled',false);
	
	$('#panel_mensaje_acta').html('');
	
	$('#id_acta').val('');
	
	$('#btn_grabar_acta').show();
	
	
}

function limpiar_form_garantia(){
	
	$('#formulario_garantia').trigger('reset');
	
	$('#descripcion_garantia').attr('disabled',false);
	$('#factura').attr('disabled',false);
	$('#fecha_factura').attr('disabled',false);
	
	$("#tipo_garantia").attr('disabled',false); 
	
	$('#institucion_financiera').attr('disabled',false);
	$('#numero_documento_garantia').attr('disabled',false);
	$('#monto_adelanto_garantia').attr('disabled',false);
	$('#monto_carta_fianza').attr('disabled',false);
	$('#fecha_creacion').attr('disabled',false);
	$('#fecha_vencimiento').attr('disabled',false);
	
	$('#panel_mensaje_garantia').html('');
	
	$('#id_garantia').val('');
	
	$('#btn_grabar_garantia').show();
	
}

function limpiar_form_resolucion(){
	
	$('#formulario_resolucion').trigger('reset');
	
	$('#resolucion_conformacion_comite').attr('disabled',false);
	$('#fecha_resolucion').attr('disabled',false);
	$('#miembros').attr('disabled',false);
	$('#motivo_generado_resolucion').attr('disabled',false);
		
	$('#panel_mensaje_resolucion').html('');
	
	$('#id_resolucion').val('');
	
	$('#btn_grabar_resolucion').show();
	
	
}

function limpiar_form_incidencia(){
	
	$('#formulario_incidencia').trigger('reset');
	
	$('#detalle_incidencia').attr('disabled',false);
	$('#motivo_incidencia').attr('disabled',false);
	$('#asiento_cuaderno_obra_incidencia').attr('disabled',false);
	$('#fecha_evento').attr('disabled',false);
	$('#fecha_asiento').attr('disabled',false);
	$('#acciones_incidencia').attr('disabled',false);
	$('#documento_emitido').attr('disabled',false);
	$('#sumilla').attr('disabled',false);
	$('#objeto_incidencia').attr('disabled',false);
	
	$('#panel_mensaje_incidencia').html('');
	
	$('#id_incidencia').val('');
	
	$('#btn_grabar_incidencia').show();
	
}

function limpiar_form_otros_documentos(){
	
	$('#formulario_otros_documentos').trigger('reset');
	
	$('#informacion_especifica').attr('disabled',false);
	$('#fecha_informe_otros_documentos').attr('disabled',false);
	$('#detalle_otros_documentos').attr('disabled',false);
	$('#motivo_generado_otros_documentos').attr('disabled',false);
	
	$('#panel_mensaje_otros_documentos').html('');
	
	$('#id_otro_documento').val('');
	
	$('#btn_grabar_otros_documentos').show();
	
}

function replegar(){
	
	var id_proyecto = $('#id_proyecto').val();
	
	lista_proceso_seleccion(id_proyecto);
	
}

function inhabilita_controles_contrato_seleccion(){
	
	$('#numero_contrato_seleccion').attr('readonly',true);
	$('#contratista_seleccionado').attr('readonly',true);
	$('#ruc_contratista_seleccionado').attr('readonly',true);
	$('#monto_adjudicado_seleccionado').attr('readonly',true);
	$('#fecha_adjudicacion_seleccionado').attr('readonly',true);
	
}

