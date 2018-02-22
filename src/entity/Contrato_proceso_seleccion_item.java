package entity;

public class Contrato_proceso_seleccion_item {

	private int id_contrato_proceso_seleccion_item;
	private int id_proceso_seleccion_item;
	private String fecha_adjudicacion;
	private double monto_adjudicado;
	private double monto_pagado;
	private double porcentaje_pagado;
	private String contratista_adjudicado;
	private String ruc_contratista;
	private String numero_contrato;
	private String fecha_firma_contrato;
	private String fecha_entrega_terreno;
	private int plazo_ejecucion;
	private String fecha_inicio_plazo_contractual;
	private int total_dias_ampliacion_plazo;
	private int total_adendas;
	private double monto_prestaciones_adicionales;
	private String observaciones;
	private String liquidacion;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;

	public Contrato_proceso_seleccion_item() {

	}

	public Contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item, int id_proceso_seleccion_item,
			String fecha_adjudicacion, double monto_adjudicado, double monto_pagado, double porcentaje_pagado,
			String contratista_adjudicado, String ruc_contratista, String numero_contrato, String fecha_firma_contrato,
			String fecha_entrega_terreno, int plazo_ejecucion, String fecha_inicio_plazo_contractual,
			int total_dias_ampliacion_plazo, int total_adendas, double monto_prestaciones_adicionales,
			String observaciones, String liquidacion, String usuario, String fecha_registro,
			String fecha_ultima_modificacion, int activo) {
		
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
		this.id_proceso_seleccion_item = id_proceso_seleccion_item;
		this.fecha_adjudicacion = fecha_adjudicacion;
		this.monto_adjudicado = monto_adjudicado;
		this.monto_pagado = monto_pagado;
		this.porcentaje_pagado = porcentaje_pagado;
		this.contratista_adjudicado = contratista_adjudicado;
		this.ruc_contratista = ruc_contratista;
		this.numero_contrato = numero_contrato;
		this.fecha_firma_contrato = fecha_firma_contrato;
		this.fecha_entrega_terreno = fecha_entrega_terreno;
		this.plazo_ejecucion = plazo_ejecucion;
		this.fecha_inicio_plazo_contractual = fecha_inicio_plazo_contractual;
		this.total_dias_ampliacion_plazo = total_dias_ampliacion_plazo;
		this.total_adendas = total_adendas;
		this.monto_prestaciones_adicionales = monto_prestaciones_adicionales;
		this.observaciones = observaciones;
		this.liquidacion = liquidacion;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_contrato_proceso_seleccion_item() {
		return id_contrato_proceso_seleccion_item;
	}

	public void setId_contrato_proceso_seleccion_item(int id_contrato_proceso_seleccion_item) {
		this.id_contrato_proceso_seleccion_item = id_contrato_proceso_seleccion_item;
	}

	public int getId_proceso_seleccion_item() {
		return id_proceso_seleccion_item;
	}

	public void setId_proceso_seleccion_item(int id_proceso_seleccion_item) {
		this.id_proceso_seleccion_item = id_proceso_seleccion_item;
	}

	public String getFecha_adjudicacion() {
		return fecha_adjudicacion;
	}

	public void setFecha_adjudicacion(String fecha_adjudicacion) {
		this.fecha_adjudicacion = fecha_adjudicacion;
	}

	public double getMonto_adjudicado() {
		return monto_adjudicado;
	}

	public void setMonto_adjudicado(double monto_adjudicado) {
		this.monto_adjudicado = monto_adjudicado;
	}

	public double getMonto_pagado() {
		return monto_pagado;
	}

	public void setMonto_pagado(double monto_pagado) {
		this.monto_pagado = monto_pagado;
	}

	public double getPorcentaje_pagado() {
		return porcentaje_pagado;
	}

	public void setPorcentaje_pagado(double porcentaje_pagado) {
		this.porcentaje_pagado = porcentaje_pagado;
	}

	public String getContratista_adjudicado() {
		return contratista_adjudicado;
	}

	public void setContratista_adjudicado(String contratista_adjudicado) {
		this.contratista_adjudicado = contratista_adjudicado;
	}

	public String getRuc_contratista() {
		return ruc_contratista;
	}

	public void setRuc_contratista(String ruc_contratista) {
		this.ruc_contratista = ruc_contratista;
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

	public String getFecha_entrega_terreno() {
		return fecha_entrega_terreno;
	}

	public void setFecha_entrega_terreno(String fecha_entrega_terreno) {
		this.fecha_entrega_terreno = fecha_entrega_terreno;
	}

	public int getPlazo_ejecucion() {
		return plazo_ejecucion;
	}

	public void setPlazo_ejecucion(int plazo_ejecucion) {
		this.plazo_ejecucion = plazo_ejecucion;
	}

	public String getFecha_inicio_plazo_contractual() {
		return fecha_inicio_plazo_contractual;
	}

	public void setFecha_inicio_plazo_contractual(String fecha_inicio_plazo_contractual) {
		this.fecha_inicio_plazo_contractual = fecha_inicio_plazo_contractual;
	}

	public int getTotal_dias_ampliacion_plazo() {
		return total_dias_ampliacion_plazo;
	}

	public void setTotal_dias_ampliacion_plazo(int total_dias_ampliacion_plazo) {
		this.total_dias_ampliacion_plazo = total_dias_ampliacion_plazo;
	}

	public int getTotal_adendas() {
		return total_adendas;
	}

	public void setTotal_adendas(int total_adendas) {
		this.total_adendas = total_adendas;
	}

	public double getMonto_prestaciones_adicionales() {
		return monto_prestaciones_adicionales;
	}

	public void setMonto_prestaciones_adicionales(double monto_prestaciones_adicionales) {
		this.monto_prestaciones_adicionales = monto_prestaciones_adicionales;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getLiquidacion() {
		return liquidacion;
	}

	public void setLiquidacion(String liquidacion) {
		this.liquidacion = liquidacion;
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
