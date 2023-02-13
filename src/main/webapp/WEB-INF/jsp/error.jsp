<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="https://livejs.com/live.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Error!</title>
</head>
<body>
	<div class="container">
		<h2 class="mb-5">Algo errado...</h2>
        <h4 class="mb-3">Ocorreu o seguinte erro:</h4>
		 
        <p class="mb-5">${erro}</p>
		
		<a class="w-25 btn btn-primary" role="button" href="/">Inicio</a>
		<a class="w-25 btn btn-primary" role="button" href="javascript:void(0)" onClick="history.go(-1); return false;">Voltar</a>
	</div>
</body>
</html>