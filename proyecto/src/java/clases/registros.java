/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author TOSHIBA
 */
public class registros {
    private String idventa;
    private String nombrepro;
    private double precio;
    private int cantidad;
    private String iduser;
    private float importe;

    public registros() {
    }

    public registros(String idventa, String nombrepro, double precio, int cantidad, String iduser, float importe) {
        this.idventa = idventa;
        this.nombrepro = nombrepro;
        this.precio = precio;
        this.cantidad = cantidad;
        this.iduser = iduser;
        this.importe = importe;
    }

    public String getIdventa() {
        return idventa;
    }

    public void setIdventa(String idventa) {
        this.idventa = idventa;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    
    
    
}
