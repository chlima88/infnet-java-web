<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="https://livejs.com/live.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    
    <link rel="stylesheet" href="https://unpkg.com/@jarstone/dselect/dist/css/dselect.css">
    <script src="https://unpkg.com/@jarstone/dselect/dist/js/dselect.js"></script>
  
    <meta charset="UTF-8">
	<title>Cadastro de agendamentos</title>
	
	<style>
	.select2-container .select2-selection--single{
	    height:34px !important;
	}
	.select2-container--default .select2-selection--single{
         border: 1px solid #ccc !important; 
	     border-radius: 0px !important; 
	}
	</style>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
	
        <c:import url="/WEB-INF/jsp/header.jsp" >
            <c:param name="title" value="Cadastrar Agendamento" />
        </c:import>
                
		<form action="/agendamento/incluir" method="post">
		    
		    <c:set var="estadoBotao" value=""/>
			<div class="row row-cols-1 row-cols-md-4">
				<div class="col mb-3">				
                    
					<label class="form-label">Cliente</label>
			        <select name="clienteId" class="form-select select-box">
                        <c:if test="${not empty clientes }">
			            <c:forEach items="${clientes}" var="cliente">
			               <option value="${ cliente.id }">${cliente.nome}</option> 
			            </c:forEach>
			            </c:if>
                        <c:if test="${empty clientes }">
                            <option selected >N�o h� items para exibir</option>
                            <c:set var="estadoBotao" value="disabled" />
                        </c:if>
			        </select>
			        
                    <label name="data" class="form-label">Data</label>
                    <input type="datetime-local" value="2023-03-17T08:00" name="data" class="form-control">	
                    
                    <label class="form-label">Dura��o</label>
                    <input type="number" value=30 min="30" step="30" name="duracaoEmMinutos" class="form-control">           		       
                    
                </div>
                
                <div class="col mb-3">   
                    <label class="form-label">Atendente</label>
                    <select name="usuarioId" class="form-select select-box" >
                        <c:if test="${not empty usuarios }">
                        <c:forEach items="${usuarios}" var="usuario">
                           <option value="${ usuario.id }">${usuario.nome}</option> 
                        </c:forEach>
                        </c:if>
                        <c:if test="${empty usuarios }">
                            <option selected >N�o h� items para exibir</option>
                            <c:set var="estadoBotao" value="disabled" />
                        </c:if>
                    </select>   
                    
                    <label class="form-label">Servi�o</label>
                    <select name="servicoCodigos" class="form-select select-box" required multiple>
                    
                        <c:if test="${not empty servicos }">
                        <c:forEach items="${servicos}" var="servico">
                           <option value="${ servico.codigo }">${servico.codigo} | ${servico.nome}</option> 
                        </c:forEach>
                        </c:if>
                        <c:if test="${empty servicos }">
                            <option selected >N�o h� items para exibir</option>
                            <c:set var="estadoBotao" value="disabled" />
                        </c:if>
                    </select>
	
				</div>
			</div>
		
			<button class="w-25 btn btn-primary ${estadoBotao}" type="submit">Cadastrar</button>
            <a class="w-25 btn btn-primary" role="button" href="/agendamento/listar" >Cancelar</a>
			
		</form>
	</div>
	
	<script>
	Array.from(document.getElementsByClassName("select-box")).forEach(item => dselect(item, {search: true} ))      
	</script>

</body>
</html>