package entity;

public class Adelanto {
	
	private int id_adelanto;
	private int id_contrato_proceso_seleccion_item;
	private String adelanto_descipcion;
	private String fecha_solicitud_adelanto;
	private String tipo_adelanto;
	private double monto_adelanto;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;
	
	public Adelanto() {
		
	}

	public Adelanto(int id_adelanto, int id_contrato_proceso_seleccion_item, String adelanto_descipcion,
			String fecha_solicitud_adelanto, String tipo_adelanto, double monto_adelanto, String usuario,
			String fecha_registro, String fecha_ultima_modificacion, int activo) {
		
		this.id_adelanto = id_adelanto;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.adelanto_descipcion = adelanto_descipcion;
		this.fecha_solicitud_adelanto = fecha_solicitud_adelanto;
		this.tipo_adelanto = tipo_adelanto;
		this.monto_adelanto = monto_adelanto;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_adelanto() {
		return id_adelanto;
	}

	public void setId_adelanto(int id_adelanto) {
		this.id_adelanto = id_adelanto;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getAdelanto_descipcion() {
		return adelanto_descipcion;
	}

	public void setAdelanto_descipcion(String adelanto_descipcion) {
		this.adelanto_descipcion = adelanto_descipcion;
	}

	public String getFecha_solicitud_adelanto() {
		return fecha_solicitud_adelanto;
	}

	public void setFecha_solicitud_adelanto(String fecha_solicitud_adelanto) {
		this.fecha_solicitud_adelanto = fecha_solicitud_adelanto;
	}

	public String getTipo_adelanto() {
		return tipo_adelanto;
	}

	public void setTipo_adelanto(String tipo_adelanto) {
		this.tipo_adelanto = tipo_adelanto;
	}

	public double getMonto_adelanto() {
		return monto_adelanto;
	}

	public void setMonto_adelanto(double monto_adelanto) {
		this.monto_adelanto = monto_adelanto;
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
