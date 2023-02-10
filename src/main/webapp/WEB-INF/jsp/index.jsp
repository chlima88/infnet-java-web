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

	<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
	   <symbol id="info-fill" viewBox="0 0 16 16">
	       <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
	   </symbol>
	</svg>
	
    <div class="container mb-3">
        <h1>AT App</h1>
        <div class="alert alert-primary alert-dismissible fade show" role="alert">
	             Bem-vindo de volta <strong>${usuario.getNome()}</strong>!
	            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        
        
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