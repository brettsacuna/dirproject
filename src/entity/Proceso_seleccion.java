package entity;

public class Proceso_seleccion {
	
	private int id_proceso_seleccion;
	private int id_proyecto;
	private String proceso_seleccion_pertenencia;
	private String numero_proceso;
	private double valor_referencial;
	private String fecha_valor_referencial;
	private int plazo_ejecucion;
	private String modalidad_contratacion;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;
	
	public Proceso_seleccion() {
		
	}

	public Proceso_seleccion(int id_proceso_seleccion, int id_proyecto, String proceso_seleccion_pertenencia,
			String numero_proceso, double valor_referencial, String fecha_valor_referencial, int plazo_ejecucion,
			String modalidad_contratacion, String usuario, String fecha_registro, String fecha_ultima_modificacion,
			int activo) {
	
		this.id_proceso_seleccion = id_proceso_seleccion;
		this.id_proyecto = id_proyecto;
		this.proceso_seleccion_pertenencia = proceso_seleccion_pertenencia;
		this.numero_proceso = numero_proceso;
		this.valor_referencial = valor_referencial;
		this.fecha_valor_referencial = fecha_valor_referencial;
		this.plazo_ejecucion = plazo_ejecucion;
		this.modalidad_contratacion = modalidad_contratacion;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_proceso_seleccion() {
		return id_proceso_seleccion;
	}

	public void setId_proceso_seleccion(int id_proceso_seleccion) {
		this.id_proceso_seleccion = id_proceso_seleccion;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public String getProceso_seleccion_pertenencia() {
		return proceso_seleccion_pertenencia;
	}

	public void setProceso_seleccion_pertenencia(String proceso_seleccion_pertenencia) {
		this.proceso_seleccion_pertenencia = proceso_seleccion_pertenencia;
	}

	public String getNumero_proceso() {
		return numero_proceso;
	}

	public void setNumero_proceso(String numero_proceso) {
		this.numero_proceso = numero_proceso;
	}

	public double getValor_referencial() {
		return valor_referencial;
	}

	public void setValor_referencial(double valor_referencial) {
		this.valor_referencial = valor_referencial;
	}

	public String getFecha_valor_referencial() {
		return fecha_valor_referencial;
	}

	public void setFecha_valor_referencial(String fecha_valor_referencial) {
		this.fecha_valor_referencial = fecha_valor_referencial;
	}

	public int getPlazo_ejecucion() {
		return plazo_ejecucion;
	}

	public void setPlazo_ejecucion(int plazo_ejecucion) {
		this.plazo_ejecucion = plazo_ejecucion;
	}

	public String getModalidad_contratacion() {
		return modalidad_contratacion;
	}

	public void setModalidad_contratacion(String modalidad_contratacion) {
		this.modalidad_contratacion = modalidad_contratacion;
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
