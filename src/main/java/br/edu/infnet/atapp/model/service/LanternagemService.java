package br.edu.infnet.atapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Lanternagem;
import br.edu.infnet.atapp.model.repository.EletricaRepository;
import br.edu.infnet.atapp.model.repository.LanternagemRepository;

@Service
public class LanternagemService {
	
	@Autowired
	private LanternagemRepository lanternagemRepository;

	public Lanternagem incluir(Lanternagem servico) throws Exception {
		return lanternagemRepository.save(servico);
	};
	
	public Lanternagem excluir(Integer key) throws Exception {
		return lanternagemRepository.delete(key);
	};
	
	public void atualizar(String codigo, Lanternagem servico) throws Exception {
		lanternagemRepository.update(codigo, servico);
	};
	
	public Collection<Lanternagem> obterLista() {
		return lanternagemRepository.findAll();
	};
	
	public Lanternagem buscarCodigo(String codigo) throws Exception {
		return lanternagemRepository.findByCode(codigo);
	};
	
}
