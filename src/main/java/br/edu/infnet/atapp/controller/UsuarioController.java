package br.edu.infnet.atapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@GetMapping(value = "/usuario/incluir")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuario/listar")
	public String telaLista() {
		return "usuario/lista";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {
		System.out.println("Inclusão realizada com sucesso: " + usuario);
		
		UsuarioRepository.save(usuario);
		
		System.out.println(UsuarioRepository.count());
		
		return "redirect:/";
	}
}
