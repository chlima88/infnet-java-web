<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://livejs.com/live.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" rel="stylesheet" />
    <meta charset="UTF-8">
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
				<c:import url="/WEB-INF/jsp/header.jsp" >
						<c:param name="title" value="Usuários" />
				</c:import>	

		
        <div class="d-flex align-items-center justify-content-between mb-4">
            <form class="d-flex gap-1 col-4" method="get" action="/usuario/incluir">
                <button 
                  class="btn col btn-primary"
                  ${usuarioLogado.tipo.equals("P") ? "disabled" : ""}
                  type="submit"
                >Novo usuário</button>
                <a class="btn col btn-primary" role="button" href="/usuario/buscar" >Buscar</a>
            </form>
            <strong class="text-end col-3">Total de usuários: ${usuarios.size()}</strong>
        </div>
		
		<table class="table table-sm align-middle table-hover">
			<thead>
				<tr>
				    <th scope="col">Id</th>
				    <th scope="col">Nome</th>
					<th scope="col">E-mail</th>
					<th scope="col">Caracteristicas</th>
					<th scope="col">Tipo</th>
                    <th scope="col">Empresa</th>
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
	                           <c:if test="${usuario.tipo.equals('A')}">
	                               <span class="badge bg-success rounded-pill d-inline">Admin</span>
	                           </c:if>
	                           <c:if test="${usuario.tipo.equals('D')}">
	                               <span class="badge bg-primary rounded-pill d-inline">Diretor</span>
	                           </c:if>
	                           <c:if test="${usuario.tipo.equals('P')}">
	                               <span class="badge bg-secondary rounded-pill d-inline">Padrão</span>
	                           </c:if>
	                           
	                       </td>
	                       <td>
	                           ${usuario.empresa}
	                       </td>
                           <td>
                               ${usuario.clientes.size()}
                           </td>
	                       <td>
	                           <c:choose>
	                           <c:when test="${usuarioLogado.id == usuario.id }">
	                               <a 
	                                   class="btn btn-sm btn-primary " 
	                                   role="button" 
	                                   href="/usuario?email=${usuario.getEmail()}" 
	                                   ><i class="fa-regular fa-pen-to-square"></i>
	                              </a> 
	                               <a 
	                                   class="btn btn-sm btn-danger disabled"
	                                   role="button"
	                                   href="/usuario/${usuario.getId()}/excluir"
	                                   ><i class="fa-solid fa-trash"></i>
	                               </a>
	                           </c:when>
                               <c:when test="${usuarioLogado.tipo.equals(\"A\") && !usuario.masterAdmin }">
                                   <a
	                                   class="btn btn-sm btn-primary"
	                                   role="button"
	                                   href="/usuario?email=${usuario.getEmail()}"
	                                   ><i class="fa-regular fa-pen-to-square"></i>
                                   </a> 
                                   <a
	                                   class="btn btn-sm btn-danger"
	                                   role="button"
	                                   href="/usuario/${usuario.getId()}/excluir"
	                                   ><i class="fa-solid fa-trash"></i>
                                   </a>
                               </c:when>
	                           <c:otherwise>
	                               <a
		                               class="btn btn-sm btn-primary disabled"
		                               role="button"
		                               href="#"
		                               ><i class="fa-regular fa-pen-to-square"></i>
	                               </a>
	                               <a
		                               class="btn btn-sm btn-danger disabled"
		                               role="button"
		                               href="#"
		                               ><i class="fa-solid fa-trash"></i>
	                               </a>
	                           </c:otherwise>
	                           </c:choose>
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