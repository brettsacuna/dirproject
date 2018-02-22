package entity;

public class Presupuesto {
	
	private int id_presupuesto;
	private int id_proyecto;
	private double pia;
	private int anio_pim;
	private double pim;
	private int anio_pia;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;
	
	public Presupuesto() {
	
	}

	public Presupuesto(int id_presupuesto, int id_proyecto, double pia, int anio_pim, double pim, int anio_pia,
			String usuario, String fecha_registro, String fecha_ultima_modificacion, int activo) {
	
		this.id_presupuesto = id_presupuesto;
		this.id_proyecto = id_proyecto;
		this.pia = pia;
		this.anio_pim = anio_pim;
		this.pim = pim;
		this.anio_pia = anio_pia;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
	}

	public int getId_presupuesto() {
		return id_presupuesto;
	}

	public void setId_presupuesto(int id_presupuesto) {
		this.id_presupuesto = id_presupuesto;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public double getPia() {
		return pia;
	}

	public void setPia(double pia) {
		this.pia = pia;
	}

	public int getAnio_pim() {
		return anio_pim;
	}

	public void setAnio_pim(int anio_pim) {
		this.anio_pim = anio_pim;
	}

	public double getPim() {
		return pim;
	}

	public void setPim(double pim) {
		this.pim = pim;
	}

	public int getAnio_pia() {
		return anio_pia;
	}

	public void setAnio_pia(int anio_pia) {
		this.anio_pia = anio_pia;
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
