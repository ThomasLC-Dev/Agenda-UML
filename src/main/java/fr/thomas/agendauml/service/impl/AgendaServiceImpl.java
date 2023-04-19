package fr.thomas.agendauml.service.impl;

import fr.thomas.agendauml.exception.CustomException;
import fr.thomas.agendauml.model.Agenda;
import fr.thomas.agendauml.model.User;
import fr.thomas.agendauml.model.dto.AgendaDTO;
import fr.thomas.agendauml.repository.AgendaRepository;
import fr.thomas.agendauml.service.AgendaService;
import fr.thomas.agendauml.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;
    private final UserService userService;

    public AgendaServiceImpl(AgendaRepository agendaRepository, UserService userService) {
        this.agendaRepository = agendaRepository;
        this.userService = userService;
    }

    @Override
    public List<Agenda> getAgendasByUser(Long userId) {
        return agendaRepository.findAllByUserId(userId);
    }

    @Override
    public Agenda getAgenda(Long agendaId) {
        return agendaRepository.findById(agendaId).orElseThrow(() -> new CustomException("Agenda inexistant"));
    }

    @Override
    public void createAgenda(AgendaDTO agendaDTO) {
        User user = userService.getUser(agendaDTO.getUserId());
        Agenda agenda = new Agenda(agendaDTO.getName(), user);
        agendaRepository.save(agenda);
    }

    @Override
    public void updateAgenda(Long agendaId, AgendaDTO agendaDTO) {
        Agenda agenda = this.getAgenda(agendaId);
        User user = (agendaDTO.getUserId() != null) ? userService.getUser(agendaDTO.getUserId()) : null;
        agenda.setName((agendaDTO.getName() != null) ? agendaDTO.getName() : agenda.getName());
        agenda.setUser((user != null) ? user : agenda.getUser());
        agendaRepository.save(agenda);
    }

    @Override
    public void deleteAgenda(Long agendaId) {
        agendaRepository.deleteById(agendaId);
    }
}
