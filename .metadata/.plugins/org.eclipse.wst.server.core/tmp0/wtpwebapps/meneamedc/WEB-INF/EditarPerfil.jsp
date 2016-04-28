<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
 	<title>${user.name}</title>
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_196x196.png" type="image/png" sizes="196x196">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_64x64.png" type="image/png" sizes="64x64">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_16x16.png" type="image/png" sizes="16x16">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_128x128.png" type="image/png" sizes="128x128">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ver-perfil.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modificar-perfil.css">
</head>
<body>
	<jsp:include page="Header.jsp" />
    <article>
    	<div class="titulo">
    		<div class="titulo-general"><h2>Información del perfil:</h2></div>
    		<div class="titulo-especifico"><h2>${user.name}</h2></div>
    	</div>
    	<div id="modif-perfil">
    		<a href="${pageContext.request.contextPath}/auth/Perfil?id=${user.id}"><input type="button" value="Cancelar"></a>
    	</div><br/><br/>
    	<fieldset>
    		<legend>Información personal</legend>
    		<!--div id="pic-user">
    			<img alt="avatar usuario" src="img/pic-test.jpeg">
    			<input id="bt-cambiar" type="button" value="Cambiar">
    		</div-->
            <div class="cambio-perfil">
                <form action="" method="post" id="#form-edicion">
                	<h2>${messages.error}</h2>
        			<label>usuario:</label>
        			<input class="cam-inp" type="text" name="name" required placeholder="nombre de usuario" value="${user.name}">
        			<label>correo electronico:</label>
        			<input class="cam-inp" type="email" name="email" required placeholder="correo electronico" value="${user.email}">
        			<label>clave:</label>
        			<input class="cam-inp" type="password" name="password" required placeholder="clave" value="${user.password}">
        			<label>repetir clave:</label>
        			<input class="cam-inp" type="password" name="confirmpassword" required placeholder="verificar clave" value="${user.password}">
                    <br/>
                    <div class="non-rg">
                        <input type="submit" value="Guardar cambios">
                    </div>
                </form>
            </div>
    	</fieldset>
    	<fieldset>
    		<legend>Borrar cuenta</legend>
    		<p>
                ¡Atención!, la cuenta sera deshabilitada,
                Se borrara la información personal
            </p>
            <form method="post" action="${pageContext.request.contextPath}/auth/BorrarUsuario">
            <div class="non-rg">
                <input type="submit" value="Borrar">
            </div>
            </form>
    	</fieldset>
        
    </article>
    <jsp:include page="Footer.jsp" />
    
    <script   src="https://code.jquery.com/jquery-1.12.3.min.js"   integrity="sha256-aaODHAgvwQW1bFOGXMeX+pC4PZIPsvn2h1sArYOhgXQ="   crossorigin="anonymous"></script>
    <script>
    	var formulario = "#form-edicion";
    	var clase = ".cam-inp";
    </script>
    <script src="${pageContext.request.contextPath}/js/camposVacios.js"></script>

</body>
</html>