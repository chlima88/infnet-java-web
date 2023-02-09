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
	<title>Dados do Usuário</title>
</head>
<body>
	<div class="container">
	
    <h1 class="md-5">Informações do usuário</h1>
	       
		<table class="table table-hover">
			<tbody>
					<tr>
						<th scope=row>Nome</th>
						<td>${usuario.getNome()}</td>
					</tr>
					<tr>
						<th scope=row>Email</th>
						<td>${usuario.getEmail()}</td>
					</tr>
					<tr>
						<th scope=row>Caracteristicas</th>
						<td>${usuario.getCaracteristicas()}</td>
					</tr>
					<tr>
						<th scope=row>Tipo</th>
						<td>${usuario.getTipo()}</td>
					</tr>
					<tr>
						<th scope=row>Setor</th>
						<td>${usuario.getSetor()}</td>
					</tr>
			</tbody>
		</table>
        <a class="w-25 btn btn-primary" role="button" href="javascript:void(0)" onClick="history.go(-1); return false;">Voltar</a>
        <a class="w-25 btn btn-primary" role="button" href="/">Inicio</a>
	</div>
</body>
</html>