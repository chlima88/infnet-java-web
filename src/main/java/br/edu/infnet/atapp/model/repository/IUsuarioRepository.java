package br.edu.infnet.atapp.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.atapp.model.domain.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer>  {


	Usuario findByEmail(String email);
	Usuario findByNome(String email);
	Boolean existsByEmail(String email);
	

	@Query("from Usuario u where u.empresa = :empresa order by u.id")
	Collection<Usuario> findAllByEmpresa(String empresa);
	
}
