package br.edu.infnet.atapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Eletrica;
import br.edu.infnet.atapp.model.repository.EletricaRepository;

@Service
public class EletricaService {
	
	@Autowired
	private EletricaRepository eletricaRepository;

	public Eletrica incluir(Eletrica servico) throws Exception {
		return eletricaRepository.save(servico);
	};
	
	public Eletrica excluir(Integer key) throws Exception {
		return eletricaRepository.delete(key);
	};
	
	public void atualizar(String codigo, Eletrica servico) throws Exception {
		eletricaRepository.update(codigo, servico);
	};
	
	public Collection<Eletrica> obterLista() {
		return eletricaRepository.findAll();
	};
	
	public Eletrica buscarCodigo(String codigo) throws Exception {
		return eletricaRepository.findByCode(codigo);
	};
	
}
