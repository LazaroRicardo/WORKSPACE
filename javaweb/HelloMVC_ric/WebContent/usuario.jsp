
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>
	
	<jsp:include page="./header.jsp"></jsp:include>
	
	<h1>Datos de usuario</h1>
	<ul>
		<li>id :${elusuario.id}</li>
		<li>nombre :${elusuario.name}</li>
		<li>email :${elusuario.email}</li>
		<li>Habitacion : 
		<a href="./habitacion?hid=${elusuario.habitacion.hid}">
			${elusuario.habitacion.hid}
		</a>
		</li>
	</ul>

</body>


</html>