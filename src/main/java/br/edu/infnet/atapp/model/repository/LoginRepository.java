package br.edu.infnet.atapp.model.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.atapp.model.domain.Usuario;

public class LoginRepository {
	

	static List<Usuario> logins = new ArrayList<Usuario>();
	
	static {
		Usuario admin = new Usuario("admin","123");
		logins.add(admin);		
	}
	
	
	public static boolean autenticar(Usuario usuario) throws Exception {
		
		if (!existsByEmail(usuario.getEmail())) {
			throw new Exception("Usuario ou senha invalidos");
		}
		
		Usuario usuarioEncontrado = findByEmail(usuario.getEmail());
		
		if (!usuarioEncontrado.getEmail().equalsIgnoreCase(usuario.getEmail())
				|| !usuarioEncontrado.getSenha().equalsIgnoreCase(usuario.getSenha())) {
			throw new Exception("Usuario ou senha invalidos");
		};
		return true;
	};
	
	private static Usuario findByEmail(String email) throws Exception {
		
		Usuario usuarioEncontrado = null;
		
		for (Usuario usuario: logins) {
			if (email.equalsIgnoreCase(usuario.getEmail())) {
				usuarioEncontrado = usuario;
			}
		}			
		if (usuarioEncontrado == null) throw new Exception("Usuario não encontrado");
		return usuarioEncontrado;
	};
	
	private static boolean existsByEmail(String email) {
		
		for (Usuario usuario: logins) {
			if (usuario.getEmail().equalsIgnoreCase(email)) return true;
		}
		return false;
	};
	
}
