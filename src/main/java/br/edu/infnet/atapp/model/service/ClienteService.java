package br.edu.infnet.atapp.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Eletrica;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.IClienteRepository;

@Service
public class ClienteService {
	
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	public Cliente incluir(Cliente usuario) throws Exception {
		Cliente servicoEncontrado = clienteRepository.findByDocumento(usuario.getDocumento());
		if (servicoEncontrado != null ) throw new Exception("Documento <strong>[" + usuario.getDocumento() + "]</strong> ja cadastrado!");
		return clienteRepository.save(usuario);
	}
	
	public Cliente excluir(Integer key) throws Exception {
		
		Optional<Cliente> cliente = clienteRepository.findById(key);
		if (cliente.isEmpty()) throw new Exception("Cliente não encontrado!"); 
		clienteRepository.deleteById(key);
		return cliente.get();
			
	}
	
	public void atualizar(String email, Cliente usuario) throws Exception {
		clienteRepository.save(usuario);
	}
	
	public Collection<Cliente> obterLista(){
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public Collection<Cliente> obterLista(Integer id){
		return (Collection<Cliente>) clienteRepository.findAllByIdUsuario(id);
	}
	
	public Cliente buscarDocumento(String documento) throws Exception {
		Cliente cliente = clienteRepository.findByDocumento(documento);
		if (cliente == null) throw new Exception("Documento <strong>" + documento + "</strong> não encontrado");
		return cliente;
	}
}
