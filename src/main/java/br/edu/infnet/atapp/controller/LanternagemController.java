package br.edu.infnet.atapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Lanternagem;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.service.LanternagemService;

@Controller
public class LanternagemController {
	
	@Autowired
	LanternagemService lanternagemService;
	
	@GetMapping("/lanternagem")
	public String telaCliente(
			@RequestParam("codigo") String codigo, 
			Model model,
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
			RedirectAttributes redirectAttrs){
	
		if (codigo == ""){
			redirectAttrs.addFlashAttribute("erro", "Um codigo deve ser especificado na pesquisa");
			return "redirect:/lanternagem/buscar"; 
		} else {
			
			try {
				Lanternagem servico = lanternagemService.buscarCodigo(codigo, usuarioLogado.getEmpresa());
				model.addAttribute("servico", servico);
				return "servicos/lanternagem/dados";
			} catch(Exception error) {
				redirectAttrs.addFlashAttribute("erro", error.getMessage());
				return "redirect:/lanternagem/buscar"; 
			}
		}
	}
	

	@GetMapping("/lanternagem/listar")
	public String telaLista(
				Model model,
				@SessionAttribute("usuarioLogado") Usuario usuarioLogado
			) throws Exception {
		model.addAttribute("servicos", lanternagemService.obterLista(usuarioLogado));
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
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
			RedirectAttributes redirectAttrs
		) {
		
		try {
			servico.setUsuario(usuarioLogado);
			Lanternagem servicoCadastrado = lanternagemService.incluir(servico);
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
				@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
				RedirectAttributes redirectAttrs
			) {
			
			try {
				servico.setUsuario(usuarioLogado);
			lanternagemService.atualizar(codigoBuscado, servico);
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
				RedirectAttributes redirectAttrs
			) {
		
		try {
			Lanternagem servico = lanternagemService.excluir(id);
			String msg = "Serviço <strong>" + servico.getNome() + "</strong> excluido com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/lanternagem/listar"; 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/lanternagem/listar"; 
		}
	}
}
