<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
 	<title>Meneame</title>
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_196x196.png" type="image/png" sizes="196x196">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_64x64.png" type="image/png" sizes="64x64">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_16x16.png" type="image/png" sizes="16x16">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_128x128.png" type="image/png" sizes="128x128">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/registro.css">
</head>
<body>
	<jsp:include page="Header.jsp" />
    <article>
    	<h2 id="titulo">Registro</h2>
    	<section id="bloque-registro">
    		<div class="img-sg">
	    		<img alt="" src="${pageContext.request.contextPath}/img/reg.png">
	    	</div>
    		<div id="inputs">
    			<form action="" method="post" id="form-registro">
    				<h2>${messages.error}</h2>
	    			<div class="row">
			    		<label>Nombre de usuario:</label>
			    		<input class="rg-inp" type="text"  name="name" placeholder="nombre usuario" required>
			    		<!--  input type="button" value="Verificar"-->
		    		</div>
		    		<div class="row">
			    		<label>Correo electronico:</label>
			    		<input class="rg-inp" type="email"  name="email" placeholder="email">
		    		</div>
		    		<div class="row">
			    		<label>Clave:</label>
			    		<input class="rg-inp" type="password"  name="password" placeholder="clave" required>
		    		</div>
		    		<div class="row">
			    		<label>Confirmar clave:</label>
			    		<input class="rg-inp" type="password" name="confirmpassword"  placeholder="verificar clave" required>
		    		</div>
		    		<input type="checkbox" required name="vehicle" value="ok">Acepto los terminos y condiciones <br/><br/>
		    		<input class="rg-bt" type="submit" value="Enviar">
		    	</form>
	    	</div>
	    	
    	</section>
    </article>
    <jsp:include page="Footer.jsp" />
    
    <script   src="https://code.jquery.com/jquery-1.12.3.min.js"   integrity="sha256-aaODHAgvwQW1bFOGXMeX+pC4PZIPsvn2h1sArYOhgXQ="   crossorigin="anonymous"></script>
    <script>
    	var formulario = "#form-registro";
    	var clase = ".rg-inp";
    </script>
    <script src="${pageContext.request.contextPath}/js/camposVacios.js"></script>

</body>
</html>