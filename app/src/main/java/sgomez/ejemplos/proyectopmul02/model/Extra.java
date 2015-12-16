package sgomez.ejemplos.proyectopmul02.model;

import java.util.ArrayList;
import java.util.Date;

import sgomez.ejemplos.proyectopmul02.MainActivity;

/**
 * Created by sgomez on 28/11/2015.
 */
public class Extra {
    private String idExtra;
    private String idUsuario;
    private Date fechaExtra;
    private String momentoDia;
    private Local local;
    private int cobrado;
    private double propina;
    private double pagoAsociado;
    private String festividad;
    private Cocina cocina;
    private String notas;
    private double duracion;
    private ArrayList<Camarero> camareros;

    public Extra() {

    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public ArrayList<Camarero> getCamareros() {
        return camareros;
    }

    public void setCamareros(ArrayList<Camarero> camareros) {
        this.camareros = camareros;
    }

    public String getIdExtra() {
        return idExtra;
    }

    public void setIdExtra(String idExtra) {
        this.idExtra = idExtra;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaExtra() {
        return fechaExtra;
    }

    public void setFechaExtra(String fechaExtra) {
        this.fechaExtra = new Date(fechaExtra);
    }

    public void setFechaExtra(Date fechaExtra) {
        this.fechaExtra = fechaExtra;
    }

    public String getMomentoDia() {
        return momentoDia;
    }

    public void setMomentoDia(String momentoDia) {
        this.momentoDia = momentoDia;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(String idLocal) {
        this.local = MainActivity.getLocalRepository().getLocal(idLocal);
    }

    public void setIdLocal(String idLocal) {
        //falta buscar todos los datos en tabla local
        this.local = MainActivity.getLocalRepository().getLocal(idLocal);
    }

    public void setIdLocal(Local idLocal) {
        this.local = idLocal;
    }

    public int getCobrado() {
        return cobrado;
    }

    public void setCobrado(int cobrado) {
        this.cobrado = cobrado;
    }

    public double getPropina() {
        return propina;
    }

    public void setPropina(double propina) {
        this.propina = propina;
    }

    public String getFestividad() {
        return festividad;
    }

    public void setFestividad(String festividad) {
        this.festividad = festividad;
    }

    public double getPagoAsociado() {
        return pagoAsociado;
    }

    public void setPagoAsociado(double pagoAsociado) {
        this.pagoAsociado = pagoAsociado;
    }

    public Cocina getCocina() {
        return cocina;
    }

    public void setCocina(String idCocina) {
        this.cocina = MainActivity.getCocinaRepository().getCocina(idCocina);
    }

    public void setCocina(Cocina cocina) {
        this.cocina = cocina;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "idExtra='" + idExtra + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", fechaExtra=" + fechaExtra +
                ", momentoDia='" + momentoDia + '\'' +
                ", Local=" + local +
                ", cobrado=" + cobrado +
                ", propina=" + propina +
                ", pagoAsociado=" + pagoAsociado +
                ", festividad='" + festividad + '\'' +
                ", cocina=" + cocina +
                ", notas='" + notas + '\'' +
                ", duracion=" + duracion +
                ", camareros=" + camareros +
                '}';
    }
}
