package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.Conexiondb;
import java.sql.CallableStatement;

public final class nuevocliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <h1 align=\"center\">Formulario de registro</h1>\n");
      out.write("        <form action=\"Controllerlogin;http://pagina.com/send.php\" method=\"post\" > \n");
      out.write("          \n");
      out.write("        <table border=\"0\"  align=\"center\" width=\"200\" style=\"margin-top: 30px\">\n");
      out.write("            \n");
      out.write("          <tr>\n");
      out.write("                <td>Nombre y apellidos:   </td>\n");
      out.write("                <td><input type=\"text\" name=\"nombreusu\" placeholder=\"requisito obligatorio\" required pattern=\"[A-Za-z0-9]{5,40}\"\n");
      out.write("         title=\"Letras y números. Tamaño mínimo: 5. Tamaño máximo: 40\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>Nombre de usuario:   </td>\n");
      out.write("                <td><input type=\"text\" name=\"iduser\" placeholder=\"requisito obligatorio\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>Contraseña:   </td>\n");
      out.write("                <td><input type=\"password\" name=\"contras\" placeholder=\"requisito obligatorio\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>DNI: </td>\n");
      out.write("                <td><input type=\"text\" name=\"dni\" placeholder=\"(max 8 caracteres)\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>Direccion o domicilio :  </td>\n");
      out.write("                <td><input type=\"text\" name=\"domicilio\" placeholder=\"ingrese su domicilio\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>Correo electronico :  </td>\n");
      out.write("                <td><input type=\"text\" name=\"correo\" placeholder=\"example@gmail.com\"></td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <td><input class=\"btn btn-info\" type=\"submit\" name=\"action2\" value=\"Registrarse\" style=\"margin-top: 30px;margin-left: 100px\"></td>\n");
      out.write("                </table>\n");
      out.write("        </form>\n");
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
