package sgomez.ejemplos.proyectopmul02.model;

/**
 * Created by sgomez on 28/11/2015.
 */
public class Cocina {
    private int idCocina;
    private String nombre;
    boolean activa ;

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cocina(int idCocina) {
        this.idCocina = idCocina;
    }

    public int getIdCocina() {
        return idCocina;
    }

    public Cocina() {
    }

    public void setIdCocina(int idCocina) {
        this.idCocina = idCocina;
    }
}
