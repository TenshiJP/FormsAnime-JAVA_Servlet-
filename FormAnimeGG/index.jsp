<!-- Copyright (c) 2002 by ObjectLearn. All Rights Reserved. -->
<!-- Angel Roberto Jacinto Payes - 5990-2-01756 -->
<!DOCTYPE html>
<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <title>AnimeGG</title>
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
	            <h2 class="form-title">Crear Cuenta Gratis</h2>
	        </div>
	        <section class="form-container">
	            <form name="form-registro" method="post" action="registro">
	                <div class="input-group">
	                    <label for="nombre" class="input-label">
	                        <span class="input-span">&#191;Cu&#225;l es tu nombre?</span>
	                    </label>
	                    <input type="text" id="nombre" name="nombre" class="input-field" placeholder="Pon tu nombre..." required>
	                </div>
	                <div class="input-group">
	                    <label for="apellido" class="input-label">
	                        <span class="input-span">&#191;Cu&#225;l es tu apellido?</span>
	                    </label>
	                    <input type="text" id="apellido" name="apellido" class="input-field" placeholder="Pon tu apellido..." required>
	                </div>
	                <div class="input-group">
	                    <label for="telefono" class="input-label">
	                        <span class="input-span">&#191;Cu&#225;l es tu n&#250;mero de celular?</span>
	                    </label>
	                    <input type="number" id="telefono" name="telefono" class="input-field" placeholder="XXXXXXXX" required>
	                </div>
	                <div class="input-group">
	                    <label for="email" class="input-label">
	                        <span class="input-span">&#191;Cu&#225;l es tu correo electr&#243;nico?</span>
	                    </label>
	                    <input type="text" id="email" name="email" class="input-field" placeholder="Pon tu correo electr&#243;nico..." required>
	                </div>
	                <div class="input-group">
	                    <label for="password" class="input-label">
	                        <span class="input-span">Crea una contrase&#241a</span>
	                    </label>
	                    <input type="password" id="password" name="password" class="input-field" placeholder="Crea tu contrase&#241a..." required>
	                </div>
	                <div class="input-group">
	                    <label for="key" class="input-label">
	                        <span class="input-span">Confirma tu contrase&#241a</span>
	                    </label>
	                    <input type="password" id="key" name="key" class="input-field" placeholder="Confirma tu contrase&#241a..." required>
	                </div>
	                <div class="input-group">
	                    <label for="apodo" class="input-label">
	                        <span class="input-span">&#191;C&#243;mo quieres que te llamemos?</span>
	                    </label>
	                    <input type="text" id="apodo" name="apodo" class="input-field" placeholder="Pon un nombre de perfil..." required>
	                </div>
	                <div class="input-group">
	                    <label for="fecha" class="input-label">
	                        <span class="input-span">&#191;Cu&#225;l es tu fecha de nacimeinto?</span>
	                    </label>
	                    <input type="date" id="fecha" name="fecha" class="input-field" required>
	                </div>
	                <div class="input-group">
	                    <label class="input-legend">
	                        <span class="input-span">&#191;Cu&#225;l es tu g&#233;nero?</span>
	                    </label>
	                    <div class="radio-group">
	                        <input type="radio" id="hombre" name="genero" value="Masculino" class="radio-input">
	                        <label for="hombre" class="radio-label">Hombre</label>
	                    </div>
	                    <div class="radio-group">
	                        <input type="radio" id="mujer" name="genero" value="Femenino" class="radio-input">
	                        <label for="mujer" class="radio-label">Mujer</label>
	                    </div>
	                    <div class="radio-group">
	                        <input type="radio" id="otro" name="genero" value="Otro" class="radio-input">
	                        <label for="otro" class="radio-label">Otro</label>
	                    </div>
	                    <div class="radio-group">
	                        <input type="radio" id="desconocido" name="genero" value="No especificado" class="radio-input">
	                        <label for="desconocido" class="radio-label">Prefiero no responder</label>
	                    </div>
	                </div>
	                
	                <div class="input-group">
	                    <label class="input-legend">
	                        <span class="input-span">&#191;Quieres conocer las &#250;ltimas novedades?</span>
	                    </label>
	                    <input type="checkbox" id="oferta" name="oferta" value="Si" class="checkbox-input">
	                    <label for="oferta" class="checkbox-label">Quiero conocer todas las &#250;ltimas noticias, informaci&#243;n y ofertas de AnimeGG.</label>
	                </div>
	                <div class="input-group">
	                    <button type="button" class="submit-button" id="btn-crear-cuenta">Crear Cuenta</button>
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
	    <script src="script.js"></script>
	</body>
</html>
