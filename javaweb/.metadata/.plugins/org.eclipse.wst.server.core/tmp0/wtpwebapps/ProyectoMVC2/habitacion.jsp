<%@page import="com.ricardo.modelos.Habitacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Habiteishon</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	<h1>Datos de Habitación</h1>
		<ul>
			<li>HID: ${laHabitacion.hid}</li>
			<li>Calle: ${laHabitacion.calle}</li>
			<li>Metros2: ${laHabitacion.m2}</li>
			
			<button id="volverBtn">Volver</button>
		</ul>
	<img src="./img/images.png" alt="" />
</body>
<script src="./js/script.js"></script>
</html>