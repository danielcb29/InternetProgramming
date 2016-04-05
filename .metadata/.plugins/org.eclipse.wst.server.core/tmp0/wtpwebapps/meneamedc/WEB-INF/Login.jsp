<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
 	<title>Login</title>
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_196x196.png" type="image/png" sizes="196x196">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_64x64.png" type="image/png" sizes="64x64">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_16x16.png" type="image/png" sizes="16x16">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_128x128.png" type="image/png" sizes="128x128">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<jsp:include page="Header.jsp" />
    <article>
    	<section class="login-left">
    		<div class="titulo-general"><h2>Iniciar Sesion</h2></div>
    		<p>
    			Bienvenido a meneame,
    		</p>
    		<img alt="" src="${pageContext.request.contextPath}/img/news.png"> 
    	</section>
    	<section class="login-rigth">
    		<div class="login-inputs">
    			<form action="" method="post">
    				<h2>${messages}</h2>
	    			<input class="lg-inp" name="username" type="text" placeholder="Nombre de usuario">
	    			<input class="lg-inp" type="password" name="password" placeholder="Contraseña">
	    			<input class="lg-bt" type="submit" value="Entrar">
    			</form>
    			<p>
    				<a href="forgot">¿Ha olvidado su contraseña?</a>
    			</p>
    		</div> 
    	</section>
    </article>
    <jsp:include page="Footer.jsp" />

</body>
</html>