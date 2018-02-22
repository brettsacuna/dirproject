package entity;

public class Proceso_seleccion_item {

	private int id_proceso_seleccion_item;
	private int id_proceso_seleccion;
	private int id_item_proyecto;
	private String item_descripcion;
	private double valor_referencial;
	private String fecha_valor_referencial;
	private int plazo_ejecucion;
	private String situacion;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Proceso_seleccion_item() {

	}

	public Proceso_seleccion_item(int id_proceso_seleccion_item, int id_proceso_seleccion, int id_item_proyecto,
			String item_descripcion, double valor_referencial, String fecha_valor_referencial, int plazo_ejecucion,
			String situacion, String usuario, String fecha_registro, String fecha_ultima_modificacion, int activo) {
	
		this.id_proceso_seleccion_item = id_proceso_seleccion_item;
		this.id_proceso_seleccion = id_proceso_seleccion;
		this.id_item_proyecto = id_item_proyecto;
		this.item_descripcion = item_descripcion;
		this.valor_referencial = valor_referencial;
		this.fecha_valor_referencial = fecha_valor_referencial;
		this.plazo_ejecucion = plazo_ejecucion;
		this.situacion = situacion;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_proceso_seleccion_item() {
		return id_proceso_seleccion_item;
	}

	public void setId_proceso_seleccion_item(int id_proceso_seleccion_item) {
		this.id_proceso_seleccion_item = id_proceso_seleccion_item;
	}

	public int getId_proceso_seleccion() {
		return id_proceso_seleccion;
	}

	public void setId_proceso_seleccion(int id_proceso_seleccion) {
		this.id_proceso_seleccion = id_proceso_seleccion;
	}

	public int getId_item_proyecto() {
		return id_item_proyecto;
	}

	public void setId_item_proyecto(int id_item_proyecto) {
		this.id_item_proyecto = id_item_proyecto;
	}

	public String getItem_descripcion() {
		return item_descripcion;
	}

	public void setItem_descripcion(String item_descripcion) {
		this.item_descripcion = item_descripcion;
	}

	public double getValor_referencial() {
		return valor_referencial;
	}

	public void setValor_referencial(double valor_referencial) {
		this.valor_referencial = valor_referencial;
	}

	public String getFecha_valor_referencial() {
		return fecha_valor_referencial;
	}

	public void setFecha_valor_referencial(String fecha_valor_referencial) {
		this.fecha_valor_referencial = fecha_valor_referencial;
	}

	public int getPlazo_ejecucion() {
		return plazo_ejecucion;
	}

	public void setPlazo_ejecucion(int plazo_ejecucion) {
		this.plazo_ejecucion = plazo_ejecucion;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
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
