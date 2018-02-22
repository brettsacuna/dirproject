function lista_garantia(id_contrato_proceso_seleccion_item){
	
	var opcionVar = "listar_garantia";
	var id_contrato_proceso_seleccion_itemVar = id_contrato_proceso_seleccion_item;
		
	$.get('GarantiaController', {
		
		opcion : opcionVar,		
		id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar
		
	},function(response){
			
			$('#listado_garantias').empty();
			
			var body = "";
			var usuario = $('#usuario').val();
			var tipo_usuario = $('#tipo_usuario').val();
			
			$.each(response, function(index, garantia){
				
				
				if(usuario == garantia.usuario || tipo_usuario == "Administrador" ){
					
					
					body += `
							<tr class="warning">					  
								<td class="text-center">${index+1}</td>
								<td>${garantia.descripcion_garantia}</td>																	
								<td class="text-center"><button type="button"  class="btn btn-primary"  onclick="ver_datos_garantia(${garantia.id_garantia})" data-toggle="modal" data-target="#modal_garantia" ><i class="glyphicon glyphicon-eye-open"></i></button> 
														<button type="button"  class="btn btn-default" onclick="editar_datos_garantia(${garantia.id_garantia})" data-toggle="modal" data-target="#modal_garantia"><i class="glyphicon glyphicon-edit"></i></button>
						    							<button type="button"  class="btn btn-danger" onclick="carga_garantia_eliminar(${garantia.id_garantia})" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>
						    	</td>						
						    </tr>						
					`;
					
				}else if(tipo_usuario == "Operador" || tipo_usuario == "Usuario" ){
					
					
					body += `
							<tr class="warning">					  
								<td class="text-center">${index+1}</td>
								<td>${garantia.descripcion_garantia}</td>																	
								<td class="text-center">
										<button type="button" class="btn btn-primary"  onclick="ver_datos_garantia(${garantia.id_garantia})" data-toggle="modal" data-target="#modal_garantia" ><i class="glyphicon glyphicon-eye-open"></i></button>						
								</td>						
						    </tr>						
					`;
					
				}
				
													
			});
			
			$('#listado_garantias').html(body);
						
	});
	
}

function carga_garantia_eliminar(id_garantia){
	
	$('#id_garantia').val(id_garantia);
	$('#id_eliminar_objeto').val('garantia');
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar la garantia seleccionada?</strong>?</h5>');
}

function elimina_garantia(id_garantia){
		
		var opcionVar = 'eliminar';
	
		$.post('GarantiaController',{
			
			opcion: opcionVar,
			id_garantia : id_garantia
			
		},function(response){
			
			if(response == 1){
				
				lista_garantia($('#id_contrato_proceso_seleccion_item').val());
				$('#id_garantia').val('');
				
				
			}else if(response == 0){
				alert('Error');
			}
			
		});	
			
}


function guardar_garantia(){
	
	var opcionVar = "guardar";

	var id_garantiaVar = $('#id_garantia').val();
	var id_contrato_proceso_seleccion_itemVar = $('#id_contrato_proceso_seleccion_item').val();

	if (id_garantiaVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';

	}

	var descripcion_garantiaVar = $('#descripcion_garantia').val();
	var facturaVar = $('#factura').val();
	var fecha_facturaVar = $('#fecha_factura').val();
	var tipo_garantiaVar = $('#tipo_garantia').val();	
	var institucion_financieraVar = $('#institucion_financiera').val(); 
	var numero_documentoVar = $('#numero_documento_garantia').val(); 
	var monto_adelantoVar = $('#monto_adelanto_garantia').val(); 
	var monto_carta_fianzaVar = $('#monto_carta_fianza').val();
	var fecha_creacionVar = $('#fecha_creacion').val();
	var fecha_vencimientoVar = $('#fecha_vencimiento').val();
	
	var usuarioVar = $('#usuario').val();
	
	$.post('GarantiaController',
					{

						opcion : opcionVar,
						operacion : operacionVar,

						id_garantia : id_garantiaVar,
						id_contrato_proceso_seleccion_item : id_contrato_proceso_seleccion_itemVar,
						
						descripcion_garantia : descripcion_garantiaVar,
						factura : facturaVar,
						fecha_factura : fecha_facturaVar,
						tipo_garantia : tipo_garantiaVar,
						institucion_financiera : institucion_financieraVar,
						numero_documento : numero_documentoVar,
						monto_adelanto : monto_adelantoVar,
						monto_carta_fianza : monto_carta_fianzaVar,
						fecha_creacion : fecha_creacionVar,
						fecha_vencimiento : fecha_vencimientoVar,
						
						usuario : usuarioVar

					},
					function(response) {

						if (response == 1) {
																					
							lista_garantia(id_contrato_proceso_seleccion_itemVar);							

							$('#panel_mensaje_garantia').html('<div class="alert alert-success" align="center" role="alert">Garantía grabada con éxito</div>');
							$('#btn_grabar_garantia').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_garantia').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});

	
}

function cargar_datos_garantia(id_garantia) {

	var opcionVar = "buscar";
	var id_garantiaVar = id_garantia;

	$.get('GarantiaController', {

		opcion : opcionVar,
		id_garantia : id_garantiaVar

	}, function(response) {
		
		$('#id_garantia').val(response.id_garantia);
		
		$('#descripcion_garantia').val(response.descripcion_garantia);
		$('#factura').val(response.factura);
		$('#fecha_factura').val(response.fecha_factura);
		
		document.ready = document.getElementById("tipo_garantia").value = response.tipo_garantia; 
		
		$('#institucion_financiera').val(response.institucion_financiera); 
		$('#numero_documento_garantia').val(response.numero_documento); 
		$('#monto_adelanto_garantia').val(response.monto_adelanto); 
		$('#monto_carta_fianza').val(response.monto_carta_fianza);
		$('#fecha_creacion').val(response.fecha_creacion);
		$('#fecha_vencimiento').val(response.fecha_vencimiento);
		
	});

}

function ver_datos_garantia(id_garantia){
	
	limpiar_form_garantia();
	
	cargar_datos_garantia(id_garantia);	

	$('#descripcion_garantia').attr('disabled',true);
	$('#factura').attr('disabled',true);
	$('#fecha_factura').attr('disabled',true);
	
	$("#tipo_garantia").attr('disabled',true); 
	
	$('#institucion_financiera').attr('disabled',true);
	$('#numero_documento_garantia').attr('disabled',true);
	$('#monto_adelanto_garantia').attr('disabled',true);
	$('#monto_carta_fianza').attr('disabled',true);
	$('#fecha_creacion').attr('disabled',true);
	$('#fecha_vencimiento').attr('disabled',true);
		
	$('#btn_grabar_garantia').hide();
	
}

function editar_datos_garantia(id_garantia){
	
	limpiar_form_garantia();
	
	cargar_datos_garantia(id_garantia);	

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
		
	$('#btn_grabar_garantia').show();
	
};
