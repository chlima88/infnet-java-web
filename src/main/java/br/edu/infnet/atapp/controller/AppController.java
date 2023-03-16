package br.edu.infnet.atapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String telaIndex() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String telaHome() {
		return "index";
	}
	
	@GetMapping("/error")
	public String telaErro() {
		return "error";
	}
	
}
