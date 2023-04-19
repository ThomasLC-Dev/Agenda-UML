package fr.thomas.agendauml.repository;

import fr.thomas.agendauml.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findAllByUserId(Long userId);
}
