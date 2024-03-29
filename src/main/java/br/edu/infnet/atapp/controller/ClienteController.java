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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Endereco;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/cliente")
	public String telaCliente(
			@RequestParam("documento") String documento, 
			Model model,
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
			RedirectAttributes redirectAttrs){
	
		if (documento == ""){
			redirectAttrs.addFlashAttribute("erro", "Um documento deve ser especificado na pesquisa");
			return "redirect:/cliente/buscar"; 
		} else {
			
			try {				
				model.addAttribute("cliente", clienteService.buscarDocumento(documento, usuarioLogado));
				return "cliente/dados";
			} catch(Exception error) {
				redirectAttrs.addFlashAttribute("erro", error.getMessage());
				return "redirect:/cliente/buscar"; 
			}
		}
	}
	

	@GetMapping("/cliente/listar")
	public String telaLista(
			Model model,
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado
			) throws Exception {
		model.addAttribute("clientes", clienteService.obterLista(usuarioLogado));
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
			Endereco endereco,
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
			RedirectAttributes redirectAttrs
		) {
		
		try {
			cliente.setUsuario(usuarioLogado);
			cliente.setEndereco(endereco);
			Cliente clienteCadastrado = clienteService.incluir(cliente);
			String msg = "Cliente <strong>" + clienteCadastrado.getNome() + "</strong> cadastrado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/cliente/incluir";
		}
		return "redirect:/cliente/listar";
		
	}
	
	@PostMapping("/cliente/atualizar")
	public String atualizar(
				@RequestParam("documentoBuscado") String documentoBuscado, 
				Cliente cliente,   
				@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
				RedirectAttributes redirectAttrs
			) {
			
		try {
			cliente.setUsuario(usuarioLogado);
			clienteService.atualizar(cliente);
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
			Cliente cliente = clienteService.excluir(id);
			String msg = "Cliente <strong>" + cliente.getNome() + "</strong> excluido com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
		} catch(DataIntegrityViolationException error) {
			redirectAttrs.addFlashAttribute("erro", "Não foi possível excluir: <strong>O cliente está associado a um agendamento.</strong>");
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage()); 
		}
		return "redirect:/cliente/listar"; 
	}
}
