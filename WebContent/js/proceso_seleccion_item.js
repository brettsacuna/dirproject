function guardar_proceso_seleccion_item(){
	
	var opcionVar = "guardar";
	
	var id_proceso_seleccionVar = $('#id_proceso_seleccion').val();
	
	var id_proceso_seleccion_itemVar = $('#id_proceso_seleccion_item').val();
	
	if (id_proceso_seleccion_itemVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}
		
	var id_item_proyectoVar = $('#id_item_proyecto_').val();
	var item_descripcionVar = $('#id_item_proyecto_ option:selected').text();
	
	var valor_referencialVar = $('#valor_referencial_proceso_seleccion_item').val();
	var fecha_valor_referencialVar = $('#fecha_valor_referencial_proceso_seleccion_item').val(); 
	var plazo_ejecucionVar = $('#plazo_ejecucion_proceso_seleccion_item').val();
	var situacionVar = $('#situacion').val();
	
	var usuarioVar = $('#usuario').val();
	
	$.post('Proceso_seleccion_itemController',
					{

						opcion : opcionVar,
						operacion : operacionVar,
												
						id_proceso_seleccion_item : id_proceso_seleccion_itemVar,
						id_proceso_seleccion : id_proceso_seleccionVar,
						id_item_proyecto : id_item_proyectoVar,
						item_descripcion : item_descripcionVar,
						valor_referencial : valor_referencialVar,
						fecha_valor_referencial : fecha_valor_referencialVar,
						plazo_ejecucion : plazo_ejecucionVar,
						situacion : situacionVar,
						
						usuario : usuarioVar

					},
					
					function(response) {

						if (response == 1) {
							
							lista_proceso_seleccion_item(id_proceso_seleccionVar);
																					
							$('#panel_mensaje_proceso_seleccion_item').html('<div class="alert alert-success" align="center" role="alert">Item guardado con éxito</div>');
							$('#btn_grabar_proceso_seleccion_item').hide();
						} else if (response == 0) {
							$('#panel_mensaje_proceso_seleccion_item').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});
	
}

function ver_datos_proceso_seleccion_item(id_proceso_seleccion_item){
		
	limpiar_form_proceso_seleccion_item();
	
	cargar_datos_proceso_seleccion_item(id_proceso_seleccion_item);
	
	$('#item_descripcion').attr('readonly',true);
	$('#valor_referencial_proceso_seleccion_item').attr('readonly',true);
	$('#fecha_valor_referencial_proceso_seleccion_item').attr('disabled',true);
	$('#situacion').attr('disabled',true);
	$('#plazo_ejecucion_proceso_seleccion_item').attr('readonly',true);
	
	$('#btn_grabar_proceso_seleccion_item').hide();
		
}

function editar_datos_proceso_seleccion_item(id_proceso_seleccion_item,id_proceso_seleccion){
	
	limpiar_form_proceso_seleccion_item();
		
	cargar_datos_proceso_seleccion_item(id_proceso_seleccion_item);
	
	$('#item_descripcion').attr('readonly',false);
	$('#valor_referencial_proceso_seleccion_item').attr('readonly',false);
	$('#fecha_valor_referencial_proceso_seleccion_item').attr('disabled',false);
	$('#situacion').attr('disabled',false);
	$('#plazo_ejecucion_proceso_seleccion_item').attr('readonly',false);
	
	$('#id_proceso_seleccion').val(id_proceso_seleccion);
	
	$('#btn_grabar_proceso_seleccion_item').show();
	
	$('#id_proceso_seleccion_item').val(id_proceso_seleccion_item);
	
}

function lista_item_proyecto_item(id_proyecto){
	
	var opcionVar = "listar_item_proyecto";
	var id_proyectoVar = id_proyecto;
		
	$.get('Item_proyectoController', {
		
		opcion : opcionVar,		
		id_proyecto: id_proyectoVar
		
	},function(response){			
		
			$('#id_item_proyecto_').empty();	
			
			$.each(response, function(index, item_proyecto){
										
					$('#id_item_proyecto_').append('<option value ="'+item_proyecto.id_item_proyecto+'">'+item_proyecto.item_descripcion+'</option>');
																		
			});
							
	});
	
}

function lista_proceso_seleccion_item(id_proceso_seleccion){
	
	var opcionVar = "listar_proceso_seleccion_item";
		
	var id_proceso_seleccionVar = id_proceso_seleccion;
		
	$.get('Proceso_seleccion_itemController', {
		
		opcion : opcionVar,	
		id_proceso_seleccion : id_proceso_seleccionVar
		
	},function(response){
						
			$('#listado_items_proceso_'+id_proceso_seleccion).empty();
				
			var body = "";
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, proceso_seleccion_item){
				
				var situacion = "";
				
				switch (proceso_seleccion_item.situacion) {
				
				case '1' : situacion = "Adjudicado";
					break;	
				case '2' : situacion = "Desierto";
					break;	
				case '3' : situacion = "Cancelado";
					break;
				case '4' : situacion = "Revertido";
					break;	
										
				}	
				
				if(usuario == proceso_seleccion_item.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="info">
							<td class="text-center" onclick="lista_contrato_proceso_seleccion_item(${proceso_seleccion_item.id_proceso_seleccion_item})">${index+1}</td>
							<td onclick="lista_contrato_proceso_seleccion_item(${proceso_seleccion_item.id_proceso_seleccion_item})">${proceso_seleccion_item.item_descripcion}</td>						
							<td class="text-center" onclick="lista_contrato_proceso_seleccion_item(${proceso_seleccion_item.id_proceso_seleccion_item})">${situacion}</td>
							<td class="text-center"><button type="button"  class="btn btn-success" data-toggle="modal" data-target="#modal_contrato_proceso_seleccion_item" onclick="carga_id_proceso_seleccion_item(${proceso_seleccion_item.id_proceso_seleccion_item})"><i class="glyphicon glyphicon-plus"></i></button> 
													<button type="button" class="btn btn-primary" onclick="ver_datos_proceso_seleccion_item(${proceso_seleccion_item.id_proceso_seleccion_item})" data-toggle="modal" data-target="#modal_proceso_seleccion_item"><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" class="btn btn-default" onclick="editar_datos_proceso_seleccion_item(${proceso_seleccion_item.id_proceso_seleccion_item},${proceso_seleccion_item.id_proceso_seleccion})" data-toggle="modal" data-target="#modal_proceso_seleccion_item" ><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" class="btn btn-danger" onclick="carga_proceso_seleccion_item_eliminar(${proceso_seleccion_item.id_proceso_seleccion_item})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
						</tr>
						<tr id="contrato_proceso_item_${proceso_seleccion_item.id_proceso_seleccion_item}" style="display: none;">
								<td colspan="7">
									<table class="table table-hover table-bordered table-striped" id="lista_contrato_proceso_seleccion_item">							
										<thead>	
											<tr>
												<caption><h4 class="form-section">Contrato</h4></caption>
											</tr>
											<tr class="warning">																						
												<th class=" text-center">N°</th>
												<th>N° Contrato</th>											
												<th class="text-center" >Opciones</th>																																		
											</tr>																					
										</thead>
										<tbody id="listado_contrato_proceso_item_${proceso_seleccion_item.id_proceso_seleccion_item}">										
										</tbody>
									</table>
								</td>
							</tr>			
						
					`;
					
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="info">
							<td class="text-center" onclick="lista_contrato_proceso_seleccion_item(${proceso_seleccion_item.id_proceso_seleccion_item})">${index+1}</td>
							<td onclick="lista_contrato_proceso_seleccion_item(${proceso_seleccion_item.id_proceso_seleccion_item})">${proceso_seleccion_item.item_descripcion}</td>						
							<td class="text-center" onclick="lista_contrato_proceso_seleccion_item(${proceso_seleccion_item.id_proceso_seleccion_item})">${situacion}</td>
							<td class="text-center">
													<button type="button"  class="btn btn-primary" onclick="ver_datos_proceso_seleccion_item(${proceso_seleccion_item.id_proceso_seleccion_item})" data-toggle="modal" data-target="#modal_proceso_seleccion_item"><i class="glyphicon glyphicon-eye-open"></i></button> 
							</td>
						</tr>
						<tr id="contrato_proceso_item_${proceso_seleccion_item.id_proceso_seleccion_item}" style="display: none;">
								<td colspan="7">
									<table class="table table-hover table-bordered table-striped" id="lista_contrato_proceso_seleccion_item">							
										<thead>	
											<tr>
												<caption><h4 class="form-section">Contrato</h4></caption>
											</tr>
											<tr class="warning">																						
												<th class=" text-center">N°</th>
												<th>N° Contrato</th>											
												<th class="text-center" >Opciones</th>																																		
											</tr>																					
										</thead>
										<tbody id="listado_contrato_proceso_item_${proceso_seleccion_item.id_proceso_seleccion_item}">										
										</tbody>
									</table>
								</td>
							</tr>			
						
					`;					
					
				}								
										
			});
			
			$('#listado_items_proceso_'+id_proceso_seleccion).html(body);
			$('#items_proceso_'+id_proceso_seleccion).show();
		
	});		
	
}

