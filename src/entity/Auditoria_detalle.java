package entity;

public class Auditoria_detalle {

	private int id_auditoria_detalle;
	private int id_auditoria;
	private String auditoria_hallazgo;
	private String observaciones;
	private String recomendaciones;
	private String estado_implementacion_recomendacion;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_actualizacion;
	private int activo;

	public Auditoria_detalle() {

	}

	public Auditoria_detalle(int id_auditoria_detalle, int id_auditoria, String auditoria_hallazgo,
			String observaciones, String recomendaciones, String estado_implementacion_recomendacion, String usuario,
			String fecha_registro, String fecha_ultima_actualizacion, int activo) {

		this.id_auditoria_detalle = id_auditoria_detalle;
		this.id_auditoria = id_auditoria;
		this.auditoria_hallazgo = auditoria_hallazgo;
		this.observaciones = observaciones;
		this.recomendaciones = recomendaciones;
		this.estado_implementacion_recomendacion = estado_implementacion_recomendacion;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
		this.activo = activo;
	}

	public int getId_auditoria_detalle() {
		return id_auditoria_detalle;
	}

	public void setId_auditoria_detalle(int id_auditoria_detalle) {
		this.id_auditoria_detalle = id_auditoria_detalle;
	}

	public int getId_auditoria() {
		return id_auditoria;
	}

	public void setId_auditoria(int id_auditoria) {
		this.id_auditoria = id_auditoria;
	}

	public String getAuditoria_hallazgo() {
		return auditoria_hallazgo;
	}

	public void setAuditoria_hallazgo(String auditoria_hallazgo) {
		this.auditoria_hallazgo = auditoria_hallazgo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	public String getEstado_implementacion_recomendacion() {
		return estado_implementacion_recomendacion;
	}

	public void setEstado_implementacion_recomendacion(String estado_implementacion_recomendacion) {
		this.estado_implementacion_recomendacion = estado_implementacion_recomendacion;
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
