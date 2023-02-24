<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <c:if test="${ not empty usuario }">
	                <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Usuários
                      </a>
                      <ul class="dropdown-menu">  
                          <li><a class="dropdown-item" href="/usuario/incluir">Cadastro</a></li>
                          <li><a class="dropdown-item" href="/usuario/listar">Listagem</a></li>
                          <li><a class="dropdown-item" href="/usuario/buscar">Buscar</a></li>
                      </ul>
                    </li>
                    <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Clientes
                      </a>
                      <ul class="dropdown-menu">  
                          <li><a class="dropdown-item" href="/cliente/incluir">Cadastro</a></li>
                          <li><a class="dropdown-item" href="/cliente/listar">Listagem</a></li>
                          <li><a class="dropdown-item" href="/cliente/buscar">Buscar</a></li>
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
	                      <li><a class="dropdown-item" href="/agendamento/incluir">Cadastro</a></li>
	                      <li><a class="dropdown-item" href="/agendamento/listar">Listagem</a></li>
	                      <li><a class="dropdown-item" href="/agendamento/buscar">Buscar</a></li>
	                  </ul>
	                </li>
                   </c:if>
	              </ul>
	            </div>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${empty usuario}">
	                <li><a class="nav-link" href="/usuario/incluir"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	                <li><a class="nav-link" href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	            </c:if>
                <c:if test="${not empty usuario}">
                    <li><a class="nav-link" href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout, ${usuario.nome}</a></li>
                </c:if>
            </ul>
          </div>
        </nav>

</body>
</html>