package br.edu.infnet.atapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@GetMapping("/usuario")
	public String telaUsuario(@RequestParam("email") String email, Model model) throws Exception {
	
		if (email == null){
			model.addAttribute("erro", "Um e-mail deve ser especificado na pesquisa");
			return "/error";
		} else {
			
			try {
				Usuario usuario = UsuarioRepository.findByEmail(email);
				model.addAttribute("usuario", usuario);
				return "usuario/dados";
			} catch(Exception error) {
				model.addAttribute("erro", error.getMessage());
				return "/error";
			}
		}
	}
	

	@GetMapping("/usuario/listar")
	public String telaLista(Model model) throws Exception {
		return "usuario/lista";
	}
	
	@GetMapping("/usuario/buscar")
	public String telaBusca() {
		return "usuario/busca";
	}
	
	@GetMapping("/usuario/incluir")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
			
	@PostMapping("/usuario/incluir")
	public String incluir(Usuario usuario, Model model) throws Exception {
		
		try {
			UsuarioRepository.save(usuario);
			System.out.println("Inclusão realizada com sucesso: " + usuario);
			return "redirect:/usuario/listar";
		} catch(Exception error) {
			model.addAttribute("erro", error.getMessage());
			return "/error";
		}
		
	}
	
	@PostMapping("/usuario/atualizar")
	public String atualizar(
				@RequestParam("emailBuscado") String email, 
				Usuario usuario,
				Model model
			) throws Exception {
		
		try {
//			UsuarioRepository.update(email, usuario);
			return "redirect:/usuario/listar";			 
		} catch(Exception error) {
			model.addAttribute("erro", error.getMessage());
			return "/error";
		}
	}
	
	@GetMapping("/usuario/{id}/excluir")
	public String excluir(
				@PathVariable("id") Integer id, 
				Model model
			) {
		
		try {
			Usuario usuario = UsuarioRepository.delete(id);
			System.out.println(usuario);
			return "redirect:/usuario/listar"; 
		} catch(Exception error) {
			model.addAttribute("erro", error.getMessage());
			return "/error";
		}
	}
}
