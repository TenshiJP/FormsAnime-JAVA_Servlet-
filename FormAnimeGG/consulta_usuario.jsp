<%@ page language="java" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<!-- Angel Roberto Jacinto Payes - 5990-2-01756 -->
<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <title>AnimeGG - Usuarios </title> 
	    <link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<body>
	    <header>
	        <nav>
	        	<img src="logo.jfif" alt="Logo Anime GG">
	        	<h1>AnimeGG</h1>
	        	<ul class="nav-links">
		            <li><a href="index.jsp">Registrar Usuario</a></li>
		            <li><a href="consulta_usuario.jsp">Buscar Usuario</a></li>
		        </ul>
	        </nav>
	    </header>
	    <main>
	    	<br><br><br><br><br><br>
	        <div>
	            <h2 class="form-title">B&#250;squeda de Usuario</h2>
	        </div>
	        <section class="form-container">
	            <form name="form-registro" method="post" action="consultaCuenta">
	                <div class="input-group">
	                    <label for="nombre" class="input-label">
	                        <span class="input-span">B&#250;squeda por nombre</span>
	                    </label>
	                    <input type="text" id="nombre" name="nombre" class="input-field" value="" placeholder="Pon el nombre a buscar...">
	                </div>
	                <div class="input-group">
	                    <label for="apellido" class="input-label">
	                        <span class="input-span">B&#250;squeda por apellido</span>
	                    </label>
	                    <input type="text" id="apellido" name="apellido" class="input-field" value="" placeholder="Pon el apellido a buscar...">
	                </div>
	                <div class="input-group">
	                    <label for="apodo" class="input-label">
	                        <span class="input-span">B&#250;squeda por apodo del perfil</span>
	                    </label>
	                    <input type="text" id="apodo" name="apodo" class="input-field" value="" placeholder="Pon el nombre de perfil a buscar...">
	                </div>
	                <div class="input-group">
	                    <input type="submit" name="Buscar" class="submit-button" id="btn-crear-cuenta" value="Buscar Usuario"></button>
	                </div>
	            </form>
	        </section>
	    </main>
	    <footer>
	        <section>
	            <div><img src="logo.jfif" alt="Logo AnimeGG"></div>
	            <div>&#169; AnimeGG</div>
	        </section>
	        <section><p>Angel Jacinto - 5990-20-1756</p></section>
	    </footer>
	</body>
</html>
