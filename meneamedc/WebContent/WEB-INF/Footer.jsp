<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer>
    <div class="footer-sections">
    	<div class="section-separator">
    		<h4>Categorias</h4>
    		<ul>
	            <li><a href="">Cultura</a></li>
	            <li><a href="">Tecnologia</a></li>
	            <li><a href="">Ocio</a></li>
	            <li><a href="">Actualidad</a></li>
	        </ul>
    	</div>
    	<div class="section-separator">
    		<h4>Filtros</h4>
    		<ul>
	            <li><a href="registrar-noticia.html">Enviar historia</a></li>
	            <li><a href="">Portada</a></li>
	            <li><a href="Noticias">Nuevas</a></li>
	            <li><a href="">Populares</a></li>
	        </ul>
    	</div>
    	<div>
    		<h4>Usuario</h4>
    		<ul>
	            <li><a href="login.html">Login</a></li>
	            <c:if test="${user}"> 
		            <li><a href="ver-perfil.html">Ver perfil</a></li>
		            <li><a href="modificar-perfil.html">Modificar perfil</a></li>
		            <li><a href="modificar-borrar-noticia.html">Ver mis noticias</a></li>
	            </c:if>
	        </ul>
    	</div>
   	</div>
   	<div class="footer-sections">
   		<img alt="" src="img/logo-bottom.png">
   		<div id="copyrigth">
   			<a>legal </a>/
   			<a>quienes somos </a>/
   			<a>HTML5</a> |
   			Daniel Correa Barrios, Universidad de Extremadura
   		</div>
   	</div>
   </footer>