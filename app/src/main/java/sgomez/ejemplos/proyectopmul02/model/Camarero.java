package sgomez.ejemplos.proyectopmul02.model;

/**
 * Created by sgomez on 29/11/2015.
 */
public class Camarero {
    private String idCamarero;
    private String Nombre;
    private boolean activo;

    public Camarero(String nombre, boolean activo) {
        Nombre = nombre;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(String id) {
        this.idCamarero = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Camarero() {

    }

    @Override
    public String toString() {
        return Nombre ;
    }
}
