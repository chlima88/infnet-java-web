<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <!--<script type="text/javascript" src="https://livejs.com/live.js"></script>-->
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>  
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
	<title>Dados do Usuário</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
 
    <c:import url="/WEB-INF/jsp/header.jsp" >
        <c:param name="title" value="Informações do usuário" />
    </c:import>	
    
        <c:import url="/WEB-INF/jsp/alertas.jsp" />
	       
        <div x-data="{pessoa: $store.csPessoa.pessoa}" class="row">
            <form class="col" action="/usuario/atualizar" method="post">
                <input type="hidden" name="emailAtual" value="${usuario.email}" />
                <input type="hidden" name="id" value="${usuario.id}" />
            
                <div class="col">
                    <div class="row mb-3">
                        <div class="form-group mb-2">
                            <label class="form-label" for="nome">Nome:</label>
                            <input
                                class="form-control enable-disable"
                                value="${usuario.nome}"
                                type="text"
                                name="nome"
                                disabled
                        />
                        </div>           
					    <div class="form-group mb-2">
                            <label class="form-label" for="nome">Empresa:</label>
                            <input
                                class="form-control enable-disable"
                                value="${usuario.empresa}"
                                type="text"
                                name="empresa"
                                disabled
                        />
                        </div>
						<div class="form-group w-50 mb-2">
                            <label class="form-label" for="contato">E-mail: </label>
                            <input
                                class="form-control enable-disable"
                                value="${usuario.email}"
                                type="email"
                                name="email" 
                                disabled
                            />
                        </div>
                        <div class="form-group w-50 mb-2">
                            <label class="form-label" for="documento">Senha: </label>
                            <input
                                class="form-control enable-disable"
                                value="${usuario.senha}"
                                type="password"
                                name="senha"
                                disabled
                            />
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <div class="col mb-3">
                            <p>Tipo: </p>
                            <div class="form-group">
                                <input
                                    class="form-check-input enable-disable"
                                    value="P"
                                    type="radio"
                                    name="tipo"
                                    ${ usuario.tipo == "P" ? 'checked' : '' }
                                    disabled/>
                                <label class="form-check-label" for="tipoPadrao">Padrão</label>
                            </div>
                            <div class="form-group">
                                <input
                                    class="form-check-input enable-disable"
                                    value="D"
                                    type="radio"
                                    name="tipo"
                                    ${ usuario.tipo == "D" ? 'checked' : '' }
                                    disabled/>
                                <label class="form-check-label" for="tipoDiretor">Diretor</label>
                            </div>
                            <div class="form-group">
                                <input
                                    class="form-check-input enable-disable"
                                    value="A"
                                    type="radio"
                                    name="tipo"
                                    ${ usuario.tipo == "A" ? 'checked' : '' }
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
                                    id="caracteristicasEle"
                                    value="Ele"
                                    ${ usuario.getCaracteristicas().contains("Ele") ? 'checked' : '' }
                                    disabled />
                                <label class="form-check-label" for="caracteristicasDev">Eletrica</label>
                            </div>
                            <div class="form-group">
                                <input
                                    class="form-check-input enable-disable"
                                    type="checkbox"
                                    name="caracteristicas"
                                    id="caracteristicasLan"
                                    value="Lan"
                                    ${ usuario.getCaracteristicas().contains("Lan") ? 'checked' : '' }
                                    disabled/>
                                <label class="form-check-label" for="caracteristicasAnl">Lanternagem</label>
                            </div>
                            <div class="form-group">
                                <input
                                    class="form-check-input enable-disable"
                                    type="checkbox"
                                    name="caracteristicas"
                                    id="caracteristicasMec"
                                    value="Mec"
                                    ${ usuario.getCaracteristicas().contains("Mec") ? 'checked' : '' }
                                    disabled/>
                                <label class="form-check-label" for="caracteristicasDb">Mecanica</label>
                            </div>
                        </div>
                        							
                        <div class="input-group mb-3">
                            <input
                                class="form-control enable-disable"
                                type="file"
                                id="imagem"
                                name="imagem"
                                accept="image/png, image/gif, image/jpeg"
                                disabled>
                        </div>
							
                    </div>
                    

                    <div  class="d-flex gap-1">
                        <button 
                            class="btn btn-primary col read-edit"
                            type="button"
                            onClick="editar()" 
                            ${usuarioLogado.tipo.equals("A") || usuarioLogado.id == usuario.id ? "" : "disabled" }>
                            Editar
                        </button>
                        <button class="btn btn-primary col read-edit hidden">Salvar</button>
                        <button class="btn btn-primary col read-edit hidden" type="button" onClick="editar()">Cancelar</button>
                        <a class="btn btn-primary col read-edit" role="button" href="/usuario/listar" >Cancelar</a>
                    </div>

                </div>
					               
                <input type="hidden" x-model="pessoa.endereco.cep" name="cep" />               
                <input type="hidden" x-model="pessoa.endereco.logradouro" name="logradouro" />
                <input type="hidden" x-model="pessoa.endereco.bairro" name="bairro" />
                <input type="hidden" x-model="pessoa.endereco.localidade" name="localidade" />
                <input type="hidden" x-model="pessoa.endereco.uf" name="uf" />
                        
            </form>
            <c:import url="/WEB-INF/jsp/endereco/cadastro.jsp">
                <c:param name="origem" value="usuario?email=${usuario.email}" />
                <c:param name="status" value="disabled" />
            </c:import>
        </div>
	</div>
</body>
</html>