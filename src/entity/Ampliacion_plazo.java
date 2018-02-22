package entity;

public class Ampliacion_plazo {

	private int id_ampliacion_plazo;
	private int id_contrato_proceso_seleccion_item;
	private String resolucion_aprobacion_ampliacion_plazo;
	private String fecha_resolucion_aprobacion_ampliacion_plazo;
	private int plazo_otorgado;
	private String motivo_generado;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Ampliacion_plazo() {

	}

	public Ampliacion_plazo(int id_ampliacion_plazo, int id_contrato_proceso_seleccion_item,
			String resolucion_aprobacion_ampliacion_plazo, String fecha_resolucion_aprobacion_ampliacion_plazo,
			int plazo_otorgado, String motivo_generado, String usuario, String fecha_registro,
			String fecha_ultima_modificacion, int activo) {

		this.id_ampliacion_plazo = id_ampliacion_plazo;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.resolucion_aprobacion_ampliacion_plazo = resolucion_aprobacion_ampliacion_plazo;
		this.fecha_resolucion_aprobacion_ampliacion_plazo = fecha_resolucion_aprobacion_ampliacion_plazo;
		this.plazo_otorgado = plazo_otorgado;
		this.motivo_generado = motivo_generado;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_ampliacion_plazo() {
		return id_ampliacion_plazo;
	}

	public void setId_ampliacion_plazo(int id_ampliacion_plazo) {
		this.id_ampliacion_plazo = id_ampliacion_plazo;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getResolucion_aprobacion_ampliacion_plazo() {
		return resolucion_aprobacion_ampliacion_plazo;
	}

	public void setResolucion_aprobacion_ampliacion_plazo(String resolucion_aprobacion_ampliacion_plazo) {
		this.resolucion_aprobacion_ampliacion_plazo = resolucion_aprobacion_ampliacion_plazo;
	}

	public String getFecha_resolucion_aprobacion_ampliacion_plazo() {
		return fecha_resolucion_aprobacion_ampliacion_plazo;
	}

	public void setFecha_resolucion_aprobacion_ampliacion_plazo(String fecha_resolucion_aprobacion_ampliacion_plazo) {
		this.fecha_resolucion_aprobacion_ampliacion_plazo = fecha_resolucion_aprobacion_ampliacion_plazo;
	}

	public int getPlazo_otorgado() {
		return plazo_otorgado;
	}

	public void setPlazo_otorgado(int plazo_otorgado) {
		this.plazo_otorgado = plazo_otorgado;
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
