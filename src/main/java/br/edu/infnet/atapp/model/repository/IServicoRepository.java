package br.edu.infnet.atapp.model.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.edu.infnet.atapp.model.domain.Servico;


public interface IServicoRepository extends JpaRepository<Servico, Integer>  {

	Servico findByCodigo(String documento);
	
	@Query("from Servico s where s.usuario.empresa = :empresa")
	Collection<Servico> findAllByEmpresa(String empresa, Sort sort);
	
	List<Servico> findAll(Sort sort);
}
