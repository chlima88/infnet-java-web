<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="https://livejs.com/live.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>
<body>

	<div class="container pt-5" style="width:400px;" >
	
		<h1 class="mb-4">Login</h1>
		<form method="post" action="login">
			<div class="form-outline mb-4">
				<label class="form-label" for="email">E-mail</label>
				<input type="text" name="email" id="email" class="form-control">
			</div>
			<div class="form-outline mb-4">
				<label class="form-label" for="senha">Senha</label>
				<input type="password" name="senha" id="senha" class="form-control">
			</div>
			<button type="submit" class="w-25 btn btn-primary">Acessar</button>
			<a class="w-25 btn btn-primary" role="button" href="javascript:void(0)" onClick="history.go(-1); return false;">Voltar</a>
		</form>
	</div>

</body>
</html>