package br.edu.infnet.atapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.service.LoginService;
import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("usuario")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String telaLogin(Model model) {
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
			
			Usuario usuario = loginService.autenticar(credentials);
			model.addAttribute(usuario);
			return "redirect:/home";
			
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro","Usuário ou senha inválidos");
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(
			HttpSession session,
			SessionStatus status
		) {
		
		status.setComplete();
		session.removeAttribute("usuario");
		return "redirect:/";
	} 
}
