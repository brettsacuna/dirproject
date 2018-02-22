//Función para iniciar elementos de la página
$(document).ready(function() {
	
	lista_proyectos();
	
	$('#fecha_resolucion_aprobacion_expediente_tecnico').datepicker({
		endDate : "0d"
	});
	$('#fecha_resolucion_aprobacion_valor_referencial').datepicker({
		endDate : "0d"
	});
	$('#fecha_resolucion_actualizacion_valor_referencial').datepicker({
		endDate : "0d"
	});
	$('#fecha_informe_tecnico_declaratoria_viabilidad').datepicker({
		endDate : "0d"
	});
	
	//convertir siempre a new date
	var fecha_inicio = new Date();
	var fecha_fin = new Date();
	
	//validador de fechas
	
	if (fecha_inicio.getTime() < fecha_fin.getTime()) {
		console.log("Cumple");
	} else {
		console.log("No cumple");
	}
	
	$('#presupuesto_viabilidad').numeric();
	$('#presupuesto_expediente_tecnico').numeric();
	$('#valor_referencial').numeric();
	$('#monto_componente_viable').numeric();
		
	$('#tabla_proyectos_snip').dataTable();

	$('#btn_actualizar').hide();
	$('#panel_item_proyecto').hide();
	$('#panel_componentes').hide();
	$('#panel_documentos_preinversion').hide();
	
	
	if($('#tipo_usuario').val() == "Usuario" ){
		
		$('#btn_guardar').hide();
		
	}else{
		
		$('#btn_guardar').show();
	}
		
});

$('#btn_guardar').click(function(event) {
	
	var codigo_snip = $('#codigo_snip').val();
	var codigo_proyecto = $('#codigo_proyecto').val();
	var nombre_pip =  $('#nombre_pip').val();
	
	if(codigo_snip == '' ||  codigo_proyecto == ''){
		
		$('#panel_mensaje').html('<div class="alert alert-danger" align="center" role="alert">¡Los campos Código SNIP y Código de Proyecto no pueden estar vacios!</h5>');
		
	}else{
		guardar_proyecto();
	}
	
	
	

});

$('#btn_grabar_item_proyecto').click(function(event) {

	guardar_item_proyecto();	
	limpiar_form_item_proyecto();
	
});

$('#btn_agregar_item_proyecto').click(function(event) {

	$('#id_item_proyecto').val('');
	
});

$('#btn_agregar_componentes').click(function(event) {

	$('#id_componente').val('');
	
});

$('#btn_grabar_componentes').click(function(event) {

	guardar_componentes();	
	limpiar_form_componentes();
	
});

$('#btn_grabar_documento_preinversion').click(function(event) {

	guardar_documento_preinversion();	
	limpiar_form_documento_preinversion();
	
});

$('#btn_eliminar_objeto_preinversion').click(function(event){
	
	if($('#id_eliminar_objeto_preinversion').val() == 'componente'){
		
		elimina_componente($('#id_componente').val());		
	
	}else if($('#id_eliminar_objeto_preinversion').val() == 'datos_proyecto'){
		
		elimina_datos_proyecto($('#id_proyecto').val());
		
	}else if($('#id_eliminar_objeto_preinversion').val() == 'documento_preinversion'){
		
		elimina_datos_documento_preinversion($('#id_documento_preinversion').val());
		
	}else if($('#id_eliminar_objeto_preinversion').val() == 'item_proyecto'){
		
		elimina_item_proyecto($('#id_item_proyecto').val());
		
	}
		
	$('#id_objeto_eliminar_preinversion').val('');
	
});

$('#btn_cancelar_objeto_preinversion').click(function(event){
	
	$('#id_componente').val('');
	$('#id_item_proyecto').val('');
	$('#id_documento_preinversion').val('');
	$('#id_objeto_eliminar_preinversion').val('');
});

function limpiar() {

	$('#formulario_registro_proyecto').trigger("reset");

	$('#codigo_snip').val('');
	$('#codigo_proyecto').val('');
	$('#nombre_pip').val('');

	$('#presupuesto_viabilidad').val('');
	$('#consultor_preinversion').val('');
	$('#consultor_expediente_tecnico').val('')
	$('#resolucion_aprobacion_expediente_tecnico').val('');
	$('#fecha_resolucion_aprobacion_expediente_tecnico').val('');

	$('#resolucion_aprobacion_valor_referencial').val('');
	$('#fecha_resolucion_aprobacion_valor_referencial').val('');
	$('#resolucion_actualizacion_valor_referencial').val('');
	$('#fecha_resolucion_actualizacion_valor_referencial').val('');
	$('#informe_tecnico_declaratoria_viabilidad').val('');
	$('#fecha_informe_tecnico_declaratoria_viabilidad').val('');
	$('#beneficiarios_directos').val('');

	$('#panel_mensaje').html('');
	
	$('#id_proyecto').val('');
	$('#id_item_proyecto').val('');
	$('#id_componente').val('');	
	
	$('#btn_guardar').show();
	$('#panel_item_proyecto').hide();
	$('#panel_componentes').hide();
	$('#panel_documentos_preinversion').hide();
	
	habilita_controles_datos_proyecto();

}

