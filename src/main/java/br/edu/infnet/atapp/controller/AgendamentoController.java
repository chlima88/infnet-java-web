package br.edu.infnet.atapp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.infnet.atapp.model.domain.Agendamento;
import br.edu.infnet.atapp.model.domain.Servico;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.service.AgendamentoService;
import br.edu.infnet.atapp.model.service.ClienteService;
import br.edu.infnet.atapp.model.service.ServicoService;
import br.edu.infnet.atapp.model.service.UsuarioService;

@Controller
public class AgendamentoController {
	
	@Autowired
	AgendamentoService agendamentoService;
	@Autowired
	ClienteService clienteService;
	@Autowired
	ServicoService servicoService;
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/agendamento")
	public String telaCliente(
			@RequestParam("data") LocalDateTime data, 
			@RequestParam("documento") String documento,
			Model model,
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
			RedirectAttributes redirectAttrs
		){
		
		if (documento == ""){
			redirectAttrs.addFlashAttribute("erro", "Uma data e um documento devem ser especificados na pesquisa");
			return "redirect:/agendamento/buscar"; 
		} else {
			
			try {
				Agendamento agendamento = agendamentoService.buscarDataDocumento(data, documento);
				
				model.addAttribute("agendamento", agendamento);
				model.addAttribute("clientes", clienteService.obterLista(usuarioLogado.getEmpresa()));
				model.addAttribute("servicos", servicoService.obterLista(usuarioLogado.getEmpresa()));
				model.addAttribute("usuarios", usuarioService.obterLista(usuarioLogado.getEmpresa()));
				return "agendamento/dados";
			} catch(Exception error) {
				redirectAttrs.addFlashAttribute("erro", error.getMessage());
				return "redirect:/agendamento/buscar"; 
			}
		}
	}
	

	@GetMapping("/agendamento/listar")
	public String telaLista(
			Model model,
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
			RedirectAttributes redirectAttrs
		) throws Exception {
		try {
			model.addAttribute("agendamentos", agendamentoService.obterLista(usuarioLogado.getEmpresa()));
			return "agendamento/lista";
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/home";
		}
	}
	
	@GetMapping("/agendamento/buscar")
	public String telaBusca() {
		return "agendamento/busca";
	}
	
	@GetMapping("/agendamento/incluir")
	public String telaCadastro(
			Model model,
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado
		) {
		model.addAttribute("clientes", clienteService.obterLista(usuarioLogado.getEmpresa()));
		model.addAttribute("servicos", servicoService.obterLista(usuarioLogado.getEmpresa()));
		model.addAttribute("usuarios", usuarioService.obterLista(usuarioLogado.getEmpresa()));
		return "agendamento/cadastro";
	}
			
	@PostMapping("/agendamento/incluir")
	public String incluir(
			Agendamento agendamento,
			@RequestParam("usuarioId") Integer usuarioId,
			@RequestParam("clienteId") Integer clienteId, 
			@RequestParam("servicoCodigos") List<String> servicoCodigos,
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
			RedirectAttributes redirectAttrs
		) {
		
		try {
			List<Servico> servicos = new ArrayList<Servico>();
			for (String codigo: servicoCodigos) {
				Servico servico = servicoService.buscarCodigo(codigo, usuarioLogado.getEmpresa());
				servicos.add(servico);
			}			
			
			agendamentoService.incluir(usuarioId, clienteId, servicos, agendamento);
			String msg = "Agendamento cadastrado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/agendamento/listar";
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/agendamento/incluir";
		}
		
	}
	
	@PostMapping("/agendamento/atualizar")
	public String atualizar(
			Agendamento agendamento,
			@RequestParam("usuarioId") Integer usuarioId,
			@RequestParam("clienteId") Integer clienteId, 
			@RequestParam("servicoCodigos") List<String> servicoCodigos,
			@SessionAttribute("usuarioLogado") Usuario usuarioLogado,
			RedirectAttributes redirectAttrs
		) {
			
		try {		
			agendamentoService.atualizar(usuarioLogado, usuarioId, clienteId, servicoCodigos, agendamento);
			String msg = "Agendamento atualizado com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/agendamento/listar";			 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/agendamento?documento="+agendamento.getCliente().getDocumento()+"&data="+agendamento.getData();
		}
	}
	
	@GetMapping("/agendamento/{id}/excluir")
	public String excluir(
			@PathVariable("id") Integer id, 
			Model model,
			RedirectAttributes redirectAttrs
		) {
		
		try {
			agendamentoService.excluir(id);
			String msg = "Agendamento excluido com sucesso!";
			redirectAttrs.addFlashAttribute("msg", msg);
			return "redirect:/agendamento/listar"; 
		} catch(Exception error) {
			redirectAttrs.addFlashAttribute("erro", error.getMessage());
			return "redirect:/agendamento/listar"; 
		}
	}
}
