package br.edu.infnet.atapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.repository.ClienteRepository;
import br.edu.infnet.atapp.model.repository.MecanicaRepository;
import br.edu.infnet.atapp.model.repository.ClienteRepository;

@Controller
public class MecanicaController {
	
	@GetMapping("/mecanica")
	public String telaCliente(
			@RequestParam("codigo") String codigo, 
			Model model,
			RedirectAttributes redirectAttrs){
	
		if (codigo == ""){
			redirectAttrs.addFlashAttribute("erro", "Um codigo deve ser especificado na pesquisa");
			return "redirect:/mecanica/buscar"; 
		} else {
			
			try {
				Mecanica servico = MecanicaRepository.findByCode(codigo);
				model.addAttribute("servico", servico);
				return "servicos/mecanica/dados";
			} catch(Exception error) {
				redirectAttrs.addFlashAttribute("erro", error.getMessage());
				return "redirect:/mecanica/buscar"; 
			}
		}
	}
	

	@GetMapping("/mecanica/listar")
	public String telaLista(Model model) throws Exception {
		model.addAttribute("servicos", MecanicaRepository.findAll());
		return "servicos/mecanica/lista";
	}
	
	@GetMapping("/mecanica/buscar")
	public String telaBusca() {
		return "servicos/mecanica/busca";
	}
	
	@GetMapping("/mecanica/incluir")
	public String telaCadastro() {
		return "servicos/mecanica/cadastro";
	}
			
	@PostMapping("/mecanica/incluir")
	public String incluir(
			Mecanica servico, 
			Model model, 
			RedirectAttributes redirectAttrs
		) {
		
		try {
			Mecanica servicoCadastrado = MecanicaRepository.save(servico);
			String msg = "Servico <strong>" + " ["+ servico.getCodigo() + "] " + 
					servicoCadastrado.getNome() + "</strong> atualizado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/mecanica/listar";
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/mecanica/incluir";
		}
		
	}
	
	@PostMapping("/mecanica/atualizar")
	public String atualizar(
				@RequestParam("codigoBuscado") String codigoBuscado, 
				Mecanica servico,
				RedirectAttributes redirectAttrs
			){
		
		try {
			MecanicaRepository.update(codigoBuscado, servico);
			String msg = "Servico <strong>" + " ["+ servico.getCodigo() + "] " + 
					servico.getNome() + "</strong> atualizado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/mecanica/listar";			 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/mecanica?codigo="+codigoBuscado;
		}
	}
	
	@GetMapping("/mecanica/{id}/excluir")
	public String excluir(
				@PathVariable("id") Integer id, 
				Model model,
				RedirectAttributes redirectAttrs
			) {
		
		try {
			Mecanica servico = MecanicaRepository.delete(id);
			String msg = "Serviço <strong>" + servico.getNome() + "</strong> excluido com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/mecanica/listar"; 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/mecanica/listar"; 
		}
	}
}
