package fr.thomas.agendauml.controller;

import fr.thomas.agendauml.model.Contact;
import fr.thomas.agendauml.model.dto.ContactDTO;
import fr.thomas.agendauml.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getContacts(@RequestParam(name = "agenda", required = true) Long agendaId){
        return new ResponseEntity<>(contactService.getContactsByAgenda(agendaId), HttpStatus.OK);
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContact(@PathVariable(name = "contactId") Long contactId){
        return new ResponseEntity<>(contactService.getContact(contactId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createContact(@RequestBody ContactDTO contactDTO){
        contactService.createContact(contactDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<?> updateContact(@PathVariable(name = "contactId") Long contactId, @RequestBody ContactDTO contactDTO){
        contactService.updateContact(contactId, contactDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable(name = "contactId") Long contactId){
        contactService.deleteContact(contactId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
