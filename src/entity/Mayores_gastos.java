package entity;

public class Mayores_gastos {
	
	private int id_mayor_gasto;
		private int id_contrato_proceso_seleccion_item;
		private String mayores_gastos_desc;
		private String fecha;
		private double monto;
		private String usuario;
		private String fecha_registro;
		private String fecha_ultima_modificacion;
		private int activo;
		
		public Mayores_gastos() {
			
		}

		public Mayores_gastos(int id_mayor_gasto, int id_contrato_proceso_seleccion_item, String mayores_gastos_desc,
				String fecha, double monto, String usuario, String fecha_registro, String fecha_ultima_modificacion,
				int activo) {
		
			this.id_mayor_gasto = id_mayor_gasto;
			this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
			this.mayores_gastos_desc = mayores_gastos_desc;
			this.fecha = fecha;
			this.monto = monto;
			this.usuario = usuario;
			this.fecha_registro = fecha_registro;
			this.fecha_ultima_modificacion = fecha_ultima_modificacion;
			this.activo = activo;
		}

		public int getId_mayor_gasto() {
			return id_mayor_gasto;
		}

		public void setId_mayor_gasto(int id_mayor_gasto) {
			this.id_mayor_gasto = id_mayor_gasto;
		}

		public int getId_contrato_proceso_seleccion_item() {
			return id_contrato_proceso_seleccion_item;
		}

		public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
			this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		}

		public String getMayores_gastos_desc() {
			return mayores_gastos_desc;
		}

		public void setMayores_gastos_desc(String mayores_gastos_desc) {
			this.mayores_gastos_desc = mayores_gastos_desc;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public double getMonto() {
			return monto;
		}

		public void setMonto(double monto) {
			this.monto = monto;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getFecha_registro() {
			return fecha_registro;
		}

		public void setFecha_registro(String fecha_registro) {
			this.fecha_registro = fecha_registro;
		}

		public String getFecha_ultima_modificacion() {
			return fecha_ultima_modificacion;
		}

		public void setFecha_ultima_modificacion(String fecha_ultima_modificacion) {
			this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		}

		public int getActivo() {
			return activo;
		}

		public void setActivo(int activo) {
			this.activo = activo;
		}
		
		
}
