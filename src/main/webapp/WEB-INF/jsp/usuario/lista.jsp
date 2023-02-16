<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://livejs.com/live.js"></script>
  
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
	<title>Listagem de usuários</title>
	<style>
	td, th { text-align: center; }
	</style>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
        
        
		<h1>Listagem de usuários</h1>
		
        <c:if test="${not empty usuario}">
            <div class="alert alert-primary alert-dismissible fade show" role="alert">
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
					<th scope="col">Caracteristicas</th>
					<th scope="col">Tipo</th>
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
	                           <a href="/usuario?email=${usuario.getEmail()}">Editar</a> 
	                           <a href="/usuario/${usuario.getId()}/excluir">Excluir</a>
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