package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clases.categoria;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import utils.Conexiondb;
import java.sql.PreparedStatement;
import clases.Productosadmin;
import java.io.ByteArrayInputStream;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import DAO.ProductosDAO;
import clases.Productos;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<a href=\"../src/java/Servet/Controllerimagen.java\"></a>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("         <style type=\"text/css\">\n");
      out.write("             ul,ol{\n");
      out.write("                 list-style: none;\n");
      out.write("             }\n");
      out.write("             .nav li a{\n");
      out.write("                 background-color: #434342;\n");
      out.write("                 color:#fff;\n");
      out.write("                 text-decoration: none;\n");
      out.write("                 padding: 10px 15px;\n");
      out.write("                 display: block;\n");
      out.write("             }\n");
      out.write("             \n");
      out.write("             .nav li a:hover{\n");
      out.write("                 background-color: #003366;\n");
      out.write("             }\n");
      out.write("             .nav li ul{\n");
      out.write("                 display: none;\n");
      out.write("                 position: absolute;\n");
      out.write("                 min-width: 140px;\n");
      out.write("             }\n");
      out.write("             .nav li:hover > ul{\n");
      out.write("                 display: block;\n");
      out.write("             }\n");
      out.write("             .fake a:hover{\n");
      out.write("                  background-color: #003366;\n");
      out.write("             }\n");
      out.write("             \n");
      out.write("         </style>\n");
      out.write("       ");

           response.setHeader("Cache-Control", "no-cache");
           response.setHeader("Cache-Control", "no-store");
           response.setHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
            HttpSession sesion=request.getSession();
            String usuario;
            String nivel;
            if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
                usuario=sesion.getAttribute("user").toString();
                nivel=sesion.getAttribute("nivel").toString();
                
                
      out.write("\n");
      out.write("                 \n");
      out.write("                \n");
      out.write("              \n");

