package entity;

public class Datos_proyecto {

	private int id_proyecto; 
	private String codigo_snip;
	private String codigo_proyecto;
	private String etapa_proyecto;
	private String estado_proyecto;
	private String ubicacion;
	private String nombre_pip;
	private double presupuesto_viabilidad;
	private String consultor_preinversion;
	private String consultor_expediente_tecnico;
	private String resolucion_aprobacion_expediente_tecnico;
	private String fecha_resolucion_aprobacion_expediente_tecnico;
	private double presupuesto_expediente_tecnico;
	private double valor_referencial;
	private String resolucion_aprobacion_valor_referencial;
	private String fecha_resolucion_aprobacion_valor_referencial;
	private String resolucion_actualizacion_valor_referencial;
	private String fecha_resolucion_actualizacion_valor_referencial;
	private String informe_tecnico_declaratoria_viabilidad;
	private String fecha_informe_tecnico_declaratoria_viabilidad;
	private String beneficiarios_directos;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;
	
	public Datos_proyecto() {
		
	}

	public Datos_proyecto(int id_proyecto, String codigo_snip, String codigo_proyecto, String etapa_proyecto,
			String estado_proyecto, String ubicacion, String nombre_pip, double presupuesto_viabilidad,
			String consultor_preinversion, String consultor_expediente_tecnico,
			String resolucion_aprobacion_expediente_tecnico, String fecha_resolucion_aprobacion_expediente_tecnico,
			double presupuesto_expediente_tecnico, double valor_referencial,
			String resolucion_aprobacion_valor_referencial, String fecha_resolucion_aprobacion_valor_referencial,
			String resolucion_actualizacion_valor_referencial, String fecha_resolucion_actualizacion_valor_referencial,
			String informe_tecnico_declaratoria_viabilidad, String fecha_informe_tecnico_declaratoria_viabilidad,
			String beneficiarios_directos, String usuario, String fecha_registro, String fecha_ultima_modificacion,
			int activo) {
		super();
		this.id_proyecto = id_proyecto;
		this.codigo_snip = codigo_snip;
		this.codigo_proyecto = codigo_proyecto;
		this.etapa_proyecto = etapa_proyecto;
		this.estado_proyecto = estado_proyecto;
		this.ubicacion = ubicacion;
		this.nombre_pip = nombre_pip;
		this.presupuesto_viabilidad = presupuesto_viabilidad;
		this.consultor_preinversion = consultor_preinversion;
		this.consultor_expediente_tecnico = consultor_expediente_tecnico;
		this.resolucion_aprobacion_expediente_tecnico = resolucion_aprobacion_expediente_tecnico;
		this.fecha_resolucion_aprobacion_expediente_tecnico = fecha_resolucion_aprobacion_expediente_tecnico;
		this.presupuesto_expediente_tecnico = presupuesto_expediente_tecnico;
		this.valor_referencial = valor_referencial;
		this.resolucion_aprobacion_valor_referencial = resolucion_aprobacion_valor_referencial;
		this.fecha_resolucion_aprobacion_valor_referencial = fecha_resolucion_aprobacion_valor_referencial;
		this.resolucion_actualizacion_valor_referencial = resolucion_actualizacion_valor_referencial;
		this.fecha_resolucion_actualizacion_valor_referencial = fecha_resolucion_actualizacion_valor_referencial;
		this.informe_tecnico_declaratoria_viabilidad = informe_tecnico_declaratoria_viabilidad;
		this.fecha_informe_tecnico_declaratoria_viabilidad = fecha_informe_tecnico_declaratoria_viabilidad;
		this.beneficiarios_directos = beneficiarios_directos;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public String getCodigo_snip() {
		return codigo_snip;
	}

	public void setCodigo_snip(String codigo_snip) {
		this.codigo_snip = codigo_snip;
	}

	public String getCodigo_proyecto() {
		return codigo_proyecto;
	}

	public void setCodigo_proyecto(String codigo_proyecto) {
		this.codigo_proyecto = codigo_proyecto;
	}

	public String getEtapa_proyecto() {
		return etapa_proyecto;
	}

	public void setEtapa_proyecto(String etapa_proyecto) {
		this.etapa_proyecto = etapa_proyecto;
	}

	public String getEstado_proyecto() {
		return estado_proyecto;
	}

	public void setEstado_proyecto(String estado_proyecto) {
		this.estado_proyecto = estado_proyecto;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNombre_pip() {
		return nombre_pip;
	}

	public void setNombre_pip(String nombre_pip) {
		this.nombre_pip = nombre_pip;
	}

	public double getPresupuesto_viabilidad() {
		return presupuesto_viabilidad;
	}

	public void setPresupuesto_viabilidad(double presupuesto_viabilidad) {
		this.presupuesto_viabilidad = presupuesto_viabilidad;
	}

	public String getConsultor_preinversion() {
		return consultor_preinversion;
	}

	public void setConsultor_preinversion(String consultor_preinversion) {
		this.consultor_preinversion = consultor_preinversion;
	}

	public String getConsultor_expediente_tecnico() {
		return consultor_expediente_tecnico;
	}

	public void setConsultor_expediente_tecnico(String consultor_expediente_tecnico) {
		this.consultor_expediente_tecnico = consultor_expediente_tecnico;
	}

	public String getResolucion_aprobacion_expediente_tecnico() {
		return resolucion_aprobacion_expediente_tecnico;
	}

	public void setResolucion_aprobacion_expediente_tecnico(String resolucion_aprobacion_expediente_tecnico) {
		this.resolucion_aprobacion_expediente_tecnico = resolucion_aprobacion_expediente_tecnico;
	}

	public String getFecha_resolucion_aprobacion_expediente_tecnico() {
		return fecha_resolucion_aprobacion_expediente_tecnico;
	}

	public void setFecha_resolucion_aprobacion_expediente_tecnico(String fecha_resolucion_aprobacion_expediente_tecnico) {
		this.fecha_resolucion_aprobacion_expediente_tecnico = fecha_resolucion_aprobacion_expediente_tecnico;
	}

	public double getPresupuesto_expediente_tecnico() {
		return presupuesto_expediente_tecnico;
	}

	public void setPresupuesto_expediente_tecnico(double presupuesto_expediente_tecnico) {
		this.presupuesto_expediente_tecnico = presupuesto_expediente_tecnico;
	}

	public double getValor_referencial() {
		return valor_referencial;
	}

	public void setValor_referencial(double valor_referencial) {
		this.valor_referencial = valor_referencial;
	}

	public String getResolucion_aprobacion_valor_referencial() {
		return resolucion_aprobacion_valor_referencial;
	}

	public void setResolucion_aprobacion_valor_referencial(String resolucion_aprobacion_valor_referencial) {
		this.resolucion_aprobacion_valor_referencial = resolucion_aprobacion_valor_referencial;
	}

	public String getFecha_resolucion_aprobacion_valor_referencial() {
		return fecha_resolucion_aprobacion_valor_referencial;
	}

	public void setFecha_resolucion_aprobacion_valor_referencial(String fecha_resolucion_aprobacion_valor_referencial) {
		this.fecha_resolucion_aprobacion_valor_referencial = fecha_resolucion_aprobacion_valor_referencial;
	}

	public String getResolucion_actualizacion_valor_referencial() {
		return resolucion_actualizacion_valor_referencial;
	}

	public void setResolucion_actualizacion_valor_referencial(String resolucion_actualizacion_valor_referencial) {
		this.resolucion_actualizacion_valor_referencial = resolucion_actualizacion_valor_referencial;
	}

	public String getFecha_resolucion_actualizacion_valor_referencial() {
		return fecha_resolucion_actualizacion_valor_referencial;
	}

	public void setFecha_resolucion_actualizacion_valor_referencial(
			String fecha_resolucion_actualizacion_valor_referencial) {
		this.fecha_resolucion_actualizacion_valor_referencial = fecha_resolucion_actualizacion_valor_referencial;
	}

	public String getInforme_tecnico_declaratoria_viabilidad() {
		return informe_tecnico_declaratoria_viabilidad;
	}

	public void setInforme_tecnico_declaratoria_viabilidad(String informe_tecnico_declaratoria_viabilidad) {
		this.informe_tecnico_declaratoria_viabilidad = informe_tecnico_declaratoria_viabilidad;
	}

	public String getFecha_informe_tecnico_declaratoria_viabilidad() {
		return fecha_informe_tecnico_declaratoria_viabilidad;
	}

	public void setFecha_informe_tecnico_declaratoria_viabilidad(String fecha_informe_tecnico_declaratoria_viabilidad) {
		this.fecha_informe_tecnico_declaratoria_viabilidad = fecha_informe_tecnico_declaratoria_viabilidad;
	}

	public String getBeneficiarios_directos() {
		return beneficiarios_directos;
	}

	public void setBeneficiarios_directos(String beneficiarios_directos) {
		this.beneficiarios_directos = beneficiarios_directos;
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
