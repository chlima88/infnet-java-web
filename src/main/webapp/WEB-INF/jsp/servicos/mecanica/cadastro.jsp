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
	<title>Cadastrar servico mecânico</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
	
        <c:import url="/WEB-INF/jsp/header.jsp" >
            <c:param name="title" value="Cadastrar servico mecânico" />
        </c:import>	
	
		<form action="/mecanica/incluir" method="post">
		
			<div class="row row-cols-1 row-cols-md-4">
				<div class="col mb-3">
					<label class="form-label" for="nome">Nome:</label>
					<input class="form-control" value="Troca de oleo" type="text" name="nome" />
					
					<label class="form-label" for="codigo">Código: </label>
					<input class="form-control" value="M02" type="text" name="codigo"/>
					
					<label class="form-label" for="precoBase">Preço Base: </label>
					<input class="form-control" value="150" type="text" name="precoBase"/>
	
				</div>
				
				<div class="col mb-3">
                    <p>Tipo: </p>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="revisao"
                            type="radio"
                            name="categoriaServico"
                        />
                        <label class="form-check-label" for="tipoRevisao">Revisão</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="troca"
                            type="radio"
                            name="categoriaServico"
                            checked
                        />
                        <label class="form-check-label" for="tipoTroca">Troca</label>
                    </div>
                    <div class="form-group">
                        <input
                            class="form-check-input enable-disable"
                            value="manutencao"
                            type="radio"
                            name="categoriaServico"
                        />
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
            <a class="w-25 btn btn-primary" role="button" href="/mecanica/listar" >Cancelar</a>
			
		</form>
	</div>
	

</body>
</html>