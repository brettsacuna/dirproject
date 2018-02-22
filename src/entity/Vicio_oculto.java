package entity;

public class Vicio_oculto {

	private int id_vicio_oculto;
	private int id_contrato_proceso_supervision_item;
	private String asiento_cuaderno_obra;
	private String vicio_oculto;
	private String fecha_encontrado;
	private String acciones;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Vicio_oculto() {

	}

	public Vicio_oculto(int id_vicio_oculto, int id_contrato_proceso_supervision_item, String asiento_cuaderno_obra,
			String vicio_oculto, String fecha_encontrado, String acciones, String usuario, String fecha_registro,
			String fecha_ultima_modificacion, int activo) {

		this.id_vicio_oculto = id_vicio_oculto;
		this.id_contrato_proceso_supervision_item = id_contrato_proceso_supervision_item;
		this.asiento_cuaderno_obra = asiento_cuaderno_obra;
		this.vicio_oculto = vicio_oculto;
		this.fecha_encontrado = fecha_encontrado;
		this.acciones = acciones;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_vicio_oculto() {
		return id_vicio_oculto;
	}

	public void setId_vicio_oculto(int id_vicio_oculto) {
		this.id_vicio_oculto = id_vicio_oculto;
	}

	public int getId_contrato_proceso_supervision_item() {
		return id_contrato_proceso_supervision_item;
	}

	public void setId_contrato_proceso_supervision_item(int id_contrato_proceso_supervision_item) {
		this.id_contrato_proceso_supervision_item = id_contrato_proceso_supervision_item;
	}

	public String getAsiento_cuaderno_obra() {
		return asiento_cuaderno_obra;
	}

	public void setAsiento_cuaderno_obra(String asiento_cuaderno_obra) {
		this.asiento_cuaderno_obra = asiento_cuaderno_obra;
	}

	public String getVicio_oculto() {
		return vicio_oculto;
	}

	public void setVicio_oculto(String vicio_oculto) {
		this.vicio_oculto = vicio_oculto;
	}

	public String getFecha_encontrado() {
		return fecha_encontrado;
	}

	public void setFecha_encontrado(String fecha_encontrado) {
		this.fecha_encontrado = fecha_encontrado;
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
