package br.edu.infnet.atapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.repository.EletricaRepository;
import br.edu.infnet.atapp.model.repository.MecanicaRepository;

@Service
public class MecanicaService {
		
	@Autowired
	private MecanicaRepository mecanicaRepository;

	public Mecanica incluir(Mecanica servico) throws Exception {
		return mecanicaRepository.save(servico);
	};
	
	public Mecanica excluir(Integer key) throws Exception {
		return mecanicaRepository.delete(key);
	};
	
	public void atualizar(String codigo, Mecanica servico) throws Exception {
		mecanicaRepository.update(codigo, servico);
	};
	
	public Collection<Mecanica> obterLista() {
		return mecanicaRepository.findAll();
	};
	
	public Mecanica buscarCodigo(String codigo) throws Exception {
		return mecanicaRepository.findByCode(codigo);
	};
	
}
