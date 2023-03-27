package br.edu.infnet.atapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Endereco;
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
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
			RedirectAttributes redirectAttrs){
	
		if (email == ""){
			redirectAttrs.addFlashAttribute("erro", "Um e-mail deve ser especificado na pesquisa");
			return "redirect:/usuario/buscar"; 
		} else {
			
			try {
				Usuario usuario = usuarioService.buscarEmail(email, usuarioLogado);
				model.addAttribute("usuario", usuario);
//				model.addAttribute("endereco", usuario.getEndereco());
				return "usuario/dados";
			} catch(Exception error) {
				redirectAttrs.addFlashAttribute("erro", error.getMessage());
				return "redirect:/usuario/buscar"; 
			}
		}
	}
	

	@GetMapping("/usuario/listar")
	public String telaLista(
			Model model,
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado
	) throws Exception {
		model.addAttribute("usuarios", usuarioService.obterLista(usuarioLogado));
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
			@RequestParam("imagem") MultipartFile imagem,
			Usuario usuario,
			Endereco endereco, 
			Model model, 
			RedirectAttributes redirectAttrs
		) {
		
		try {
			usuario.setEndereco(endereco);
			Usuario usuarioCadastrado = usuarioService.incluir(usuario, imagem);
			String msg = "Usuário <strong>" + usuarioCadastrado.getEmail() + "</strong> cadastrado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/usuario/incluir";
		}
		
		return "redirect:/usuario/listar";
	}
	
	@PostMapping("/usuario/atualizar")
	public String atualizar(
				String emailAtual,
				Usuario usuario,
				Endereco endereco,
				RedirectAttributes redirectAttrs
		){
		
		try {
			usuario.setEndereco(endereco);
			usuarioService.atualizar(usuario);
			String msg = "Usuário <strong>" + usuario.getEmail() + "</strong> atualizado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/usuario?email=" + emailAtual;
		}
		return "redirect:/usuario/listar";			 
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
		} catch(DataIntegrityViolationException error) {
			redirectAttrs.addFlashAttribute("erro", "Não foi possível excluir: <strong>O usuario está associado a um agendamento.</strong>");
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage()); 
		}
		return "redirect:/usuario/listar"; 
	}
}
