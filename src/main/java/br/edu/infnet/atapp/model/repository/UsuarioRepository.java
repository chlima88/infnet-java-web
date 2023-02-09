package br.edu.infnet.atapp.model.repository;


import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.atapp.model.domain.Usuario;

public class UsuarioRepository {
	
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
		
	public static boolean save(Usuario usuario) {
		usuarios.add(usuario);
		return false;
	};
	
	public static List<Usuario> findByName(String nome) {
		
		List<Usuario> usuariosEncontrados = new ArrayList<Usuario>();
	
		for (Usuario usuario: usuarios) {
			if (usuario.getNome().toLowerCase().contains(nome.toLowerCase()) ) {
				usuariosEncontrados.add(usuario);				
			}
		};
		
		return usuariosEncontrados;
		
	};
	
	public static Usuario findByEmail(String email) throws Exception {
		
		Usuario usuarioEncontrado = null;
	
		for (Usuario usuario: usuarios) {
			if (usuario.getEmail().equalsIgnoreCase(email.toLowerCase()) ) {
				usuarioEncontrado = usuario;				
			}
		};
		
		if (usuarioEncontrado == null) throw new Exception("Usuário não encontrado!");
		
		return usuarioEncontrado;
		
	};
	
	public static List<Usuario> findAll() {
		return usuarios;
	};
	
	public static int count() {
		return usuarios.size();
	}
}
