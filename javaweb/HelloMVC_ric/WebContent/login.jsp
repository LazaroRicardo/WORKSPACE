
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>

	<h1>Login</h1>
	
	<div class="error">${errormensaje}</div>
	
	<form action="" method="POST">
		<div>
			<input type="email" placeholder="Email" name="email" id="email" required/>
		</div>
		<div>
			<input type="password" placeholder="Password" name="password"
				id="password" required/>
		</div>
		<div><button>Entrar</button></div>
	</form>

</body>
</html>