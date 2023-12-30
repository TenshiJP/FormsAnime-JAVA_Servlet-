<!-- Angel Roberto Jacinto Payes - 5990-20-1756 -->
<%@ page language="java" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <title>AnimeGG - Resultado Usuarios </title> 
	    <link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<script languaje="javascript">
		function askDelete(){
			if(confirm("¿Esta seguro de eliminar el usuario seleccionado?")){
				document.forms.formOptions.Eliminar.value = "SI";
				window.document.formOptions.submit();
			}
		}
	
		function askUpdate(){
			if(confirm("¿Esta seguro de actualizar los datos del usuario seleccionado?")){
				document.forms.formOptions.Actualizar.value = "SI";
				window.document.formOptions.submit();
			}
		}
		
		function asigneValues(pId, pNombre, pApellido, pApodo, pFecha, pSexo, pTel, pMail, pOferta){
			document.getElementById('dUser1').style.display = 'block';
			document.getElementById('dUser2').style.display = 'block';
			document.forms.formOptions.cod.value = pId;
			document.forms.formOptions.nombre.value = pNombre;
			document.forms.formOptions.apellido.value = pApellido;
			document.forms.formOptions.apodo.value = pApodo;
			document.forms.formOptions.fecha.value = pFecha;
			document.forms.formOptions.genero.value = pSexo;
			document.forms.formOptions.telefono.value = pTel;
			document.forms.formOptions.email.value = pMail;
			document.forms.formOptions.oferta.value = pOferta;
			document.forms.formOptions.cod.focus();	
		}
	</script>
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
	    	<br><br><br><br><br>
	        <div id="dUser1" style="display:none">
	            <h2 class="form-title">Usuario Seleccionado</h2>
	        </div>
	    	<section id="dUser2" class="form-container"  style="display:none">
	            <form name="formOptions" method="post" action="modCuenta">
	            	<div class="input-group">
	                    <label for="cod" class="input-label">
	                        <span class="input-span">ID</span>
	                    </label>
	                    <input type="text" id="cod" name="cod" class="input-field" value="" readonly>
	                </div>
	                <div class="input-group">
	                    <label for="nombre" class="input-label">
	                        <span class="input-span">Nombre</span>
	                    </label>
	                    <input type="text" id="nombre" name="nombre" class="input-field" value="">
	                </div>
	                <div class="input-group">
	                    <label for="apellido" class="input-label">
	                        <span class="input-span">Apellido</span>
	                    </label>
	                    <input type="text" id="apellido" name="apellido" class="input-field" value="">
	                </div>
	                <div class="input-group">
	                    <label for="apodo" class="input-label">
	                        <span class="input-span">Apodo</span>
	                    </label>
	                    <input type="text" id="apodo" name="apodo" class="input-field" value="">
	                </div>
	                <div class="input-group">
	                    <label for="fecha" class="input-label">
	                        <span class="input-span">Fecha de Nacimeinto</span>
	                    </label>
	                    <input type="text" id="fecha" name="fecha" class="input-field" value="">
	                </div>
	                <div class="input-group">
	                    <label class="input-legend">
	                        <span class="input-span">G&#233;nero</span>
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
	                    <label for="telefono" class="input-label">
	                        <span class="input-span">N&#250;mero de celular</span>
	                    </label>
	                    <input type="tel" id="telefono" name="telefono" class="input-field" value="">
	                </div>
	                <div class="input-group">
	                    <label for="email" class="input-label">
	                        <span class="input-span">Correo Electr&#243;nico</span>
	                    </label>
	                    <input type="text" id="email" name="email" class="input-field" value="">
	                </div>
	                <div class="input-group">
	                    <label class="input-legend">
	                        <span class="input-span">Conocer las &#250;ltimas novedades</span>
	                    </label>
	                    <div class="radio-group">
	                        <input type="radio" id="Si" name="oferta" value="Si" class="radio-input">
	                        <label for="Si" class="radio-label">Si</label>
	                    </div>
	                    <div class="radio-group">
	                        <input type="radio" id="Nombre" name="oferta" value="No" class="radio-input">
	                        <label for="No" class="radio-label">No</label>
	                    </div>
	                </div>
	                <div class="input-group">
	                    <input type="button" value="Actualizar" class="submit-button" onClick="javascript:askUpdate();">
	                    <input type="hidden" name="Actualizar">
	                    <input type="button" value="Eliminar" class="submit-button" onClick="javascript:askDelete();">
	                    <input type="hidden" name="Eliminar">
	                </div>
	            </form>
	        </section>
	        <br><br><br>
	        <div>
	            <h2 class="form-title">Resultado de Usuarios</h2>
	        </div>
	        <section name="usuarios-cuenta" class="result-table-container">
	            <table class="result-table">
	            
	            	<tr>
	            		<th>ID</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Apodo</th>
						<th>Fecha de Nacimiento</th>
						<th>Sexo</th>
						<th>Telefono</th>
						<th>E-mail</th>
						<th>Novedades</th>
					</tr>
					
					<%if(session.getAttribute("catUsuarios") != null){
						ArrayList arrayData = (ArrayList)session.getAttribute("catUsuarios");
						if(arrayData.size() > 0){ 
							for (int j=0; j<arrayData.size(); j++) {
								Object[] objDatos = (Object[])arrayData.get(j);
					%>
					
					<tr onClick="javascript:asigneValues('<%=objDatos[0]%>', '<%=objDatos[1]%>', '<%=objDatos[2]%>', '<%=objDatos[5]%>', '<%=objDatos[6]%>', '<%=objDatos[7]%>', '<%=objDatos[3]%>', '<%=objDatos[4]%>', '<%=objDatos[8]%>');">
						<td><%=objDatos[0]%></td>
						<td><%=objDatos[1]%></td>
						<td><%=objDatos[2]%></td>
						<td><%=objDatos[5]%></td>
						<td><%=objDatos[6]%></td>
						<td><%=objDatos[7]%></td>
						<td><%=objDatos[3]%></td>
						<td><%=objDatos[4]%></td>
						<td><%=objDatos[8]%></td>
					</tr>
					
					<%		} //Fin ciclo
						} // Fin if Condicional.
					  }	// Fin if session. 
					%>
	            </table>
	        </section><br><br>   
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
