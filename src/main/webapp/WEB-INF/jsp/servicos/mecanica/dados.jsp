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
	<title>Dados do servico - mecanica</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
 
        	
	
    <h1 class="md-5">Informações do Servico Mecanico</h1>
    
        <c:if test="${not empty erro}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${erro}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
	       

        <form id="form" action="/mecanica/atualizar" method="post">
        
            <input type="hidden" value="${servico.codigo}" name="codigoBuscado" />
            <input type="hidden" value="${servico.id}" name="id" />
        
            <div class="row row-cols-1 row-cols-md-4">
                <div class="col mb-3">
                    <label class="form-label" for="nome">Nome:</label>
                    <input class="form-control enable-disable" value="${servico.nome}" type="text" name="nome" disabled/>
                    
                    <label class="form-label" for="codigo">Codigo: </label>
                    <input class="form-control enable-disable" value="${servico.codigo}" type="text" name="codigo" disabled/>
                    
                    <label class="form-label" for="precoBase">Preço Base: </label>
                    <input class="form-control enable-disable" value="${servico.precoBase}" type="text" name="precoBase" disabled/>
                        
                </div>
                
                <div class="col mb-3">
                    <p>Tipo: </p>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="revisao"
                            type="radio"
                            name="categoriaServico"
                            ${ servico.categoriaServico == "revisao" ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="tipoRevisao">Revisão</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="troca"
                            type="radio"
                            name="categoriaServico"
                            ${ servico.categoriaServico == "troca" ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="tipoTroca">Troca</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="manutencao"
                            type="radio"
                            name="categoriaServico"
                            ${ servico.categoriaServico == "manutencao" ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="tipoManutencao">Manutenção</label>
                    </div>
                </div>
            
                <div class="col mb-3">
                
                    <p>Características:</p>
    
                    <div class="form-group">
                        <input
	                        class="form-check-input enable-disable" 
	                        type="checkbox"
	                        name="terceirizado"
	                        id="terceirizado"
	                        value="true"
	                        disabled
                            ${ servico.terceirizado ? 'checked' : '' }
                            disabled />
                        <input type="hidden" value="false" name="terceirizado" />
                        <label class="form-check-label" for="caracteristicasDev">Terceirizado</label>
                    </div>
                
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
            <a class="w-25 btn btn-primary read-edit" role="button" href="/mecanica/listar" >Cancelar</a>
                    
        </form>
	</div>
</body>
</html>