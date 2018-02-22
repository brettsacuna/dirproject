function guardar_proyecto() {

	var opcionVar = "guardar";

	var id_proyectoVar = $('#id_proyecto').val();

	if (id_proyectoVar == '') {

		operacionVar = 'registrar'

	} else {

		operacionVar = 'actualizar'

	}

	var codigo_snipVar = $('#codigo_snip').val();
	var codigo_proyectoVar = $('#codigo_proyecto').val();
	var nombre_pipVar = $('#nombre_pip').val();
	
	var presupuesto_viabilidadVar = $('#presupuesto_viabilidad').val();
	var consultor_preinversionVar = $('#consultor_preinversion').val();
	var consultor_expediente_tecnicoVar = $('#consultor_expediente_tecnico').val();
	var resolucion_aprobacion_expediente_tecnicoVar = $('#resolucion_aprobacion_expediente_tecnico').val();
	
	var fecha_resolucion_aprobacion_expediente_tecnicoVar = $('#fecha_resolucion_aprobacion_expediente_tecnico').val();	
	var resolucion_aprobacion_valor_referencialVar = $('#resolucion_aprobacion_valor_referencial').val();
	var fecha_resolucion_aprobacion_valor_referencialVar = $('#fecha_resolucion_aprobacion_valor_referencial').val();
	
	var resolucion_actualizacion_valor_referencialVar = $('#resolucion_actualizacion_valor_referencial').val();
	var fecha_resolucion_actualizacion_valor_referencialVar = $('#fecha_resolucion_actualizacion_valor_referencial').val();
	
	var informe_tecnico_declaratoria_viabilidadVar = $('#informe_tecnico_declaratoria_viabilidad').val();
	var fecha_informe_tecnico_declaratoria_viabilidadVar = $('#fecha_informe_tecnico_declaratoria_viabilidad').val();
	var beneficiarios_directosVar = $('#beneficiarios_directos').val();
	var usuarioVar = $('#usuario').val();
	
	var fecha_fecha_resolucion_aprobacion_expediente_tecnicoVar = new Date(formatear_fecha(fecha_resolucion_aprobacion_expediente_tecnicoVar));
	var fecha_fecha_resolucion_aprobacion_valor_referencialVar = new Date(formatear_fecha(fecha_resolucion_aprobacion_valor_referencialVar));
	var fecha_fecha_resolucion_actualizacion_valor_referencialVar = new Date(formatear_fecha(fecha_resolucion_actualizacion_valor_referencialVar));
	
	if (fecha_fecha_resolucion_aprobacion_expediente_tecnicoVar.getTime() <= fecha_fecha_resolucion_aprobacion_valor_referencialVar.getTime() && fecha_fecha_resolucion_aprobacion_valor_referencialVar.getTime() <= fecha_fecha_resolucion_actualizacion_valor_referencialVar.getTime()) {
		$.post('Datos_proyectoController',
				{

					opcion : opcionVar,
					operacion : operacionVar,

					id_proyecto : id_proyectoVar,
					codigo_snip : codigo_snipVar,
					codigo_proyecto : codigo_proyectoVar,
					nombre_pip : nombre_pipVar,
		
					presupuesto_viabilidad : presupuesto_viabilidadVar,
					consultor_preinversion : consultor_preinversionVar,
					consultor_expediente_tecnico : consultor_expediente_tecnicoVar,
					resolucion_aprobacion_expediente_tecnico : resolucion_aprobacion_expediente_tecnicoVar,
					fecha_resolucion_aprobacion_expediente_tecnico : fecha_resolucion_aprobacion_expediente_tecnicoVar,
	
					resolucion_aprobacion_valor_referencial : resolucion_aprobacion_valor_referencialVar,
					fecha_resolucion_aprobacion_valor_referencial : fecha_resolucion_aprobacion_valor_referencialVar,
					resolucion_actualizacion_valor_referencial : resolucion_actualizacion_valor_referencialVar,
					fecha_resolucion_actualizacion_valor_referencial : fecha_resolucion_actualizacion_valor_referencialVar,
					informe_tecnico_declaratoria_viabilidad : informe_tecnico_declaratoria_viabilidadVar,
					fecha_informe_tecnico_declaratoria_viabilidad : fecha_informe_tecnico_declaratoria_viabilidadVar,
					beneficiarios_directos : beneficiarios_directosVar,
					usuario : usuarioVar

				},
				function(response) {

					if (response == 1) {
						
						$('#panel_mensaje').html('<div class="alert alert-success" align="center" role="alert">¡Proyecto guardado con éxito!</h5>');
						//limpiar();
						lista_proyectos();
					} else if (response == 0) {
						
						$('#panel_mensaje').html('<div class="alert alert-warning" align="center" role="alert">¡El código de proyecto '+ codigo_proyectoVar+ ' ya existe!</h5>');

					} else if (response == 2) {
						
						$('#panel_mensaje').html('<div class="alert alert-warning" align="center" role="alert">¡El código SNIP '	+ codigo_snipVar+ ' ya existe!</h5>');
					}

				});
	} else {
		
		$('#panel_mensaje').html('<div class="alert alert-danger" align="center" role="alert">¡Revise las fechas por favor!</h5>');
		
	}

}

