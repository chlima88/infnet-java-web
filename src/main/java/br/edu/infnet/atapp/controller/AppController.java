package br.edu.infnet.atapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.clients.ViaCepClient;
import br.edu.infnet.atapp.model.domain.Endereco;
import feign.FeignException;

@Controller
public class AppController {

	@Autowired
	ViaCepClient viaCepClient;
	
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
	
	@PostMapping("/cep")
	public String obterCep(
			String origem,
			Endereco endereco,
			RedirectAttributes redirectAttrs) {
		try { 
			Endereco enderecoCompleto = viaCepClient.getEndereco(endereco.getCep());
			redirectAttrs.addFlashAttribute(enderecoCompleto);
		} catch(FeignException error) {
			redirectAttrs.addFlashAttribute("erro", "O CEP informado é inválido");
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage()); 
		}
		return "redirect:/"+origem;			
		
	}
	
}
