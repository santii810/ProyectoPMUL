package sgomez.ejemplos.proyectopmul02.model;

/**
 * Created by sgomez on 28/11/2015.
 */
public class Local {
    private String idLocal;
    private String nombre;
    private String direccion;
    private String tipoLocal;

    public Local(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Local() {
    }

    public Local(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
