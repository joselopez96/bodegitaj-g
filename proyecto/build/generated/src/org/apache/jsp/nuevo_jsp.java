package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nuevo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
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
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <h1 align=\"center\" >Nuevo producto</h1>\n");
      out.write("        <br>\n");
      out.write("        <form action=\"Controller\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("                             <script>\n");
      out.write("                    $(window).load(function(){\n");
      out.write("\n");
      out.write(" $(function() {\n");
      out.write("  $('#file-input').change(function(e) {\n");
      out.write("      addImage(e); \n");
      out.write("     });\n");
      out.write("\n");
      out.write("     function addImage(e){\n");
      out.write("      var file = e.target.files[0],\n");
      out.write("      imageType = /image.*/;\n");
      out.write("    \n");
      out.write("      if (!file.type.match(imageType))\n");
      out.write("       return;\n");
      out.write("  \n");
      out.write("      var reader = new FileReader();\n");
      out.write("      reader.onload = fileOnload;\n");
      out.write("      reader.readAsDataURL(file);\n");
      out.write("     }\n");
      out.write("  \n");
      out.write("     function fileOnload(e) {\n");
      out.write("      var result=e.target.result;\n");
      out.write("      $('#imgSalida').attr(\"src\",result);\n");
      out.write("     }\n");
      out.write("    });\n");
      out.write("  });\n");
      out.write("                </script>\n");
      out.write("        <table border=\"0\"  align=\"center\"  >\n");
      out.write("            \n");
      out.write("          <tr>\n");
      out.write("              <td >Nombre</td>\n");
      out.write("                <td><input  class=\"form-control\"  type=\"text\" name=\"nombre\" required pattern=\"[A-Za-z0-9. ]+\" minlength=\"5\" maxlength=\"25\"\n");
      out.write("                            title=\"Solo letras y numeros estan permitidas en este campo. Tamaño mínimo: 5. Tamaño máximo: 20\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>Descripcion</td>\n");
      out.write("                <td><input  class=\"form-control\" type=\"text\" name=\"descripcion\" required=\"required\" pattern=\"[a-zA-Z0-9. ]+\" minlength=\"5\" maxlength=\"40\"\n");
      out.write("                           title=\"Solo letras y numeros estan permitidas en este campo. Tamaño mínimo: 5. Tamaño máximo: 40\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>Precio</td>\n");
      out.write("                <td><input class=\"form-control\"  type=\"text\" name=\"precio\" required pattern=\"^[0-9]{1,5}(\\.[0-9]{0,2})?$\" minlength=\"1\" maxlength=\"5\"\n");
      out.write("                            title=\"Solo numeros estan permitidos en este campo. Tamaño mínimo: 1 Tamaño máximo: 5\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>Stock</td>\n");
      out.write("                <td><input  class=\"form-control\" type=\"text\" name=\"stock\" required=\"required\" pattern=\"[0-9]+\" minlength=\"1\" maxlength=\"4\"\n");
      out.write("                            title=\"Solo numeros positivos en este campo. Tamaño mínimo: 1. Tamaño máximo: 4\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>Medida</td>\n");
      out.write("                <td> <select name = \"medida\" class=\"form-control\" required=\"required\">\n");
      out.write("                                         <option value=\"\">Seleccione un opcion..</option>\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </select></td>\n");
      out.write("                </tr>\n");
      out.write("                  <tr>\n");
      out.write("                <td>Categoria</td>\n");
      out.write("                <td> <select name = \"categoria\" class=\"form-control\" required=\"required\" >\n");
      out.write("                                         <option value=\"\">Seleccione un categoria..</option>\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </select></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>Imagen</td>\n");
      out.write("                <td><input class=\"form-control \"  id=\"file-input\" class=\"btn btn-outline-light\" type=\"file\" name=\"filefoto\" required=\"required\" accept=\"image/*\"></td>\n");
      out.write("                 <td><img id=\"imgSalida\"  width=\"250\" height=\"230\" src=\"\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <td><input class=\"btn btn-info\" type=\"submit\" name=\"action2\" value=\"Guardar\"></td>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lista1}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("medida");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <option value = \"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.getIdmed()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medida.getNomed()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lista2}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("categoria");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <option value = \"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${categoria.getIdcate()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${categoria.getNomcate()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" </option>\n");
          out.write("                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
