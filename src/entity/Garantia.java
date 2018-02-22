package entity;

public class Garantia {

	private int id_garantia;
	private int id_contrato_proceso_seleccion_item;
	private String descripcion_garantia;
	private String factura;
	private String fecha_factura;
	private String tipo_garantia;
	private String institucion_financiera;
	private String numero_documento;
	private double monto_adelanto;
	private double monto_carta_fianza;
	private String fecha_creacion;
	private String fecha_vencimiento;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Garantia() {
//		super();
	}

	public Garantia(int id_garantia, int id_contrato_proceso_seleccion_item, String descripcion_garantia,
			String factura, String fecha_factura, String tipo_garantia, String institucion_financiera,
			String numero_documento, double monto_adelanto, double monto_carta_fianza, String fecha_creacion,
			String fecha_vencimiento, String usuario, String fecha_registro, String fecha_ultima_modificacion,
			int activo) {
		super();
		this.id_garantia = id_garantia;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.descripcion_garantia = descripcion_garantia;
		this.factura = factura;
		this.fecha_factura = fecha_factura;
		this.tipo_garantia = tipo_garantia;
		this.institucion_financiera = institucion_financiera;
		this.numero_documento = numero_documento;
		this.monto_adelanto = monto_adelanto;
		this.monto_carta_fianza = monto_carta_fianza;
		this.fecha_creacion = fecha_creacion;
		this.fecha_vencimiento = fecha_vencimiento;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_garantia() {
		return id_garantia;
	}

	public void setId_garantia(int id_garantia) {
		this.id_garantia = id_garantia;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getDescripcion_garantia() {
		return descripcion_garantia;
	}

	public void setDescripcion_garantia(String descripcion_garantia) {
		this.descripcion_garantia = descripcion_garantia;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public String getTipo_garantia() {
		return tipo_garantia;
	}

	public void setTipo_garantia(String tipo_garantia) {
		this.tipo_garantia = tipo_garantia;
	}

	public String getInstitucion_financiera() {
		return institucion_financiera;
	}

	public void setInstitucion_financiera(String institucion_financiera) {
		this.institucion_financiera = institucion_financiera;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public double getMonto_adelanto() {
		return monto_adelanto;
	}

	public void setMonto_adelanto(double monto_adelanto) {
		this.monto_adelanto = monto_adelanto;
	}

	public double getMonto_carta_fianza() {
		return monto_carta_fianza;
	}

	public void setMonto_carta_fianza(double monto_carta_fianza) {
		this.monto_carta_fianza = monto_carta_fianza;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
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
