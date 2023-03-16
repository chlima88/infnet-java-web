package br.edu.infnet.atapp.model.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.infnet.atapp.model.domain.Mecanica;

public interface IMecanicaRepository extends CrudRepository<Mecanica, Integer>  {

	Mecanica findByCodigo(String codigo);

	
}
