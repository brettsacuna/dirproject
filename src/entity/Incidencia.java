package entity;

public class Incidencia {

	private int id_incidencia;
	private int id_contrato_proceso_seleccion_item;
	private String detalle_incidencia;
	private String motivo;
	private String asiento_cuaderno_obra;
	private String fecha_evento;
	private String fecha_asiento;
	private String acciones;
	private String documento_emitido;
	private String sumilla;
	private String objeto_incidencia;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Incidencia() {

	}

	public Incidencia(int id_incidencia, int id_contrato_proceso_seleccion_item, String detalle_incidencia,
			String motivo, String asiento_cuaderno_obra, String fecha_evento, String fecha_asiento, String acciones,
			String documento_emitido, String sumilla, String objeto_incidencia, String usuario, String fecha_registro,
			String fecha_ultima_modificacion, int activo) {

		this.id_incidencia = id_incidencia;
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.detalle_incidencia = detalle_incidencia;
		this.motivo = motivo;
		this.asiento_cuaderno_obra = asiento_cuaderno_obra;
		this.fecha_evento = fecha_evento;
		this.fecha_asiento = fecha_asiento;
		this.acciones = acciones;
		this.documento_emitido = documento_emitido;
		this.sumilla = sumilla;
		this.objeto_incidencia = objeto_incidencia;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_incidencia() {
		return id_incidencia;
	}

	public void setId_incidencia(int id_incidencia) {
		this.id_incidencia = id_incidencia;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public String getDetalle_incidencia() {
		return detalle_incidencia;
	}

	public void setDetalle_incidencia(String detalle_incidencia) {
		this.detalle_incidencia = detalle_incidencia;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getAsiento_cuaderno_obra() {
		return asiento_cuaderno_obra;
	}

	public void setAsiento_cuaderno_obra(String asiento_cuaderno_obra) {
		this.asiento_cuaderno_obra = asiento_cuaderno_obra;
	}

	public String getFecha_evento() {
		return fecha_evento;
	}

	public void setFecha_evento(String fecha_evento) {
		this.fecha_evento = fecha_evento;
	}

	public String getFecha_asiento() {
		return fecha_asiento;
	}

	public void setFecha_asiento(String fecha_asiento) {
		this.fecha_asiento = fecha_asiento;
	}

	public String getAcciones() {
		return acciones;
	}

	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}

	public String getDocumento_emitido() {
		return documento_emitido;
	}

	public void setDocumento_emitido(String documento_emitido) {
		this.documento_emitido = documento_emitido;
	}

	public String getSumilla() {
		return sumilla;
	}

	public void setSumilla(String sumilla) {
		this.sumilla = sumilla;
	}

	public String getObjeto_incidencia() {
		return objeto_incidencia;
	}

	public void setObjeto_incidencia(String objeto_incidencia) {
		this.objeto_incidencia = objeto_incidencia;
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
