<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
                    Menu
                  </a>
                  <ul class="dropdown-menu">
                    <li>
                        <a class="dropdown-item" href="#">Geral &raquo;</a>
                        <ul class="dropdown-menu dropdown-submenu">
                            <li><a class="dropdown-item" href="/login">Login</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Usu�rios &raquo;</a>
                        <ul class="dropdown-menu dropdown-submenu">   
                            <li><a class="dropdown-item" href="/usuario/incluir">Cadastro</a></li>
                            <li><a class="dropdown-item" href="/usuario/listar">Listagem</a></li>
                            <li><a class="dropdown-item" href="/usuario/buscar">Buscar</a></li>
                        </ul>
                    </li>
                  </ul>
                  
                </li>
              </ul>
            </div>
            
            <ul class="nav navbar-nav navbar-right">
                <li><a class="nav-link" href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a class="nav-link" href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
          </div>
        </nav>

</body>
</html>