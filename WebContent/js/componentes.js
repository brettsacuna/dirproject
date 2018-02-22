function guardar_componentes() {

	var opcionVar = "guardar";

	var id_componenteVar = $('#id_componente').val();
	var id_proyectoVar = $('#id_proyecto').val();

	if (id_componenteVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var id_tipo_componenteVar = $('#id_tipo_componente').val();
	var componenteVar = $('#id_tipo_componente option:selected').text();
	var monto_componente_viableVar = $('#monto_componente_viable').val();
	var observacionVar = $('#observacion_componente').val();
		
	var usuarioVar = $('#usuario').val();

	$.post('ComponentesController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_componente : id_componenteVar,
						id_proyecto : id_proyectoVar,
						id_tipo_componente: id_tipo_componenteVar,
						
						componente : componenteVar,
						monto_componente_viable : monto_componente_viableVar,
						observacion: observacionVar,
						
						usuario : usuarioVar

					},
					
					function(response) {

						if (response == 1) {
							
							$('#panel_mensaje_componentes').html('<div class="alert alert-success" align="center" role="alert">¡Componente guardado con éxito!</h5>');
							lista_componentes(id_proyectoVar,'show');	
							$('#btn_grabar_componentes').hide();
							
						} else if (response == 0) {
							
							$('#panel_mensaje_componentes').html('<div class="alert alert-success" align="center" role="alert">¡Error!</h5>');

						} 

					});

}

function lista_componentes(id_proyecto,opcion_btn){
	
	var opcionVar = "listar_componentes";
	var id_proyectoVar = id_proyecto;
		
	$.get('ComponentesController', {
		
		opcion : opcionVar,		
		id_proyecto: id_proyectoVar
		
	},function(response){
			
			$('#listado_componentes').empty();
			$('#total_componentes').empty()
			
			var body = "";
			var tfood="";
			
			var total = 0.0;
							
			$.each(response, function(index, componente){
				
				var monto = componente.monto_componente_viable.toFixed(2);
				
				total = total + componente.monto_componente_viable;
				
				if(opcion_btn == "show"){
					
				body += `
						<tr class="success">
						  
							<td class="text-center">${index+1}</td>
							<td>${componente.componente}</td>
							<td class="text-center">${monto}</td>												
							<td class="text-center"><button type="button" class="btn btn-primary"  onclick="ver_datos_componentes(${componente.id_componente})" data-toggle="modal" data-target="#modal_componentes"><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" class="btn btn-default" onclick="editar_datos_componentes(${componente.id_componente})" data-toggle="modal" data-target="#modal_componentes"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" class="btn btn-danger" onclick="carga_componente_eliminar(${componente.id_componente})" data-toggle="modal" data-target="#modal_confirma_eliminar_preinversion"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					     
						</tr>
						
						`;
				
				}else if(opcion_btn == "hide"){
					
					body += `
						<tr class="success">
						  
							<td class="text-center">${index+1}</td>
							<td >${componente.componente}</td>	
							<td class="text-center">${monto}</td>											
							<td class="text-center"><button type="button" class="btn btn-primary"  onclick="ver_datos_componentes(${componente.id_componente})" data-toggle="modal" data-target="#modal_componentes"><i class="glyphicon glyphicon-eye-open"></i></button>
							</td>
					     
						</tr>
						
						`;				
				}
														
			});
			
			var tot = total.toFixed(2);
			
			tfood = `
				<tr class="active">
					<td colspan="2" class="text-center"><strong>Total (S/.) : </strong></td>
					<td class="text-center"><strong>${tot}</strong></td>
				</tr>
			`;
			
		
			
			$('#listado_componentes').html(body);
			$('#total_componentes').html(tfood)
						
	});
	
}

function carga_componente_eliminar(id_componente){
	
	$('#id_componente').val(id_componente);
	$('#id_eliminar_objeto_preinversion').val('componente');
	$('#panel_mensaje_confirma_preinversion').html('<h5>¿Confirma eliminar el componente seleccionado?</h5>');
}

function elimina_componente(id_componente){
		
		var opcionVar = 'eliminar';
	
		$.post('ComponentesController',{
			
			opcion: opcionVar,
			id_componente : id_componente
			
		},function(response){
			
			if(response == 1){
				
				lista_componentes($('#id_proyecto').val(),'show');
				$('#id_componente').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function cargar_datos_componentes(id_componente) {

	var opcionVar = "buscar";
	var id_componenteVar = id_componente;

	$.get('ComponentesController', {

		opcion : opcionVar,
		id_componente : id_componenteVar

	}, function(response) {

		$('#id_componente').val(response.id_componente);
		document.ready = document.getElementById("id_tipo_componente").value = response.id_tipo_componente;
				
		$('#monto_componente_viable').val(response.monto_componente_viable);
		$('#observacion_componente').val(response.observacion);
		
		
	});
	
}

function ver_datos_componentes(id_componente) {
		
	cargar_datos_componentes(id_componente);

	$('#id_tipo_componente').attr('disabled',true);
	$('#monto_componente_viable').attr('disabled',true);
	$('#observacion_componente').attr('disabled',true);
		
	$('#btn_grabar_componentes').hide();
	
}

function editar_datos_componentes(id_componente) {

	cargar_datos_componentes(id_componente);

	$('#id_tipo_componente').attr('disabled',false);
	$('#monto_componente_viable').attr('disabled',false);
	$('#observacion_componente').attr('disabled',false);
			
	$('#btn_grabar_componentes').show();
	
}
