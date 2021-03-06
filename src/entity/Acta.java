package entity;

public class Acta {

	private int id_acta;
	private int id_contrato_proceso_seleccion_item;
	private String acta_descripcion;
	private String fecha_acta;
	private String detalle_acta;
	private String motivo_generado;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Acta() {

	}

	public Acta(int id_acta, int id_contrato_proceso_seleccion_item, String acta_descripcion, String fecha_acta,
			String detalle_acta, String motivo_generado, String usuario, String fecha_registro,
			String fecha_ultima_modificacion, int activo) {

		this.id_acta = id_acta;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.acta_descripcion = acta_descripcion;
		this.fecha_acta = fecha_acta;
		this.detalle_acta = detalle_acta;
		this.motivo_generado = motivo_generado;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_acta() {
		return id_acta;
	}

	public void setId_acta(int id_acta) {
		this.id_acta = id_acta;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getActa_descripcion() {
		return acta_descripcion;
	}

	public void setActa_descripcion(String acta_descripcion) {
		this.acta_descripcion = acta_descripcion;
	}

	public String getFecha_acta() {
		return fecha_acta;
	}

	public void setFecha_acta(String fecha_acta) {
		this.fecha_acta = fecha_acta;
	}

	public String getDetalle_acta() {
		return detalle_acta;
	}

	public void setDetalle_acta(String detalle_acta) {
		this.detalle_acta = detalle_acta;
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
