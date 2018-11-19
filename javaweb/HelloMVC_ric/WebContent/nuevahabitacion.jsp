<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date de alta</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>

	<h1>Nueva habitación</h1>

	<form action="" method="POST">
		<div class="error">${mensajeerror}</div>
		
		<div>
			<input type="text" placeholder="Calle" name="calle" id="calle" value="${nuevahabitacion.calle}" />
		</div>
		<div>
			<input type="text" placeholder="Metros" name="metros" id="metros" value="${nuevahabitacion.metros}" />
		</div>
		<div>
			<button>Guardar</button>
		</div>
	</form>

</body>
</html>







