package fr.thomas.agendauml.controller;

import fr.thomas.agendauml.model.Agenda;
import fr.thomas.agendauml.model.dto.AgendaDTO;
import fr.thomas.agendauml.service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {
    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> getAgendas(@RequestParam(name = "user", required = true) Long userId){
        return new ResponseEntity<>(agendaService.getAgendasByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/{agendaId}")
    public ResponseEntity<Agenda> getAgenda(@PathVariable(name = "agendaId") Long agendaId){
        return new ResponseEntity<>(agendaService.getAgenda(agendaId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAgenda(@RequestBody AgendaDTO agendaDTO){
        agendaService.createAgenda(agendaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{agendaId}")
    public ResponseEntity<?> updateAgenda(@PathVariable(name = "agendaId") Long agendaId, @RequestBody AgendaDTO agendaDTO){
        agendaService.updateAgenda(agendaId, agendaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{agendaId}")
    public ResponseEntity<?> deleteAgenda(@PathVariable(name = "agendaId") Long agendaId){
        agendaService.deleteAgenda(agendaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
