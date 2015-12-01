package model;

/**
 * Created by sgomez on 28/11/2015.
 */
public class Festividad {
    private String id;

    public Festividad() {
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public Festividad(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

