package br.edu.infnet.atapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String telaIndex() {
		return "index";
	}
	
	@GetMapping("/error")
	public String telaErro() {
		return "error";
	}
	

}
