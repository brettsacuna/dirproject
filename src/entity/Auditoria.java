package entity;

public class Auditoria {

	private int id_auditoria;
	private int id_contrato_proceso_seleccion_item;
	private String tipo_auditoria;
	private String jefe_auditoria;
	private String nombre_auditor;
	private String documento_auditoria;
	private String numero_auditoria;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Auditoria() {

	}

	public Auditoria(int id_auditoria, int id_contrato_proceso_seleccion_item, String tipo_auditoria,
			String jefe_auditoria, String nombre_auditor, String documento_auditoria, String numero_auditoria,
			String usuario, String fecha_registro, String fecha_ultima_modificacion, int activo) {

		this.id_auditoria = id_auditoria;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.tipo_auditoria = tipo_auditoria;
		this.jefe_auditoria = jefe_auditoria;
		this.nombre_auditor = nombre_auditor;
		this.documento_auditoria = documento_auditoria;
		this.numero_auditoria = numero_auditoria;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_auditoria() {
		return id_auditoria;
	}

	public void setId_auditoria(int id_auditoria) {
		this.id_auditoria = id_auditoria;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getTipo_auditoria() {
		return tipo_auditoria;
	}

	public void setTipo_auditoria(String tipo_auditoria) {
		this.tipo_auditoria = tipo_auditoria;
	}

	public String getJefe_auditoria() {
		return jefe_auditoria;
	}

	public void setJefe_auditoria(String jefe_auditoria) {
		this.jefe_auditoria = jefe_auditoria;
	}

	public String getNombre_auditor() {
		return nombre_auditor;
	}

	public void setNombre_auditor(String nombre_auditor) {
		this.nombre_auditor = nombre_auditor;
	}

	public String getDocumento_auditoria() {
		return documento_auditoria;
	}

	public void setDocumento_auditoria(String documento_auditoria) {
		this.documento_auditoria = documento_auditoria;
	}

	public String getNumero_auditoria() {
		return numero_auditoria;
	}

	public void setNumero_auditoria(String numero_auditoria) {
		this.numero_auditoria = numero_auditoria;
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
