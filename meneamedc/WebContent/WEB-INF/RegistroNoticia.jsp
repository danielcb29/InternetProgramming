<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
 	<title>Nueva Noticia</title>
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_196x196.png" type="image/png" sizes="196x196">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_64x64.png" type="image/png" sizes="64x64">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_16x16.png" type="image/png" sizes="16x16">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_128x128.png" type="image/png" sizes="128x128">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ver-perfil.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modificar-perfil.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registrar-noticia.css">
</head>
<body>
	<jsp:include page="Header.jsp" />
    <article>
    	<div class="titulo">
    		<div class="titulo-general"><h2>Enviar noticia:</h2></div>
    	</div>
    	<div id="modif-perfil">
    		<a href="${pageContext.request.contextPath}/Noticias"><input type="button" value="Cancelar"></a>
    	</div><br/><br/>
    	<fieldset>
    		<legend>Información de la noticia</legend>
            <form action="" method="post">
        		<!--div id="pic-user">
                    <label>Vista previa:</label>
        			<img alt="previsualizacion noticia" src="img/pic-test.jpeg">
        			<input id="bt-cambiar" type="button" value="Cambiar">
        		</div-->
                <div class="cambio-perfil">
        			<label>enlace:</label>
        			<input class="cam-inp" type="url" name="url" required placeholder="url de la noticia">
        			<label>titulo:</label>
        			<input class="cam-inp" type="text" name="titulo" required placeholder="titulo">
        			<!-- >label>etiquetas:</label>
        			<input class="cam-inp" type="text" required placeholder="separadas por ,"-->
        			<label>descripcion:</label>
        			<textarea class="cam-inp" required name="descripcion" cols="70" rows="10"></textarea>
                    <label>categorias:</label>
                    <input class="not-check" type="radio" name="categoria" value="tecnologia" required>Tecnologia<br>
                    <input class="not-check" type="radio" name="categoria" value="ocio" required>Ocio<br>
                    <input class="not-check" type="radio" name="categoria" value="cultura" required>Cultura<br>
                    <input class="not-check" type="radio" name="categoria" value="actualidad" required>Actualidad<br>
                    <input class="not-check" type="radio" name="categoria" value="deporte" required>Deporte
                    <br/>
                    <div class="non-rg">
                        <input type="submit" value="Enviar noticia">
                    </div>
                </div>
            </form>
    	</fieldset>
    </article>
    <jsp:include page="Footer.jsp" />

</body>
</html>