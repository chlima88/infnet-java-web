package br.edu.infnet.atapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Eletrica;
import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.repository.ClienteRepository;
import br.edu.infnet.atapp.model.repository.EletricaRepository;
import br.edu.infnet.atapp.model.repository.MecanicaRepository;
import br.edu.infnet.atapp.model.repository.ClienteRepository;

@Controller
public class EletricaController {
	
	@GetMapping("/eletrica")
	public String telaCliente(
			@RequestParam("codigo") String codigo, 
			Model model,
			RedirectAttributes redirectAttrs){
	
		if (codigo == ""){
			redirectAttrs.addFlashAttribute("erro", "Um codigo deve ser especificado na pesquisa");
			return "redirect:/eletrica/buscar"; 
		} else {
			
			try {
				Eletrica servico = EletricaRepository.findByCode(codigo);
				model.addAttribute("servico", servico);
				return "servicos/eletrica/dados";
			} catch(Exception error) {
				redirectAttrs.addFlashAttribute("erro", error.getMessage());
				return "redirect:/eletrica/buscar"; 
			}
		}
	}
	

	@GetMapping("/eletrica/listar")
	public String telaLista(Model model) throws Exception {
		model.addAttribute("servicos", EletricaRepository.findAll());
		return "servicos/eletrica/lista";
	}
	
	@GetMapping("/eletrica/buscar")
	public String telaBusca() {
		return "servicos/eletrica/busca";
	}
	
	@GetMapping("/eletrica/incluir")
	public String telaCadastro() {
		return "servicos/eletrica/cadastro";
	}
			
	@PostMapping("/eletrica/incluir")
	public String incluir(
			Eletrica servico, 
			Model model, 
			RedirectAttributes redirectAttrs
		) {
		
		try {
			Eletrica servicoCadastrado = EletricaRepository.save(servico);
			String msg = "Servico <strong>" + " ["+ servico.getCodigo() + "] " + 
					servicoCadastrado.getNome() + "</strong> atualizado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/eletrica/listar";
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/eletrica/incluir";
		}
		
	}
	
	@PostMapping("/eletrica/atualizar")
	public String atualizar(
				@RequestParam("codigoBuscado") String codigoBuscado, 
				Eletrica servico,
				RedirectAttributes redirectAttrs
			){
		
		try {
			EletricaRepository.update(codigoBuscado, servico);
			String msg = "Servico <strong>" + " ["+ servico.getCodigo() + "] " + 
					servico.getNome() + "</strong> atualizado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/eletrica/listar";			 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/eletrica?codigo="+codigoBuscado;
		}
	}
	
	@GetMapping("/eletrica/{id}/excluir")
	public String excluir(
				@PathVariable("id") Integer id, 
				Model model,
				RedirectAttributes redirectAttrs
			) {
		
		try {
			Eletrica servico = EletricaRepository.delete(id);
			String msg = "Serviço <strong>" + servico.getNome() + "</strong> excluido com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/eletrica/listar"; 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/eletrica/listar"; 
		}
	}
}
