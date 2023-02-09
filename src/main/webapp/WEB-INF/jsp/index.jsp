<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="https://livejs.com/live.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>ATapp</title>
</head>
<body>
	<div class="container mb-3">
		<h1>AT App</h1>
		<h4 style="color:red;">${message}</h3>
		
		
		<h2>Menu</h2>


		<h3>App</h3>
		<ul>
			<li><a href="/login">Login</a></li>
			<li><a href="/error">Pagina de erro</a></li>
		</ul>
		
		<h3>Usuários</h3>
		<ul>
			<li><a href="/usuario/incluir">Cadastro</a></li>
			<li><a href="/usuario/listar">Listagem</a></li>
            <li><a href="/usuario/buscar">Buscar</a></li>
            <li><a href="/usuario">Dados</a></li>
		</ul>
		
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    
</body>
</html>