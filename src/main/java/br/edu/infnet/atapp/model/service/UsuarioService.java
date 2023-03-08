package br.edu.infnet.atapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario incluir(Usuario usuario) throws Exception {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario excluir(Integer key) throws Exception {
		return usuarioRepository.delete(key);
	}
	
	public void atualizar(String email, Usuario usuario) throws Exception {
		usuarioRepository.update(email, usuario);
	}
	
	public Collection<Usuario> obterLista(){
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarEmail(String email) throws Exception {
		return usuarioRepository.findByEmail(email);
	}
}
