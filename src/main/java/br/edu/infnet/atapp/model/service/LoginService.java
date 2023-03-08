package br.edu.infnet.atapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.UsuarioRepository;

@Service
public class LoginService {

	
	@Autowired
	private UsuarioRepository loginRepository;
	
	public Usuario autenticar(Usuario usuario) throws Exception{
			
		if (!loginRepository.existsByEmail(usuario.getEmail())) {
			throw new Exception("Usuario ou senha invalidos");
		}
		
		Usuario usuarioEncontrado = loginRepository.findByEmail(usuario.getEmail());
		
		if (!usuarioEncontrado.getEmail().equalsIgnoreCase(usuario.getEmail())
				|| !usuarioEncontrado.getSenha().equalsIgnoreCase(usuario.getSenha())) {
			throw new Exception("Usuario ou senha invalidos");
		};
		return usuarioEncontrado;
		
	}
	
}
