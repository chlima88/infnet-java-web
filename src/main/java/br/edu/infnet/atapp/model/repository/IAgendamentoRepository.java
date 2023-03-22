package br.edu.infnet.atapp.model.repository;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.infnet.atapp.model.domain.Agendamento;

public interface IAgendamentoRepository extends JpaRepository<Agendamento, Integer>  {

	Agendamento findByData(LocalDateTime data);
	
	@Query("from Agendamento a where a.usuario.empresa = :empresa order by a.data desc")
	Collection<Agendamento> findAllByEmpresa(String empresa);

	Collection<Agendamento> findAllByData(LocalDateTime data);
	
}

