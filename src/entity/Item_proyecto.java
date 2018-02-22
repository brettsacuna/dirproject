package entity;

public class Item_proyecto {
	
	private int id_item_proyecto; 
	private int id_proyecto;
	private String item_descripcion; 
	private int etapa_proyecto; 
	private int estado_proyecto; 
	private String ubicacion; 
	private double presupuesto_expediente_tecnico; 
	private double valor_referencial; 
	private String usuario; 
	private String fecha_registro; 
	private String fecha_ultima_actualizacion; 
	private int activo;

	public Item_proyecto() {
	
	}

	public Item_proyecto(int id_item_proyecto, int id_proyecto, String item_descripcion, int etapa_proyecto,
			int estado_proyecto, String ubicacion, double presupuesto_expediente_tecnico, double valor_referencial,
			String usuario, String fecha_registro, String fecha_ultima_actualizacion, int activo) {
		
		this.id_item_proyecto = id_item_proyecto;
		this.id_proyecto = id_proyecto;
		this.item_descripcion = item_descripcion;
		this.etapa_proyecto = etapa_proyecto;
		this.estado_proyecto = estado_proyecto;
		this.ubicacion = ubicacion;
		this.presupuesto_expediente_tecnico = presupuesto_expediente_tecnico;
		this.valor_referencial = valor_referencial;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
		this.activo = activo;
	}

	public int getId_item_proyecto() {
		return id_item_proyecto;
	}

	public void setId_item_proyecto(int id_item_proyecto) {
		this.id_item_proyecto = id_item_proyecto;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public String getItem_descripcion() {
		return item_descripcion;
	}

	public void setItem_descripcion(String item_descripcion) {
		this.item_descripcion = item_descripcion;
	}

	public int getEtapa_proyecto() {
		return etapa_proyecto;
	}

	public void setEtapa_proyecto(int etapa_proyecto) {
		this.etapa_proyecto = etapa_proyecto;
	}

	public int getEstado_proyecto() {
		return estado_proyecto;
	}

	public void setEstado_proyecto(int estado_proyecto) {
		this.estado_proyecto = estado_proyecto;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public double getPresupuesto_expediente_tecnico() {
		return presupuesto_expediente_tecnico;
	}

	public void setPresupuesto_expediente_tecnico(double presupuesto_expediente_tecnico) {
		this.presupuesto_expediente_tecnico = presupuesto_expediente_tecnico;
	}

	public double getValor_referencial() {
		return valor_referencial;
	}

	public void setValor_referencial(double valor_referencial) {
		this.valor_referencial = valor_referencial;
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

	public String getFecha_ultima_actualizacion() {
		return fecha_ultima_actualizacion;
	}

	public void setFecha_ultima_actualizacion(String fecha_ultima_actualizacion) {
		this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
}
