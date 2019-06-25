/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servet;

import DAO.ProductosDAO;
import clases.Productos;
import clases.categoria;
import clases.medida;
import clases.meses;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author TOSHIBA
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
@MultipartConfig
public class Controller extends HttpServlet {
    ProductosDAO dao= new ProductosDAO();
    Productos p= new Productos();   
    String nuevo="nuevo.jsp";
    String editar="editar.jsp";
    String listar="index.jsp";
    String reportes="reportes.jsp";
    String topproducto="reporteprodvendido.jsp";
    String categoria="categoria.jsp";
    String categoria2="categoria2.jsp";
    String topcliente="topcliente.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       String acceso="";
       String action=request.getParameter("action");
       String codpro=request.getParameter("codpro");
       String codcli=request.getParameter("codcli");
        String idcate=request.getParameter("id");
        String idcate2=request.getParameter("id2");
        String codcli2=request.getParameter("codcli2");
        if(action.equalsIgnoreCase("Nuevo")){
            ArrayList<medida> lista1=dao.medida();
            request.setAttribute("lista1", lista1);
            ArrayList<categoria> lista2=dao.categoria();
            request.setAttribute("lista2", lista2);
              acceso=nuevo;
             
        }
        else if(action.equalsIgnoreCase("editar")){
             request.setAttribute("codigo", request.getParameter("codpro"));
             ArrayList<medida> lista3=dao.medida();
            request.setAttribute("lista3", lista3);
            ArrayList<categoria> lista4=dao.categoria();
            request.setAttribute("lista4", lista4);
             acceso=editar;
             
         }
        else if(action.equalsIgnoreCase("eliminar")){
            p.setCodpro(codpro);
            dao.eliminar(codpro);
            acceso=listar;
            
        } else if(action.equalsIgnoreCase("Reportes")){
            acceso=reportes;
            
        }
         else if(action.equalsIgnoreCase("Topproducto")){
            acceso=topproducto;
            
        }else if(action.equalsIgnoreCase("cate")){
            request.setAttribute("codcli", codcli);
            request.setAttribute("idcate", idcate);
            acceso=categoria;
        }if(action.equalsIgnoreCase("cate2")){
            request.setAttribute("codcli2", codcli2);
            request.setAttribute("idcate2", idcate2);
            acceso=categoria2;
        }else if(action.equalsIgnoreCase("Topcliente")){
            
            acceso=topcliente;
        }
            
            
               RequestDispatcher vista=request.getRequestDispatcher(acceso);
                vista.forward(request, response); 
                 
        
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
         String action2=request.getParameter("action2");
         String codpro=request.getParameter("codpro");
         String nombre=request.getParameter("nombre");
         String description =request.getParameter("descripcion");
         double precio=Double.parseDouble(request.getParameter("precio"));
         int stock= Integer.parseInt(request.getParameter("stock"));
         int medpro=Integer.parseInt(request.getParameter("medida"));
           int categoria=Integer.parseInt(request.getParameter("categoria"));
        switch(action2){
           
      
            case "Guardar":
                Part part=request.getPart("filefoto");
                InputStream inputStream=part.getInputStream();
                dao.insertar(nombre, description, precio, stock, medpro,categoria, inputStream);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
break;

            case "Actualizar":
                Part part1=request.getPart("filefotoact");
                InputStream inputStream2=part1.getInputStream();
                dao.actualizar(codpro, nombre, description, precio, stock, medpro,categoria, inputStream2);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
    break;
        }
       
        
       // processRequest(request, response);
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
