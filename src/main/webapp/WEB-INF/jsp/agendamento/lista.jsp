<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" rel="stylesheet" />
    <meta charset="UTF-8">
	<title>Listagem de agendamentos</title>
	<style>
	td, th { text-align: center; }
	td ul li {list-style: none;}
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
        
        <c:import url="/WEB-INF/jsp/header.jsp" >
            <c:param name="title" value="Agendamentos" />
        </c:import>
        
        <div class="d-flex align-items-center justify-content-between mb-4">
            <form class="d-flex gap-1 col-4" method="get" action="/agendamento/incluir">
                <button 
                  class="btn col btn-primary"
                  ${usuarioLogado.tipo.equals("P") ? "disabled" : ""}
                  type="submit"
                >Novo Agendamento</button>
                <a class="btn col btn-primary" role="button" href="/agendamento/buscar" >Buscar</a>
            </form>
            <strong class="text-end col-3">Total de agendamentos: ${agendamentos.size()}</strong>
        </div>
		
		<table class="table table-hover">
			<thead>
				<tr>
				    <th scope="col">Data</th>
					<th scope="col">Duracao</th>
					<th scope="col">Servicos</th>
					<th scope="col">Preço total</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Atendente</th>
                    <th scope="col">Ação</th>
				</tr>
			</thead>
			
		    <c:if test="${not empty agendamentos}" >
		        <tbody>
		            <c:forEach items="${agendamentos}" var="agendamento">
		                <tr>
	                        <td>
	                           <fmt:parseDate value="${ agendamento.data }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                               <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${ parsedDateTime }" />
                            </td>
                            <td>
                                ${agendamento.duracaoEmMinutos} min
                            </td>
                            <td>
                                <ul>
                                    <c:forEach items="${agendamento.servicos}" var="servico">
                                        <li>${servico.codigo} - ${servico.nome}</li>
                                    </c:forEach>
                                </ul>
                            </td>
                            <td>
                                <c:set var="total" value="0" />
                                <c:forEach items="${agendamento.servicos}" var="servico">
                                    <c:set var="total" value="${total + servico.obterPrecoFinal()}" />
                                </c:forEach>
                                <fmt:formatNumber type = "currency" value="${total}" />                             
                            </td>
                            <td>
                                ${agendamento.cliente.nome}
                            </td>
                            <td>
                                ${agendamento.usuario.nome}
                            </td>
                            <td>
                                <c:if test="${!usuarioLogado.tipo.equals(\"P\")}">
                                    <a class="btn btn-sm btn-primary"
                                        role="button"
                                        href="/agendamento?documento=${agendamento.cliente.documento}&data=${agendamento.data}">
                                        <i class="fa-regular fa-pen-to-square"></i>
                                    </a> 
                                    <a class="btn btn-sm btn-danger"
                                        role="button"
                                        href="/agendamento/${agendamento.id}/excluir">
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
		
        <c:if test="${empty agendamentos }">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                N�o h� agendamentos cadastarados
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
	
	</div>

</body>
</html>