<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Login</title>
<link rel="stylesheet" href="./css/styles.css" />
</head>
<body>
	<h1>Login</h1>
	
	<div class="error">${mensaje_error}</div>
	<form action="" method="POST">
		<div>
			<input type="text" placeholder="Nombre" name="nombre" />
		</div>
		<div>
			<input type="text" placeholder="Número" name="numero" maxlength="20"  minlength="20"/>
		</div>
		<div>
			<input type="text" placeholder="Saldo" name="saldo" />
		</div>
		<div>
			<button>Crear</button>
		</div>
	</form>
</body>
</html>