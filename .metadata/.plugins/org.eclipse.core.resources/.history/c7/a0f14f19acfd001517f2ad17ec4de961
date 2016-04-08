<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
 	<title>Meneame</title>
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_196x196.png" sizes="196x196">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_64x64.png" sizes="64x64">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_16x16.png" sizes="16x16">
 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_128x128.png" sizes="128x128">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lista-noticias.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/modificar-borrar-noticia.css">
</head>
<body>
	<jsp:include page="Header.jsp" />
    <article>
    	<div class="titulo">
    		<div class="titulo-general"><h2>Noticias de categoria:</h2></div>
    		 <div class="titulo-especifico"><h2>Mis Noticias</h2></div>
    	</div>
    		<c:choose>
			    <c:when test="${empty noticias}">
			        <h1>No hay noticias disponibles</h1>
			    </c:when>
			    <c:otherwise>
			    	<h2>${messages.error}</h2>
			    	<c:forEach var="noticia" items="${noticias}">
			    		<!--una noticia-->
						<section>
							<div class="info-menem">
									<div class="votes">
										${noticia.key.likes}
										<div class="text-votes">
											meneos
										</div>
		
									</div>
									<div class="meneame">
										<input class="bt-meneame" type="submit" value="menealo">
									</div>
									<div class="clicks">
										${noticia.key.hits} clicks
									</div>
							</div>
							<div class="info-noticia">
								<h3><a href="${noticia.key.url }">${noticia.key.title }</a></h3>
								<div class="info-user-noticia">
									<!--img alt="Usuario" class="new-pic" src="img/pic-test.jpeg"-->
									<div class="user-and-date">
										<div>
											por
											<a href="${pageContext.request.contextPath}/auth/Perfil?id=${noticia.key.owner}">${noticia.value.name}</a>
										</div>
										<div>
											${noticia.key.dateStamp } ${noticia.key.timeStamp }
										</div>
									</div>
								</div>
								<div class="contenido">
									<!-- img alt="Vista previa noticia" class="prev-noticia" src="img/pic-test.jpeg"-->
									<p>
										${noticia.key.text }
									</p>
								</div>
								<div class="noticia-details">
									<span class="noticia-sep"><b>usuarios:</b> 90 </span>
									<span class="noticia-sep"><b>anonimos:</b> 90</span>
									<span class="noticia-sep"><b>negativos:</b> 90</span>
									<span class="noticia-sep">|</span>
									<span class="noticia-sep"><b>compartir:</b>
									 <a href=""><img alt="" class="social-icon" src="${pageContext.request.contextPath}/img/fb.png"></a>
									 <a href=""><img alt="" class="social-icon" src="${pageContext.request.contextPath}/img/tw.png"></a>
									</span>
								</div>
								<div class="show-comments">
									<span class="noticia-sep comments-link"><span class="contador">20</span> <a href="${pageContext.request.contextPath}/auth/ComentarioNoticia?id=${noticia.key.id}">comentarios</a></span>
									<span class="noticia-sep">| </span>
									<span class="noticia-sep">${noticia.key.category } </span>
									<span class="noticia-sep">| </span>
									<span class="noticia-sep">karma: 7000</span>
								</div>
							</div>
							<div class="delete-mod">
								<a href="${pageContext.request.contextPath}/auth/EditarNoticia?id=${noticia.key.id}"><input type="button" class="bt bt-modificar" value="Modificar Noticia"></a>
								<input type="button" class="bt bt-borrar" value="Borrar Noticia">
							</div>
					</section>
					<!--fin una noticia-->
				</c:forEach>
				<!--fin todas las noticias-->
		    </c:otherwise>
		</c:choose>

			<!--fin todas las noticias-->
			<!--ul class="pagination">
			  <li><a href="#">«anterior</a></li>
			  <li><a href="#">1</a></li>
			  <li><a class="active" href="#">2</a></li>
			  <li><a href="#">3</a></li>
			  <li><a href="#">4</a></li>
			  <li><a href="#">5</a></li>
			  <li><a href="#">6</a></li>
			  <li><a href="#">7</a></li>
			  <li><a href="#">siguiente»</a></li>
			</ul-->
    </article>
    <jsp:include page="Footer.jsp" />

</body>
</html>