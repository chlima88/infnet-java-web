package br.edu.infnet.atapp.model.repository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.atapp.model.domain.Cliente;

@Repository
public class ClienteRepository {
	
	private static Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
	private static Integer id = 0;
	
	private static Cliente cliente;
	
	public Cliente save(Cliente cliente) throws Exception {
		
		try {
			findByDocument(cliente.getDocumento());			
		} catch (Exception e) {
			cliente.setId(id);
			clientes.put(id++, cliente);
			return cliente;
		} 
		throw new Exception("Documento já cadastrado!");

	};
	
	public Cliente delete(Integer key) throws Exception {
		
		Cliente cliente = clientes.remove(key);
		if (cliente == null) throw new Exception("O id informado é inválido ou não existe!");
		return cliente;
	}
	
	public static List<Cliente> findByName(String nome) {
		
		List<Cliente> clientesEncontrados = new ArrayList<Cliente>();
	
		for (Cliente usuario: clientes.values()) {
			if (cliente.getNome().toLowerCase().contains(nome.toLowerCase()) ) {
				clientesEncontrados.add(usuario);				
			}
		};
		
		return clientesEncontrados;
		
	};
	
	public Cliente findByDocument(String documento) throws Exception {
		
		Cliente clienteEncontrado = null;
	
		for (Cliente cliente: clientes.values()) {
			if (cliente.getDocumento().equalsIgnoreCase(documento.toLowerCase()) ) {
				clienteEncontrado = cliente;				
			}
		};
		
		if (clienteEncontrado == null) throw new Exception("Usuário não encontrado!");
		
		return clienteEncontrado;
		
	};
	
	public Collection<Cliente> findAll() {
		return clientes.values();
	};
	
	public void update(String documento, Cliente cliente) throws Exception {
		
		try {
			if (documento.equalsIgnoreCase(cliente.getDocumento())) {
				clientes.put(cliente.getId(), cliente);
				return;
			} else {
				findByDocument(cliente.getDocumento());
			}
		} catch(Exception error) {
			clientes.put(cliente.getId(), cliente);
			return;
		}
		
		throw new Exception("O documento informado já está em uso!");
		
		
	};
	
	public static int count() {
		return clientes.size();
	}
}
