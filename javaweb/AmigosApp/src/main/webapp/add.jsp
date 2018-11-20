<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Add amigo</title>
</head>
<body>

	<h1>Añadir amigo</h1>

	<div class="error">${messerror}</div>

	<form action="" method="POST">
		<div>
			<input type="text" placeholder="Nombre" name="nombre" id="nombre" />
		</div>
		<div>
			<input type="email" placeholder="Email" name="email" id="email" />
		</div>
		<div>
			<input type="number" min="14" placeholder="Edad" name="edad"
				id="edad" />
		</div>
		<div>
			<input type="text" placeholder="Altura" name="altura" id="altura" />
		</div>
		<div>
			<input type="text" placeholder="Tiene pelo" name="pelo" id="pelo" />
		</div>
		<div>
			<button>Guardar</button>
		</div>
	</form>

	<c:if test="${unAmigo!=null}">
		<h2>Datos recibidos</h2>
		<ul>
			<li>Nombre:${unAmigo.nombre}</li>
			<li>Email:${unAmigo.email}</li>
			<li>Edad:${unAmigo.edad}</li>
			<li>Altura:${unAmigo.altura}</li>
			<li>Pelo:${unAmigo.alopecia}</li>
		</ul>
	</c:if>

</body>
</html>