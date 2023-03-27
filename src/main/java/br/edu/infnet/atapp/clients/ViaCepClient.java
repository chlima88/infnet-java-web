package br.edu.infnet.atapp.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.atapp.model.domain.Endereco;

@FeignClient(name = "viaCepService", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {
		
	@GetMapping("/{cep}/json")
	Endereco getEndereco(@PathVariable("cep") String cep);
	
}
