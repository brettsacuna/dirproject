package entity;

public class Adicional {

	private int id_adicional;
	private int id_contrato_proceso_seleccion_item;
	private String resolucion_aprobacion_adicional;
	private String fecha_resolucion_aprobacion_adicional;
	private double monto_adicional_otorgado;
	private String motivo_generado;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Adicional() {

	}

	public Adicional(int id_adicional, int id_contrato_proceso_seleccion_item, String resolucion_aprobacion_adicional,
			String fecha_resolucion_aprobacion_adicional, double monto_adicional_otorgado, String motivo_generado,
			String usuario, String fecha_registro, String fecha_ultima_modificacion, int activo) {

		this.id_adicional = id_adicional;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.resolucion_aprobacion_adicional = resolucion_aprobacion_adicional;
		this.fecha_resolucion_aprobacion_adicional = fecha_resolucion_aprobacion_adicional;
		this.monto_adicional_otorgado = monto_adicional_otorgado;
		this.motivo_generado = motivo_generado;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_adicional() {
		return id_adicional;
	}

	public void setId_adicional(int id_adicional) {
		this.id_adicional = id_adicional;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getResolucion_aprobacion_adicional() {
		return resolucion_aprobacion_adicional;
	}

	public void setResolucion_aprobacion_adicional(String resolucion_aprobacion_adicional) {
		this.resolucion_aprobacion_adicional = resolucion_aprobacion_adicional;
	}

	public String getFecha_resolucion_aprobacion_adicional() {
		return fecha_resolucion_aprobacion_adicional;
	}

	public void setFecha_resolucion_aprobacion_adicional(String fecha_resolucion_aprobacion_adicional) {
		this.fecha_resolucion_aprobacion_adicional = fecha_resolucion_aprobacion_adicional;
	}

	public double getMonto_adicional_otorgado() {
		return monto_adicional_otorgado;
	}

	public void setMonto_adicional_otorgado(double monto_adicional_otorgado) {
		this.monto_adicional_otorgado = monto_adicional_otorgado;
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
