package entity;

public class Expediente_tecnico {

	private int id_expediente_tecnico;
	private int id_proyecto;
	private int id_item_proyecto;
	private String item_descripcion;
	private int id_tipo_informe_tecnico;
	private String informe_tecnico_modificaciones_etapa_inversion;
	private double monto_informe_tecnico_etapa_inversion;
	private String fecha_informe_tecnico_etapa_inversion;
	private String numero_proceso_expediente_tecnico;
	private double valor_referencial;
	private String modalidad_contratacion;
	private String fecha_presupuesto_base;
	private String postores;
	private double monto_adjudicado;
	private String contratista_adjudicado;
	private String ruc_contratista_adjudicado;
	private String fecha_otorgamiento;
	private String numero_contrato;
	private String fecha_firma_contrato;
	private int plazo_ejecucion_expediente_tecnico;
	private String tipo_ejecucion;
	private String observaciones;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Expediente_tecnico() {

	}

	public Expediente_tecnico(int id_expediente_tecnico, int id_proyecto, int id_item_proyecto, String item_descripcion,
			int id_tipo_informe_tecnico, String informe_tecnico_modificaciones_etapa_inversion,
			double monto_informe_tecnico_etapa_inversion, String fecha_informe_tecnico_etapa_inversion,
			String numero_proceso_expediente_tecnico, double valor_referencial, String modalidad_contratacion,
			String fecha_presupuesto_base, String postores, double monto_adjudicado, String contratista_adjudicado,
			String ruc_contratista_adjudicado, String fecha_otorgamiento, String numero_contrato,
			String fecha_firma_contrato, int plazo_ejecucion_expediente_tecnico, String tipo_ejecucion,
			String observaciones, String usuario, String fecha_registro, String fecha_ultima_modificacion, int activo) {
	
		this.id_expediente_tecnico = id_expediente_tecnico;
		this.id_proyecto = id_proyecto;
		this.id_item_proyecto = id_item_proyecto;
		this.item_descripcion = item_descripcion;
		this.id_tipo_informe_tecnico = id_tipo_informe_tecnico;
		this.informe_tecnico_modificaciones_etapa_inversion = informe_tecnico_modificaciones_etapa_inversion;
		this.monto_informe_tecnico_etapa_inversion = monto_informe_tecnico_etapa_inversion;
		this.fecha_informe_tecnico_etapa_inversion = fecha_informe_tecnico_etapa_inversion;
		this.numero_proceso_expediente_tecnico = numero_proceso_expediente_tecnico;
		this.valor_referencial = valor_referencial;
		this.modalidad_contratacion = modalidad_contratacion;
		this.fecha_presupuesto_base = fecha_presupuesto_base;
		this.postores = postores;
		this.monto_adjudicado = monto_adjudicado;
		this.contratista_adjudicado = contratista_adjudicado;
		this.ruc_contratista_adjudicado = ruc_contratista_adjudicado;
		this.fecha_otorgamiento = fecha_otorgamiento;
		this.numero_contrato = numero_contrato;
		this.fecha_firma_contrato = fecha_firma_contrato;
		this.plazo_ejecucion_expediente_tecnico = plazo_ejecucion_expediente_tecnico;
		this.tipo_ejecucion = tipo_ejecucion;
		this.observaciones = observaciones;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_expediente_tecnico() {
		return id_expediente_tecnico;
	}

	public void setId_expediente_tecnico(int id_expediente_tecnico) {
		this.id_expediente_tecnico = id_expediente_tecnico;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public int getId_item_proyecto() {
		return id_item_proyecto;
	}

	public void setId_item_proyecto(int id_item_proyecto) {
		this.id_item_proyecto = id_item_proyecto;
	}

	public String getItem_descripcion() {
		return item_descripcion;
	}

	public void setItem_descripcion(String item_descripcion) {
		this.item_descripcion = item_descripcion;
	}

	public int getId_tipo_informe_tecnico() {
		return id_tipo_informe_tecnico;
	}

	public void setId_tipo_informe_tecnico(int id_tipo_informe_tecnico) {
		this.id_tipo_informe_tecnico = id_tipo_informe_tecnico;
	}

	public String getInforme_tecnico_modificaciones_etapa_inversion() {
		return informe_tecnico_modificaciones_etapa_inversion;
	}

	public void setInforme_tecnico_modificaciones_etapa_inversion(String informe_tecnico_modificaciones_etapa_inversion) {
		this.informe_tecnico_modificaciones_etapa_inversion = informe_tecnico_modificaciones_etapa_inversion;
	}

	public double getMonto_informe_tecnico_etapa_inversion() {
		return monto_informe_tecnico_etapa_inversion;
	}

	public void setMonto_informe_tecnico_etapa_inversion(double monto_informe_tecnico_etapa_inversion) {
		this.monto_informe_tecnico_etapa_inversion = monto_informe_tecnico_etapa_inversion;
	}

	public String getFecha_informe_tecnico_etapa_inversion() {
		return fecha_informe_tecnico_etapa_inversion;
	}

	public void setFecha_informe_tecnico_etapa_inversion(String fecha_informe_tecnico_etapa_inversion) {
		this.fecha_informe_tecnico_etapa_inversion = fecha_informe_tecnico_etapa_inversion;
	}

	public String getNumero_proceso_expediente_tecnico() {
		return numero_proceso_expediente_tecnico;
	}

	public void setNumero_proceso_expediente_tecnico(String numero_proceso_expediente_tecnico) {
		this.numero_proceso_expediente_tecnico = numero_proceso_expediente_tecnico;
	}

	public double getValor_referencial() {
		return valor_referencial;
	}

	public void setValor_referencial(double valor_referencial) {
		this.valor_referencial = valor_referencial;
	}

	public String getModalidad_contratacion() {
		return modalidad_contratacion;
	}

	public void setModalidad_contratacion(String modalidad_contratacion) {
		this.modalidad_contratacion = modalidad_contratacion;
	}

	public String getFecha_presupuesto_base() {
		return fecha_presupuesto_base;
	}

	public void setFecha_presupuesto_base(String fecha_presupuesto_base) {
		this.fecha_presupuesto_base = fecha_presupuesto_base;
	}

	public String getPostores() {
		return postores;
	}

	public void setPostores(String postores) {
		this.postores = postores;
	}

	public double getMonto_adjudicado() {
		return monto_adjudicado;
	}

	public void setMonto_adjudicado(double monto_adjudicado) {
		this.monto_adjudicado = monto_adjudicado;
	}

	public String getContratista_adjudicado() {
		return contratista_adjudicado;
	}

	public void setContratista_adjudicado(String contratista_adjudicado) {
		this.contratista_adjudicado = contratista_adjudicado;
	}

	public String getRuc_contratista_adjudicado() {
		return ruc_contratista_adjudicado;
	}

	public void setRuc_contratista_adjudicado(String ruc_contratista_adjudicado) {
		this.ruc_contratista_adjudicado = ruc_contratista_adjudicado;
	}

	public String getFecha_otorgamiento() {
		return fecha_otorgamiento;
	}

	public void setFecha_otorgamiento(String fecha_otorgamiento) {
		this.fecha_otorgamiento = fecha_otorgamiento;
	}

	public String getNumero_contrato() {
		return numero_contrato;
	}

	public void setNumero_contrato(String numero_contrato) {
		this.numero_contrato = numero_contrato;
	}

	public String getFecha_firma_contrato() {
		return fecha_firma_contrato;
	}

	public void setFecha_firma_contrato(String fecha_firma_contrato) {
		this.fecha_firma_contrato = fecha_firma_contrato;
	}

	public int getPlazo_ejecucion_expediente_tecnico() {
		return plazo_ejecucion_expediente_tecnico;
	}

	public void setPlazo_ejecucion_expediente_tecnico(int plazo_ejecucion_expediente_tecnico) {
		this.plazo_ejecucion_expediente_tecnico = plazo_ejecucion_expediente_tecnico;
	}

	public String getTipo_ejecucion() {
		return tipo_ejecucion;
	}

	public void setTipo_ejecucion(String tipo_ejecucion) {
		this.tipo_ejecucion = tipo_ejecucion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
