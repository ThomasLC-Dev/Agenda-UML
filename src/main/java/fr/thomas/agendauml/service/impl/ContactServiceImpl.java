package fr.thomas.agendauml.service.impl;

import fr.thomas.agendauml.exception.CustomException;
import fr.thomas.agendauml.model.Agenda;
import fr.thomas.agendauml.model.Contact;
import fr.thomas.agendauml.model.dto.ContactDTO;
import fr.thomas.agendauml.repository.ContactRepository;
import fr.thomas.agendauml.service.AgendaService;
import fr.thomas.agendauml.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    private final AgendaService agendaService;

    public ContactServiceImpl(ContactRepository contactRepository, AgendaService agendaService) {
        this.contactRepository = contactRepository;
        this.agendaService = agendaService;
    }

    @Override
    public List<Contact> getContactsByAgenda(Long agendaId) {
        return contactRepository.findAllByAgendaId(agendaId);
    }

    @Override
    public Contact getContact(Long contactId) {
        return contactRepository.findById(contactId).orElseThrow(() -> new CustomException("Contact inexistant"));
    }

    @Override
    public void createContact(ContactDTO contactDTO) {
        Agenda agenda = agendaService.getAgenda(contactDTO.getAgendaId());
        Contact contact = new Contact(contactDTO.getFirstName(), contactDTO.getLastName(), agenda);
        contactRepository.save(contact);
    }

    @Override
    public void updateContact(Long contactId, ContactDTO contactDTO) {
        Contact contact = this.getContact(contactId);
        Agenda agenda = (contactDTO.getAgendaId() != null) ? agendaService.getAgenda(contactDTO.getAgendaId()) : null;
        contact.setFirstName((contactDTO.getFirstName() != null) ? contactDTO.getFirstName() : contact.getFirstName());
        contact.setLastName((contactDTO.getLastName() != null) ? contactDTO.getLastName() : contact.getLastName());
        contact.setAgenda((agenda != null) ? agenda : contact.getAgenda());
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);
    }
}
