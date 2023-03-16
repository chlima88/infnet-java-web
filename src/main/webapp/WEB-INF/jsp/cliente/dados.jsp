<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://livejs.com/live.js"></script>
  
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <style>
       
     .hidden {
        display:none;
     }
    
    </style>
    <script>
    function editar() {
    	inputList = document.getElementsByClassName("read-edit"); 
    	for (let item of inputList) { 
    		item.classList.toggle("hidden");
    	}
    	
    	inputs = document.getElementsByClassName("enable-disable")
    	for (let item of inputs) {
    		item.disabled = !item.disabled;
    	}

    }
    
    </script>
	<title>Dados do Cliente</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
 
        	
	
    <h1 class="md-5">Informações do cliente</h1>
    
        <c:if test="${not empty erro}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${erro}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
	       

        <form action="/cliente/atualizar" method="post">
        
            <input type="hidden" value="${cliente.documento}" name="documentoBuscado" />
            <input type="hidden" value="${cliente.id}" name="id" />
        
            <div class="row row-cols-1 row-cols-md-4">
                <div class="col mb-3">
                    <label class="form-label" for="nome">Nome:</label>
                    <input class="form-control enable-disable" value="${cliente.nome}" type="text" name="nome" disabled/>
                    
                    <label class="form-label" for="documento">Documento: </label>
                    <input class="form-control enable-disable" value="${cliente.documento}" type="text" name="documento" disabled/>
                    
                    <label class="form-label" for="contato">Contato: </label>
                    <input class="form-control enable-disable" value="${cliente.contato}" type="text" name="contato" disabled/>
    
                </div>
            </div>
	        
	        <button 
               class="w-25 btn btn-primary read-edit"
               type="button"
               onClick="editar()" 
               ${usuarioLogado.tipo.equals("P") ? "disabled" : ""}
            >Editar</button>
	        <button class="w-25 btn btn-primary read-edit hidden">Salvar</button>
	        <button class="w-25 btn btn-primary read-edit hidden" type="button" onClick="editar()">Cancelar</button>
            <a class="w-25 btn btn-primary read-edit" role="button" href="/cliente/listar" >Cancelar</a>
                    
        </form>
	</div>
</body>
</html>