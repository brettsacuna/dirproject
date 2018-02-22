package entity;

public class Adenda {

	private int id_adenda;
	private int id_contrato_proceso_seleccion_item;
	private String tipo_contrato;
	private String adenda_descripcion;
	private String fecha_suscripcion;
	private int plazo_otorgado;
	private String motivo_generado;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Adenda() {

	}

	public Adenda(int id_adenda, int id_contrato_proceso_seleccion_item, String tipo_contrato,
			String adenda_descripcion, String fecha_suscripcion, int plazo_otorgado, String motivo_generado,
			String usuario, String fecha_registro, String fecha_ultima_modificacion, int activo) {

		this.id_adenda = id_adenda;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.tipo_contrato = tipo_contrato;
		this.adenda_descripcion = adenda_descripcion;
		this.fecha_suscripcion = fecha_suscripcion;
		this.plazo_otorgado = plazo_otorgado;
		this.motivo_generado = motivo_generado;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_adenda() {
		return id_adenda;
	}

	public void setId_adenda(int id_adenda) {
		this.id_adenda = id_adenda;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getTipo_contrato() {
		return tipo_contrato;
	}

	public void setTipo_contrato(String tipo_contrato) {
		this.tipo_contrato = tipo_contrato;
	}

	public String getAdenda_descripcion() {
		return adenda_descripcion;
	}

	public void setAdenda_descripcion(String adenda_descripcion) {
		this.adenda_descripcion = adenda_descripcion;
	}

	public String getFecha_suscripcion() {
		return fecha_suscripcion;
	}

	public void setFecha_suscripcion(String fecha_suscripcion) {
		this.fecha_suscripcion = fecha_suscripcion;
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
