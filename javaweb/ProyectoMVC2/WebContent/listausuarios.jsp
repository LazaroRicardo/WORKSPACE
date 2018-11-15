<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  bloque añadido al ppio para utilizar el tablib jstl:-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Los Usuarios</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>

	<h1>Usuarios</h1>
	<ul>
	<!--para cada uno de los usuarios voy a guardar el atributo en unUsuario y lo voy a utilizar después para montar los "li":-->
	<!--  código añadido  por el tablib jstl, ya que sino no podría utilizarlo:-->
		<c:forEach var="unUsuario" items="${losUsuarios}">  
  			<li>
  			<!-- para que al pinchar en cada usuario te lleve a una pag diferente:-->
	  			<a href="./usuario?id=${unUsuario.id}">
	  				<div>( ${unUsuario.id} )</div>
	  				<div>${unUsuario.name}</div>
	  			</a>
  			</li>
		</c:forEach>
	</ul>
</body>
</html>