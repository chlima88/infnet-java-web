package br.edu.infnet.atapp.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.atapp.model.domain.Mecanica;

public interface IMecanicaRepository extends CrudRepository<Mecanica, Integer>  {

	Mecanica findByCodigo(String codigo);
	@Query("from Mecanica m where m.usuario.empresa = :empresa")
	Collection<Mecanica> findAllByEmpresa(String empresa, Sort sort);

	Collection<Mecanica> findAll(Sort sort);
}
