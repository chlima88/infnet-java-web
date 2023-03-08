package br.edu.infnet.atapp.model.repository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.edu.infnet.atapp.model.domain.Usuario;

@Repository
public class UsuarioRepository {
	
	private static Map<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
	private static Integer id = 0;
	
	public Usuario save(Usuario usuario) throws Exception {
		
		try {
			findByEmail(usuario.getEmail());			
		} catch (Exception e) {
			usuario.setId(id);
			usuarios.put(id++, usuario);
			return usuario;
		} 
		throw new Exception("E-mail ja cadastrado!");

	};
	
	public Usuario delete(Integer key) throws Exception {
		
		Usuario usuario = usuarios.remove(key);
		if (usuario == null) throw new Exception("O id informado é inválido ou não existe!");
		return usuario;
	}
	
	public static List<Usuario> findByName(String nome) {
		
		List<Usuario> usuariosEncontrados = new ArrayList<Usuario>();
	
		for (Usuario usuario: usuarios.values()) {
			if (usuario.getNome().toLowerCase().contains(nome.toLowerCase()) ) {
				usuariosEncontrados.add(usuario);				
			}
		};
		
		return usuariosEncontrados;
		
	};
	
	public boolean existsByEmail(String email) {
		
		for (Usuario usuario: usuarios.values()) {
			if (usuario.getEmail().equalsIgnoreCase(email)) return true;
		}
		return false;
	};
	
	public Usuario findByEmail(String email) throws Exception {
		
		Usuario usuarioEncontrado = null;
	
		for (Usuario usuario: usuarios.values()) {
			if (usuario.getEmail().equalsIgnoreCase(email.toLowerCase()) ) {
				usuarioEncontrado = usuario;				
			}
		};
		
		if (usuarioEncontrado == null) throw new Exception("Usuário não encontrado!");
		
		return usuarioEncontrado;
		
	};
	
	public Collection<Usuario> findAll() {
		return usuarios.values();
	};
	
	public void update(String emailBuscado, Usuario usuario) throws Exception {
		
		try {
			if (emailBuscado.equalsIgnoreCase(usuario.getEmail())) {
				usuarios.put(usuario.getId(), usuario);
				return;
			} else {
				findByEmail(usuario.getEmail());
			}
		} catch(Exception error) {
			usuarios.put(usuario.getId(), usuario);
			return;
		}
		
		throw new Exception("O e-mail informado já está em uso!");
		
		
	};
	
	public static int count() {
		return usuarios.size();
	}
}
