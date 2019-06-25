/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Productos;
import clases.Productosadmin;
import clases.categoria;
import clases.medida;
import clases.meses;
import clases.registros;
import clases.usuarios;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.naming.spi.DirStateFactory;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import utils.Conexiondb;

/**
 *
 * @author TOSHIBA
 */
public class ProductosDAO {

    public ArrayList<Productos> listarprod(){
        ArrayList <Productos> lista= new ArrayList<>();
        try{
          CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call listaprod}");
//PreparedStatement cs=Conexiondb.getConexion().prepareStatement("select codpro, nombrepro, descripcion,precio,stock,medpro,imagen from productos");
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                Blob imagenes=rs.getBlob(8);
                Productos p= new Productos(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6),rs.getString(7), imagenes);
                
             lista.add(p);
            }
            
        }catch(Exception e){System.out.println("1"+e);}
        
        return lista;
    }
      public ArrayList<Productos> clientecate(int idcate){
        ArrayList <Productos> lista= new ArrayList<>();
        try{
          CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call buscacliente(?)}");
          cs.setInt(1, idcate);
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                Blob imagenes=rs.getBlob(8);
                Productos p= new Productos(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6),rs.getString(7), imagenes);
                
             lista.add(p);
            }
            
        }catch(Exception e){System.out.println("x"+e);}
        
        return lista;
    }
    
    public ArrayList<Productosadmin> listarprodadmin(){
        ArrayList <Productosadmin> lista= new ArrayList<>();
        try{
          CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call listaprodamin}");
//PreparedStatement cs=Conexiondb.getConexion().prepareStatement("select codpro, nombrepro, descripcion,precio,stock,medpro,imagen from productos");
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                Blob imagenes=rs.getBlob(7);
                Productosadmin p= new Productosadmin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6),rs.getString(7), imagenes);
                
             lista.add(p);
            }
            
        }catch(Exception e){System.out.println("2"+e);}
        
        return lista;
    }
    
   
    
    public void insertar(String nombre, String descripcion,double precio,int stock,int medpro,int cate,InputStream imagen){
      
        try{
            CallableStatement cstm=Conexiondb.getConexion().prepareCall("{Call newprod(?,?,?,?,?,?,?)}");
             cstm.setString(1, nombre);
              cstm.setString(2, descripcion);
               cstm.setDouble(3, precio);
                cstm.setInt(4, stock);
                 cstm.setInt(5, medpro);
                 cstm.setInt(6, cate);
                  cstm.setBlob(7, imagen);
               
            cstm.executeUpdate();
        }catch(Exception e){System.out.println("3"+e);}
        
    }
    public void actualizar(String codpro, String nombre, String descripcion,double precio,int stock ,int medpro,int cate, InputStream imagen) {
         
           try{
            CallableStatement cstm=Conexiondb.getConexion().prepareCall("{Call editprod(?,?,?,?,?,?,?,?)}");
             cstm.setString(1, codpro);
             cstm.setString(2, nombre);
              cstm.setString(3, descripcion);
               cstm.setDouble(4,precio);
                cstm.setInt(5, stock);
                 cstm.setInt(6, medpro);
                 cstm.setInt(7, cate);
                 cstm.setBlob(8, imagen);
            cstm.executeUpdate();
        }catch(Exception e){System.out.println("4"+e);}   
    }
    public void eliminar(String codpro){
        try{
            CallableStatement cstm=Conexiondb.getConexion().prepareCall("{Call deleteprod(?)}");
            cstm.setString(1, codpro);
            cstm.executeUpdate();
              }catch(Exception e){System.out.println("5"+e);}  
    }
    
    public int logeo(String user, String pass){
    
         int nivel=0;
        try{

PreparedStatement cs=Conexiondb.getConexion().prepareStatement("select nivel from usuarios where iduser='"+user+"' and contra='"+pass+"'");
            ResultSet rs=cs.executeQuery();
           
            while(rs.next()){
               nivel=rs.getInt(1);
            }
            
        }catch(Exception e){System.out.println("6"+e);}
        
        return nivel;
            
    }
   public void insertareg(String codpro,double precio,int cantidad,String codcli){
      
        try{
            CallableStatement cstm=Conexiondb.getConexion().prepareCall("{Call ingresoreg(?,?,?,?)}");
            cstm.setString(1, codpro);
              cstm.setInt(2, cantidad);
              cstm.setDouble(3, precio);
              cstm.setString(4, codcli);
            cstm.executeUpdate();
        }catch(Exception e){ System.out.println("7"+e);}
        
    }
   public ArrayList<registros> listaregistros(String codcli){
       ArrayList<registros> lista= new ArrayList<>();
       try{
           PreparedStatement cs=Conexiondb.getConexion().prepareStatement("select r.idreg,p.nombrepro,p.precio,r.cantidad,u.iduser,"
                   + "(p.precio*r.cantidad) as importe from "
                   + "registros r inner join productos p on r.codpro=p.codpro inner join usuarios u on u.id=r.id where u.iduser=? and fechareg=FORMAT(GETDATE(),'yyyy-MM-dd')");
           cs.setString(1,codcli );
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
            registros r= new registros(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),rs.getFloat(6));
            lista.add(r);
            }
       }catch(Exception e){System.out.println("8"+e);}
       return  lista;
   }
   public void deletereg(String codreg){
        try{
            CallableStatement cstm=Conexiondb.getConexion().prepareCall("{Call deletereg(?)}");
            cstm.setString(1, codreg);
            cstm.executeUpdate();
              }catch(Exception e){System.out.println("9"+e);}  
   }
   public ArrayList<usuarios> listusu(String codcli){
       ArrayList<usuarios> lista=new ArrayList<>();
       try{
           CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call listusu(?)}");
           cs.setString(1, codcli);
           ResultSet rs=cs.executeQuery();
           while(rs.next()){
               usuarios u=new usuarios(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
               lista.add(u);
           }
       }catch(Exception e){System.out.println("10"+e);}
       return lista;
   }
   public void newcliente(String iduser,String contra,String nombre,String dni, String direccion,String correo ){
       try{
           CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call newcliente(?,?,?,?,?,?)}");
           cs.setString(1, iduser);
           cs.setString(2, contra);
           cs.setString(3, nombre);
           cs.setString(4, dni);
           cs.setString(5, direccion);
           cs.setString(6, correo);
           cs.executeUpdate();
   }catch(Exception e){System.out.println("11"+e);}
}
   public void newboleta(String codcli){
        try{
           CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call nuevboleta(?)}");
           cs.setString(1, codcli);
           cs.executeUpdate();
   }catch(Exception e){System.out.println("12"+e);}
   }
   public void detallbol(String codpro,double precio, int cantidad){
        try{
           CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call detbol(?,?,?)}");
           cs.setString(1, codpro);
           cs.setDouble(2, precio);
           cs.setInt(3, cantidad);
           cs.executeUpdate();
   }catch(Exception e){System.out.println("13"+e);}
   }
 public ArrayList<medida> medida(){
      ArrayList <medida> lista= new ArrayList<>();
      try{
          CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call listmedida}");
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                medida m =new medida(rs.getInt(1), rs.getString(2));
                
             lista.add(m);
            }
            
        }catch(Exception e){System.out.println("14"+e);}
        
        return lista;
 }
 public ArrayList<categoria> categoria(){
      ArrayList <categoria> lista= new ArrayList<>();
      try{
          CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call listcategoria}");
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                categoria c =new categoria(rs.getInt(1), rs.getString(2));
                
             lista.add(c);
            }
            
        }catch(Exception e){System.out.println("15"+e);}
        
        return lista;
 }
  public ArrayList<meses> meses(){
      ArrayList <meses> lista= new ArrayList<>();
      try{
          CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call meses2}");
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                meses m =new meses(rs.getInt(1), rs.getString(2));
                
             lista.add(m);
            }
            
        }catch(Exception e){System.out.println("18"+e);}
        
        return lista;
 }
  /*public ArrayList<Productos> proxcate(String idcate){
      ArrayList<Productos> lista = new ArrayList<>();
      try{
          CallableStatement cstm= Conexiondb.getConexion().prepareCall("{Call proxcate(?)}");
          cstm.setString(1, idcate);
          ResultSet rs=cstm.executeQuery();
          while(rs.next()){
              Productos p= new Productos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getBlob(6));
          }
      }catch(Exception e){}
      return lista;
  } */
 
    
}
