package sgomez.ejemplos.proyectopmul02.model;

/**
 * Created by sgomez on 28/11/2015.
 */
public class Festividad {
    private int id;

    public Festividad() {
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public Festividad(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

