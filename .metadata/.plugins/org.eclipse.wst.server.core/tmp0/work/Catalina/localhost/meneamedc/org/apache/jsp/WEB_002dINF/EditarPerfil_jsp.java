/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2016-04-05 21:15:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EditarPerfil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/Users/daniel/Documents/UnEx/PI/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/meneamedc/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098703890000L));
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1455219336000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write(" \t<title>nombreusuario</title>\n");
      out.write(" \t<link rel=\"shortcut icon\" href=\"https://mnmstatic.net/v_40/img/favicons/logo_196x196.png\" type=\"image/png\" sizes=\"196x196\">\n");
      out.write(" \t<link rel=\"shortcut icon\" href=\"https://mnmstatic.net/v_40/img/favicons/logo_64x64.png\" type=\"image/png\" sizes=\"64x64\">\n");
      out.write(" \t<link rel=\"shortcut icon\" href=\"https://mnmstatic.net/v_40/img/favicons/logo_16x16.png\" type=\"image/png\" sizes=\"16x16\">\n");
      out.write(" \t<link rel=\"shortcut icon\" href=\"https://mnmstatic.net/v_40/img/favicons/logo_128x128.png\" type=\"image/png\" sizes=\"128x128\">\n");
      out.write(" \t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/base.css\">\n");
      out.write(" \t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/ver-perfil.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/modificar-perfil.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("    <article>\n");
      out.write("    \t<div class=\"titulo\">\n");
      out.write("    \t\t<div class=\"titulo-general\"><h2>Información del perfil:</h2></div>\n");
      out.write("    \t\t<div class=\"titulo-especifico\"><h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2></div>\n");
      out.write("    \t</div>\n");
      out.write("    \t<div id=\"modif-perfil\">\n");
      out.write("    \t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/auth/Perfil?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"><input type=\"button\" value=\"Cancelar\"></a>\n");
      out.write("    \t</div><br/><br/>\n");
      out.write("    \t<fieldset>\n");
      out.write("    \t\t<legend>Información personal</legend>\n");
      out.write("    \t\t<!--div id=\"pic-user\">\n");
      out.write("    \t\t\t<img alt=\"avatar usuario\" src=\"img/pic-test.jpeg\">\n");
      out.write("    \t\t\t<input id=\"bt-cambiar\" type=\"button\" value=\"Cambiar\">\n");
      out.write("    \t\t</div-->\n");
      out.write("            <div class=\"cambio-perfil\">\n");
      out.write("                <form action=\"\" method=\"post\">\n");
      out.write("        \t\t\t<label>usuario:</label>\n");
      out.write("        \t\t\t<input class=\"cam-inp\" type=\"text\" required placeholder=\"nombre de usuario\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("        \t\t\t<label>correo electronico:</label>\n");
      out.write("        \t\t\t<input class=\"cam-inp\" type=\"emai\" required placeholder=\"correo electronico\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("        \t\t\t<label>clave:</label>\n");
      out.write("        \t\t\t<input class=\"cam-inp\" type=\"password\" required placeholder=\"clave\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.password}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("        \t\t\t<label>repetir clave:</label>\n");
      out.write("        \t\t\t<input class=\"cam-inp\" type=\"password\" required placeholder=\"verificar clave\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.password}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <br/>\n");
      out.write("                    <div class=\"non-rg\">\n");
      out.write("                        <input type=\"submit\" value=\"Guardar cambios\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("    \t</fieldset>\n");
      out.write("    \t<fieldset>\n");
      out.write("    \t\t<legend>Borrar cuenta</legend>\n");
      out.write("    \t\t<p>\n");
      out.write("                ¡Atención!, la cuenta sera deshabilitada,\n");
      out.write("                Se borrara la información personal\n");
      out.write("            </p>\n");
      out.write("            <div class=\"non-rg\">\n");
      out.write("                <input type=\"button\" value=\"Borrar\">\n");
      out.write("            </div>\n");
      out.write("    \t</fieldset>\n");
      out.write("        \n");
      out.write("    </article>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}