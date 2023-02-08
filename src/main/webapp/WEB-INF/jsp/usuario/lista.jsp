<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "br.edu.infnet.atapp.model.domain.Usuario" %>
<%@ page import = "br.edu.infnet.atapp.model.repository.UsuarioRepository" %>
<%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="https://livejs.com/live.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Listagem de usuários</title>
</head>
<body>
	<div class="container">
	
		<h1>Listagem de usuários</h1>
		
		<form method="get" action="/usuario/incluir">
			<button class="w-25 btn btn-primary" type="submit">Novo usuário</button>
			<a class="w-25 btn btn-primary" role="button" href="javascript:void(0)" onClick="history.go(-1); return false;">Voltar</a>
		</form>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">E-mail</th>
					<th scope="col">Tipo</th>
					<th scope="col">Caracteristicas</th>
					<th scope="col">Setor</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Usuario> usuarios = UsuarioRepository.findAll(); 
					
					for (Usuario usuario: usuarios) {
						%>
						<tr>
							<td><%= usuario.getNome() %></td>
							<td><%= usuario.getEmail() %></td>
							<td><%= usuario.getTipo() %></td>
							<td><%= usuario.getCaracteristicas() %></td>
							<td><%= usuario.getSetor() %></td>
						</tr>
					   <%
						
					}
				%>
					
	
			</tbody>
		</table>
	
	</div>

</body>
</html>