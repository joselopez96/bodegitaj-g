package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.ProductosDAO;
import clases.meses;
import java.sql.CallableStatement;
import utils.Conexiondb;
import java.util.ArrayList;
import clases.topcliente;
import java.sql.ResultSet;

public final class topcliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        ");

            ProductosDAO dao=new ProductosDAO();
            ArrayList<meses> meses=dao.meses();
            request.setAttribute("mes", meses);
            
      out.write("\n");
      out.write("    <center>\n");
      out.write("        <h1>Filtro de clientes top</h1>\n");
      out.write("        <form action=\"topcliente.jsp\">\n");
      out.write("        <select name = \"mes\" required=\"required\">\n");
      out.write("                                         <option value=\"\">Seleccione un opcion..</option>\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("        \n");
      out.write("            <input type=\"number\" name=\"top\" required=\"required\" min=\"5\" max=\"100\" value=\"5\" pattern=\"[0-9]\">\n");
      out.write("        <input type=\"submit\" name=\"btn\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <table class=\"table-bordered\" align=\"center\" >\n");
      out.write("            <thead class=\"bg-success\">\n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <th>Nombre</th>\n");
      out.write("                    <th>DNI</th>\n");
      out.write("                     <th>Direccion</th>\n");
      out.write("                     <th>Correo</th>\n");
      out.write("                     <th>mes</th>\n");
      out.write("                     <th>Importe</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("           \n");
      out.write("      \n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("  ");

      
      try{
          
     ResultSet rs;
     String nrofilas=request.getParameter("top");
     String mes=request.getParameter("mes");
        CallableStatement cs= Conexiondb.getConexion().prepareCall("{Call topclientedefault}");
        rs=cs.executeQuery();  
      
        if(request.getParameter("btn")!=null){
            if(nrofilas!=null && mes!=null){
                CallableStatement cstm= Conexiondb.getConexion().prepareCall("{Call topcliente(?,?)}");
           cstm.setString(1, mes);
            cstm.setString(2, nrofilas);
            rs=cstm.executeQuery();
            }
            
        }
           
          
        
           while(rs.next()){
               
      out.write("\n");
      out.write("                <tbody class=\"bg-light\">\n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>");
      out.print(rs.getString(1) );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getString(2) );
      out.write("</td>\n");
      out.write("                     <td>");
      out.print(rs.getString(3) );
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(rs.getString(4) );
      out.write("</td>\n");
      out.write("                       <td>");
      out.print(rs.getString(5) );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rs.getDouble(6) );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("               \n");
      out.write("               \n");
      out.write("               \n");
      out.write("               \n");
      out.write("           ");
    
           }
           
      }catch(Exception e){System.out.println("20"+e);}
      
     
   
      out.write("\n");
      out.write("    </table>      \n");
      out.write("    </center>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mes}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("mess");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <option value = \"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess.getIdmes()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess.getNomes()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" </option>\n");
          out.write("                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
