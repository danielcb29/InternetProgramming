<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
	 	<title>Comentarios</title>
	 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_196x196.png" sizes="196x196">
	 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_64x64.png" sizes="64x64">
	 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_16x16.png" sizes="16x16">
	 	<link rel="shortcut icon" href="https://mnmstatic.net/v_40/img/favicons/logo_128x128.png" sizes="128x128">
	 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lista-noticias.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/view-comment.css">
	</head>
	<body>
		<jsp:include page="Header.jsp" />
	    <article>
	    		<!--una noticia-->
				<section>
						<div class="info-menem">
								<div class="votes">
									${info.noticia.likes}
									<div class="text-votes">
										meneos
									</div>
	
								</div>
								<form method="post" action="${pageContext.request.contextPath}/Menear">
									<input type="hidden" name="id" value="${info.noticia.id}">
									<div class="meneame">
										<input class="bt-meneame" type="submit" value="menealo">
									</div>
								</form>
								
								<div class="clicks">
									${info.noticia.hits} clicks
								</div>
						</div>
						<div class="info-noticia">
							<h3><a href="${pageContext.request.contextPath}/HitNoticia?id=${info.noticia.id}">${info.noticia.title }</a></h3>
							<div class="info-user-noticia">
								<!--img alt="Usuario" class="new-pic" src="img/pic-test.jpeg"-->
								<div class="user-and-date">
									<div>
										por
										<a href="${pageContext.request.contextPath}/auth/Perfil?id=${info.owner.id}">${info.owner.name}</a>
									</div>
									<div>
										${info.noticia.dateStamp } ${info.noticia.timeStamp }
									</div>
								</div>
							</div>
							<div class="contenido">
								<!-- img alt="Vista previa noticia" class="prev-noticia" src="img/pic-test.jpeg"-->
								<p>
									${info.noticia.text }
								</p>
								
								
								
							</div>
							<div class="noticia-details">
								<span class="noticia-sep"><b>usuarios:</b> ${info.cantidadComent} </span>
								<!--span class="noticia-sep"><b>anonimos:</b> 90</span>
								<span class="noticia-sep"><b>negativos:</b> 90</span-->
								<span class="noticia-sep">|</span>
								<span class="noticia-sep"><b>compartir:</b>
								 <a href=""><img alt="" class="social-icon" src="${pageContext.request.contextPath}/img/fb.png"></a>
								 <a href=""><img alt="" class="social-icon" src="${pageContext.request.contextPath}/img/tw.png"></a>
								</span>
							</div>
							<div class="show-comments">
								<span class="noticia-sep comments-link"><span class="contador">${info.cantidadComent}</span> comentarios</span>
								<span class="noticia-sep">| </span>
								<span class="noticia-sep">${info.noticia.category } </span>
								<span class="noticia-sep">| </span>
								<span class="noticia-sep">karma: ${info.karma }</span>
	
							</div>
	
						</div>
	
				</section>
				<!--fin una noticia-->
	
				<!--fin todas las noticias-->
				<!--inicio comentarios destacados-->
				<section>
					<div id="popular-comments">
						Cantidad de comentarios: ${info.cantidadComent}
						
						<img alt="Usuario" class="new-pic" src="${pageContext.request.contextPath}/img/user.png">
					</div>
				</section>
				<!--fin comentarios destacados-->
				<!--inicio ver comentarios-->
				<section class="comments-queue">
					<c:choose>
					    <c:when test="${empty info.comentarios}">
					        <h1>No hay comentarios para esta noticia</h1>
					    </c:when>
					    <c:otherwise>
					    	
					    	<c:forEach var="comm" items="${info.comentarios}" varStatus="loop">
					    		<div class="comment">
									<div class="comment-body">
										<p>
											<span class="num-comment">#${loop.index}</span> ${comm.key.text }
										</p>
									</div>
									<div class="comment-foot">
										<div class="comment-user">
											${comm.key.dateStamp } ${comm.key.timeStamp }
											<a href="${pageContext.request.contextPath}/auth/Perfil?id=${comm.value.id}">${comm.value.name }</a>
											<img alt="Usuario" class="comment-user-prev" src="${pageContext.request.contextPath}/img/user.png">
										</div>
										<div class="comment-votes">
											Votos: <span class="num-votes">${comm.key.likes }</span>
											<!-- Karma: <b>34</b> -->
											<!--img alt="" src="${pageContext.request.contextPath}/img/karma.png"-->
											<a href="${pageContext.request.contextPath}/auth/LikeComment?id=${comm.key.id}&new=${info.noticia.id}"><img alt="" src="${pageContext.request.contextPath}/img/like.png"></a>
											<!--img alt="" src="${pageContext.request.contextPath}/img/reply.png" -->
				
										</div>
										
									</div>
								</div>
							</c:forEach>
					    </c:otherwise>
					</c:choose>
				</section>
				<!--fin ver comentarios-->
				<!--escribir comentario-->
				<fieldset id="box-comment" >
					<legend>Escriba un comentario:</legend>
					<form method="post" action="" id="form-comentarios">
						<textarea rows="7" cols="150" name="text" id="comment" placeholder="Comentario"></textarea><br>
						<input id="bt" type="submit" value="Enviar">
					</form>
	
				</fieldset>
				<!--fin escribir comentario-->
	    </article>
	    <jsp:include page="Footer.jsp" />
	    
	    <script   src="https://code.jquery.com/jquery-1.12.3.min.js"   integrity="sha256-aaODHAgvwQW1bFOGXMeX+pC4PZIPsvn2h1sArYOhgXQ="   crossorigin="anonymous"></script>
	    <script>
	    	var formulario = "#form-comentarios";
	    	var clase = "#comment";
	    </script>
	    <script src="${pageContext.request.contextPath}/js/camposVacios.js"></script>
	</body>
</html>