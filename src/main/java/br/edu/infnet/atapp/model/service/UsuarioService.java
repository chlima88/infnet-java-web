package br.edu.infnet.atapp.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.IUsuarioRepository;

@Service
public class UsuarioService {
	
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public Usuario incluir(Usuario usuario) throws Exception {
		Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioEncontrado != null ) throw new Exception("E-mail <strong>[" + usuario.getEmail() + "]</strong> ja cadastrado!");
		return usuarioRepository.save(usuario);
	}
	
	public Usuario excluir(Integer key) throws Exception {
		Optional<Usuario> servico = usuarioRepository.findById(key);
		if (servico.isEmpty()) throw new Exception("Usuário não encontrado!"); 
		usuarioRepository.deleteById(key);
		return servico.get();
	}
	
	public void atualizar(String email, Usuario usuario) throws Exception {
		usuarioRepository.save(usuario);
	}
	
	public Collection<Usuario> obterLista(){
		return (Collection<Usuario>) usuarioRepository.findAll();
	}
	
	public Usuario buscarEmail(String email) throws Exception {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario == null) throw new Exception("E-mail <strong>" + email + "</strong> não encontrado");
		return usuario;
	}
	
	public Usuario autenticar(Usuario usuario) throws Exception{
		
		if (!usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new Exception("Usuario ou senha invalidos");
		}
		
		Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
		
		if (!usuarioEncontrado.getEmail().equalsIgnoreCase(usuario.getEmail())
				|| !usuarioEncontrado.getSenha().equalsIgnoreCase(usuario.getSenha())) {
			throw new Exception("Usuario ou senha invalidos");
		};
		return usuarioEncontrado;
		
	}
}
