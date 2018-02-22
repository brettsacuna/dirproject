package entity;

public class Componentes {
	
	private int id_componente;
	private int id_proyecto;
	private int id_tipo_componente;
	private String componente;
	private double monto_componente_viable;
	private String observacion;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Componentes() {
		
	}

	public Componentes(int id_componente, int id_proyecto, int id_tipo_componente, String componente,
			double monto_componente_viable, String observacion, String usuario, String fecha_registro,
			String fecha_ultima_modificacion, int activo) {
		
		this.id_componente = id_componente;
		this.id_proyecto = id_proyecto;
		this.id_tipo_componente = id_tipo_componente;
		this.componente = componente;
		this.monto_componente_viable = monto_componente_viable;
		this.observacion = observacion;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_componente() {
		return id_componente;
	}

	public void setId_componente(int id_componente) {
		this.id_componente = id_componente;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public int getId_tipo_componente() {
		return id_tipo_componente;
	}

	public void setId_tipo_componente(int id_tipo_componente) {
		this.id_tipo_componente = id_tipo_componente;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

	public double getMonto_componente_viable() {
		return monto_componente_viable;
	}

	public void setMonto_componente_viable(double monto_componente_viable) {
		this.monto_componente_viable = monto_componente_viable;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
