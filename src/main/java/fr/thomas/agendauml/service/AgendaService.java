package fr.thomas.agendauml.service;

import fr.thomas.agendauml.model.Agenda;
import fr.thomas.agendauml.model.dto.AgendaDTO;

import java.util.List;

public interface AgendaService {
    List<Agenda> getAgendasByUser(Long userId);

    Agenda getAgenda(Long agendaId);

    void createAgenda(AgendaDTO agendaDTO);

    void updateAgenda(Long agendaId, AgendaDTO agendaDTO);

    void deleteAgenda(Long agendaId);
}
