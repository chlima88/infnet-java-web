package br.edu.infnet.atapp.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Cliente;
import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.IClienteRepository;

@Service
public class ClienteService {
	
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	public Cliente incluir(Cliente cliente) throws Exception {
		Cliente servicoEncontrado = clienteRepository.findByDocumento(cliente.getDocumento(), Sort.by(Sort.Direction.ASC, "nome"));
		if (servicoEncontrado != null ) throw new Exception("Documento <strong>[" + cliente.getDocumento() + "]</strong> ja cadastrado!");
		return clienteRepository.save(cliente);
	}
	
	public Cliente excluir(Integer key) throws Exception {
		
		Optional<Cliente> cliente = clienteRepository.findById(key);
		if (cliente.isEmpty()) throw new Exception("Cliente não encontrado!"); 
		clienteRepository.deleteById(key);
		return cliente.get();
			
	}
	
	public void atualizar(Cliente cliente) throws Exception {
		clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> obterLista(){
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public Collection<Cliente> obterLista(Usuario usuarioLogado){
		if (usuarioLogado.isMasterAdmin()) {
			return (Collection<Cliente>) clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));			
		} else {
			return (Collection<Cliente>) clienteRepository.findAllByEmpresa(usuarioLogado.getEmpresa(), Sort.by(Sort.Direction.ASC, "nome"));			
		}
	}
	
	public Cliente buscarDocumento(String documento, Usuario usuarioLogado) throws Exception {
		Cliente cliente = clienteRepository.findByDocumento(documento, Sort.by(Sort.Direction.ASC, "nome"));
		if (cliente == null ) throw new Exception("Documento <strong>" + documento + "</strong> não encontrado");
		if (! usuarioLogado.isMasterAdmin() 
				&& !cliente.getUsuario().getEmpresa().equals(usuarioLogado.getEmpresa())) 
			throw new Exception("Documento <strong>" + documento + "</strong> não encontrado");
		return cliente;
	}

}
