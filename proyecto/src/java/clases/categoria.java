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
public class categoria {
    private int idcate;
    private String nomcate;

    public categoria() {
    }

    public categoria(int idcate, String nomcate) {
        this.idcate = idcate;
        this.nomcate = nomcate;
    }

    public int getIdcate() {
        return idcate;
    }

    public void setIdcate(int idcate) {
        this.idcate = idcate;
    }

    public String getNomcate() {
        return nomcate;
    }

    public void setNomcate(String nomcate) {
        this.nomcate = nomcate;
    }
    
    
}
