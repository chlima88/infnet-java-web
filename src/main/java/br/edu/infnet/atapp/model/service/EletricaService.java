package br.edu.infnet.atapp.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.infnet.atapp.model.domain.Eletrica;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.IEletricaRepository;

@Service
public class EletricaService {
	
	@Autowired
	private IEletricaRepository eletricaRepository;

	public Eletrica incluir(Eletrica servico) throws Exception {
		Eletrica servicoEncontrado = eletricaRepository.findByCodigo(servico.getCodigo());
		if (servicoEncontrado != null ) throw new Exception("Codigo <strong>[" + servico.getCodigo() + "]</strong> ja cadastrado!");
		return eletricaRepository.save(servico);
	};
	
	public Eletrica excluir(Integer key) throws Exception {
		Optional<Eletrica> servico = eletricaRepository.findById(key);
		if (servico.isEmpty()) throw new Exception("Servico não encontrado!"); 
		eletricaRepository.deleteById(key);
		return servico.get();
	};
	
	public void atualizar(String codigo, Eletrica servico) throws Exception {
		eletricaRepository.save(servico);
	};
	
	public Collection<Eletrica> obterLista() {
		return (Collection<Eletrica>) eletricaRepository.findAll();
	};
	
	public Collection<Eletrica> obterLista(Usuario usuario) {
		return (Collection<Eletrica>) eletricaRepository.findAllByEmpresa(usuario.getEmpresa());
	};
	
	public Eletrica buscarCodigo(String codigo, String empresa) throws Exception {

		Eletrica servico = eletricaRepository.findByCodigo(codigo);
		if (servico == null || !servico.getUsuario().getEmpresa().equals(empresa)) throw new Exception("Codigo <strong>" + codigo + "</strong> não encontrado");
		return servico;
	};
	
}
