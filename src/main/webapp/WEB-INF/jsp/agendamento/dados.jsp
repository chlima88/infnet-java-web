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
    
    <link rel="stylesheet" href="https://unpkg.com/@jarstone/dselect/dist/css/dselect.css">
    <script src="https://unpkg.com/@jarstone/dselect/dist/js/dselect.js"></script>
  
    <meta charset="ISO-8859-1">
    <style>
       
     .hidden {
        display:none;
     }
    
    </style>
	<title>Dados do Agendamento</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container">
 
        	
	
    <h1 class="md-5">Informações do agendamento</h1>
    
        <c:if test="${not empty erro}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${erro}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
	       

        <form action="/agendamento/atualizar" method="post">
        
            <input type="hidden" value="${agendamento.cliente.documento}" name="documentoBuscado" />
            <input type="hidden" value="${agendamento.id}" name="id" />
        
            <div class="row row-cols-1 row-cols-md-4">
                <div class="col mb-3">              
                    
                    <label class="form-label">Cliente</label>
                    <select name="clienteId" class="form-select select-box enable-disable" disabled>
                        <c:forEach items="${clientes}" var="cliente">
                           <option value="${ cliente.id }" ${cliente.id == agendamento.cliente.id ? "selected" : "" }>${cliente.nome}</option> 
                        </c:forEach>
                    </select>
                    
                    <label name="data" class="form-label">Data</label>
                    <input type="datetime-local" value="${agendamento.data }" name="data" class="form-control enable-disable" disabled> 
                    
                    <label class="form-label">Duração</label>
                    <input type="number" value=${agendamento.duracaoEmMinutos } min="30" step="30" name="duracaoEmMinutos" class="form-control enable-disable" disabled>                         
                    
                </div>
                
                <div class="col mb-3">   
                    <label class="form-label">Atendente</label>
                    <select name="usuarioId" class="form-select select-box enable-disable" disabled>
                        <c:forEach items="${usuarios}" var="usuario">
                           <option value="${ usuario.id }"  ${usuario.id == agendamento.usuario.id ? "selected" : "" }>${usuario.nome}</option> 
                        </c:forEach>
                    </select>   

                    <label class="form-label">Serviço</label>
                    <select name="servicoCodigos" class="form-select select-box enable-disable" multiple disabled>
                        <c:forEach items="${servicos}" var="servico">
                           <option value="${ servico.codigo }"  ${agendamento.servicos.contains(servico) ? "selected" : "" }>${servico.codigo} | ${servico.nome}</option> 
                        </c:forEach>
                    </select>
    
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
            <a class="w-25 btn btn-primary read-edit" role="button" href="/agendamento/listar" >Cancelar</a>
                    
        </form>
	</div>
    <script>
    Array.from(document.getElementsByClassName("select-box"))
    .forEach(item => dselect(item, {clearable: true, search: true} ))
    
    Array.from(document.getElementsByClassName("dselect-wrapper"))
    .forEach(wrapper => wrapper.childNodes[1].disabled = true)
    
    function editar() {
        inputList = document.getElementsByClassName("read-edit"); 
        for (let item of inputList) { 
            item.classList.toggle("hidden");
        }
        
        inputs = document.getElementsByClassName("enable-disable")
        for (let item of inputs) {
            item.disabled = !item.disabled;
        }
        
        let wrappers = document.getElementsByClassName("dselect-wrapper")
        for (let wrapper of wrappers) {
        	wrapper.childNodes[1].disabled = !wrapper.childNodes[1].disabled
        }
    }
    
    </script>
</body>
</html>