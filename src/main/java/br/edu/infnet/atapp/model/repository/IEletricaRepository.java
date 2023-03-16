package br.edu.infnet.atapp.model.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.infnet.atapp.model.domain.Eletrica;

public interface IEletricaRepository extends CrudRepository<Eletrica, Integer>  {

	Eletrica findByCodigo(String documento);

	
}
