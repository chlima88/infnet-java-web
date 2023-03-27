package br.edu.infnet.atapp.model.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.infnet.atapp.model.domain.Agendamento;

public interface IAgendamentoRepository extends JpaRepository<Agendamento, Integer>  {

	Agendamento findByData(LocalDateTime data);
	
	List<Agendamento> findAll(Sort sort);
	
	@Query("from Agendamento a where a.usuario.empresa = :empresa ")
	Collection<Agendamento> findAllByEmpresa(String empresa, Sort sort);

	Collection<Agendamento> findAllByData(LocalDateTime data, Sort sort);
	
}

