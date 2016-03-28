<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head" id="nombre-categorias">
	<div>
		<img alt="" src="img/menu.png">
		<a href="Noticias"><img alt="" src="img/logo-top.png"></a>
		<img alt="" src="img/door.png">
	</div>
	<div id="categorias">
		<ul>
			<li><a>cultura y tecnologia</a></li>
			<li><a>edicion general</a></li>
			<li><a>deportes</a></li>
		</ul>
	</div>
	<c:choose>
	    <c:when test="${user}">
	        <div class="rigth login-succ">
				<a href="ver-perfil.html">${user.name}</a>
				<img id="avatar-login" alt="avatar usuario" src="img/pic-test.jpeg">
				<img id="shutdown" alt="" src="img/logout.png">
			</div>
	    </c:when>
	    <c:otherwise>
	        <div class="rigth">
				<a href="">login</a> /
				<a href="CrearUsuario">registrarse</a>
			</div>
	    </c:otherwise>
	</c:choose>
	
	
	
</div>
<div class="head" id="logo-search">
	<div><img alt="" src="img/elef.png"></div>
	<div><b>${categoria }</b></div>
	<div>
		<img alt="" src="img/fb.png">
		<img alt="" src="img/tw.png">
	</div>
	<div class="rigth">
		<input id="search" type="text" placeholder="Buscar">
	</div>
</div>
<nav>
    <ul>
    	<c:if test="${user}"> 
        	<li><a href="registrar-noticia.html">enviar historia</a></li>
        </c:if>
        <li><a href="">portada</a></li>
        <li><a href="">nuevas</a></li>
        <li><a href="">populares</a></li>
    </ul>
</nav>
   