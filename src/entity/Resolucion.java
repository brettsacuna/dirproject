package entity;

public class Resolucion {

	private int id_resolucion;
	private int id_contrato_proceso_seleccion_item;
	private String resolucion_conformacion_comite;
	private String fecha_resolucion;
	private String miembros;
	private String motivo_generado;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Resolucion() {

	}

	public Resolucion(int id_resolucion, int id_contrato_proceso_seleccion_item, String resolucion_conformacion_comite,
			String fecha_resolucion, String miembros, String motivo_generado, String usuario, String fecha_registro,
			String fecha_ultima_modificacion, int activo) {

		this.id_resolucion = id_resolucion;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.resolucion_conformacion_comite = resolucion_conformacion_comite;
		this.fecha_resolucion = fecha_resolucion;
		this.miembros = miembros;
		this.motivo_generado = motivo_generado;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_resolucion() {
		return id_resolucion;
	}

	public void setId_resolucion(int id_resolucion) {
		this.id_resolucion = id_resolucion;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getResolucion_conformacion_comite() {
		return resolucion_conformacion_comite;
	}

	public void setResolucion_conformacion_comite(String resolucion_conformacion_comite) {
		this.resolucion_conformacion_comite = resolucion_conformacion_comite;
	}

	public String getFecha_resolucion() {
		return fecha_resolucion;
	}

	public void setFecha_resolucion(String fecha_resolucion) {
		this.fecha_resolucion = fecha_resolucion;
	}

	public String getMiembros() {
		return miembros;
	}

	public void setMiembros(String miembros) {
		this.miembros = miembros;
	}

	public String getMotivo_generado() {
		return motivo_generado;
	}

	public void setMotivo_generado(String motivo_generado) {
		this.motivo_generado = motivo_generado;
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
