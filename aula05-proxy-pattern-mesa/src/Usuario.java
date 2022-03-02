public class Usuario {

    private String id;
    private String tipoUsuario;

    public Usuario(String id, String tipoUsuario) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
