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
	<title>Busca de agendamentos</title>
</head>
<body>

    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
       
        <c:import url="/WEB-INF/jsp/header.jsp" >
            <c:param name="title" value="Buscar Agendamento" />
        </c:import>
		
		<form method="get" action="/agendamento">
			<label class="form-label" for="documento">Informe o documento: </label>
			<input class="form-control w-25 mb-3" type="text" value="12345678910" name="documento" id="documento" />

            <label name="data" class="form-label">Data</label>
            <input type="datetime-local" value="2023-05-01T09:15" name="data" class="form-control w-25 mb-3" required> 
                    
			<button class="w-25 btn btn-primary" type="submit">Buscar</button>
            <a class="w-25 btn btn-primary" role="button" href="/agendamento/listar" >Cancelar</a>
		</form>
	</div>
	

</body>
</html>