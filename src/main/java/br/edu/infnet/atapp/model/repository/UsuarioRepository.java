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
	
//	public static Usuario findByName(String nome) {
//		for (Usuario usuario: usuarios) {
//			if (usuario.nome.equals(nome) ) {
//				
//			}
//		};
//	};
	
	public static List<Usuario> findAll() {
		return null;
	};
	
	public static int count() {
		return usuarios.size();
	}
}
