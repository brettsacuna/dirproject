package entity;

public class Tabla_snip {

	private int id_codigo_snip;
	private String codigo_snip;
	private String nombre_pip;
	private double monto_viabilidad;
	private String funcion;
	private String programa;
	private String sub_programa;
	private String situacion;
	private String estado_pip;
	private String nivel;
	private String sector;
	private String pliego;
	private String uf;
	private String sector_evaluadora;
	private String pliego_evaluadora;
	private String evaluadora;
	private String ejecutora;
	private String fecha_registro;
	private String ultimo_estudio;
	private String estado_estudio;
	private String nivel_viabilidad;
	private String responsable;
	private String fecha_viabilidad;
	private String con_f15;
	private String con_f14;
	private double monto_f15;
	private double monto_f16;
	private double monto_verificacion_viabilidad;
	private double monto_laudo;
	private double monto_carta_fianza;
	private double costo;
	private String descripcion_alternativa;
	private String beneficiarios;
	private String codigo_siaf;
	private double pia_anio_actual;
	private double pim_anio_actual;
	private double devengado_acumulado;
	private String cerrado;
	private String departamento;
	private String provincia;
	private String distrito;
	private String centro_poblado;

	public Tabla_snip() {

	}

	public Tabla_snip(int id_codigo_snip, String codigo_snip, String nombre_pip, double monto_viabilidad,
			String funcion, String programa, String sub_programa, String situacion, String estado_pip, String nivel,
			String sector, String pliego, String uf, String sector_evaluadora, String pliego_evaluadora,
			String evaluadora, String ejecutora, String fecha_registro, String ultimo_estudio, String estado_estudio,
			String nivel_viabilidad, String responsable, String fecha_viabilidad, String con_f15, String con_f14,
			double monto_f15, double monto_f16, double monto_verificacion_viabilidad, double monto_laudo,
			double monto_carta_fianza, double costo, String descripcion_alternativa, String beneficiarios,
			String codigo_siaf, double pia_anio_actual, double pim_anio_actual, double devengado_acumulado,
			String cerrado, String departamento, String provincia, String distrito, String centro_poblado) {
		super();
		this.id_codigo_snip = id_codigo_snip;
		this.codigo_snip = codigo_snip;
		this.nombre_pip = nombre_pip;
		this.monto_viabilidad = monto_viabilidad;
		this.funcion = funcion;
		this.programa = programa;
		this.sub_programa = sub_programa;
		this.situacion = situacion;
		this.estado_pip = estado_pip;
		this.nivel = nivel;
		this.sector = sector;
		this.pliego = pliego;
		this.uf = uf;
		this.sector_evaluadora = sector_evaluadora;
		this.pliego_evaluadora = pliego_evaluadora;
		this.evaluadora = evaluadora;
		this.ejecutora = ejecutora;
		this.fecha_registro = fecha_registro;
		this.ultimo_estudio = ultimo_estudio;
		this.estado_estudio = estado_estudio;
		this.nivel_viabilidad = nivel_viabilidad;
		this.responsable = responsable;
		this.fecha_viabilidad = fecha_viabilidad;
		this.con_f15 = con_f15;
		this.con_f14 = con_f14;
		this.monto_f15 = monto_f15;
		this.monto_f16 = monto_f16;
		this.monto_verificacion_viabilidad = monto_verificacion_viabilidad;
		this.monto_laudo = monto_laudo;
		this.monto_carta_fianza = monto_carta_fianza;
		this.costo = costo;
		this.descripcion_alternativa = descripcion_alternativa;
		this.beneficiarios = beneficiarios;
		this.codigo_siaf = codigo_siaf;
		this.pia_anio_actual = pia_anio_actual;
		this.pim_anio_actual = pim_anio_actual;
		this.devengado_acumulado = devengado_acumulado;
		this.cerrado = cerrado;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.centro_poblado = centro_poblado;
	}

	public int getId_codigo_snip() {
		return id_codigo_snip;
	}

	public void setId_codigo_snip(int id_codigo_snip) {
		this.id_codigo_snip = id_codigo_snip;
	}

	public String getCodigo_snip() {
		return codigo_snip;
	}

	public void setCodigo_snip(String codigo_snip) {
		this.codigo_snip = codigo_snip;
	}

	public String getNombre_pip() {
		return nombre_pip;
	}

	public void setNombre_pip(String nombre_pip) {
		this.nombre_pip = nombre_pip;
	}

	public double getMonto_viabilidad() {
		return monto_viabilidad;
	}

