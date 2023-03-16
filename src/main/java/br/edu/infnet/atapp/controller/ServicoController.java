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

import br.edu.infnet.atapp.model.domain.Servico;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.service.EletricaService;
import br.edu.infnet.atapp.model.service.ServicoService;

@Controller
public class ServicoController {
	
	
	@Autowired
	ServicoService servicoService;


	@GetMapping("/servico/listar")
	public String telaLista(
				Model model,
				@SessionAttribute("usuarioLogado") Usuario usuarioLogado
			) throws Exception {
		model.addAttribute("servicos", servicoService.obterLista(usuarioLogado));
		return "servicos/lista";
	}
	
	@GetMapping("/servico/{id}/excluir")
	public String excluir(
				@PathVariable("id") Integer id,
				RedirectAttributes redirectAttrs
			) {
		
		try {
			Servico servico = servicoService.excluir(id);
			String msg = "Serviço <strong>" + servico.getNome() + "</strong> excluido com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/servico/listar"; 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/servico/listar"; 
		}
	}
}
