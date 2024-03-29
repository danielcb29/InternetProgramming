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
            <form action="" method="post" id="form-noticia">
        		<!--div id="pic-user">
                    <label>Vista previa:</label>
        			<img alt="previsualizacion noticia" src="img/pic-test.jpeg">
        			<input id="bt-cambiar" type="button" value="Cambiar">
        		</div-->
                <div class="cambio-perfil">
        			<label>enlace:</label>
        			<input class="cam-inp" type="url" name="url" required placeholder="url de la noticia" value="${noticia.url}">
        			<label>titulo:</label>
        			<input class="cam-inp" type="text" name="titulo" required placeholder="titulo" value="${noticia.title}">
        			<!-- >label>etiquetas:</label>
        			<input class="cam-inp" type="text" required placeholder="separadas por ,"-->
        			<label>descripcion:</label>
        			<textarea class="cam-inp" required name="descripcion" cols="70" rows="10">${noticia.text}</textarea>
                    <label>categorias:</label>
                    <input class="not-check" type="radio" name="categoria" value="tecnologia" required <c:if test="${noticia.category == 'tecnologia'}">checked</c:if>>Tecnologia<br>
                    <input class="not-check" type="radio" name="categoria" value="ocio" required <c:if test="${noticia.category == 'ocio'}">checked</c:if>>Ocio<br>
                    <input class="not-check" type="radio" name="categoria" value="cultura" required <c:if test="${noticia.category == 'cultura'}">checked</c:if>>Cultura<br>
                    <input class="not-check" type="radio" name="categoria" value="actualidad" required <c:if test="${noticia.category == 'actualidad'}">checked</c:if>>Actualidad<br>
                    <input class="not-check" type="radio" name="categoria" value="deporte" required <c:if test="${noticia.category == 'deporte'}">checked</c:if>>Deporte
                    <br/>
                    <div class="non-rg">
                        <input type="submit" value="Enviar noticia">
                    </div>
                </div>
            </form>
    	</fieldset>
    </article>
    <jsp:include page="Footer.jsp" />
    
    <script   src="https://code.jquery.com/jquery-1.12.3.min.js"   integrity="sha256-aaODHAgvwQW1bFOGXMeX+pC4PZIPsvn2h1sArYOhgXQ="   crossorigin="anonymous"></script>
    <script>
    	var formulario = "#form-noticia";
    	var clase = ".cam-inp";
    </script>
    <script src="${pageContext.request.contextPath}/js/camposVacios.js"></script>

</body>
</html>