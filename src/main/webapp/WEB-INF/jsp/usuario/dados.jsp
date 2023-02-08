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
	<title>Dados do usuario</title>
</head>
<body>
	<div class="container">
		<table>
			<tbody>
				<%
				List<Usuario> usuarios = UsuarioRepository.findAll(); 
				
				for (Usuario usuario: usuarios) {
				%>
					<tr>
						<th scope=row>Nome</th>
						<td><%= usuario.getNome() %></td>
					</tr>
					<tr>
						<th scope=row>Email</th>
						<td></td>
					</tr>
					<tr>
						<th scope=row>Caracteristicas</th>
						<td></td>
					</tr>
					<tr>
						<th scope=row>Tipo</th>
						<td></td>
					</tr>
					<tr>
						<th scope=row>Setor</th>
						<td></td>
					</tr>
				<% } %>
			</tbody>
		</table>
	</div>
</body>
</html>