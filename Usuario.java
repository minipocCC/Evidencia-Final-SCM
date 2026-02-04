
package modelos;

/**
 *
 * @author saram
 */
public class Usuario {
        private String id;
    private String password;
    private String rol;

    public Usuario(String id, String password, String rol) {
        this.id = id;
        this.password = password;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

}
