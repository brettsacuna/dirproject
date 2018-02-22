package entity;

public class UsuarioView {
	private int id_usuario;
	private String nombrecompleto;
	private String usuario;
	private String email;
	private String contrasena;
	private int id_tipo_usuario;
	private String tipo_usuario;
	private int activo;
	public UsuarioView() {
		
	}
	public UsuarioView(int id_usuario, String nombrecompleto, String usuario,
			String email, String contrasena, int id_tipo_usuario,
			String tipo_usuario, int activo) {
		
		this.id_usuario = id_usuario;
		this.nombrecompleto = nombrecompleto;
		this.usuario = usuario;
		this.email = email;
		this.contrasena = contrasena;
		this.id_tipo_usuario = id_tipo_usuario;
		this.tipo_usuario = tipo_usuario;
		this.activo = activo;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}
	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}
	public String getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	

}
