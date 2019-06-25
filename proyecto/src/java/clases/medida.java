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
public class medida {
    private int idmed;
    private String nomed;

    public medida(int idmed, String nomed) {
        this.idmed = idmed;
        this.nomed = nomed;
    }

    public medida() {
    }

    public int getIdmed() {
        return idmed;
    }

    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    public String getNomed() {
        return nomed;
    }

    public void setNomed(String nomed) {
        this.nomed = nomed;
    }
    
    
}
