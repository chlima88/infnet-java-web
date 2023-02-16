package br.edu.infnet.atapp.model.repository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.infnet.atapp.model.domain.Usuario;

public class UsuarioRepository {
	
	//private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static Map<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
	private static Integer id = 0;
	
	private static Usuario usuario = new Usuario("Usuario", "1@1.com", "123", null, "P", "1");
	
	static {
		try {
			save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static Usuario save(Usuario usuario) throws Exception {
		
		try {
			findByEmail(usuario.getEmail());			
		} catch (Exception e) {
			usuario.setId(id);
			usuarios.put(id++, usuario);
			return usuario;
		} 
		throw new Exception("E-mail ja cadastrado!");

	};
	
	public static Usuario delete(Integer key) throws Exception {
		
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
	
	public static Usuario findByEmail(String email) throws Exception {
		
		Usuario usuarioEncontrado = null;
	
		for (Usuario usuario: usuarios.values()) {
			if (usuario.getEmail().equalsIgnoreCase(email.toLowerCase()) ) {
				usuarioEncontrado = usuario;				
			}
		};
		
		if (usuarioEncontrado == null) throw new Exception("Usuário não encontrado!");
		
		return usuarioEncontrado;
		
	};
	
	public static Collection<Usuario> findAll() {
		return usuarios.values();
	};
	
//	public static void update(String email, Usuario usuario) throws Exception {
//		
//		Usuario usuarioEncontrado = findByEmail(email);
//		
//		try {
//			if (email != usuario.getEmail()) findByEmail(usuario.getEmail());
//		} catch(Exception error) {
//			int usuarioIndex = usuarios.indexOf(usuarioEncontrado);
//			usuarios.set(usuarioIndex, usuario);		
//			return;
//		}
//		throw new Exception("O e-mail informado já está em uso!");
//		
//		
//	};
	
	public static int count() {
		return usuarios.size();
	}
}
