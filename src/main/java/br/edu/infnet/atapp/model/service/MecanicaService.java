package br.edu.infnet.atapp.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Mecanica;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.IMecanicaRepository;

@Service
public class MecanicaService {
		
	@Autowired
	private IMecanicaRepository mecanicaRepository;

	public Mecanica incluir(Mecanica servico) throws Exception {
		Mecanica servicoEncontrado = mecanicaRepository.findByCodigo(servico.getCodigo());
		if (servicoEncontrado != null ) throw new Exception("Codigo <strong>[" + servico.getCodigo() + "]</strong> ja cadastrado!");
		return mecanicaRepository.save(servico);
	};
	
	public Mecanica excluir(Integer key) throws Exception {
		Optional<Mecanica> servico = mecanicaRepository.findById(key);
		if (servico.isEmpty()) throw new Exception("Servico não encontrado!"); 
		mecanicaRepository.deleteById(key);
		return servico.get();
	};
	
	public void atualizar(String codigo, Mecanica servico) throws Exception {
		mecanicaRepository.save(servico);
	};
	
	public Collection<Mecanica> obterLista() {
		return (Collection<Mecanica>) mecanicaRepository.findAll();
	};
	
	public Collection<Mecanica> obterLista(Usuario usuario) {
		return (Collection<Mecanica>) mecanicaRepository.findAllByEmpresa(usuario.getEmpresa());
	};
	
	public Mecanica buscarCodigo(String codigo, String empresa) throws Exception {
		Mecanica servico = mecanicaRepository.findByCodigo(codigo);
		if (servico == null || !servico.getUsuario().getEmpresa().equals(empresa)) throw new Exception("Codigo <strong>" + codigo + "</strong> não encontrado");
		return servico;
	};
	
}
