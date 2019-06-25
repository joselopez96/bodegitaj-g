/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TOSHIBA
 */
public class Conexiondb {
public static Connection getConexion(){
    Connection cn=null;
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        cn=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=proyecto1;user=sa;password=admin01");
        System.out.println("Conexion exitosa");
    }catch(Exception e){
        System.err.println("Error de conexion "+e);
    }
    return cn;
}    

    public static void main(String[] args) {
        getConexion();
    }
}