String user=sesion.getAttribute("user").toString();
            
      out.write("\n");
      out.write("      \n");
      out.write("       <nav class=\"navbar navbar-expand-md navbar-light bg-dark sticky-top\">\n");
      out.write("       <div class=\"container-fluid\">\n");
      out.write("           <a class=\"navbar-brand\"><img src=\"imagen/logo2.png\"></a>\n");
      out.write("           <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n");
      out.write("               <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                   <li class=\"nav-item \">\n");
      out.write("                       <a class=\"nav-item\" style=\"color: #fff;margin-right: 150px\">Bienvenido al sistema, Administrador: ");
      out.print(user );
      out.write("</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item active fake\" style=\" background-color: #434342;\n");
      out.write("                 color:#fff;\n");
      out.write("                 text-decoration: none;\n");
      out.write("                 display: block;\">\n");
      out.write("                       <a class=\"nav-link\"style=\"color: #fff\" href=\"Controller?action=Nuevo\">Nuevo Producto</a>\n");
      out.write("                   </li>\n");
      out.write("                   <ul class=\"nav\">\n");
      out.write("                   <li >\n");
      out.write("                       <a style=\"color: #fff\" href=\"\">Categorias</a>\n");
      out.write("                       <ul>\n");
      out.write("                           ");
 
                               ProductosDAO dao=new ProductosDAO();
                                       
                               ArrayList<categoria> lista=dao.categoria();
                               for(categoria c:lista){
                               
      out.write("\n");
      out.write("                               <li><a href=\"Controller?action=cate&codcli=");
      out.print( user );
      out.write("&id=");
      out.print(String.valueOf(c.getIdcate()) );
      out.write('"');
      out.write('>');
      out.print(c.getNomcate() );
      out.write("</a></li>\n");
      out.write("                           ");
} 
      out.write("\n");
      out.write("                       </ul>\n");
      out.write("                       </ul>\n");
      out.write("                   </li>\n");
      out.write("                   <ul class=\"nav\">\n");
      out.write("                   <li>\n");
      out.write("                       <a style=\"color: #fff\" href=\"\">Reportes</a>\n");
      out.write("                       <ul>\n");
      out.write("                           <li><a href=\"Controller?action=Reportes\" >Ventas por Fecha</a></li>\n");
      out.write("                           <li><a href=\"Controller?action=Topproducto\">Top de productos</a></li>\n");
      out.write("                       </ul>\n");
      out.write("                   </li>\n");
      out.write("                   </ul>\n");
      out.write("                    <li class=\"nav-item fake\" style=\" background-color: #434342;\n");
      out.write("                 color:#fff;\n");
      out.write("                 text-decoration: none;\n");
      out.write("                 display: block;\">\n");
      out.write("                    <a class=\"nav-link\" style=\"color: #fff\" href=\"Controllerlogin?cerrar=true\">Cerrar sesion</a>\n");
      out.write("                </li>\n");
      out.write("                \n");
      out.write("                </ul>\n");
      out.write("          </div>  \n");
      out.write("        </div>\n");
      out.write("            </nav>\n");
      out.write("      \n");
      out.write("            \n");
      out.write("            <h3 align=\"center\">CATALOGO DE PRODUCTOS</h3>\n");
      out.write("        <center>\n");
      out.write("           \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <form action=\"index.jsp\">\n");
      out.write("                               <input type=\"text\" name=\"txtbusca\">\n");
      out.write("            <input class=\"btn-warning\" type=\"submit\" name=\"btnconsulta\" value=\"Consultar\">\n");
      out.write("             \n");
      out.write("            </form>\n");
      out.write("       \n");
      out.write("            <br>\n");
      out.write("       \n");
      out.write("       \n");
      out.write("    \n");
      out.write("            <table class=\"table-bordered\" align=\"center\"  >\n");
      out.write("                <thead class=\"bg-success\">\n");
      out.write("                    <tr align=\"center\">\n");
      out.write("                        <th>Codigo</th>\n");
      out.write("                        <th>Nombre de producto</th>\n");
      out.write("                        <th>Descripcion</th>\n");
      out.write("                        <th>Precio</th>\n");
      out.write("                        <th>Stock disponible</th>\n");
      out.write("                        <th>Unidad de medida</th>\n");
      out.write("                        <th>Imagen</th>\n");
      out.write("                        <th>Accion</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                 ");
 
                     try{   
                     ResultSet rs;
                         CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call listaprodamin}");
                        rs=cs.executeQuery();
                         String consulta=request.getParameter("txtbusca");
                         if(request.getParameter("btnconsulta")!=null){
                         if(consulta!=null){
                         CallableStatement cstm=Conexiondb.getConexion().prepareCall("{Call consulprod(?)}");
                         cstm.setString(1, consulta);
                         rs=cstm.executeQuery();
                         }else{
                             request.getRequestDispatcher("index.jsp").forward(request, response);
                             
      out.write("\n");
      out.write("                             <td><h1>No se encontro resultados de la busqueda</h1></td>\n");
      out.write("                             ");

                             
                         }
                         }
                         while(rs.next()){
                           //imag=ImageIO.read(e.getImagen().getBinaryStream());
                           
                          
                    
      out.write("\n");
      out.write("                <tbody class=\"bg-light\">\n");
      out.write("                    <tr align=\"center\">\n");
      out.write("                       <td>");
      out.print(rs.getString(1));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(3));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getDouble(4));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getInt(5));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(6));
      out.write("</td>             \n");
      out.write("                        <td><img src=\"Controllerimagen?codpro=");
      out.print(rs.getString(1));
      out.write("\"width=\"250\" height=\"230\"</td>\n");
      out.write("                        \n");
      out.write("      \n");
      out.write("                        <td>\n");
      out.write("                            <a href=\"Controller?action=editar&codpro=");
      out.print(rs.getString(1));
      out.write("\">Editar</a>\n");
      out.write("                            /<a href=\"Controller?action=eliminar&codpro=");
      out.print(rs.getString(1));
      out.write("\">Eliminar</a>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                             </td>\n");
      out.write("                        </tr>\n");
      out.write("                         ");
}

                         
}catch(Exception e){System.out.println(e);}
                         
      out.write("\n");
      out.write("                      \n");
      out.write("                         ");

            }else{
             request.getRequestDispatcher("login.jsp").forward(request, response);
}
      out.write("\n");
      out.write("                       \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </center>\n");
      out.write("        \n");
      out.write("     \n");
      out.write("\n");
      out.write("</body>\n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
