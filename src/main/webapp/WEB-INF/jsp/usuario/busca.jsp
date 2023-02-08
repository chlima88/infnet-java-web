<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="https://livejs.com/live.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Busca de usuário</title>
</head>
<body>

	<div class="container">
		<h1>Busca de Usuário</h1>
		
		<form>
			<label class="form-label" for="usuario">Informe o nome: </label>
			<input class="form-control mb-3" type="text" value="Charles" name="usuario" id="usuario" />
			<button class="w-25 btn btn-primary" type="submit">Buscar</button>
			<a class="w-25 btn btn-primary" role="button" href="javascript:void(0)" onClick="history.go(-1); return false;">Voltar</a>
			
		</form>
	</div>
	

</body>
</html>