<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer>
    <div class="footer-sections">
    	<div class="section-separator">
    		<h4>Categorias</h4>
    		<ul>
	            <li><a href="${pageContext.request.contextPath}/Noticias?categoria=tecnologia">Tecnologia</a></li>
	            <li><a href="${pageContext.request.contextPath}/Noticias?categoria=ocio">Ocio</a></li>
	            <li><a href="${pageContext.request.contextPath}/Noticias?categoria=cultura">Cultura</a></li>
	            <li><a href="${pageContext.request.contextPath}/Noticias?categoria=actualidad">Actualidad</a></li>
	        </ul>
    	</div>
    	<div class="section-separator">
    		<h4>Filtros</h4>
    		<ul>
	            <li><a href="${pageContext.request.contextPath}/auth/CrearNoticia">Enviar historia</a></li>
	            <li><a href="${pageContext.request.contextPath}/Noticias">Nuevas</a></li>
	            <li><a href="${pageContext.request.contextPath}/Noticias?categoria=deporte">Deportes</a></li>
	            <!--  li><a href="">Populares</a></li-->
	            <br>
	        </ul>
    	</div>
    	<div>
    		<h4>Usuario</h4>
    		<ul>
	            <li><a href="${pageContext.request.contextPath}/LoginServlet">Login</a></li>
		         <c:choose>
				    <c:when test="${empty user}">
				        <br/>
				        <br/>
				        <br/>
				    </c:when>
				    <c:otherwise>
				    	<li><a href="${pageContext.request.contextPath}/auth/Perfil?id=${user.id}">Ver perfil</a></li>
			            <li><a href="${pageContext.request.contextPath}/auth/EditarPerfilServlet?id=${user.id}">Modificar perfil</a></li>
			            <li><a href="">Ver mis noticias</a></li>
				    </c:otherwise>
				</c:choose>
	        </ul>
    	</div>
   	</div>
   	<div class="footer-sections">
   		<img alt="" src="${pageContext.request.contextPath}/img/logo-bottom.png">
   		<div id="copyrigth">
   			<a>legal </a>/
   			<a>quienes somos </a>/
   			<a>HTML5</a> |
   			Daniel Correa Barrios, Universidad de Extremadura
   		</div>
   	</div>
   </footer>