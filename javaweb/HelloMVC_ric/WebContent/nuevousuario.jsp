<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date de alta</title>
<link rel="stylesheet" href="./css
/style.css" />
</head>
<body>

	<h1>Date de alta</h1>

	<form action="" method="POST"
	id="nuevousuarioform" novalidate>
		<div class="error">${mensajeerror}</div>
		
		<div>
			<input type="email" placeholder="Email" name="email" id="email" value="${newusuario.email}" required/>
			<div class="error esconder" id="emailerr">Debes introducir un email válido</div>
		</div>
		<div>
			<input type="text" placeholder="Nombre" name="nombre" id="nombre" value="${newusuario.name}" />
			<div class="error esconder" id="nombreerr">Debes introducir un nombre válido</div>
		</div>
		<div>
			<input type="password" placeholder="Contraseña" name="pass" id="pass" value="" />
			<div class="error esconder" id="passerr">Debes introducir una contraseña válido</div>
		</div>
		<div>
			<input type="password" placeholder="Repetir contraseña" name="reppass" id="reppass" />
			<div class="error esconder" id="reppasserr">Las contraseñas deben coincidir</div>
		</div>
		<div>
			<label for="habitacion">Habitación:</label>
			<select name="habitacion" id="habitacion">
				<c:forEach var="unaHab" items="${lasHabitaciones}">
					<option value="${unaHab.hid}">${unaHab.calle}</option>
				</c:forEach>
			</select>
			<div class="error esconder" id="habitacionerr">Debes introducir una habitación válida</div>

		</div>
		
		<a href="./nuevahabitacion">Nueva habitacion</a>
		
		<div>
			<button id="enviarBtn">Enviar</button>
		</div>
	</form>

</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/script.js"></script>
</html>







