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
public class productosmasvend {
    private String codpro;
    private String nombrepro;
    private int cantidad;

    public productosmasvend(String codpro, String nombrepro, int cantidad) {
        this.codpro = codpro;
        this.nombrepro = nombrepro;
        this.cantidad = cantidad;
    }

    public productosmasvend() {
    }

    public String getCodpro() {
        return codpro;
    }

    public void setCodpro(String codpro) {
        this.codpro = codpro;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
