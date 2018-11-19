<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <!--tagli paea el for each-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>
	<h1><a href="./agnadirhabitacion">Añadir Habitación</a></h1>
	
	
	<h1>Registrarse</h1>
	<form action="" method="POST" novalidate>
		<div class="error">${mensajeerror}</div>
		<div><input type="name" placeholder="Name" name="name" value="${nuevoUsuario.name}" required /></div>
		<div class="error esconder"> Debes introducir un nombre válido</div>
		<div><input type="email" placeholder="Email" name="email" value="${nuevoUsuario.email}" required /></div>
		<div class="error esconder"> Debes introducir un email válido</div>
		<div><input type="password" placeholder="Contraseña" name="password" value="" required /></div>
		<div class="error esconder"> Debes introducir una contraseña válido</div>
		<div><input type="password" placeholder="Repetir contraseña" name="confirmpassword" required /></div>
		<div class="error esconder"> Debes introducir la misma contraseña</div>
		
			<!--Aquí irán las habitaciones, el for each recorre todo lo almacenado dentro de un for-->
		<div><select name="habitacion" id="habitacion">
		<c:forEach var="unaHab" items="${lasHabitaciones}">  
  			<option value="${unaHab.hid}">"${unaHab.calle}"</option>
		</c:forEach>
		</select></div>
		<div><button id="enviarBtn">Entrar</button></div>
	</form>
	
	<img src="./img/images.png" alt="" />
	
</body>
<script src="./js/jquery.js"></script>
<script src="./js/validacionformularios.js"></script>
</html>