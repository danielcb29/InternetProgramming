/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2016-04-08 17:24:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MisNoticias_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write(" \t<title>Meneame</title>\n");
      out.write(" \t<link rel=\"shortcut icon\" href=\"https://mnmstatic.net/v_40/img/favicons/logo_196x196.png\" sizes=\"196x196\">\n");
      out.write(" \t<link rel=\"shortcut icon\" href=\"https://mnmstatic.net/v_40/img/favicons/logo_64x64.png\" sizes=\"64x64\">\n");
      out.write(" \t<link rel=\"shortcut icon\" href=\"https://mnmstatic.net/v_40/img/favicons/logo_16x16.png\" sizes=\"16x16\">\n");
      out.write(" \t<link rel=\"shortcut icon\" href=\"https://mnmstatic.net/v_40/img/favicons/logo_128x128.png\" sizes=\"128x128\">\n");
      out.write(" \t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/base.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/lista-noticias.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/modificar-borrar-noticia.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("    <article>\n");
      out.write("    \t<div class=\"titulo\">\n");
      out.write("    \t\t<div class=\"titulo-general\"><h2>Noticias de categoria:</h2></div>\n");
      out.write("    \t\t <div class=\"titulo-especifico\"><h2>Mis Noticias</h2></div>\n");
      out.write("    \t</div>\n");
      out.write("    \t\t");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<!--fin todas las noticias-->\n");
      out.write("\t\t\t<!--ul class=\"pagination\">\n");
      out.write("\t\t\t  <li><a href=\"#\">«anterior</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">1</a></li>\n");
      out.write("\t\t\t  <li><a class=\"active\" href=\"#\">2</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">3</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">4</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">5</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">6</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">7</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">siguiente»</a></li>\n");
      out.write("\t\t\t</ul-->\n");
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

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t    ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t    ");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write('\n');
        out.write('	');
        out.write('	');
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/MisNoticias.jsp(25,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty noticias}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t        <h1>No hay noticias disponibles</h1>\n");
        out.write("\t\t\t    ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t    \t<h2>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${messages.error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("</h2>\n");
        out.write("\t\t\t    \t");
        if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fotherwise_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t<!--fin todas las noticias-->\n");
        out.write("\t\t    ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fotherwise_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f0);
    // /WEB-INF/MisNoticias.jsp(30,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("noticia");
    // /WEB-INF/MisNoticias.jsp(30,8) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticias}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t    \t\t<!--una noticia-->\n");
          out.write("\t\t\t\t\t\t<section>\n");
          out.write("\t\t\t\t\t\t\t<div class=\"info-menem\">\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"votes\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.likes}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"text-votes\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tmeneos\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"meneame\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"bt-meneame\" type=\"submit\" value=\"menealo\">\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"clicks\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.hits}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(" clicks\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t<div class=\"info-noticia\">\n");
          out.write("\t\t\t\t\t\t\t\t<h3><a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.url }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</a></h3>\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"info-user-noticia\">\n");
          out.write("\t\t\t\t\t\t\t\t\t<!--img alt=\"Usuario\" class=\"new-pic\" src=\"img/pic-test.jpeg\"-->\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"user-and-date\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tpor\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/auth/Perfil?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.owner}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.value.user.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.dateStamp }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.timeStamp }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"contenido\">\n");
          out.write("\t\t\t\t\t\t\t\t\t<!-- img alt=\"Vista previa noticia\" class=\"prev-noticia\" src=\"img/pic-test.jpeg\"-->\n");
          out.write("\t\t\t\t\t\t\t\t\t<p>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.text }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("\t\t\t\t\t\t\t\t\t</p>\n");
          out.write("\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"noticia-details\">\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"noticia-sep\"><b>usuarios:</b> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.value.comments }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(" </span>\n");
          out.write("\t\t\t\t\t\t\t\t\t<!--span class=\"noticia-sep\"><b>anonimos:</b> 90</span>\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"noticia-sep\"><b>negativos:</b> 90</span-->\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"noticia-sep\">|</span>\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"noticia-sep\"><b>compartir:</b>\n");
          out.write("\t\t\t\t\t\t\t\t\t <a href=\"\"><img alt=\"\" class=\"social-icon\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/img/fb.png\"></a>\n");
          out.write("\t\t\t\t\t\t\t\t\t <a href=\"\"><img alt=\"\" class=\"social-icon\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/img/tw.png\"></a>\n");
          out.write("\t\t\t\t\t\t\t\t\t</span>\n");
          out.write("\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"show-comments\">\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"noticia-sep comments-link\"><span class=\"contador\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.value.comments }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</span> <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/auth/ComentarioNoticia?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\">comentarios</a></span>\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"noticia-sep\">| </span>\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"noticia-sep\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.category }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(" </span>\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"noticia-sep\">| </span>\n");
          out.write("\t\t\t\t\t\t\t\t\t<span class=\"noticia-sep\">karma: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.value.karma }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t<div class=\"delete-mod\">\n");
          out.write("\t\t\t\t\t\t\t\t<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/auth/EditarNoticia?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\"><input type=\"button\" class=\"bt bt-modificar\" value=\"Modificar Noticia\"></a>\n");
          out.write("\t\t\t\t\t\t\t\t<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/auth/BorrarNoticia?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noticia.key.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\"><input type=\"button\" class=\"bt bt-borrar\" value=\"Borrar Noticia\"></a>\n");
          out.write("\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t</section>\n");
          out.write("\t\t\t\t\t<!--fin una noticia-->\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
