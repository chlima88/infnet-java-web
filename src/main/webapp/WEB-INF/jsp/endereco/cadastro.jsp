<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col">
  <script>
    function savePerson() {
      pessoa = Alpine.store('csPessoa').pessoa
        localStorage.setItem('csPessoa', JSON.stringify({pessoa: pessoa}))
    }

    document.addEventListener('alpine:init', () => {
        const existingData = localStorage.getItem('csPessoa')
        data = JSON.parse(existingData) || {"pessoa": {"endereco": {}, "caracteristicas": []}};
        Alpine.store('csPessoa', data);
        localStorage.clear();
    })

  </script> 
	<div  class="col mb-3">
		<form @submit="savePerson()" class="d-flex gap-1 align-items-end mb-2" action="/cep" method="post">
			<div class="form-group col-8">
        <label class="form-label enable-disable" for="cep">Cep:</label>
        <input
          class="form-control enable-disable"
          x-model="pessoa.endereco.cep"
          x-init="pessoa.endereco.cep = '${endereco.cep}' || '${usuario.endereco.cep}' "
          type="text"
          name="cep"
          ${param.status}
        />
			</div>
			<div class="col-4">
				<button class="btn w-100 rounded-end btn-primary enable-disable" type="submit" ${param.status}>Buscar</button>
			</div>
			<input type=hidden value="${param.origem}" name="origem" />
		</form>
        
		<div class="form-group mb-2">
			<label class="form-label" for="logradouro">Logradouro:</label>
			<input
        class="form-control enable-disable"
        x-model="pessoa.endereco.logradouro"
        x-init="pessoa.endereco.logradouro = '${endereco.logradouro}' || '${usuario.endereco.logradouro}' "
        type="text"
        name="logradouro"
        ${param.status}
			/>
		</div>
		
		<div class="row">
			
			<div class="form-group col-5">
				<label class="form-label" for="bairro">Bairro: </label>
        <input
          class="form-control enable-disable"
          x-model="pessoa.endereco.bairro"
          x-init="pessoa.endereco.bairro = '${endereco.bairro}' || '${usuario.endereco.bairro}' "
          type="text"
          name="bairro"
          ${param.status}
        />
			</div>
			<div class="form-group col-5">
				<label class="form-label" for="localidade">Cidade: </label>
        <input
          class="form-control enable-disable"
          x-model="pessoa.endereco.localidade"
          x-init="pessoa.endereco.localidade = '${endereco.localidade}' || '${usuario.endereco.localidade}'  "
          type="text"
          name="localidaede"
          ${param.status}
        />
			</div>
				
			<div class="form-group col-2">
        <label class="form-label" for="uf">UF: </label>
        <input
          class="form-control enable-disable"
          x-model="pessoa.endereco.uf"
          x-init="pessoa.endereco.uf = '${endereco.uf}'|| '${usuario.endereco.uf}'"
          type="text"
          name="uf"
          ${param.status}
        />
			</div>

		</div>

	</div>
	
</div>

	