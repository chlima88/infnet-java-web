<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
	<title>Listagem de servicos eletricos</title>
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
    <fmt:setLocale value = "pt_BR"/>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
        
		<h1>${usuarioLogado.empresa} - Servicos eletricos</h1>
        <hr class="mb-4">
        
        <c:import url="/WEB-INF/jsp/alertas.jsp" />
        
        <div class="d-flex align-items-center justify-content-between mb-4">
            <form class="d-flex gap-1 col-4" method="get" action="/eletrica/incluir">
                <button 
                    class="btn col btn-primary"
                    ${usuarioLogado.tipo.equals("P") ? "disabled" : ""}
                    type="submit">
                    Novo Serviço
                </button>
                <a class="btn col btn-primary" role="button" href="/eletrica/buscar" >Buscar</a>
            </form>
            <strong class="text-end col-3">Total de serviços: ${servicos.size()}</strong>
        </div>
		
		<table class="table table-hover">
			<thead>
				<tr>
				    <th scope="col">Id</th>
				    <th scope="col">Codigo</th>
					<th scope="col">Nome</th>
                    <th scope="col">Preço</th>
					<th scope="col">Circuitos</th>
                    <th scope="col">Terceirizado</th>
                    <th scope="col">Ação</th>
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
                               <fmt:formatNumber type = "currency" value="${servico.obterPrecoMaoDeObra()}" /> 
	                       </td>
	                       <td>
                               ${servico.circuitoDanificado}
	                       </td>
	                       <td>
	                           ${servico.terceirizado ? "Sim" : "Não"}
	                       </td>
                           <td>
                                <c:if test="${!usuarioLogado.tipo.equals(\"P\")}">
                                    <a class="btn btn-sm btn-primary"
                                        role="button"
                                        href="/eletrica?codigo=${servico.codigo}">
                                        <i class="fa-regular fa-pen-to-square"></i>
                                    </a> 
                                    <a class="btn btn-sm btn-danger"
                                        role="button"
                                        href="/eletrica/${servico.id}/excluir">
                                        <i class="fa-solid fa-trash"></i>
                                    </a>
                                </c:if>
                                <c:if test="${usuarioLogado.tipo.equals(\"P\")}">
                                    <a class="btn btn-sm btn-primary disabled"
                                        role="button"
                                        href="#">
                                        <i class="fa-regular fa-pen-to-square"></i>
                                    </a>
                                    <a class="btn btn-sm btn-danger disabled"
                                        role="button"
                                        href="#">
                                        <i class="fa-solid fa-trash"></i>
                                    </a>
                                </c:if>
                           </td>
	                    </tr>
		            </c:forEach> 
		        </tbody>
		    </c:if>
		</table>
		
        <c:if test="${empty servicos }">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                Não há serviços cadastrados
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
	
	</div>

</body>
</html>