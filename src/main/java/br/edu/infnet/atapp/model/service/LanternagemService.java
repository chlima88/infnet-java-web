package br.edu.infnet.atapp.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Lanternagem;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.ILanternagemRepository;

@Service
public class LanternagemService {
	
	@Autowired
	private ILanternagemRepository lanternagemRepository;

	public Lanternagem incluir(Lanternagem servico) throws Exception {
		
		Lanternagem servicoEncontrado = lanternagemRepository.findByCodigo(servico.getCodigo());
		if (servicoEncontrado != null ) throw new Exception("Codigo <strong>[" + servico.getCodigo() + "]</strong> ja cadastrado!");
		return lanternagemRepository.save(servico);
	};
	
	public Lanternagem excluir(Integer key) throws Exception {
		Optional<Lanternagem> servico = lanternagemRepository.findById(key);
		if (servico.isEmpty()) throw new Exception("Servico não encontrado!"); 
		lanternagemRepository.deleteById(key);
		return servico.get();
	};
	
	public void atualizar(String codigo, Lanternagem servico) throws Exception {
		lanternagemRepository.save(servico);
	};
	
	public Collection<Lanternagem> obterLista() {
		return (Collection<Lanternagem>) lanternagemRepository.findAll();
	};
	
	public Collection<Lanternagem> obterLista(Usuario usuario) {
		return (Collection<Lanternagem>) lanternagemRepository.findAllByEmpresa(usuario.getEmpresa());
	};
	
	public Lanternagem buscarCodigo(String codigo, String empresa) throws Exception {
		Lanternagem servico = lanternagemRepository.findByCodigo(codigo);
		if (servico == null || !servico.getUsuario().getEmpresa().equals(empresa)) throw new Exception("Codigo <strong>" + codigo + "</strong> não encontrado");
		return servico;
	};
	
}
