<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="https://livejs.com/live.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Login</title>
	<style>
        body {
            background-image: radial-gradient(circle, rgba(0,212,255,0) 0%, rgba(9,9,121,0.3701855742296919) 50%, rgba(2,0,36,0.7399334733893557) 100%), url("./carservices.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            height: 100vh;
	       
	   }
	   
	   h1 {
	       color: #222;
	   }
	</style>
</head>
<body>

	<div class="container pt-5 vh-100 d-flex flex-column justify-content-center" style="width:400px;" >
		<form class="bg-white rounded-4 p-5" method="post" action="login">
	        <div class="text-center mb-4 mx-auto">
	            <h1>CarServices</h1>
	        </div>
            <c:if test="${not empty erro}">
	            <div class="alert alert-danger alert-dismissible fade show" role="alert">
	                ${erro}
	            </div>
	        </c:if>
			<div class="form-floating mb-4">
				<input  class="form-control" type="text" name="email" id="email" value="admin@carservices" placeholder="name@example.com">
				<label for="email">E-mail</label>
			</div>
			<div class="form-floating mb-4">
				<input  class="form-control" type="password" name="senha" id="senha" value="123" placeholder="Password">
				<label class="form-label" for="senha">Senha</label>
			</div>
			<button type="submit" class="w-100 btn btn-primary">Acessar</button>
		</form>
	</div>

</body>
</html>