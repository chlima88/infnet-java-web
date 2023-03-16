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
	<title>Cadastrar servico elétrico</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
	

	
		<h1>Cadastrar servico eletrico</h1>
		
        <c:if test="${not empty erro}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${erro}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
	
		<form action="/eletrica/incluir" method="post">
		
			<div class="row row-cols-1 row-cols-md-4">
				<div class="col mb-3">
					<label class="form-label" for="nome">Nome:</label>
					<input class="form-control" value="Reparo circuito luzes" type="text" name="nome" />
					
					<label class="form-label" for="codigo">Código: </label>
					<input class="form-control" value="E02" type="text" name="codigo"/>
					
					<label class="form-label" for="precoBase">Preço Base: </label>
					<input class="form-control" value="350" type="text" name="precoBase"/>
	
				</div>
				
				<div class="col mb-3">
                    <p>Tipo: </p>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="Ignicao"
                            type="radio"
                            name="circuitoDanificado"
                        />
                        <label class="form-check-label" for="tipoRevisao">Ignição</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="Arranque"
                            type="radio"
                            name="circuitoDanificado"
                            checked
                        />
                        <label class="form-check-label" for="tipoTroca">Arranque</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="Luzes"
                            type="radio"
                            name="circuitoDanificado"
                        />
                        <label class="form-check-label" for="tipoManutencao">Luzes</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="Acessórios"
                            type="radio"
                            name="circuitoDanificado"
                        />
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
                        />
                        <input type="hidden" value="false" id="terceirizadoHidden" name="terceirizado" />
                        <label class="form-check-label" for="terceirizado">Terceirizado</label>
                    </div>
                
                </div>
			</div>
		
			<button
			  class="w-25 btn btn-primary"
              ${usuarioLogado.tipo.equals("P") ? "disabled" : ""}
			  type="submit"
			>Cadastrar</button>
            <a class="w-25 btn btn-primary" role="button" href="/eletrica/listar" >Cancelar</a>
			
		</form>
	</div>
	

</body>
</html>