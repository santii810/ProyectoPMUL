package sgomez.ejemplos.proyectopmul02.model;

/**
 * Created by sgomez on 12/12/2015.
 */
public class Usuario {
    private String id;
    private String nombre;

    public Usuario(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
}
