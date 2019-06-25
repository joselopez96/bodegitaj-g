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
public class topcliente {
    private String nombre;
    private String dni;
    private String direccion;
    private String correo;
    private String mes;
    private double importe;

    public topcliente(String nombre, String dni, String direccion, String correo, String mes, double importe) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.correo = correo;
        this.mes = mes;
        this.importe = importe;
    }

    public topcliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
}
