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
public class usuarios {
    private String iduser;
    private String contra;
    private String nombre;
    private String dni;
    private String direccion;
    private String correo;
    private int nivel;

    public usuarios() {
    }

    public usuarios(String iduser, String contra, String nombre, String dni, String direccion, String correo, int nivel) {
        this.iduser = iduser;
        this.contra = contra;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.correo = correo;
        this.nivel = nivel;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
            
            
}
