package br.edu.infnet.atapp.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.edu.infnet.atapp.model.domain.Usuario;
import br.edu.infnet.atapp.model.repository.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	@Autowired
	private StorageService storageService;
	
	public Usuario incluir(Usuario usuario) throws Exception {
		Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioEncontrado != null)
			throw new Exception("E-mail <strong>[" + usuario.getEmail() + "]</strong> ja cadastrado!");
		return usuarioRepository.save(usuario);
	}
	
	public Usuario incluir(Usuario usuario, MultipartFile imagem) throws Exception {
		
		if (imagem != null && !imagem.isEmpty()) usuario.setImagemUrl(storageService.putObject("cj-lab", imagem));
		return incluir(usuario);
	}


	public Usuario excluir(Integer key) throws Exception {
		Optional<Usuario> servico = usuarioRepository.findById(key);
		if (servico.isEmpty())
			throw new Exception("Usuário não encontrado!");
		usuarioRepository.deleteById(key);
		return servico.get();
	}

	public void atualizar(Usuario usuario) throws Exception {
		
		Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioEncontrado != null &&
				usuarioEncontrado.getId() != usuario.getId())
			throw new Exception("E-mail <strong>[" + usuario.getEmail() + "]</strong> ja cadastrado!");
		
		System.out.println(usuario.getId());
		usuarioRepository.save(usuario);
	}

	public Collection<Usuario> obterLista() {
		return (Collection<Usuario>) usuarioRepository.findAll();
	}

	public Collection<Usuario> obterLista(Usuario usuarioLogado) {
		if (usuarioLogado.isMasterAdmin()) {
			return (Collection<Usuario>) usuarioRepository.findAll();
		} else {
			return (Collection<Usuario>) usuarioRepository.findAllByEmpresa(usuarioLogado.getEmpresa());
		}
	};

	public Usuario buscarEmail(String email, Usuario usuarioLogado) throws Exception {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario == null)
			throw new Exception("E-mail <strong>" + email + "</strong> não encontrado");
		
		if ( !usuarioLogado.isMasterAdmin() 
				&& !usuario.getEmpresa().equalsIgnoreCase(usuarioLogado.getEmpresa())) {
			throw new Exception("E-mail <strong>" + email + "</strong> não encontrado");			
		}
		return usuario;
	}

	public Usuario autenticar(Usuario usuario) throws Exception {

		if (!usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new Exception("Usuario ou senha invalidos");
		}

		Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());

		if (!usuarioEncontrado.getEmail().equalsIgnoreCase(usuario.getEmail())
				|| !usuarioEncontrado.getSenha().equalsIgnoreCase(usuario.getSenha())) {
			throw new Exception("Usuario ou senha invalidos");
		}
		;
		return usuarioEncontrado;

	}
}
