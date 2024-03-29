<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head" id="nombre-categorias">
	<div>
		<img alt="" src="${pageContext.request.contextPath}/img/menu.png">
		<a href="${pageContext.request.contextPath}/Noticias"><img alt="" src="${pageContext.request.contextPath}/img/logo-top.png"></a>
		<img alt="" src="${pageContext.request.contextPath}/img/door.png">
	</div>
	<div id="categorias">
		<ul>
			<li><a href="${pageContext.request.contextPath}/Noticias?categoria=tecnologia">Tecnologia</a></li>
			<li><a href="${pageContext.request.contextPath}/Noticias?categoria=ocio">Ocio</a></li>
			<li><a href="${pageContext.request.contextPath}/Noticias?categoria=cultura">Cultura</a></li>
		</ul>
	</div>
	<c:choose>
	    <c:when test="${empty user}">
	        <div class="rigth">
				<a href="${pageContext.request.contextPath}/LoginServlet">login</a> /
				<a href="${pageContext.request.contextPath}/CrearUsuario">registrarse</a>
			</div>
	    </c:when>
	    <c:otherwise>
	    	<div class="rigth login-succ">
				<a href="${pageContext.request.contextPath}/auth/Perfil?id=${user.id}">${user.name}</a>
				<img id="avatar-login" alt="avatar usuario" src="${pageContext.request.contextPath}/img/user.png">
				<a href="${pageContext.request.contextPath}/LogoutServlet"><img id="shutdown" alt="" src="${pageContext.request.contextPath}/img/logout.png"></a>
			</div>
	    </c:otherwise>
	</c:choose>
	
	
	
</div>
<div class="head" id="logo-search">
	<div><img alt="" src="${pageContext.request.contextPath}/img/elef.png"></div>
	<div><b>
		<c:choose>
		    <c:when test="${empty categoria}">
		    	Meneame
		    </c:when>
		    <c:otherwise>
		    	${categoria }
		    </c:otherwise>
		</c:choose>
	</b></div>
	<div>
		<img alt="" src="${pageContext.request.contextPath}/img/fb.png">
		<img alt="" src="${pageContext.request.contextPath}/img/tw.png">
	</div>
	<!--div class="rigth">
		<input id="search" type="text" placeholder="Buscar">
	</div-->
</div>
<nav>
    <ul>
    	<c:choose>
		    <c:when test="${empty user}">
		    </c:when>
		    <c:otherwise>
		    	<li><a href="${pageContext.request.contextPath}/auth/CrearNoticia">Enviar Historia</a></li>
		    	<li><a href="${pageContext.request.contextPath}/auth/MisNoticias">Mis Noticias</a></li>
		    </c:otherwise>
		</c:choose>
		<li><a href="${pageContext.request.contextPath}/Noticias">Nuevas</a></li>
        <li><a href="${pageContext.request.contextPath}/Noticias?categoria=actualidad">Actualidad</a></li>
        <li><a href="${pageContext.request.contextPath}/Noticias?categoria=deporte">Deporte</a></li>
    </ul>
</nav>
   