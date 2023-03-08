package br.edu.infnet.atapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente incluir(Cliente usuario) throws Exception {
		return clienteRepository.save(usuario);
	}
	
	public Cliente excluir(Integer key) throws Exception {
		return clienteRepository.delete(key);
	}
	
	public void atualizar(String email, Cliente usuario) throws Exception {
		clienteRepository.update(email, usuario);
	}
	
	public Collection<Cliente> obterLista(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarDocumento(String documento) throws Exception {
		return clienteRepository.findByDocument(documento);
	}
}
