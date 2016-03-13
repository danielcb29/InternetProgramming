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
 	<link rel="stylesheet" href="css/base.css">
 	<link rel="stylesheet" href="css/registro.css">
</head>
<body>
	<div class="head" id="nombre-categorias">
		<div>
			<img alt="" src="img/menu.png">
			<a href="lista-noticias.html"><img alt="" src="img/logo-top.png"></a>
			<img alt="" src="img/door.png">
		</div>
		<div id="categorias">
			<ul>
				<li><a>cultura y tecnologia</a></li>
				<li><a>edicion general</a></li>
				<li><a>deportes</a></li>
			</ul>
		</div>
		<div class="rigth">
			<a href="">login</a> /
			<a href="">registrarse</a>
		</div>
	</div>
	<div class="head" id="logo-search">
		<div><img alt="" src="img/elef.png"></div>
		<div><b>edicion general</b></div>
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
            <li><a href="registrar-noticia.html">enviar historia</a></li>
            <li><a href="">portada</a></li>
            <li><a href="">nuevas</a></li>
            <li><a href="">populares</a></li>
        </ul>
    </nav>
    <article>
    	<h2 id="titulo">Registro</h2>
    	<section id="bloque-registro">
    		<div class="img-sg">
	    		<img alt="" src="img/reg.png">
	    	</div>
    		<div id="inputs">
    			<form action="" method="post">
    				<h2>${messages.error}</h2>
	    			<div class="row">
			    		<label>Nombre de usuario:</label>
			    		<input class="rg-inp" type="text"  name="name" placeholder="nombre usuario" required>
			    		<!--  input type="button" value="Verificar"-->
		    		</div>
		    		<div class="row">
			    		<label>Correo electronico:</label>
			    		<input class="rg-inp" type="email"  name="email" placeholder="email" required>
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
		            <li><a href="">Nuevas</a></li>
		            <li><a href="">Populares</a></li>
		        </ul>
	    	</div>
	    	<div>
	    		<h4>Usuario</h4>
	    		<ul>
		            <li><a href="login.html">Login</a></li>
		            <li><a href="ver-perfil.html">Ver perfil</a></li>
		            <li><a href="modificar-perfil.html">Modificar perfil</a></li>
		            <li><a href="modificar-borrar-noticia.html">Ver mis noticias</a></li>
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

</body>
</html>