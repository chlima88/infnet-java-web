<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
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
</head>
<body>

       <nav class="navbar navbar-expand-lg bg-primary navbar-dark mb-4">
          <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="/home">CarServices</a>
		    </div>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="nav navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="/home">
                    Home
                  </a>
                 </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Usuarios
                  </a>
                  <ul class="dropdown-menu">  
                      <li><a class="dropdown-item" href="/usuario/incluir">Cadastro</a></li>
                      <li><a class="dropdown-item" href="/usuario/listar">Listagem</a></li>
                      <li><a class="dropdown-item" href="/usuario/buscar">Buscar</a></li>
                  </ul>
                </li>
                                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Serviços
                  </a>
                  <ul class="dropdown-menu">  
                      <li><a class="dropdown-item" href="/usuario/incluir">Cadastro</a></li>
                      <li><a class="dropdown-item" href="/usuario/listar">Listagem</a></li>
                      <li><a class="dropdown-item" href="/usuario/buscar">Buscar</a></li>
                  </ul>
                </li>
                                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Agendamentos
                  </a>
                  <ul class="dropdown-menu">  
                      <li><a class="dropdown-item" href="/usuario/incluir">Cadastro</a></li>
                      <li><a class="dropdown-item" href="/usuario/listar">Listagem</a></li>
                      <li><a class="dropdown-item" href="/usuario/buscar">Buscar</a></li>
                  </ul>
                </li>
              </ul>
            </div>
            
            <ul class="nav navbar-nav navbar-right">
                <li><a class="nav-link" href="/usuario/incluir"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a class="nav-link" href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
          </div>
        </nav>

</body>
</html>