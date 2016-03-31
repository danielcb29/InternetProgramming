<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
 	<title>${user.name }</title>
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_196x196.png" type="image/png" sizes="196x196">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_64x64.png" type="image/png" sizes="64x64">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_16x16.png" type="image/png" sizes="16x16">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_128x128.png" type="image/png" sizes="128x128">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ver-perfil.css">
</head>
<body>
	<jsp:include page="Header.jsp" />
    <article>
    	<div class="titulo">
    		<div class="titulo-general"><h2>Información del perfil:</h2></div>
    		<div class="titulo-especifico"><h2>${user.name}</h2></div>
    	</div>
    	<div id="modif-perfil">
    		<input type="button" value="Modificar Perfil">
    	</div><br/><br/>
    	<fieldset>
    		<legend>Información personal</legend>
    		<table>
    			<tbody>
    				<tr>
    					<th>usuario:</th>
    					<td>${user.name}</td>
    				</tr>
    				<tr>
    					<th>email:</th>
    					<td>${user.email}</td>
    				</tr>
    				<tr>
    					<th>comentarios:</th>
    					<td>${profMap.comentarios}</td>
    				</tr>
    			</tbody>
    		</table>

    	</fieldset>
    	<fieldset>
    		<legend>Karma</legend>
    		${profMap.comentarios} k
    	</fieldset>
    </article>
    <jsp:include page="Footer.jsp" />

</body>
</html>