package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Form login</title>\n");
      out.write("        <link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div id=\"contenedor1\">\n");
      out.write("            <h1>Sign in</h1>\n");
      out.write("            <form action=\"Controllerlogin\" method=\"post\" id=\"form1\">\n");
      out.write("            \n");
      out.write("                \n");
      out.write("                <img src=\"imagen/user.png\" alt=\"\"width=\"50\" height=\"30\"/>\n");
      out.write("                <input type=\"text\" name=\"txtuser\" placeholder=\"Username\">\n");
      out.write("                <hr>\n");
      out.write("                <img src=\"imagen/user.png\" alt=\"\" width=\"50\" height=\"30\"/>\n");
      out.write("                <input type=\"password\" name=\"txtcontra\" placeholder=\"Password\">\n");
      out.write("                <hr>\n");
      out.write("                <input type=\"submit\" value=\"Sign in\" name=\"btningresar\">\n");
      out.write("           \n");
      out.write("             </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div id=\"contenedor2\">\n");
      out.write("            <form id=\"form2\" action=\"Controllerlogin\" method=\"get\">\n");
      out.write("                <input type=\"submit\" value=\"Create Account\" name=\"nuevacuenta\">\n");
      out.write("            </form>\n");
      out.write("            <div id=\"referencias\">\n");
      out.write("                <a>BodegaJ&G®</a>\n");
      out.write("                <a href=\"\">Term of Use</a>\n");
      out.write("                 <a href=\"\">Privacy Policy</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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