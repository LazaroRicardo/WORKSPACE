<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Proyecto Spotify</h1>
	${lasCanciones}
	<ul>
	<!--para cada uno de los usuarios voy a guardar el atributo en unUsuario y lo voy a utilizar despu�s para montar los "li":-->
	<!--  c�digo a�adido  por el tablib jstl, ya que sino no podr�a utilizarlo:-->
		<c:forEach var="unaCancion" items="${lasCanciones}">  
  			<li>
  			<!-- para que al pinchar en cada usuario te lleve a una pag diferente:-->
	  			<a href="./usuario?id=${unUsuario.id}">
	  				<div>( ${unaCancion.id} )</div>
	  				<div>${unaCancion.titulo}</div>
	  				<div>${unaCancion.autor}</div>
	  				<div>${unaCancion.imagen}</div>
	  			</a>
  			</li>
		</c:forEach>
		
	</ul>
</body>
</html>