package br.edu.infnet.atapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.LoginRepository;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("senha") String senha,
			Model model,
			RedirectAttributes redirectAttrs
		) throws Exception {
		
		Usuario credentials = new Usuario(email, senha);
		
		try {
			
			Usuario usuario = LoginRepository.autenticar(credentials);
			redirectAttrs.addFlashAttribute("usuario", usuario);
			return "redirect:/home";
			
		} catch(Exception error) {
			model.addAttribute("erro", error.getMessage());
		}
		return "/error";
		
	}
}
