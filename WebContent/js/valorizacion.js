var meses = ["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"]

function dar_formato(fecha) {
	fecha = fecha.split("-");
	
	
	return `${meses[parseInt(fecha[1]) - 1]}-${fecha[0]}`;
}

function lista_valorizacion(id_contrato_proceso_seleccion_item, bandera = 0){
	
	var opcionVar = "listar_valorizacion";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
		
	$.get('ValorizacionController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
		bandera : bandera
		
	},function(response){
			
			$('#listado_valorizaciones').empty();
			
			var body = "";
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, valorizacion){
				
				if(usuario == valorizacion.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td class="text-center">${dar_formato(valorizacion.periodo)}</td>
							<td class="text-center">${valorizacion.valorizacion_programada}</td>
							<td class="text-center">${valorizacion.valorizacion_ejecutada}</td>
							<td class="text-center">${valorizacion.valorizacion_acumulada}</td>
							<td class="text-center">${valorizacion.porcentaje_valorizado_acumulado.toFixed(2)} %</td>																		
							<td class="text-center"><button type="button" id="btn_ver_valorizacion" class="btn btn-primary"  onclick="ver_datos_valorizacion(${valorizacion.id_valorizacion})" data-toggle="modal" data-target="#modal_valorizacion" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" id="btn_editar_valorizacion" class="btn btn-default" onclick="editar_datos_valorizacion(${valorizacion.id_valorizacion})" data-toggle="modal" data-target="#modal_valorizacion"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" id="btn_eliminar_valorizacion" class="btn btn-danger" onclick="carga_valorizacion_eliminar(${valorizacion.id_valorizacion})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
				`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="warning">					  
							<td class="text-center">${index+1}</td>
							<td class="text-center">${valorizacion.periodo}</td>
							<td class="text-center">${valorizacion.valorizacion_programada}</td>
							<td class="text-center">${valorizacion.valorizacion_ejecutada}</td>
							<td class="text-center">${valorizacion.valorizacion_acumulada}</td>
							<td class="text-center">${valorizacion.porcentaje_valorizado_acumulado} %</td>																		
							<td class="text-center">
													<button type="button" id="btn_ver_valorizacion" class="btn btn-primary"  onclick="ver_datos_valorizacion(${valorizacion.id_valorizacion})" data-toggle="modal" data-target="#modal_valorizacion" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													
							</td>
					    </tr>						
				`;
					
				}
														
			});
			
			$('#listado_valorizaciones').html(body);
						
	});
	
}


function carga_valorizacion_eliminar(id_valorizacion){
	
	$('#id_valorizacion').val(id_valorizacion);
	$('#id_eliminar_objeto').val('valorizacion');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar la valorizacion seleccionada?</strong>?</h5>');
}

function elimina_valorizacion(id_valorizacion){
		
		var opcionVar = 'eliminar';
	
		$.post('ValorizacionController',{
			
			opcion: opcionVar,
			id_valorizacion : id_valorizacion
			
		},function(response){
			
			if(response == 1){
				
				lista_valorizacion($('#id_contrato_proceso_seleccion_item').val());
				$('#id_valorizacion').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function recalcular() {
	
	lista_valorizacion($('#id_contrato_proceso_seleccion_item').val(), "1");

}

function guardar_valorizacion(){
	
	var opcionVar = "guardar";

	var id_valorizacionVar = $('#id_valorizacion').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_valorizacionVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var periodoVar = $('#periodo').val();
	var valorizacion_programadaVar = $('#valorizacion_programada').val();
	var valorizacion_ejecutadaVar = $('#valorizacion_ejecutada').val();
	var valorizacion_acumuladaVar = 0.0;
	var porcentaje_valorizado_acumuladoVar = 0.0;
	var observacionVar = $('#observacion_valorizacion').val();
	
	var usuarioVar = $('#usuario').val();
	
	$.post('ValorizacionController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_valorizacion : id_valorizacionVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						
						periodo : periodoVar,
						valorizacion_programada : valorizacion_programadaVar,
						valorizacion_ejecutada : valorizacion_ejecutadaVar,
						valorizacion_acumulada : valorizacion_acumuladaVar,
						porcentaje_valorizado_acumulado : porcentaje_valorizado_acumuladoVar,
						observacion: observacionVar,
						
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_valorizacion(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_valorizacion').html('<div class="alert alert-success" align="center" role="alert">Valorizacion grabada con éxito</div>');
							$('#btn_grabar_valorizacion').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_valorizacion').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_valorizacion(id_valorizacion) {

	var opcionVar = "buscar";
	var id_valorizacionVar = id_valorizacion;

	$.get('ValorizacionController', {

		opcion : opcionVar,
		id_valorizacion : id_valorizacionVar

	}, function(response) {
		
		$('#id_valorizacion').val(response.id_valorizacion);
		
		$('#periodo').val(response.periodo)
		$('#valorizacion_programada').val(response.valorizacion_programada);
		$('#valorizacion_ejecutada').val(response.valorizacion_ejecutada);
		$('#valorizacion_acumulada').val(response.valorizacion_acumulada);
		$('#porcentaje_valorizado_acumulado').val(response.porcentaje_valorizado_acumulado);
		$('#observacion_valorizacion').val(response.observacion);
		
	});

}

function ver_datos_valorizacion(id_valorizacion){
	
	limpiar_form_valorizacion();
	
	cargar_datos_valorizacion(id_valorizacion);

	$('#periodo').attr('disabled',true);
	$('#valorizacion_programada').attr('disabled',true);
	$('#valorizacion_ejecutada').attr('disabled',true);
	$('#valorizacion_acumulada').attr('disabled',true);
	$('#porcentaje_valorizado_acumulado').attr('disabled',true);
	
	$('#btn_grabar_valorizacion').hide();
	
}

function editar_datos_valorizacion(id_valorizacion){
	
	limpiar_form_valorizacion();
	
	cargar_datos_valorizacion(id_valorizacion);

	$('#periodo').attr('disabled',false);
	$('#valorizacion_programada').attr('disabled',false);
	$('#valorizacion_ejecutada').attr('disabled',false);
	$('#valorizacion_acumulada').attr('disabled',false);
	$('#porcentaje_valorizado_acumulado').attr('disabled',false);
	
	$('#btn_grabar_valorizacion').show();
	
};


