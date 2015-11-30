package sgomez.ejemplos.proyectopmul02.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sgomez on 28/11/2015.
 */
public class Extra {
    private String idExtra;
    private String idUsuario;
    private Date fechaExtra;
    private String momentoDia;
    private Local Local;
    private int cobrado;
    private double propina;
    private double pagoAsociado;
    private Festividad festividad;
    private Cocina cocina;
    private String notas;
    private double duracion;
    private ArrayList<Camarero> camareros;

    public void setLocal(Local local) {
        Local = local;
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

    public void setFechaExtra(Date fechaExtra) {
        this.fechaExtra = fechaExtra;
    }

    public void setFechaExtra(String fechaExtra) {
        this.fechaExtra = new Date(fechaExtra);
    }

    public String getMomentoDia() {
        return momentoDia;
    }

    public void setMomentoDia(String momentoDia) {
        this.momentoDia = momentoDia;
    }

    public Local getLocal() {
        return Local;
    }

    public void setIdLocal(String idLocal) {
        //falta buscar todos los datos en tabla local
        this.Local = new Local(idLocal);
    }

    public void setIdLocal(Local idLocal) {
        this.Local = idLocal;
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

    public Festividad getFestividad() {
        return festividad;
    }

    public void setFestividad(Festividad festividad) {
        this.festividad = festividad;
    }

    public void setFestividad(String idFestividad) {
        this.festividad = new Festividad(idFestividad);
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

    public void setCocina(Cocina cocina) {
        this.cocina = cocina;
    }
    public void setCocina(String idCocina) {
        this.cocina = new Cocina(idCocina);
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

    public Extra() {

    }
}
