package sgomez.ejemplos.proyectopmul02.model;

/**
 * Created by sgomez on 14/12/2015.
 */
public class PagoAsoc {
    private String nombre;
    private Double cantidad;

    public PagoAsoc(String nombre, Double cantidad) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + "(" + cantidad + ")";
    }
}
