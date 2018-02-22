function guardar_item_proyecto() {

	var opcionVar = "guardar";

	var id_item_proyectoVar = $('#id_item_proyecto').val();
	var id_proyectoVar = $('#id_proyecto').val();

	if (id_item_proyectoVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var ubicacionVar = $('#ubicacion').val();
	var item_descripcionVar = $('#item_descripcion').val();
	var etapa_proyectoVar = $('#etapa_proyecto').val();
	var estado_proyectoVar = $('#estado_proyecto').val();
	var presupuesto_expediente_tecnicoVar = $('#presupuesto_expediente_tecnico').val();
	var valor_referencialVar = $('#valor_referencial').val();
	
	var usuarioVar = $('#usuario').val();

	$.post('Item_proyectoController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_item_proyecto : id_item_proyectoVar,
						id_proyecto : id_proyectoVar,
						ubicacion : ubicacionVar,
						item_descripcion : item_descripcionVar,
						etapa_proyecto : etapa_proyectoVar,
						estado_proyecto : estado_proyectoVar,
						presupuesto_expediente_tecnico : presupuesto_expediente_tecnicoVar,
						valor_referencial : valor_referencialVar,
						
						usuario : usuarioVar

					},
					
					function(response) {

						if (response == 1) {8
							
							$('#panel_mensaje_item_proyecto').html('<div class="alert alert-success" align="center" role="alert">¡Item guardado con éxito!</h5>');
							lista_item_proyecto(id_proyectoVar,'show');	
							$('#btn_grabar_item_proyecto').hide();
							
						} else if (response == 0) {
							
							$('#panel_mensaje_item_proyecto').html('<div class="alert alert-success" align="center" role="alert">¡Error!</h5>');

						} 

					});

}

function lista_item_proyecto(id_proyecto,opcion_btn){
	
	var opcionVar = "listar_item_proyecto";
	var id_proyectoVar = id_proyecto;
		
	$.get('Item_proyectoController', {
		
		opcion : opcionVar,		
		id_proyecto: id_proyectoVar
		
	},function(response){
			
			$('#listado_item_proyecto').empty();
			
			var body = "";
							
			$.each(response, function(index, item_proyecto){
				

				if(opcion_btn == "show"){
					
				body += `
						<tr class="success">
						  
							<td class="text-center">${index+1}</td>
							<td >${item_proyecto.item_descripcion}</td>											
							<td class="text-center"><button type="button" class="btn btn-primary"  onclick="ver_datos_item_proyecto(${item_proyecto.id_item_proyecto})" data-toggle="modal" data-target="#modal_item_proyecto"><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" class="btn btn-default" onclick="editar_datos_item_proyecto(${item_proyecto.id_item_proyecto})" data-toggle="modal" data-target="#modal_item_proyecto"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" class="btn btn-danger" onclick="carga_item_proyecto_eliminar(${item_proyecto.id_item_proyecto})" data-toggle="modal" data-target="#modal_confirma_eliminar_preinversion"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					     
						</tr>
						
						`;
				
				}else if(opcion_btn == "hide"){
					
					body += `
						<tr class="success">
						  
							<td class="text-center">${index+1}</td>
							<td >${item_proyecto.item_descripcion}</td>											
							<td class="text-center"><button type="button" class="btn btn-primary"  onclick="ver_datos_item_proyecto(${item_proyecto.id_item_proyecto})" data-toggle="modal" data-target="#modal_item_proyecto"><i class="glyphicon glyphicon-eye-open"></i></button></td>
					     
						</tr>
						
						`;
				
				}
														
			});
			
			$('#listado_item_proyecto').html(body);
						
	});
	
}

function carga_item_proyecto_eliminar(id_item_proyecto){
	
	$('#id_item_proyecto').val(id_item_proyecto);
	$('#id_eliminar_objeto_preinversion').val('item_proyecto');
	$('#panel_mensaje_confirma_preinversion').html('<h5>¿Confirma eliminar el item seleccionado?</strong>?</h5>');
}

function elimina_item_proyecto(id_item_proyecto){
		
		var opcionVar = 'eliminar';
	
		$.post('Item_proyectoController',{
			
			opcion: opcionVar,
			id_item_proyecto : id_item_proyecto
			
		},function(response){
			
			if(response == 1){
				
				lista_item_proyecto($('#id_proyecto').val());
				$('#id_item_proyecto').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}



function cargar_datos_item_proyecto(id_item_proyecto) {

	var opcionVar = "buscar";
	var id_item_proyectoVar = id_item_proyecto;

	$.get('Item_proyectoController', {

		opcion : opcionVar,
		id_item_proyecto : id_item_proyectoVar

	}, function(response) {

		$('#id_item_proyecto').val(response.id_item_proyecto);
		$('#ubicacion').val(response.ubicacion);
		$('#item_descripcion').val(response.item_descripcion);
		$('#presupuesto_expediente_tecnico').val(response.presupuesto_expediente_tecnico);
		$('#valor_referencial').val(response.valor_referencial);
		document.ready = document.getElementById("etapa_proyecto").value = response.etapa_proyecto;
		document.ready = document.getElementById("estado_proyecto").value = response.estado_proyecto;
		
	});
	
}

function ver_datos_item_proyecto(id_item_proyecto) {
		
	cargar_datos_item_proyecto(id_item_proyecto);

	$('#id_item_proyecto').attr('disabled',true);
	$('#ubicacion').attr('disabled',true);
	$('#item_descripcion').attr('disabled',true);
	$('#presupuesto_expediente_tecnico').attr('disabled',true);
	$('#valor_referencial').attr('disabled',true);
	$('#estado_proyecto').attr('disabled',true);
	$('#etapa_proyecto').attr('disabled',true);
	
		
	$('#btn_grabar_item_proyecto').hide();
	
}

function editar_datos_item_proyecto(id_item_proyecto) {


	cargar_datos_item_proyecto(id_item_proyecto);

	$('#id_item_proyecto').attr('disabled',false);
	$('#ubicacion').attr('disabled',false);
	$('#item_descripcion').attr('disabled',false);
	$('#presupuesto_expediente_tecnico').attr('disabled',false);
	$('#valor_referencial').attr('disabled',false);
	$('#estado_proyecto').attr('disabled',false);
	$('#etapa_proyecto').attr('disabled',false)
			
	$('#btn_grabar_item_proyecto').show();
	
}