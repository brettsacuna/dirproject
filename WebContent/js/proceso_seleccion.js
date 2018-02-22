
function guardar_proceso_seleccion(){
	
	var opcionVar = "guardar";

	var id_proceso_seleccionVar = $('#id_proceso_seleccion').val();
	var id_proyectoVar = $('#id_proyecto').val();

	if (id_proceso_seleccionVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var proceso_seleccion_pertenenciaVar = $('#proceso_seleccion_pertenencia').val();
	var numero_procesoVar = $('#numero_proceso').val();
	var valor_referencialVar = $('#valor_referencial_proceso_seleccion').val();
	var fecha_valor_referencialVar = $('#fecha_valor_referencial').val(); 
	var plazo_ejecucionVar = $('#plazo_ejecucion').val();
	var modalidad_contratacionVar = $('#modalidad_contratacion').val();
	var usuarioVar = $('#usuario').val();
	
	$.post('Proceso_seleccionController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_proyecto : id_proyectoVar,
						id_proceso_seleccion : id_proceso_seleccionVar,
						proceso_seleccion_pertenencia : proceso_seleccion_pertenenciaVar,
						numero_proceso : numero_procesoVar,
						valor_referencial : valor_referencialVar,
						fecha_valor_referencial : fecha_valor_referencialVar,
						plazo_ejecucion : plazo_ejecucionVar,
						modalidad_contratacion : modalidad_contratacionVar,
						
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_proceso_seleccion(id_proyectoVar);							

							$('#panel_mensaje_proceso_seleccion').html('<div class="alert alert-success" align="center" role="alert">Proceso de selección guardado con éxito</div>');
							$('#btn_grabar_proceso_seleccion').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_proceso_seleccion').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_proceso_seleccion(id_proceso_seleccion) {

	var opcionVar = "buscar";
	var id_proceso_seleccionVar = id_proceso_seleccion;

	$.get('Proceso_seleccionController', {

		opcion : opcionVar,
		id_proceso_seleccion : id_proceso_seleccionVar

	}, function(response) {
		
		
		$('#id_proceso_seleccion').val(response.id_proceso_seleccion);
		$('#numero_proceso').val(response.numero_proceso);
		$('#valor_referencial_proceso_seleccion').val(response.valor_referencial);
		$('#fecha_valor_referencial').val(response.fecha_valor_referencial);
		$('#plazo_ejecucion').val(response.plazo_ejecucion);
		document.ready = document.getElementById("proceso_seleccion_pertenencia").value = response.proceso_seleccion_pertenencia;
		document.ready = document.getElementById("modalidad_contratacion").value = response.modalidad_contratacion;

	});

}

function ver_datos_proceso_seleccion(id_proceso_seleccion){
	
	limpiar_form_proceso_seleccion();
	
	cargar_datos_proceso_seleccion(id_proceso_seleccion);
	
	$('#numero_proceso').attr('readonly',true);
	$('#valor_referencial_proceso_seleccion').attr('readonly',true);
	$('#fecha_valor_referencial').attr('disabled',true);
	$('#modalidad_contratacion').attr('disabled',true);
	$('#plazo_ejecucion').attr('readonly',true);
	$('#proceso_seleccion_pertenencia').attr('disabled',true);
	
	$('#btn_grabar_proceso_seleccion').hide();
	
}

function editar_datos_proceso_seleccion(id_proceso_seleccion){
	
	limpiar_form_proceso_seleccion();
	
	cargar_datos_proceso_seleccion(id_proceso_seleccion);
	
	$('#numero_proceso').attr('readonly',false);
	$('#valor_referencial_proceso_seleccion').attr('readonly',false);
	$('#fecha_valor_referencial').attr('disabled',false);
	$('#modalidad_contratacion').attr('disabled',false);
	$('#plazo_ejecucion').attr('readonly',false);
	$('#proceso_seleccion_pertenencia').attr('disabled',false);
	
	$('#btn_grabar_proceso_seleccion').show();
	
};


function lista_proceso_seleccion(id_proyecto){
	
	var opcionVar = "listar_proceso_seleccion";
	var id_proyectoVar = id_proyecto;
		
	$.get('Proceso_seleccionController', {
		
		opcion : opcionVar,		
		id_proyecto: id_proyectoVar
		
	},function(response){
			
			$('#listado_procesos').empty();
			
			var body = "";
			
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, proceso_seleccion){
				
				var modalidad_contratacion = "";
				
				var objeto_convocatoria = "";
				
				switch (proceso_seleccion.modalidad_contratacion) {
				
				case '1' : modalidad_contratacion = "Suma Alzada";
					break;	
				case '2' : modalidad_contratacion = "Costos Unitarios";
					break;	
										
				}	
				
				switch (proceso_seleccion.proceso_seleccion_pertenencia) {
				
				case '1' : objeto_convocatoria = "Bien";
					break;	
				case '2' : objeto_convocatoria = "Consultoría de Obra";
					break;	
				case '3' : objeto_convocatoria = "Obra";
					break;
				case '4' : objeto_convocatoria = "Servicio";
					break;	
										
				}	
				
				if(usuario == proceso_seleccion.usuario || tipo_usuario == "Administrador" ){
					
					body += `
						<tr class="success">
						  
							<td class="text-center" onclick="lista_proceso_seleccion_item(${proceso_seleccion.id_proceso_seleccion})">${index+1}</td>
							<td onclick="lista_proceso_seleccion_item(${proceso_seleccion.id_proceso_seleccion})">${proceso_seleccion.numero_proceso}</td>							
							<td class="text-center" onclick="lista_proceso_seleccion_item(${proceso_seleccion.id_proceso_seleccion})">${objeto_convocatoria}</td>											
							<td class="text-center"><button type="button" class="btn btn-success" data-toggle="modal" data-target="#modal_proceso_seleccion_item" onclick="carga_id_proceso_seleccion(${proceso_seleccion.id_proceso_seleccion})"><i class="glyphicon glyphicon-plus"></i></button>
													<button type="button" class="btn btn-primary" onclick="ver_datos_proceso_seleccion(${proceso_seleccion.id_proceso_seleccion})" data-toggle="modal" data-target="#modal_proceso_seleccion" ><i class="glyphicon glyphicon-eye-open"></i></button> 
													<button type="button" class="btn btn-default" onclick="editar_datos_proceso_seleccion(${proceso_seleccion.id_proceso_seleccion})" data-toggle="modal" data-target="#modal_proceso_seleccion"><i class="glyphicon glyphicon-edit"></i></button>
													<button type="button" class="btn btn-danger" onclick="carga_proceso_seleccion_eliminar(${proceso_seleccion.id_proceso_seleccion})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					     
						</tr>
						<tr id="items_proceso_${proceso_seleccion.id_proceso_seleccion}" style="display: none;">
							<td colspan="7">
								<table class="table table-hover table-bordered table-striped" id="lista_proceso_seleccion_item">							
									<thead>	
										<tr>
											<caption><h4 class="form-section">Items</h4></caption>
										</tr>
										<tr class="active">																						
											<th class="text-center">N°</th>
											<th>Item Descripción</th>											
											<th class="text-center">Situación</th>
											<th class="text-center" >Opciones</th>																																		
										</tr>																				
									</thead>
									<tbody id="listado_items_proceso_${proceso_seleccion.id_proceso_seleccion}"></tbody>
								</table>
							</td>
						</tr>
				`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					body += `
						<tr class="success">
						  
							<td class="text-center" onclick="lista_proceso_seleccion_item(${proceso_seleccion.id_proceso_seleccion})">${index+1}</td>
							<td onclick="lista_proceso_seleccion_item(${proceso_seleccion.id_proceso_seleccion})">${proceso_seleccion.numero_proceso}</td>							
							<td class="text-center" onclick="lista_proceso_seleccion_item(${proceso_seleccion.id_proceso_seleccion})">${objeto_convocatoria}</td>											
							<td class="text-center">
													<button type="button" class="btn btn-primary" onclick="ver_datos_proceso_seleccion(${proceso_seleccion.id_proceso_seleccion})" data-toggle="modal" data-target="#modal_proceso_seleccion" ><i class="glyphicon glyphicon-eye-open"></i></button> 
							</td>
					     
						</tr>
						<tr id="items_proceso_${proceso_seleccion.id_proceso_seleccion}" style="display: none;">
							<td colspan="7">
								<table class="table table-hover table-bordered table-striped" id="lista_proceso_seleccion_item">							
									<thead>	
										<tr>
											<caption><h4 class="form-section">Items</h4></caption>
										</tr>
										<tr class="active">																						
											<th class="text-center">N°</th>
											<th>Item Descripción</th>											
											<th class="text-center">Situación</th>
											<th class="text-center" >Opciones</th>																																		
										</tr>																				
									</thead>
									<tbody id="listado_items_proceso_${proceso_seleccion.id_proceso_seleccion}"></tbody>
								</table>
							</td>
						</tr>
				`;	
					
				}
					
														
			});
			
			$('#listado_procesos').html(body);
						
	});
	
}

function carga_proceso_seleccion_eliminar(id_proceso_seleccion){
	
	$('#id_proceso_seleccion').val(id_proceso_seleccion);
	$('#id_eliminar_objeto').val('proceso_seleccion');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar el proceso de seleccion seleccionado?</h5>');
}

function elimina_proceso_seleccion(id_proceso_seleccion){
		
		var opcionVar = 'eliminar';
	
		$.post('Proceso_seleccionController',{
			
			opcion: opcionVar,
			id_proceso_seleccion : id_proceso_seleccion
			
		},function(response){
			
			if(response == 1){
				
				replegar();								
				$('#id_proceso_seleccion').val('');
								
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}

function carga_id_proceso_seleccion(id_proceso_seleccion){
	
	$('#id_proceso_seleccion').val(id_proceso_seleccion);
	//console.log(id_proceso_seleccion);
	
}

