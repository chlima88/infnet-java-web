package br.edu.infnet.atapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.service.ClienteService;

@Component
public class ClienteLoader implements ApplicationRunner {

	@Autowired
	ClienteService clienteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Cliente usuario = new Cliente("Silvio Santos", "12345678910", "21999887766");
		clienteService.incluir(usuario);
		
	}

}
