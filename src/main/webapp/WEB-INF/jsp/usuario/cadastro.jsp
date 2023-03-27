<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://livejs.com/live.js"></script>
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
	<title>Cadastro de usuários</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
	
		<h1>Cadastrar usuário</h1>
		
			<c:import url="/WEB-INF/jsp/alertas.jsp" />
	
	    <div x-data="{pessoa: $store.csPessoa.pessoa}" class="row">
				<form class="col" action="/usuario/incluir" method="post" enctype='multipart/form-data'>
				
					<div class="col">
						<div class="row mb-3">
							<div class="form-group mb-2">
								<label class="form-label" for="nome">Nome:</label>
								<input 
								    class="form-control"
								    x-model="pessoa.nome"
								    x-init="pessoa.nome=pessoa.nome ?? 'Charles'"
								    type="text"
								    name="nome"
								 />
							</div>
							<div class="form-group mb-2">
								<label class="form-label" for="empresa">Empresa:</label>
								<input
								    class="form-control"
								    x-model="pessoa.empresa"
								    x-init="pessoa.empresa=pessoa.empresa ?? 'CarServices'"
								    type="text"
								    name="empresa"
								/>
							</div>
							<div class="form-group w-50 mb-2">
								<label class="form-label" for="contato">E-mail: </label>
								<input
								    class="form-control"
								    x-model="pessoa.email"
								    x-init="pessoa.email=pessoa.email ?? 'c@carservices'"
								    type="email"
								    name="email"
								/>
							</div>
							<div class="form-group w-50 mb-2">
								<label class="form-label" for="senha">Senha: </label>
								<input
								    class="form-control"
								    x-model="pessoa.senha"
								    x-init="pessoa.senha=pessoa.senha ?? '123'"
								    type="password"
								    name="senha"
								/>
							</div>
						</div>
						
						<div class="row mb-3">
							<div class="col mb-3">
								<p>Tipo: </p>
								<div class="form-check">
									<input
									    class="form-check-input"
									    x-model="pessoa.tipo"
									    value="P"
									    type="radio"
									    name="tipo"
									    checked
									/>
									<label class="form-check-label" for="tipoPadrao">Padrão</label>
								</div>
								<div class="form-check">
									<input
									    class="form-check-input"
									    x-model="pessoa.tipo"
									    value="D"
									    type="radio"
									    name="tipo"
									/>
									<label class="form-check-label" for="tipoDiretor">Diretor</label>
								</div>
								<div class="form-check">
									<input
									   class="form-check-input"
									   x-model="pessoa.tipo"
									   value="A"
									   type="radio"
									   name="tipo"
								    />
									<label class="form-check-label" for="tipoDatabase">Administrador</label>
								</div>
							</div>
					
							<div class="col mb-3">
							
								<p>Características:</p>
				
								<div class="form-check">
									<input
									   class="form-check-input"
									   x-model="pessoa.caracteristicas"
									   type="checkbox"
									   name="caracteristicas"
									   id="caracteristicasDev"
									   value="Ele"
									   checked />
									<label class="form-check-label" for="caracteristicasDev">Eletrica</label>
								</div>
								
								<div class="form-check">
									<input
									   class="form-check-input"
									   x-model="pessoa.caracteristicas"
									   type="checkbox"
									   name="caracteristicas"
									   id="caracteristicasAnl"
									   value="Lan"
									/>
									<label class="form-check-label" for="caracteristicasAnl">Lanternagem</label>
								</div>
								
								<div class="form-check">
									<input
									   class="form-check-input"
									   x-model="pessoa.caracteristicas"
									   type="checkbox"
									   name="caracteristicas"
									   id="caracteristicasDb"
									   value="Mec"
								    />
									<label class="form-check-label" for="caracteristicasDb">Mecanica</label>
								</div>
							
							</div>

							
							<div class="input-group mb-3">
								<input type="file" id="imagem" name="imagem" accept="image/png, image/gif, image/jpeg" class="form-control" id="imagem">
							</div>
							
						</div>
						
						<div class="d-flex gap-1">
							<button
							class="btn col btn-primary" 
							${empty usuarioLogado || usuarioLogado.tipo.equals("A") ? "" : "disabled"}
							type="submit"
							>Cadastrar</button>
							<a class="btn col btn-primary" role="button" href="/usuario/listar" >Cancelar</a>
						</div>
							
					</div>
					               
					<input type="hidden" x-model="pessoa.endereco.cep" name="cep" />               
					<input type="hidden" x-model="pessoa.endereco.logradouro" name="logradouro" />
					<input type="hidden" x-model="pessoa.endereco.bairro" name="bairro" />
					<input type="hidden" x-model="pessoa.endereco.localidade" name="localidade" />
					<input type="hidden" x-model="pessoa.endereco.uf" name="uf" />
				
				</form>
				<c:import url="/WEB-INF/jsp/endereco/cadastro.jsp">
						<c:param name="origem" value="usuario/incluir" />
				</c:import>

			</div>
	</div>
	

</body>
</html>