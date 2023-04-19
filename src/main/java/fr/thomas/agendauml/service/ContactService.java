package fr.thomas.agendauml.service;

import fr.thomas.agendauml.model.Contact;
import fr.thomas.agendauml.model.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    List<Contact> getContactsByAgenda(Long agendaId);

    Contact getContact(Long contactId);

    void createContact(ContactDTO contactDTO);

    void updateContact(Long contactId, ContactDTO contactDTO);

    void deleteContact(Long contactId);
}
