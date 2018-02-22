package entity;

public class Tipo_diagnostico {

	private int tipo_diagnostico_id;
	private String tipo_diagnostico;
	private String eliminado;

	public Tipo_diagnostico() {

	}

	public Tipo_diagnostico(int tipo_diagnostico_id, String tipo_diagnostico, String eliminado) {

		this.tipo_diagnostico_id = tipo_diagnostico_id;
		this.tipo_diagnostico = tipo_diagnostico;
		this.eliminado = eliminado;
	}

	public int getTipo_diagnostico_id() {
		return tipo_diagnostico_id;
	}

	public void setTipo_diagnostico_id(int tipo_diagnostico_id) {
		this.tipo_diagnostico_id = tipo_diagnostico_id;
	}

	public String getTipo_diagnostico() {
		return tipo_diagnostico;
	}

	public void setTipo_diagnostico(String tipo_diagnostico) {
		this.tipo_diagnostico = tipo_diagnostico;
	}

	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}

}
