<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://livejs.com/live.js"></script>
  
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <meta charset="UTF-8">
	<title>Busca de usu�rio</title>
</head>
<body>

    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
       
		<h1>Busca de Usu�rio</h1>
		
        <c:import url="/WEB-INF/jsp/alertas.jsp" />
		
		<form method="get" action="/usuario">
			<label class="form-label" for="email">Informe o e-mail: </label>
			<input class="form-control mb-3" type="email" value="1@1.com" name="email" id="email" />
			<button class="w-25 btn btn-primary" type="submit">Buscar</button>
            <a class="w-25 btn btn-primary" role="button" href="/usuario/listar" >Cancelar</a>
		</form>
	</div>
	

</body>
</html>