<%@page import="java.util.Collection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "br.edu.infnet.atapp.model.domain.Usuario" %>
<%@ page import = "br.edu.infnet.atapp.model.repository.UsuarioRepository" %>
<%@ page import = "java.util.List" %>
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
        a { text-decoration: none;}
        a:hover { text-decoration: underline;}
        th, td {
		  text-align: center;
		}
    </style>
	<title>Listagem de usuários</title>
</head>
<body>
	<div class="container">
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
		                            <a class="dropdown-item" href="#">Usuários &raquo;</a>
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
        
		<h1>Listagem de usuários</h1>
		
        <c:if test="${not empty usuario}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Usuário <strong>${usuario.getEmail()}</strong> cadastrado com sucesso!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
		
		<form method="get" action="/usuario/incluir">
			<button class="w-25 btn btn-primary" type="submit">Novo usuário</button>
			<a class="w-25 btn btn-primary" role="button" href="javascript:void(0)" onClick="history.go(-1); return false;">Voltar</a>
		</form>
		
		<table class="table table-hover">
			<thead>
				<tr>
				    <th scope="col">Id</th>
				    <th scope="col">Nome</th>
					<th scope="col">E-mail</th>
					<th scope="col">Tipo</th>
					<th scope="col">Caracteristicas</th>
                    <th scope="col">Setor</th>
                    <th scope="col">Ação</th>
				</tr>
			</thead>
			
		    <c:if test="${not empty usuarios}" >
		        <tbody>
		            <c:forEach items="${usuarios}" var="usuario">
		                <tr>
                            <td>
                                ${usuario.getId()}
                            </td>
	                        <td>
	                            ${usuario.getNome()}
                            </td>
                            <td>
                                ${usuario.getEmail()}
                           </td>
	                       <td>
	                           ${usuario.getCaracteristicas()}
	                       </td>
	                       <td>
	                           ${usuario.getTipo()}
	                       </td>
	                       <td>
	                           ${usuario.getSetor()}
	                       </td>
	                       <td>
	                           <a href="/usuario?email=${usuario.getEmail()}">
	                               Editar
	                           </a>
	                           <a href="/usuario/${usuario.getId()}/excluir">
	                               Excluir
	                           </a>
	                       </td>
	                    </tr>
		            </c:forEach> 
		        </tbody>
		    </c:if>
		</table>
		
        <c:if test="${empty usuarios }">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                Não há usuarios cadastarados
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
	
	</div>

</body>
</html>