<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Habitacion</title>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	
	<h1>Datos de Habitacion</h1>
	<ul>
		<li>id :${laHabitacion.hid}</li>
		<li>Calle :${laHabitacion.calle}</li>
		<li>Metros Cuadrados :${laHabitacion.metros}</li>		
	</ul>
	
	<button id="volverBtn">Volver</button>

</body>

<script src="./js/script.js"></script>

</html>