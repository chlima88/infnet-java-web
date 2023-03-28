<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <!--  <script type="text/javascript" src="https://livejs.com/live.js"></script>-->
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <meta charset="UTF-8">
	<title>Cadastro de clientes</title>
	<script>


	</script>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
	
		<c:import url="/WEB-INF/jsp/header.jsp" >
			<c:param name="title" value="Cadastrar cliente" />
		</c:import>	
		
		<div x-data="{pessoa: $store.csPessoa.pessoa}" class="row">
			<form class="col" action="/cliente/incluir" method="post">
				<div class="row mb-2">
					<div class="form-group mb-2">
						<label class="form-label" for="nome">Nome:</label>
						<input 
					       class="form-control"
					       x-model="pessoa.nome"
                           x-init="pessoa.nome = pessoa.nome ?? 'Stella Ribeiro'"
					       type="text"
					       name="nome"
					    />
					</div>
					
					<div class="form-group mb-2">
						<label class="form-label" for="documento">Documento: </label>
						<input
						   class="form-control"
						   x-model="pessoa.documento"
                           x-init="pessoa.documento = pessoa.documento ?? '130199977'"
						   type="text"
						   name="documento"
						/>
					</div>
					
					<div class="form-group mb-2">
						<label class="form-label" for="contato">Contato: </label>
						<input
						   class="form-control"
						   x-model="pessoa.contato"
                           x-init="pessoa.contato = pessoa.contato ?? '21988166470'"
						   type="text"
						   name="contato"
						/>
					</div>
						
				</div>

				<div class="d-flex gap-1">
					<button class="btn col btn-primary" type="submit">Cadastrar</button>
					<a class="btn col btn-primary" role="button" href="/cliente/listar" >Cancelar</a>
				</div>
				
				<input type="hidden" x-model="pessoa.endereco.cep" name="cep" />               
				<input type="hidden" x-model="pessoa.endereco.logradouro" name="logradouro" />
				<input type="hidden" x-model="pessoa.endereco.bairro" name="bairro" />
				<input type="hidden" x-model="pessoa.endereco.localidade" name="localidade" />
				<input type="hidden" x-model="pessoa.endereco.uf" name="uf" />
			</form>
			<c:import url="/WEB-INF/jsp/endereco/cadastro.jsp">
					<c:param name="origem" value="cliente/incluir" />
			</c:import>
		</div>
	</div>
	

</body>
</html>