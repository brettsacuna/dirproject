package entity;

public class Personal {

	private int id_personal;
	private int id_contrato_proceso_seleccion_item;
	private String nombre_completo;
	private String cargo_especialidad;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Personal() {

	}

	public Personal(int id_personal, int id_contrato_proceso_seleccion_item, String nombre_completo,
			String cargo_especialidad, String usuario, String fecha_registro, String fecha_ultima_modificacion,
			int activo) {

		this.id_personal = id_personal;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.nombre_completo = nombre_completo;
		this.cargo_especialidad = cargo_especialidad;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_personal() {
		return id_personal;
	}

	public void setId_personal(int id_personal) {
		this.id_personal = id_personal;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getCargo_especialidad() {
		return cargo_especialidad;
	}

	public void setCargo_especialidad(String cargo_especialidad) {
		this.cargo_especialidad = cargo_especialidad;
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
