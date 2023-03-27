package br.edu.infnet.atapp.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.atapp.model.domain.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Integer>  {

	Cliente findByDocumento(String documento, Sort sort);
	
	@Query("from Cliente c where c.usuario.empresa = :empresa")
	Collection<Cliente> findAllByEmpresa(String empresa, Sort sort);


	Collection<Cliente> findAll(Sort sort);

}
