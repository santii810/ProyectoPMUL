package sgomez.ejemplos.proyectopmul02.model;

/**
 * Created by sgomez on 29/11/2015.
 */
public class Camarero {
    private int idCamarero;
    private String Nombre;
    private boolean activo;

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(int id) {
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
}