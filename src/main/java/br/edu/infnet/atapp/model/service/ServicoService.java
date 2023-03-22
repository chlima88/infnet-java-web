package br.edu.infnet.atapp.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Servico;
import br.edu.infnet.atapp.model.repository.IServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private IServicoRepository servicoRepository;

	public Servico excluir(Integer key) throws Exception {
		Optional<Servico> servico = servicoRepository.findById(key);
		if (servico.isEmpty())
			throw new Exception("Servico não encontrado!");
		servicoRepository.deleteById(key);
		return servico.get();
	};

	public Collection<Servico> obterLista() {
		return (Collection<Servico>) servicoRepository.findAll();
	};

	public Collection<Servico> obterLista(String empresa) {
		return (Collection<Servico>) servicoRepository.findAllByEmpresa(empresa);
	};

	public Servico buscarCodigo(String codigo, String empresa) throws Exception {

		Servico servico = servicoRepository.findByCodigo(codigo);
		if (servico == null || !servico.getUsuario().getEmpresa().equals(empresa))
			throw new Exception("Codigo <strong>" + codigo + "</strong> não encontrado");
		return servico;
	};

}
