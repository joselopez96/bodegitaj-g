/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servet;

import DAO.ProductosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TOSHIBA
 */
@WebServlet(name = "Contollercarrito", urlPatterns = {"/Contollercarrito"})
public class Contollercarrito extends HttpServlet {
String carro="carrito.jsp";
String carrito="micarrito.jsp";
    ProductosDAO dao= new ProductosDAO();
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
            out.println("<title>Servlet Contollercarrito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Contollercarrito at " + request.getContextPath() + "</h1>");
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
        String codpro=request.getParameter("codpro");
        String action=request.getParameter("action");
        String codcliente=request.getParameter("codcli");
        String codreg=request.getParameter("codreg");
        String acceso="";
        if (action.equalsIgnoreCase("comprar")){
            request.setAttribute("codcarrito", codpro);
            request.setAttribute("codclientes", codcliente);
            acceso=carro;
            
        }  else if(action.equalsIgnoreCase("carrito")){
            request.setAttribute("codclientess", codcliente);
            acceso=carrito;
        } else if(action.equalsIgnoreCase("elimcarro")){
            dao.deletereg(codreg);
            request.setAttribute("codclientess", codcliente);
            acceso=carrito;
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
        String action2=request.getParameter("btnagregacarro");
        String codpro=request.getParameter("codpro");
        String iduser=request.getParameter("codcli");
        HttpSession session=request.getSession();
        
        int cantidad=Integer.parseInt(request.getParameter("cantidad"));
        double precio=Double.parseDouble(request.getParameter("precio"));
        if((action2)!=null){
            dao.insertareg(codpro, precio, cantidad, iduser);
            dao.detallbol(codpro, precio, cantidad);
            session.setAttribute("user", iduser);
                   session.setAttribute("nivel", "2");
                   response.sendRedirect("indexuser.jsp");
        }
        
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
