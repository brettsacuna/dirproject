
<%@ page language="java" contentType="text/html; charset=utf-8"	
	pageEncoding="utf-8"%>
	
		<!-- MORRIS CHART -->
		<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
	
<!--  	<link href="assets/css/datepicker.css" rel="stylesheet"> -->
	
	<!-- STYLES DATATABLES JQUERY -->
<!--	<link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" /> -->
		
<body>

<div class="row">
                    <div class="col-md-12">
                     	<h2 class="text-primary"><strong>Últimas estadísticas</strong></h2>   
                    </div>
</div>              
                 <!-- /. ROW  -->
                  <hr/>
<div class="row">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-6 col-sm-12 col-xs-12">
				<div class="panel panel-primary">
					<div class="panel panel-heading">
						N° de casos por grupos de edades
					</div>
					<div class="panel-body">
						<div id="bar-casos-edades">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
  
    <!--INICIO DE VENTANA MODAL PARA MENSAJES  -->
 <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>  
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->

<!-- JQUERY DATATABLES -->

<script type="text/javascript">
$(document).ready(function(){
	
	$.post('<%=request.getContextPath()%>/EstadisticasController', {

		opcion : 'generagrafico'
		

	}, function(response) {
		
		 Morris.Bar({
		        element: 'bar-casos-edades',
		        data: response,
		        xkey: 'grupoetareo',
		        ykeys: ['cantidad'],
		        labels: ['N° de casos'],
		        hideHover: 'auto',
		        resize: true
		    });

	});
	
});
	
</script>
</body>
