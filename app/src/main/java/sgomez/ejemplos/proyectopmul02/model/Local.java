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

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public Local() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Local(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }


    @Override
    public String toString() {
        return nombre ;
    }
}
