package entity;

public class TipoUsuario {

    private int id_tipo_usuario;
    private String tipo_usuario;
    private int eliminado;

    public TipoUsuario() {

    }

    public TipoUsuario(int tipo_usuario_id, String tipo_usuario, int eliminado) {
        this.id_tipo_usuario = tipo_usuario_id;
        this.tipo_usuario = tipo_usuario;
        this.eliminado = eliminado;
    }

    public int getTipo_usuario_id() {
        return id_tipo_usuario;
    }

    public void setTipo_usuario_id(int tipo_usuario_id) {
        this.id_tipo_usuario = tipo_usuario_id;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

}
