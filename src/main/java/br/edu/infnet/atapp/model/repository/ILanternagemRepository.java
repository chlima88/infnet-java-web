package br.edu.infnet.atapp.model.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.infnet.atapp.model.domain.Lanternagem;

public interface ILanternagemRepository extends CrudRepository<Lanternagem, Integer>  {

	Lanternagem findByCodigo(String codigo);

	
}
