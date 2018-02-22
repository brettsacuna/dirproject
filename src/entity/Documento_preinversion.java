package entity;

public class Documento_preinversion {
	
	private int id_documento_preinversion;
	private int id_proyecto; 
	private int id_tipo_documento_preinversion;
	private String tipo_documento_preinversion;
	private String documento_preinversion; 
	private String usuario;
	private String fecha_registro; 
	private String fecha_ultima_modificacion;
	private int activo;
	
	public Documento_preinversion() {
	
	}

	public Documento_preinversion(int id_documento_preinversion, int id_proyecto, int id_tipo_documento_preinversion,
			String tipo_documento_preinversion, String documento_preinversion, String usuario, String fecha_registro,
			String fecha_ultima_modificacion, int activo) {
	
		this.id_documento_preinversion = id_documento_preinversion;
		this.id_proyecto = id_proyecto;
		this.id_tipo_documento_preinversion = id_tipo_documento_preinversion;
		this.tipo_documento_preinversion = tipo_documento_preinversion;
		this.documento_preinversion = documento_preinversion;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_documento_preinversion() {
		return id_documento_preinversion;
	}

	public void setId_documento_preinversion(int id_documento_preinversion) {
		this.id_documento_preinversion = id_documento_preinversion;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public int getId_tipo_documento_preinversion() {
		return id_tipo_documento_preinversion;
	}

	public void setId_tipo_documento_preinversion(int id_tipo_documento_preinversion) {
		this.id_tipo_documento_preinversion = id_tipo_documento_preinversion;
	}

	public String getTipo_documento_preinversion() {
		return tipo_documento_preinversion;
	}

	public void setTipo_documento_preinversion(String tipo_documento_preinversion) {
		this.tipo_documento_preinversion = tipo_documento_preinversion;
	}

	public String getDocumento_preinversion() {
		return documento_preinversion;
	}

	public void setDocumento_preinversion(String documento_preinversion) {
		this.documento_preinversion = documento_preinversion;
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
