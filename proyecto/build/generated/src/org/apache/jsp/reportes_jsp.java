package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import utils.Conexiondb;
import utils.Conexiondb;

public final class reportes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    ");

            response.setHeader("Cache-Control", "no-cache");
           response.setHeader("Cache-Control", "no-store");
           response.setHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
            
            
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h1 align=\"center\">Reporte de ventas</h1>\n");
      out.write("        <form action=\"reportes.jsp\">\n");
      out.write("            <center>\n");
      out.write("        <input type=\"date\" min=\"01-01-2019\" max=\"01-01-2020\" name=\"selfecha\">\n");
      out.write("        <input class=\"btn-warning\" type=\"submit\" name=\"btnconsulta\" value=\"Consultar\">\n");
      out.write("                    </center>\n");
      out.write("\n");
      out.write("         </form>\n");
      out.write("        <table class=\"table-bordered\" align=\"center\" style=\"margin-top: 30px\">\n");
      out.write("                <thead class=\"bg-success\">\n");
      out.write("                    <tr align=\"center\">\n");
      out.write("                        <th>Codigo producto</th>\n");
      out.write("                        <th>Nombre de producto</th>\n");
      out.write("                        <th>Cantidad</th>\n");
      out.write("                        <th>Precio unitario</th>\n");
      out.write("                        <th>Importe</th>\n");
      out.write("                        <th>Nombre de usuario</th>\n");
      out.write("                        <th>Fecha de venta</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("       \n");
      out.write("            \n");
      out.write("            ");
 
                     try{
                     ResultSet rs;
                         CallableStatement cs=Conexiondb.getConexion().prepareCall("{Call listareportes}");
                        rs=cs.executeQuery();
                         String consulta=request.getParameter("selfecha").toString();
                         if(request.getParameter("btnconsulta")!=null){
                         if(consulta!=null){
                         CallableStatement cstm=Conexiondb.getConexion().prepareCall("{Call buscareportes(?)}");
                         cstm.setString(1, consulta);
                         rs=cstm.executeQuery();
                         }else{
                             request.getRequestDispatcher("reportes.jsp").forward(request, response);
                         }
                         }
                         while(rs.next()){
                           //imag=ImageIO.read(e.getImagen().getBinaryStream());
                           
                          
                    
      out.write("\n");
      out.write("                <tbody class=\"bg-light\">\n");
      out.write("                    <tr align=\"center\">\n");
      out.write("        <td>");
      out.print(rs.getString(1));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getInt(3));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getDouble(4));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(rs.getDouble(5));
      out.write("</td>             \n");
      out.write("         <td>");
      out.print(rs.getString(6));
      out.write("</td> \n");
      out.write("         <td>");
      out.print(rs.getString(7));
      out.write("</td> \n");
      out.write("                        </tr>\n");
      out.write("                         ");
}

                         
}catch(Exception e){System.out.println("16"+e);}
                         
      out.write("\n");
      out.write("               </tbody>\n");
      out.write("                 </table>\n");
      out.write("        \n");
      out.write("    </body>\n");
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
