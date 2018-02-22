package entity;

public class Valorizacion {

	private int id_valorizacion; 
	private int id_contrato_proceso_seleccion_item;
	private String periodo;
	private double valorizacion_programada; 
	private double valorizacion_ejecutada;
	private double valorizacion_acumulada;
	private double porcentaje_valorizado_acumulado;
	private String observacion;
 	private String usuario; 
	private String fecha_registro; 
	private String fecha_ultima_modificacion;
	private int activo;
	
	public Valorizacion() {
	
	}

	public Valorizacion(int id_valorizacion, int id_contrato_proceso_seleccion_item, String periodo,
			double valorizacion_programada, double valorizacion_ejecutada, double valorizacion_acumulada,
			double porcentaje_valorizado_acumulado, String observacion, String usuario, String fecha_registro,
			String fecha_ultima_modificacion, int activo) {

		this.id_valorizacion = id_valorizacion;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.periodo = periodo;
		this.valorizacion_programada = valorizacion_programada;
		this.valorizacion_ejecutada = valorizacion_ejecutada;
		this.valorizacion_acumulada = valorizacion_acumulada;
		this.porcentaje_valorizado_acumulado = porcentaje_valorizado_acumulado;
		this.observacion = observacion;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_valorizacion() {
		return id_valorizacion;
	}

	public void setId_valorizacion(int id_valorizacion) {
		this.id_valorizacion = id_valorizacion;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public double getValorizacion_programada() {
		return valorizacion_programada;
	}

	public void setValorizacion_programada(double valorizacion_programada) {
		this.valorizacion_programada = valorizacion_programada;
	}

	public double getValorizacion_ejecutada() {
		return valorizacion_ejecutada;
	}

	public void setValorizacion_ejecutada(double valorizacion_ejecutada) {
		this.valorizacion_ejecutada = valorizacion_ejecutada;
	}

	public double getValorizacion_acumulada() {
		return valorizacion_acumulada;
	}

	public void setValorizacion_acumulada(double valorizacion_acumulada) {
		this.valorizacion_acumulada = valorizacion_acumulada;
	}

	public double getPorcentaje_valorizado_acumulado() {
		return porcentaje_valorizado_acumulado;
	}

	public void setPorcentaje_valorizado_acumulado(double porcentaje_valorizado_acumulado) {
		this.porcentaje_valorizado_acumulado = porcentaje_valorizado_acumulado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
