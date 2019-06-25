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
public class meses {
    private int idmes;
    private String nomes;

    public meses(int idmes, String nomes) {
        this.idmes = idmes;
        this.nomes = nomes;
    }

    public meses() {
    }

    public int getIdmes() {
        return idmes;
    }

    public void setIdmes(int idmes) {
        this.idmes = idmes;
    }

    public String getNomes() {
        return nomes;
    }

    public void setNomes(String nomes) {
        this.nomes = nomes;
    }
    
    
}
