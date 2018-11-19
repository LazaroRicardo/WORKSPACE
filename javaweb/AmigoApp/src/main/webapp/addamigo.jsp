<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Amigo</title>
</head>
<body>
	<h1>Añadir amigo</h1>

	<form action="" method="POST" novalidate>

		<div>
			<input type="number" placeholder="Id" name="id" required />
		</div>

		<div>
			<input type="text" placeholder="Nombre" name="name" required />
		</div>

		<div>
			<input type="number" placeholder="Edad" name="edad" required />
		</div>

		<div>
			<input type="email" placeholder="Email" name="email" required />
		</div>

		<div>
			<input type="text" placeholder="¿Alopecia?" name="pelo" required />
		</div>

		<div>
			<button id="enviarBtn">Entrar</button>
		</div>
	</form>

	<h1>Datos Recibidos</h1>
	
	<ul>
		<li>Id:${unAmigo.id1}</li>
		<li>Nombre:${unAmigo.name}</li>
		<li>Edad:${unAmigo.edad2}</li>
		<li>Email:${unAmigo.email}</li>
		<li>Alopecia:${unAmigo.calvo}</li>
	</ul>

</body>
</html>