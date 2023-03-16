package br.edu.infnet.atapp.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.edu.infnet.atapp.model.domain.Servico;

public interface IServicoRepository extends JpaRepository<Servico, Integer>  {

	Servico findByCodigo(String documento);
	@Query("from Servico s where s.usuario.empresa = :empresa order by s.codigo")
	Collection<Servico> findAllByEmpresa(String empresa);
	
}
