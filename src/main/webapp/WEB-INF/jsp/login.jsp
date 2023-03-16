<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="https://livejs.com/live.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>
<body>

	<div class="container pt-5" style="width:400px;" >
	
		<div class="mb-4 mx-auto"  style="width: 210px;">
			<h1>CarServices</h1>
		</div>
		
		<c:if test="${not empty erro}">
		    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${erro}
            </div>
		</c:if>
		
		<form method="post" action="login">
			<div class="form-outline mb-4">
				<label class="form-label" for="email">E-mail</label>
				<input  class="form-control" type="text" name="email" id="email" value="admin@carservices">
			</div>
			<div class="form-outline mb-4">
				<label class="form-label" for="senha">Senha</label>
				<input  class="form-control" type="password" name="senha" id="senha" value="123">
			</div>
			<button type="submit" class="w-100 btn btn-primary">Acessar</button>
		</form>
	</div>

</body>
</html>