function lista_proyectos(){
	
	var opcionVar = "listar_proyectos";
			
	$.get('Datos_proyectoController', {
		
		opcion : opcionVar		
		
	},function(response){
			
			$('#lista_general_proyectos').empty();
			
			var body = "";
			
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, proyecto){
				
				if(usuario == proyecto.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${proyecto.codigo_snip}</td>
							<td class="text-center">${proyecto.codigo_proyecto}</td>
							<td class="text-left">${proyecto.nombre_pip}</td>																	
							<td class="text-center"><button type="button"  class="btn btn-primary"  onclick="ver_datos(${proyecto.codigo_snip})"><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button"  class="btn btn-default" onclick="editar_datos(${proyecto.codigo_snip})"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button"  class="btn btn-danger" onclick="carga_datos_proyecto_eliminar(${proyecto.id_proyecto})" data-toggle="modal" data-target="#modal_confirma_eliminar_preinversion"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
						
						`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${proyecto.codigo_snip}</td>
							<td class="text-center">${proyecto.codigo_proyecto}</td>
							<td class="text-left">${proyecto.nombre_pip}</td>																	
							<td class="text-center"><button type="button"  class="btn btn-primary"  onclick="ver_datos(${proyecto.codigo_snip})"><i class="glyphicon glyphicon-eye-open"></i></button> 
													
							</td>
					    </tr>						
						
						`;
									
				}
														
			});
			
			$('#lista_general_proyectos').html(body);
			$('#tabla_proyectos').dataTable();			
						
	});
	
}

function carga_datos_proyecto_eliminar(id_proyecto){
	
	$('#id_proyecto').val(id_proyecto);
	$('#id_eliminar_objeto_preinversion').val('datos_proyecto');
	$('#panel_mensaje_confirma_preinversion').html('<h5>¿Confirma eliminar el proyecto seleccionado?</h5>');
}

function elimina_datos_proyecto(id_proyecto){
		
		var opcionVar = 'eliminar';
	
		$.post('Datos_proyectoController',{
			
			opcion: opcionVar,
			id_proyecto : id_proyecto
			
		},function(response){
			
			if(response == 1){
				
				lista_proyectos();
				$('#id_proyecto').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function cargar_datos(codigo_snip,opcion_btn) {

	var opcionVar = "buscar";
	var codigo_snipVar = codigo_snip;

	$.post('Datos_proyectoController', {

		opcion : opcionVar,
		codigo_snip : codigo_snipVar

	}, function(response) {
		
		limpiar();

		$('#id_proyecto').val(response.id_proyecto);

		$('#codigo_snip').val(response.codigo_snip);
		$('#codigo_proyecto').val(response.codigo_proyecto);
		$('#nombre_pip').val(response.nombre_pip);

		$('#presupuesto_viabilidad').val(response.presupuesto_viabilidad);
		$('#consultor_preinversion').val(response.consultor_preinversion);
		$('#consultor_expediente_tecnico').val(response.consultor_expediente_tecnico);
		$('#resolucion_aprobacion_expediente_tecnico').val(response.resolucion_aprobacion_expediente_tecnico);
		$('#fecha_resolucion_aprobacion_expediente_tecnico').val(response.fecha_resolucion_aprobacion_expediente_tecnico);
	
		$('#resolucion_aprobacion_valor_referencial').val(response.resolucion_aprobacion_valor_referencial);
		$('#fecha_resolucion_aprobacion_valor_referencial').val(response.fecha_resolucion_aprobacion_valor_referencial);
		$('#resolucion_actualizacion_valor_referencial').val(	response.resolucion_actualizacion_valor_referencial);
		$('#fecha_resolucion_actualizacion_valor_referencial').val(	response.fecha_resolucion_actualizacion_valor_referencial);
		$('#informe_tecnico_declaratoria_viabilidad').val(response.informe_tecnico_declaratoria_viabilidad);
		$('#fecha_informe_tecnico_declaratoria_viabilidad').val(response.fecha_informe_tecnico_declaratoria_viabilidad);
		$('#beneficiarios_directos').val(response.beneficiarios_directos);

		lista_item_proyecto(response.id_proyecto,opcion_btn);
		lista_componentes(response.id_proyecto,opcion_btn);
		lista_documentos_preinversion(response.id_proyecto,opcion_btn);
				
		$('#panel_item_proyecto').show();
		$('#panel_componentes').show();
		$('#panel_documentos_preinversion').show();
		
	});
	
}

function ver_datos(codigo_snip) {
			
	cargar_datos(codigo_snip,"hide");

	inhabilita_controles_datos_proyecto();
	
	$('#tabs_proyecto a:first').tab('show');
	
	$('#id_item_proyecto').val('');
	
	$('#btn_guardar').attr('disabled',true);
	
	$('#btn_agregar_item_proyecto').hide();
	$('#btn_agregar_componentes').hide();
	$('#btn_agregar_documento_preinversion').hide();
	
}

function editar_datos(codigo_snip) {

	$('#tabs_proyecto a:first').tab('show');

	cargar_datos(codigo_snip,"show");
	
	habilita_controles_datos_proyecto();

	$('#id_item_proyecto').val('');
	
	$('#btn_guardar').attr('disabled',false);
	
	$('#btn_agregar_item_proyecto').show();
	$('#btn_agregar_componentes').show();
	$('#btn_agregar_documento_preinversion').show();
	

}