	public void setMonto_viabilidad(double monto_viabilidad) {
		this.monto_viabilidad = monto_viabilidad;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getSub_programa() {
		return sub_programa;
	}

	public void setSub_programa(String sub_programa) {
		this.sub_programa = sub_programa;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getEstado_pip() {
		return estado_pip;
	}

	public void setEstado_pip(String estado_pip) {
		this.estado_pip = estado_pip;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getPliego() {
		return pliego;
	}

	public void setPliego(String pliego) {
		this.pliego = pliego;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getSector_evaluadora() {
		return sector_evaluadora;
	}

	public void setSector_evaluadora(String sector_evaluadora) {
		this.sector_evaluadora = sector_evaluadora;
	}

	public String getPliego_evaluadora() {
		return pliego_evaluadora;
	}

	public void setPliego_evaluadora(String pliego_evaluadora) {
		this.pliego_evaluadora = pliego_evaluadora;
	}

	public String getEvaluadora() {
		return evaluadora;
	}

	public void setEvaluadora(String evaluadora) {
		this.evaluadora = evaluadora;
	}

	public String getEjecutora() {
		return ejecutora;
	}

	public void setEjecutora(String ejecutora) {
		this.ejecutora = ejecutora;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getUltimo_estudio() {
		return ultimo_estudio;
	}

	public void setUltimo_estudio(String ultimo_estudio) {
		this.ultimo_estudio = ultimo_estudio;
	}

	public String getEstado_estudio() {
		return estado_estudio;
	}

	public void setEstado_estudio(String estado_estudio) {
		this.estado_estudio = estado_estudio;
	}

	public String getNivel_viabilidad() {
		return nivel_viabilidad;
	}

	public void setNivel_viabilidad(String nivel_viabilidad) {
		this.nivel_viabilidad = nivel_viabilidad;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getFecha_viabilidad() {
		return fecha_viabilidad;
	}

	public void setFecha_viabilidad(String fecha_viabilidad) {
		this.fecha_viabilidad = fecha_viabilidad;
	}

	public String getCon_f15() {
		return con_f15;
	}

	public void setCon_f15(String con_f15) {
		this.con_f15 = con_f15;
	}

	public String getCon_f14() {
		return con_f14;
	}

	public void setCon_f14(String con_f14) {
		this.con_f14 = con_f14;
	}

	public double getMonto_f15() {
		return monto_f15;
	}

	public void setMonto_f15(double monto_f15) {
		this.monto_f15 = monto_f15;
	}

	public double getMonto_f16() {
		return monto_f16;
	}

	public void setMonto_f16(double monto_f16) {
		this.monto_f16 = monto_f16;
	}

	public double getMonto_verificacion_viabilidad() {
		return monto_verificacion_viabilidad;
	}

	public void setMonto_verificacion_viabilidad(double monto_verificacion_viabilidad) {
		this.monto_verificacion_viabilidad = monto_verificacion_viabilidad;
	}

	public double getMonto_laudo() {
		return monto_laudo;
	}

	public void setMonto_laudo(double monto_laudo) {
		this.monto_laudo = monto_laudo;
	}

	public double getMonto_carta_fianza() {
		return monto_carta_fianza;
	}

	public void setMonto_carta_fianza(double monto_carta_fianza) {
		this.monto_carta_fianza = monto_carta_fianza;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getDescripcion_alternativa() {
		return descripcion_alternativa;
	}

	public void setDescripcion_alternativa(String descripcion_alternativa) {
		this.descripcion_alternativa = descripcion_alternativa;
	}

	public String getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(String beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public String getCodigo_siaf() {
		return codigo_siaf;
	}

	public void setCodigo_siaf(String codigo_siaf) {
		this.codigo_siaf = codigo_siaf;
	}

	public double getPia_anio_actual() {
		return pia_anio_actual;
	}

	public void setPia_anio_actual(double pia_anio_actual) {
		this.pia_anio_actual = pia_anio_actual;
	}

	public double getPim_anio_actual() {
		return pim_anio_actual;
	}

	public void setPim_anio_actual(double pim_anio_actual) {
		this.pim_anio_actual = pim_anio_actual;
	}

	public double getDevengado_acumulado() {
		return devengado_acumulado;
	}

	public void setDevengado_acumulado(double devengado_acumulado) {
		this.devengado_acumulado = devengado_acumulado;
	}

	public String getCerrado() {
		return cerrado;
	}

	public void setCerrado(String cerrado) {
		this.cerrado = cerrado;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCentro_poblado() {
		return centro_poblado;
	}

	public void setCentro_poblado(String centro_poblado) {
		this.centro_poblado = centro_poblado;
	}

}
