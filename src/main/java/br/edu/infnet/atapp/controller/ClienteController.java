package br.edu.infnet.atapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.repository.ClienteRepository;
import br.edu.infnet.atapp.model.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@GetMapping("/cliente")
	public String telaCliente(
			@RequestParam("documento") String documento, 
			Model model,
			RedirectAttributes redirectAttrs){
	
		if (documento == ""){
			redirectAttrs.addFlashAttribute("erro", "Um e-mail deve ser especificado na pesquisa");
			return "redirect:/cliente/buscar"; 
		} else {
			
			try {
				Cliente cliente = ClienteRepository.findByDocument(documento);
				model.addAttribute("cliente", cliente);
				return "cliente/dados";
			} catch(Exception error) {
				redirectAttrs.addFlashAttribute("erro", error.getMessage());
				return "redirect:/cliente/buscar"; 
			}
		}
	}
	

	@GetMapping("/cliente/listar")
	public String telaLista(Model model) throws Exception {
		model.addAttribute("clientes", ClienteRepository.findAll());
		return "cliente/lista";
	}
	
	@GetMapping("/cliente/buscar")
	public String telaBusca() {
		return "cliente/busca";
	}
	
	@GetMapping("/cliente/incluir")
	public String telaCadastro() {
		return "cliente/cadastro";
	}
			
	@PostMapping("/cliente/incluir")
	public String incluir(
			Cliente cliente, 
			Model model, 
			RedirectAttributes redirectAttrs
		) {
		
		try {
			Cliente clienteCadastrado = ClienteRepository.save(cliente);
			String msg = "Cliente <strong>" + clienteCadastrado.getNome() + "</strong> cadastrado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/cliente/listar";
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/cliente/incluir";
		}
		
	}
	
	@PostMapping("/cliente/atualizar")
	public String atualizar(
				@RequestParam("documentoBuscado") String documentoBuscado, 
				Cliente cliente,
				RedirectAttributes redirectAttrs
			){
		
		try {
			ClienteRepository.update(documentoBuscado, cliente);
			String msg = "Cliente <strong>" + cliente.getNome() + "</strong> atualizado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/cliente/listar";			 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/cliente?documento="+documentoBuscado;
		}
	}
	
	@GetMapping("/cliente/{id}/excluir")
	public String excluir(
				@PathVariable("id") Integer id, 
				Model model,
				RedirectAttributes redirectAttrs
			) {
		
		try {
			Cliente cliente = ClienteRepository.delete(id);
			String msg = "Cliente <strong>" + cliente.getNome() + "</strong> excluido com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/cliente/listar"; 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/cliente/listar"; 
		}
	}
}
