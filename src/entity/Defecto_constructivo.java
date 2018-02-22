package entity;

public class Defecto_constructivo {

	private int id_defecto_constructivo;
	private int id_contrato_proceso_seleccion_item;
	private String asiento_cuaderno_obra;
	private String defecto_constructivo;
	private String fecha_encontrado;
	private String estado_defecto;
	private String acciones;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Defecto_constructivo() {

	}

	public Defecto_constructivo(int id_defecto_constructivo, int id_contrato_proceso_supervision_item,
			String asiento_cuaderno_obra, String defecto_constructivo, String fecha_encontrado, String estado_defecto,
			String acciones, String usuario, String fecha_registro, String fecha_ultima_modificacion, int activo) {

		this.id_defecto_constructivo = id_defecto_constructivo;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_supervision_item;
		this.asiento_cuaderno_obra = asiento_cuaderno_obra;
		this.defecto_constructivo = defecto_constructivo;
		this.fecha_encontrado = fecha_encontrado;
		this.estado_defecto = estado_defecto;
		this.acciones = acciones;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_defecto_constructivo() {
		return id_defecto_constructivo;
	}

	public void setId_defecto_constructivo(int id_defecto_constructivo) {
		this.id_defecto_constructivo = id_defecto_constructivo;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getAsiento_cuaderno_obra() {
		return asiento_cuaderno_obra;
	}

	public void setAsiento_cuaderno_obra(String asiento_cuaderno_obra) {
		this.asiento_cuaderno_obra = asiento_cuaderno_obra;
	}

	public String getDefecto_constructivo() {
		return defecto_constructivo;
	}

	public void setDefecto_constructivo(String defecto_constructivo) {
		this.defecto_constructivo = defecto_constructivo;
	}

	public String getFecha_encontrado() {
		return fecha_encontrado;
	}

	public void setFecha_encontrado(String fecha_encontrado) {
		this.fecha_encontrado = fecha_encontrado;
	}

	public String getEstado_defecto() {
		return estado_defecto;
	}

	public void setEstado_defecto(String estado_defecto) {
		this.estado_defecto = estado_defecto;
	}

	public String getAcciones() {
		return acciones;
	}

	public void setAcciones(String acciones) {
		this.acciones = acciones;
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
