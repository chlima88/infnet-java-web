package br.edu.infnet.atapp.model.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.infnet.atapp.model.domain.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer>  {


	Usuario findByEmail(String email);
	Usuario findByNome(String email);
	Boolean existsByEmail(String email);
	
}
