package br.edu.infnet.atapp.model.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Agendamento;
import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Servico;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.IAgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private IAgendamentoRepository agendamentoRepository;
	
	@Autowired
	private ServicoService servicoService;

	public Agendamento incluir(Agendamento agendamento) throws Exception {
		
		Collection<Agendamento> agendamentos = agendamentoRepository.findAllByData(agendamento.getData(), Sort.by(Sort.Direction.DESC, "data"));
		
		for (Agendamento agendamentoEncontrado: agendamentos) {
			if (agendamento.getCliente().getNome() == agendamentoEncontrado.getCliente().getNome() ) 
				throw new Exception("Codigo <strong>[" + agendamento.getId() + "]</strong> ja cadastrado!");
		}
		
		return agendamentoRepository.save(agendamento);
			
	};
	
public Agendamento incluir(Integer usuarioId, Integer clienteId, List<Servico> servicos, Agendamento agendamento) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(usuarioId);
		Cliente cliente = new Cliente();
		cliente.setId(clienteId);
	
		agendamento.setUsuario(usuario);
		agendamento.setCliente(cliente);
		agendamento.setServicos(servicos);
	
		Agendamento agendamentoEncontrado = agendamentoRepository.findByData(agendamento.getData());
		if (agendamentoEncontrado != null ) 
			throw new Exception("Já existe um agendamento para o cliente no dia <strong>[" +
								agendamento.getData()  + "]</strong> !");
		
		return agendamentoRepository.save(agendamento);
	};
	
	public Agendamento excluir(Integer key) throws Exception {
		Optional<Agendamento> agendamento = agendamentoRepository.findById(key);
		if (agendamento.isEmpty()) throw new Exception("Servico não encontrado!"); 
		agendamentoRepository.deleteById(key);
		return agendamento.get();
	};
	
	public void atualizar(
			Usuario usuarioLogado,
			Integer atendenteId,
			Integer clienteId,
			Collection<String> servicoCodigos,
			Agendamento agendamento
		) throws Exception {
		
		List<Servico> servicos = new ArrayList<Servico>();
		for (String codigo: servicoCodigos) {
			Servico servico = servicoService.buscarCodigo(codigo, usuarioLogado.getEmpresa());
			servicos.add(servico);
		}
		
		Usuario usuario = new Usuario();
		usuario.setId(atendenteId);
		Cliente cliente = new Cliente();
		cliente.setId(clienteId);
	
		agendamento.setUsuario(usuario);
		agendamento.setCliente(cliente);
		agendamento.setServicos(servicos);
		
		agendamentoRepository.save(agendamento);
	};
	
	public Collection<Agendamento> obterLista() {
		return agendamentoRepository.findAll();
	};
	
	public Collection<Agendamento> obterLista(Usuario usuarioLogado) {
		if (usuarioLogado.isMasterAdmin()) {
			return agendamentoRepository.findAll();
		} else {
			return agendamentoRepository.findAllByEmpresa(usuarioLogado.getEmpresa(), Sort.by(Sort.Direction.ASC, "data"));			
		}
	};
	
	public Agendamento buscarDataDocumento(LocalDateTime data, String documento) throws Exception {
		Collection<Agendamento> agendamentos = agendamentoRepository.findAllByData(data, Sort.by(Sort.Direction.ASC, "data"));
		
		if (agendamentos.isEmpty()) throw new Exception("Agendamento nao encontrado!");
		
		Agendamento agendamentoEncontrado = null;
		
		for (Agendamento agendamento: agendamentos) {
			if (!agendamento.getCliente().getDocumento().equals(documento)) {
				throw new Exception("Agendamento nao encontrado!");
			}
			agendamentoEncontrado = agendamento;
		}
		return agendamentoEncontrado;
	};
	
}