function carga_proceso_seleccion_item_eliminar(id_proceso_seleccion_item){
	
	$('#id_proceso_seleccion_item').val(id_proceso_seleccion_item);
	$('#id_eliminar_objeto').val('proceso_seleccion_item');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar el item seleccionado?</h5>');
}

function elimina_proceso_seleccion_item(id_proceso_seleccion_item){
		
		var opcionVar = 'eliminar';
	
		$.post('Proceso_seleccion_itemController',{
			
			opcion: opcionVar,
			id_proceso_seleccion_item : id_proceso_seleccion_item
			
		},function(response){
			
			if(response == 1){
				
				replegar();								
				$('#id_proceso_seleccion_item').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}


function cargar_datos_proceso_seleccion_item(id_proceso_seleccion_item) {

	var opcionVar = "buscar";
	var id_proceso_seleccion_itemVar = id_proceso_seleccion_item;

	$.get('Proceso_seleccion_itemController', {

		opcion : opcionVar,
		id_proceso_seleccion_item : id_proceso_seleccion_itemVar

	}, function(response) {
		
		
		$('#id_proceso_seleccion_item').val(response.id_proceso_seleccion_item);
		
		$('#item_descripcion').val(response.item_descripcion);
		$('#valor_referencial_proceso_seleccion_item').val(response.valor_referencial);
		$('#fecha_valor_referencial_proceso_seleccion_item').val(response.fecha_valor_referencial);
		$('#plazo_ejecucion_proceso_seleccion_item').val(response.plazo_ejecucion);
		document.ready = document.getElementById("situacion").value = response.situacion;
		document.ready = document.getElementById("id_item_proyecto_").value = response.id_item_proyecto;
		
	
	});

}

function carga_id_proceso_seleccion_item(id_proceso_seleccion_item){
	
	$('#id_proceso_seleccion_item').val(id_proceso_seleccion_item);
}

