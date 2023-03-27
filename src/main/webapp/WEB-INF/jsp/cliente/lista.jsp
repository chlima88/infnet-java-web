<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<script type="text/javascript" src="https://livejs.com/live.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" rel="stylesheet" />
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" rel="stylesheet" />
	<meta charset="ISO-8859-1">
	<title>Listagem de clientes</title>
	<style>
		td, th {
			text-align: center;
		}

		a.disabledLink {
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

		<h1>${usuarioLogado.empresa} - Clientes</h1>
		<hr class="mb-4">
		<c:import url="/WEB-INF/jsp/alertas.jsp" />

		<div class="d-flex align-items-center justify-content-between mb-4">
			<form class="d-flex gap-1 col-4" method="get" action="/cliente/incluir">
				<button
					class="btn col btn-primary" ${usuarioLogado.tipo.equals("P") ? "disabled" : "" } 
					type="submit">
					Novo cliente
				</button>
				<a class="btn col btn-primary" role="button" href="/cliente/buscar">Buscar</a>
			</form>
			<strong class="text-end col-3">Total de clientes: ${clientes.size()}</strong>
		</div>

		<table class="table table-sm align-middle table-hover">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nome</th>
					<th scope="col">Documento</th>
					<th scope="col">Contato</th>
					<th scope="col">Usuario</th>
					<th scope="col">Ação</th>
				</tr>
			</thead>

			<c:if test="${not empty clientes}">
				<tbody>
					<c:forEach items="${clientes}" var="cliente">
						<tr>
							<td>
								${cliente.id}
							</td>
							<td>
								${cliente.nome}
							</td>
							<td>
								${cliente.documento}
							</td>
							<td>
								${cliente.contato}
							</td>
							<td>
								${cliente.usuario.nome}
							</td>
							<td>
								<c:if test="${!usuarioLogado.tipo.equals(\" P\")}">
									<a
										class="btn btn-sm btn-primary read-edit" 
										role="button"
										href="/cliente?documento=${cliente.documento}">
										<i class="fa-regular fa-pen-to-square"></i>
									</a>
									<a
									  class="btn btn-sm btn-danger read-edit"
										role="button"
										href="/cliente/${cliente.id}/excluir">
										<i class="fa-solid fa-trash"></i>
									</a>
								</c:if>
								<c:if test="${usuarioLogado.tipo.equals(\" P\")}">
									<a 
									  class="btn btn-sm btn-primary disabled"
										role="button"
										href="#">
										<i class="fa-regular fa-pen-to-square"></i>
									</a>
									<a
									  class="btn btn-sm btn-danger disabled"
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

		<c:if test="${empty clientes }">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				Não há clientes cadastarados
				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>

	</div>

</body>

</html>