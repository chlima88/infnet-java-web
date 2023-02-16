<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://livejs.com/live.js"></script>
  
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <style>
        .dropdown-menu li {
    		position: relative;
		}
		.dropdown-menu .dropdown-submenu {
			display: none;
			position: absolute;
			left: 100%;
			top: -7px;
		}
		.dropdown-menu .dropdown-submenu-left {
			right: 100%;
			left: auto;
		}
		.dropdown-menu > li:hover > .dropdown-submenu {
		  display: block;
		}
    </style>
    <title>ATapp</title>
</head>
<body>
    <div class="container mb-3">
        
        
		<nav class="navbar navbar-expand-lg bg-primary navbar-dark mb-4">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="/home">Home</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Menu
                  </a>
                  <ul class="dropdown-menu">
                    <li>
                        <a class="dropdown-item" href="#">Geral &raquo;</a>
                        <ul class="dropdown-menu dropdown-submenu">
		                    <li><a class="dropdown-item" href="/login">Login</a></li>
		                    <li><a class="dropdown-item" href="/error">Pagina de erro</a></li>
		                </ul>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Usu�rios &raquo;</a>
                        <ul class="dropdown-menu dropdown-submenu">   
		                    <li><a class="dropdown-item" href="/usuario/incluir">Cadastro</a></li>
		                    <li><a class="dropdown-item" href="/usuario/listar">Listagem</a></li>
		                    <li><a class="dropdown-item" href="/usuario/buscar">Buscar</a></li>
		                    <li><a class="dropdown-item" href="/usuario">Dados</a></li>
                        </ul>
                    </li>
                  </ul>
                  
                </li>
              </ul>
            </div>
		  </div>
		</nav>
		
        
        <h2 class="mb-4">Home</h2>
        
        <div class="alert alert-primary alert-dismissible fade show" role="alert">
            <p>Bem-vindo de volta <strong>${usuario.getNome()}</strong>!</p>
            <p>Utilize os links abaixo ou o menu no superior para navegar entre as p�ginas</p>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>


        <h3>App</h3>
        <ul>
            <li><a href="/login">Login</a></li>
            <li><a href="/error">Pagina de erro</a></li>
        </ul>
        
        <h3>Usu�rios</h3>
        <ul>
            <li><a href="/usuario/incluir">Cadastro</a></li>
            <li><a href="/usuario/listar">Listagem</a></li>
            <li><a href="/usuario/buscar">Buscar</a></li>
            <li><a href="/usuario">Dados</a></li>
        </ul>
        
    </div>

</body>
</html>