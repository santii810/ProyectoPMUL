package sgomez.ejemplos.proyectopmul02.model;

/**
 * Created by sgomez on 28/11/2015.
 */
public class Cocina {
    private String idCocina;
    private String nombre;
    boolean activo;


    public Cocina(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public Cocina() {
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cocina(String idCocina) {
        this.idCocina = idCocina;
    }

    public String getIdCocina() {
        return idCocina;
    }

    public void setIdCocina(String idCocina) {
        this.idCocina = idCocina;
    }

    @Override
    public String toString() {
        return  nombre;
    }
}
