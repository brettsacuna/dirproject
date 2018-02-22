package entity;

public class Otros_documentos {

	private int id_otro_documento;
	private int id_contrato_proceso_seleccion_item;
	private String informacion_especifica;
	private String fecha_informe;
	private String detalle;
	private String motivo_generado;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Otros_documentos() {

	}

	public Otros_documentos(int id_otro_documento, int id_contrato_proceso_seleccion_item,
			String informacion_especifica, String fecha_informe, String detalle, String motivo_generado, String usuario,
			String fecha_registro, String fecha_ultima_modificacion, int activo) {

		this.id_otro_documento = id_otro_documento;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.informacion_especifica = informacion_especifica;
		this.fecha_informe = fecha_informe;
		this.detalle = detalle;
		this.motivo_generado = motivo_generado;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_otro_documento() {
		return id_otro_documento;
	}

	public void setId_otro_documento(int id_otro_documento) {
		this.id_otro_documento = id_otro_documento;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getInformacion_especifica() {
		return informacion_especifica;
	}

	public void setInformacion_especifica(String informacion_especifica) {
		this.informacion_especifica = informacion_especifica;
	}

	public String getFecha_informe() {
		return fecha_informe;
	}

	public void setFecha_informe(String fecha_informe) {
		this.fecha_informe = fecha_informe;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
