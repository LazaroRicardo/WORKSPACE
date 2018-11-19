<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Habitación</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>
	<h1>Añadir Habitación</h1>
	<form action="" method="POST">
		<div class="error">${mensajeerror}</div>
		
		<div><input type="text" placeholder="Calle" name="calle" value="${laHabitacion.calle}" required /></div>
		<div><input type="number" placeholder="Metros2" name="metros2" value="${laHabitacion.m2}" required /></div>

		<div><button>Entrar</button></div>
	</form>
	<img src="./img/images.png" alt="" />
</body>
</html>