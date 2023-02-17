package br.edu.infnet.atapp.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.edu.infnet.atapp.model.domain.Usuario;

public class LoginRepository {
	

	static Collection<Usuario> logins = UsuarioRepository.findAll();
		
	
	public static Usuario autenticar(Usuario usuario) throws Exception {
		
		if (!existsByEmail(usuario.getEmail())) {
			throw new Exception("Usuario ou senha invalidos");
		}
		
		Usuario usuarioEncontrado = findByEmail(usuario.getEmail());
		
		if (!usuarioEncontrado.getEmail().equalsIgnoreCase(usuario.getEmail())
				|| !usuarioEncontrado.getSenha().equalsIgnoreCase(usuario.getSenha())) {
			throw new Exception("Usuario ou senha invalidos");
		};
		return usuarioEncontrado;
	};
	
	public static Usuario save(String nome, String email, String senha) {
		Usuario usuario = new Usuario(nome, email, senha);
		return usuario;
	};
	
	public static Usuario findByEmail(String email) throws Exception {
		
		Usuario usuarioEncontrado = null;
		
		for (Usuario usuario: logins) {
			if (email.equalsIgnoreCase(usuario.getEmail())) {
				usuarioEncontrado = usuario;
			}
		}			
		if (usuarioEncontrado == null) throw new Exception("Usuario não encontrado");
		return usuarioEncontrado;
	};
	
	public static boolean existsByEmail(String email) {
		
		for (Usuario usuario: logins) {
			if (usuario.getEmail().equalsIgnoreCase(email)) return true;
		}
		return false;
	};
	
}
