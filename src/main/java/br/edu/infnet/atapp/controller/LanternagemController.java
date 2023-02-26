package br.edu.infnet.atapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Lanternagem;
import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.repository.ClienteRepository;
import br.edu.infnet.atapp.model.repository.LanternagemRepository;
import br.edu.infnet.atapp.model.repository.LanternagemRepository;
import br.edu.infnet.atapp.model.repository.MecanicaRepository;
import br.edu.infnet.atapp.model.repository.ClienteRepository;

@Controller
public class LanternagemController {
	
	@GetMapping("/lanternagem")
	public String telaCliente(
			@RequestParam("codigo") String codigo, 
			Model model,
			RedirectAttributes redirectAttrs){
	
		if (codigo == ""){
			redirectAttrs.addFlashAttribute("erro", "Um codigo deve ser especificado na pesquisa");
			return "redirect:/lanternagem/buscar"; 
		} else {
			
			try {
				Lanternagem servico = LanternagemRepository.findByCode(codigo);
				model.addAttribute("servico", servico);
				return "servicos/lanternagem/dados";
			} catch(Exception error) {
				redirectAttrs.addFlashAttribute("erro", error.getMessage());
				return "redirect:/lanternagem/buscar"; 
			}
		}
	}
	

	@GetMapping("/lanternagem/listar")
	public String telaLista(Model model) throws Exception {
		model.addAttribute("servicos", LanternagemRepository.findAll());
		return "servicos/lanternagem/lista";
	}
	
	@GetMapping("/lanternagem/buscar")
	public String telaBusca() {
		return "servicos/lanternagem/busca";
	}
	
	@GetMapping("/lanternagem/incluir")
	public String telaCadastro() {
		return "servicos/lanternagem/cadastro";
	}
			
	@PostMapping("/lanternagem/incluir")
	public String incluir(
			Lanternagem servico, 
			Model model, 
			RedirectAttributes redirectAttrs
		) {
		
		try {
			Lanternagem servicoCadastrado = LanternagemRepository.save(servico);
			String msg = "Servico <strong>" + " ["+ servico.getCodigo() + "] " + 
					servicoCadastrado.getNome() + "</strong> atualizado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/lanternagem/listar";
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/lanternagem/incluir";
		}
		
	}
	
	@PostMapping("/lanternagem/atualizar")
	public String atualizar(
				@RequestParam("codigoBuscado") String codigoBuscado, 
				Lanternagem servico,
				RedirectAttributes redirectAttrs
			){
		
		try {
			LanternagemRepository.update(codigoBuscado, servico);
			String msg = "Servico <strong>" + " ["+ servico.getCodigo() + "] " + 
					servico.getNome() + "</strong> atualizado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/lanternagem/listar";			 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/lanternagem?codigo="+codigoBuscado;
		}
	}
	
	@GetMapping("/lanternagem/{id}/excluir")
	public String excluir(
				@PathVariable("id") Integer id, 
				Model model,
				RedirectAttributes redirectAttrs
			) {
		
		try {
			Lanternagem servico = LanternagemRepository.delete(id);
			String msg = "Serviço <strong>" + servico.getNome() + "</strong> excluido com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/lanternagem/listar"; 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/lanternagem/listar"; 
		}
	}
}