function limpiar_form_item_proyecto() {

	$('#formulario_item_proyecto').trigger("reset");
	$('#panel_mensaje_item_proyecto').html('');

	$('#id_item_proyecto').val('');	
	
	habilita_controles_item_proyecto();
	

}

function limpiar_form_componentes(){
	
	$('#formulario_componentes').trigger("reset");
		
	$('#monto_componente_viable').attr('disabled',false);
	$('#observacion_componente').attr('disabled',false);
	$('#id_tipo_componente').attr('disabled',false);
	
	$('#panel_mensaje_componentes').html('');
	
	$('#id_componente').val('');	
		
	$('#btn_grabar_componentes').show();
	
}

function limpiar_form_documento_preinversion(){
	
	$('#formulario_documento_preinversion').trigger("reset");
	
	$('#id_tipo_documento_preinversion').attr('disabled',false);
	$('#documento_preinversion').attr('disabled',false);
	
	$('#panel_mensaje_documento_preinversion').html('');
	
	$('#id_documento_preinversion').val('');	
		
	$('#btn_grabar_documento_preinversion').show();
	
}

function inhabilita_controles_item_proyecto(){
	
	$('#ubicacion').attr('readonly',true);
	$('#etapa_proyecto').attr('disabled',true);
	$('#estado_proyecto').attr('disabled',true);
	$('#presupuesto_expediente_tecnico').attr('readonly',true);
	$('#valor_referencial').attr('readonly',true);
	
	$('#btn_grabar_item_proyecto').hide();
	
}

function habilita_controles_item_proyecto(){
	
	$('#ubicacion').attr('readonly',false);
	$('#etapa_proyecto').attr('disabled',false);
	$('#estado_proyecto').attr('disabled',false);
	$('#presupuesto_expediente_tecnico').attr('readonly',false);
	$('#valor_referencial').attr('readonly',false);
	
	$('#btn_grabar_item_proyecto').show();
	
}

function inhabilita_controles_datos_proyecto(){
	
	$('#codigo_snip').attr('disabled',true);
	$('#codigo_proyecto').attr('disabled',true);
	$('#nombre_pip').attr('disabled',true);
	
	$('#presupuesto_viabilidad').attr('disabled',true);
	$('#consultor_preinversion').attr('disabled',true);
	$('#consultor_expediente_tecnico').attr('disabled',true);
	$('#resolucion_aprobacion_expediente_tecnico').attr('disabled',true);
	$('#fecha_resolucion_aprobacion_expediente_tecnico').attr('disabled',true);
	
	$('#resolucion_aprobacion_valor_referencial').attr('disabled',true);
	$('#fecha_resolucion_aprobacion_valor_referencial').attr('disabled',true);
	$('#resolucion_actualizacion_valor_referencial').attr('disabled',true);
	$('#fecha_resolucion_actualizacion_valor_referencial').attr('disabled',true);
	$('#informe_tecnico_declaratoria_viabilidad').attr('disabled',true);
	$('#fecha_informe_tecnico_declaratoria_viabilidad').attr('disabled',true);
	$('#beneficiarios_directos').attr('disabled',true);
	
}

function habilita_controles_datos_proyecto(){
	
	$('#codigo_snip').attr('disabled',false);
	$('#codigo_proyecto').attr('disabled',false);
	$('#nombre_pip').attr('disabled',false);

	$('#presupuesto_viabilidad').attr('disabled',false);
	$('#consultor_preinversion').attr('disabled',false);
	$('#consultor_expediente_tecnico').attr('disabled',false);
	$('#resolucion_aprobacion_expediente_tecnico').attr('disabled',false);
	$('#fecha_resolucion_aprobacion_expediente_tecnico').attr('disabled',false);

	$('#resolucion_aprobacion_valor_referencial').attr('disabled',false);
	$('#fecha_resolucion_aprobacion_valor_referencial').attr('disabled',false);
	$('#resolucion_actualizacion_valor_referencial').attr('disabled',false);
	$('#fecha_resolucion_actualizacion_valor_referencial').attr('disabled',false);
	$('#informe_tecnico_declaratoria_viabilidad').attr('disabled',false);
	$('#fecha_informe_tecnico_declaratoria_viabilidad').attr('disabled',false);
	$('#beneficiarios_directos').attr('disabled',false);
	
}

$('#btn_nuevo').click(function(event) {

	limpiar();
	
	if($('#tipo_usuario').val() == "Usuario" ){
		
		$('#btn_guardar').attr('disabled',true);
		
	}else if($('#tipo_usuario').val() == "Administrador" || $('#tipo_usuario').val() == "Operador"){
		
		$('#btn_guardar').attr('disabled',false);
	}
	
});

//funcion para convertir fechas en ingles a español.

 
 function formatear_fecha(date) {
    return `${date.split('/')[2]}-${date.split('/')[1]}-${date.split('/')[0]}`;
} 
  

