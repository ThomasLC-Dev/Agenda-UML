package fr.thomas.agendauml.controller;

import fr.thomas.agendauml.model.ContactDetail;
import fr.thomas.agendauml.model.dto.ContactDetailDTO;
import fr.thomas.agendauml.service.ContactDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-details")
public class ContactDetailController {
    private final ContactDetailService contactDetailService;

    public ContactDetailController(ContactDetailService contactDetailService) {
        this.contactDetailService = contactDetailService;
    }

    @GetMapping
    public ResponseEntity<List<ContactDetail>> getContactDetails(@RequestParam(name = "contact", required = true) Long contactId){
        return new ResponseEntity<>(contactDetailService.getContactDetailsByContact(contactId), HttpStatus.OK);
    }

    @GetMapping("/{contactDetailId}")
    public ResponseEntity<ContactDetail> getContactDetail(@PathVariable(name = "contactDetailId") Long contactDetailId){
        return new ResponseEntity<>(contactDetailService.getContactDetail(contactDetailId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createContactDetail(@RequestBody ContactDetailDTO contactDetailDTO){
        contactDetailService.createContactDetail(contactDetailDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{contactDetailId}")
    public ResponseEntity<?> updateContactDetail(@PathVariable(name = "contactDetailId") Long contactDetailId, @RequestBody ContactDetailDTO contactDetailDTO){
        contactDetailService.updateContactDetail(contactDetailId, contactDetailDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{contactDetailId}")
    public ResponseEntity<?> deleteContactDetail(@PathVariable(name = "contactDetailId") Long contactDetailId){
        contactDetailService.deleteContactDetail(contactDetailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
