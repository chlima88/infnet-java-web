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
	<title>Dados do servico - eletrica</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">

        <c:import url="/WEB-INF/jsp/header.jsp" >
            <c:param name="title" value="Informações do serviço" />
        </c:import>	

        <form id="form" action="/eletrica/atualizar" method="post">
        
            <input type="hidden" value="${servico.codigo}" name="codigoBuscado" />
            <input type="hidden" value="${servico.id}" name="id" />
        
            <div class="row row-cols-1 row-cols-md-4">
                <div class="col mb-3">
                    <label class="form-label" for="nome">Nome:</label>
                    <input class="form-control enable-disable" value="${servico.nome}" type="text" name="nome" disabled/>
                    
                    <label class="form-label" for="codigo">Código: </label>
                    <input class="form-control enable-disable" value="${servico.codigo}" type="text" name="codigo" disabled/>
                    
                    <label class="form-label" for="precoBase">Preço Base: </label>
                    <input class="form-control enable-disable" value="${servico.precoBase}" type="text" name="precoBase" disabled/>
                        
                </div>
                
                <div class="col mb-3">
                    <p>Tipo: </p>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="ignicao"
                            type="radio"
                            name="circuitoDanificado"
                            ${ servico.circuitoDanificado == "ignicao" ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="tipoRevisao">Ignição</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="arranque"
                            type="radio"
                            name="circuitoDanificado"
                            ${ servico.circuitoDanificado ==  "arranque" ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="tipoTroca">Arranque</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="luzes"
                            type="radio"
                            name="circuitoDanificado"
                            ${ servico.circuitoDanificado == "luzes" ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="tipoManutencao">Luzes</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="acess�rios"
                            type="radio"
                            name="circuitoDanificado"
                            ${ servico.circuitoDanificado == "acess�rios" ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="tipoManutencao">Acessórios</label>
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
            <a class="w-25 btn btn-primary read-edit" role="button" href="/eletrica/listar" >Cancelar</a>
                    
        </form>
	</div>
</body>
</html>