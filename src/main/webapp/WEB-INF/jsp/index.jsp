<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://livejs.com/live.js"></script>
  
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <title>ATapp</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
    <div class="container mb-3">
        
        <h2 class="mb-4">Home</h2>
        
        <div class="alert alert-primary alert-dismissible fade show" role="alert">
            <p>Bem-vindo de volta <strong>${usuario.getNome()}</strong>!</p>
            <p>Utilize os links abaixo ou o menu no superior para navegar entre as páginas</p>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>


        <h3>App</h3>
        <ul>
            <li><a href="/login">Login</a></li>
        </ul>
        
        <h3>Usuários</h3>
        <ul>
            <li><a href="/usuario/incluir">Cadastro</a></li>
            <li><a href="/usuario/listar">Listagem</a></li>
            <li><a href="/usuario/buscar">Buscar</a></li>
        </ul>
        
    </div>

</body>
</html>