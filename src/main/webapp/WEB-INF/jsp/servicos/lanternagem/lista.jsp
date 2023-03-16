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
	<title>Listagem de servicos lanternagem</title>
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
        
        
		<h1>Listagem de servicos lanternagem</h1>
		
        <c:if test="${not empty msg}">
            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                ${msg}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
		
		<form method="get" action="/lanternagem/incluir">
			<button class="w-25 btn btn-primary"  
              class="w-25 btn btn-primary"
              ${usuarioLogado.tipo.equals("P") ? "disabled" : ""}
              type="submit"
             type="submit">Novo Servi�o Lanternagem</button>
            <a class="w-25 btn btn-primary" role="button" href="/lanternagem/buscar" >Buscar</a>
		</form>
		
		<table class="table table-hover">
			<thead>
				<tr>
				    <th scope="col">Id</th>
				    <th scope="col">Codigo</th>
					<th scope="col">Nome</th>
					<th scope="col">Pre�o Base</th>
					<th scope="col">Tam. Avaria</th>
                    <th scope="col">Terceirizado</th>
                    <th scope="col">A��o</th>
				</tr>
			</thead>
			
		    <c:if test="${not empty servicos}" >
		        <tbody>
		            <c:forEach items="${servicos}" var="servico">
		                <tr>
                            <td>
                                ${servico.id}
                            </td>
	                        <td>
	                            ${servico.codigo}
                            </td>
                            <td>
                                ${servico.nome}
                           </td>
                           <td>
                               ${servico.obterPrecoMaoDeObra()}
                           </td>
	                       <td>
                               ${servico.tamanhoAvaria}
	                       </td>
	                       <td>
	                           ${servico.terceirizado ? "Sim" : "N�o"}
	                       </td>
                           <td>
                               <c:if test="${!usuarioLogado.tipo.equals(\"P\")}">
	                               <a href="/lanternagem?codigo=${servico.codigo}">Editar</a> 
	                               <a href="/lanternagem/${servico.id}/excluir">Excluir</a>
                               </c:if>
                               <c:if test="${usuarioLogado.tipo.equals(\"P\")}">
                                   <a class="disabledLink" >Editar</a>
                                   <a class="disabledLink" >Excluir</a>
                               </c:if>
                           </td>
	                    </tr>
		            </c:forEach> 
		        </tbody>
		    </c:if>
		</table>
		
        <c:if test="${empty servicos }">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                N�o h� servi�os cadastrados
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
	
	</div>

</body>
</html>