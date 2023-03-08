package br.edu.infnet.atapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuario")
	public String telaUsuario(
			@RequestParam("email") String email, 
			Model model,
			RedirectAttributes redirectAttrs){
	
		if (email == ""){
			redirectAttrs.addFlashAttribute("erro", "Um e-mail deve ser especificado na pesquisa");
			return "redirect:/usuario/buscar"; 
		} else {
			
			try {
				Usuario usuario = usuarioService.buscarEmail(email);
				model.addAttribute("usuario", usuario);
				return "usuario/dados";
			} catch(Exception error) {
				redirectAttrs.addFlashAttribute("erro", error.getMessage());
				return "redirect:/usuario/buscar"; 
			}
		}
	}
	

	@GetMapping("/usuario/listar")
	public String telaLista(Model model) throws Exception {
		model.addAttribute("usuarios", usuarioService.obterLista());
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
	public String incluir(
			Usuario usuario, 
			Model model, 
			RedirectAttributes redirectAttrs
		) {
		
		try {
			Usuario usuarioCadastrado = usuarioService.incluir(usuario);
			String msg = "Usuário <strong>" + usuarioCadastrado.getEmail() + "</strong> cadastrado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/usuario/listar";
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/usuario/incluir";
		}
		
	}
	
	@PostMapping("/usuario/atualizar")
	public String atualizar(
				@RequestParam("emailBuscado") String emailBuscado, 
				Usuario usuario,
				RedirectAttributes redirectAttrs
			){
		
		try {
			usuarioService.atualizar(emailBuscado, usuario);
			String msg = "Usuário <strong>" + usuario.getEmail() + "</strong> atualizado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/usuario/listar";			 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/usuario?email="+emailBuscado;
		}
	}
	
	@GetMapping("/usuario/{id}/excluir")
	public String excluir(
				@PathVariable("id") Integer id, 
				Model model,
				RedirectAttributes redirectAttrs
			) {
		
		try {
			Usuario usuario = usuarioService.excluir(id);
			String msg = "Usuário <strong>" + usuario.getEmail() + "</strong> excluido com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/usuario/listar"; 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/usuario/listar"; 
		}
	}
}
