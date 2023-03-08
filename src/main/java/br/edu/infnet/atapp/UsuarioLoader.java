package br.edu.infnet.atapp;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.UsuarioRepository;

@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario("Admin", "admin@carservices", "123", new ArrayList<String>(Arrays.asList("Dev")), "P", "1");
		usuarioRepository.save(usuario);
		
	}

}
