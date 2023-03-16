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
	<title>Dados do Usuário</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
 
        	
	
    <h1 class="md-5">Informações do usuário</h1>
    
        <c:if test="${not empty erro}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${erro}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
	       

        <form action="/usuario/atualizar" method="post">
        
            <input type="hidden" value="${usuario.getEmail()}" name="emailBuscado" />
            <input type="hidden" value="${usuario.getId()}" name="id" />
        
            <div class="row row-cols-1 row-cols-md-4">
                <div class="col mb-3">
                    <label class="form-label" for="nome">Nome:</label>
                    <input class="form-control enable-disable" value="${usuario.getNome()}" type="text" name="nome" disabled/>
                    
                    <label class="form-label" for="contato">E-mail: </label>
                    <input class="form-control enable-disable" value="${usuario.getEmail()}" type="email" name="email" disabled/>
                    
                    <label class="form-label" for="documento">Senha: </label>
                    <input class="form-control enable-disable" value="${usuario.getSenha()}" type="password" name="senha" disabled/>
    
                </div>
                
                <div class="col mb-3">
                    <p>Tipo: </p>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="P"
                            type="radio"
                            name="tipo"
                            ${ usuario.getTipo() == "P" ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="tipoPadrao">Padrão</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="D"
                            type="radio"
                            name="tipo"
                            ${ usuario.getTipo() == "D" ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="tipoDiretor">Diretor</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="A"
                            type="radio"
                            name="tipo"
                            ${ usuario.getTipo() == "A" ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="tipoDatabase">Administrador</label>
                    </div>
                </div>
            
                <div class="col mb-3">
                
                    <p>Características:</p>
    
                    <div class="form-group">
                        <input 
                            class="form-check-input enable-disable" 
                            type="checkbox"
                            name="caracteristicas"
                            id="caracteristicasDev"
                            value="Dev"
                            ${ usuario.getCaracteristicas().contains("Dev") ? 'checked' : '' }
                            disabled />
                        <label class="form-check-label" for="caracteristicasDev">Developer</label>
                    </div>
                    
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            type="checkbox"
                            name="caracteristicas"
                            id="caracteristicasAnl"
                            value="Anl"
                            ${ usuario.getCaracteristicas().contains("Anl") ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="caracteristicasAnl">Analista</label>
                    </div>
                    
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            type="checkbox"
                            name="caracteristicas"
                            id="caracteristicasDb"
                            value="Db"
                            ${ usuario.getCaracteristicas().contains("Db") ? 'checked' : '' }
                            disabled/>
                        <label class="form-check-label" for="caracteristicasDb">Database</label>
                    </div>
                
                </div>
            
                <div class="col mb-3">
                    <p>Setor:</p>
                    <select class="enable-disable" name="setor" disabled>
                        <option value=1 ${ usuario.getSetor() == 1 ? 'selected' : '' }>Comercial</option>
                        <option value=2 ${ usuario.getSetor() == 2 ? 'selected' : '' }>Diretoria</option>
                        <option value=3 ${ usuario.getSetor() == 3 ? 'selected' : '' }>Desenvolvimento</option>
                    </select>
                    
                
                </div>
            </div>
	        
	        <button 
               class="w-25 btn btn-primary read-edit"
               type="button"
               onClick="editar()" 
               ${usuarioLogado.tipo.equals("A") ? "" : "disabled" }
            >Editar</button>
	        <button class="w-25 btn btn-primary read-edit hidden">Salvar</button>
	        <button class="w-25 btn btn-primary read-edit hidden" type="button" onClick="editar()">Cancelar</button>
            <a class="w-25 btn btn-primary read-edit" role="button" href="/usuario/listar" >Cancelar</a>
                    
        </form>
	</div>
</body>
</html>