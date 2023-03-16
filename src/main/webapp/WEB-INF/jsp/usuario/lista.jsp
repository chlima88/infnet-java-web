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
	a.disabledLink{
	    color: currentColor;
	    cursor: not-allowed;
	    opacity: 0.5;
	    text-decoration: none;
	}
	</style>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
        
        
		<h1>Listagem de usuários</h1>
		
        <c:if test="${not empty msg}">
            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                ${msg}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
		
		<form method="get" action="/usuario/incluir">
			<button 
              class="w-25 btn btn-primary"
              ${usuarioLogado.tipo.equals("A") ? "" : "disabled"}
              type="submit"
            >Novo usuário</button>
            <a class="w-25 btn btn-primary" role="button" href="/usuario/buscar" >Buscar</a>
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
                    <th scope="col">Clientes</th>
                    <th scope="col">Ação</th>
				</tr>
			</thead>
			
		    <c:if test="${not empty usuarios}" >
		        <tbody>
		            <c:forEach items="${usuarios}" var="usuario">
		                <tr>
                            <td>
                                ${usuario.id}
                            </td>
	                        <td>
	                            ${usuario.nome}
                            </td>
                            <td>
                                ${usuario.email}
                           </td>
	                       <td>
	                           ${usuario.caracteristicas}
	                       </td>
	                       <td>
                               ${usuario.tipo.equals("P") ? "Padrão" : ""}
                               ${usuario.tipo.equals("A") ? "Administrador" : ""}
                               ${usuario.tipo.equals("D") ? "Diretor" : ""}
	                       </td>
	                       <td>
	                           ${usuario.setor.equals("1") ? "Comercial" : ""}
	                           ${usuario.setor.equals("2") ? "Diretoria" : ""}
	                           ${usuario.setor.equals("3") ? "Desenvolvimento" : ""}
	                       </td>
                           <td>
                               ${usuario.clientes.size()}
                           </td>
	                       <td>
	                           <c:if test="${usuarioLogado.tipo.equals(\"A\")}">
	                               <a href="/usuario?email=${usuario.getEmail()}">Editar</a> 
	                               <a href="/usuario/${usuario.getId()}/excluir">Excluir</a>
	                           </c:if>
	                           <c:if test="${!usuarioLogado.tipo.equals(\"A\")}">
	                               <a class="disabledLink" href="#">Editar</a>
	                               <a class="disabledLink" href="#">Excluir</a>
	                           </c:if>
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