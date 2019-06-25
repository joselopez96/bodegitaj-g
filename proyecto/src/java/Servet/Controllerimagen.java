/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servet;

import DAO.ProductosDAO;
import java.io.IOException;
import java.io.OutputStream;import java.sql.SQLException;

import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Conexiondb;

/**
 *
 * @author TOSHIBA
 */
@WebServlet(name = "Controllerimagen", urlPatterns = {"/Controllerimagen"})
public class Controllerimagen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    ProductosDAO dao=new ProductosDAO();
     Blob imagen;
     byte[] imgData;


    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codpro=request.getParameter("codpro");
     
     try{
          String sql="select imagen from productos where codpro"+"='"+codpro+"'";
         PreparedStatement ps=Conexiondb.getConexion().prepareStatement(sql);
        
         
         ResultSet rs=ps.executeQuery();
         if(rs.next()){
             imagen=rs.getBlob("imagen");
             imgData=imagen.getBytes(1,(int)imagen.length());
             response.setContentType("image/*");
             OutputStream  o=response.getOutputStream();
             o.write(imgData);
             o.flush();
             o.close();
         }
     }catch(SQLException e){
         System.out.println("No se pudo subir");
     }
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
