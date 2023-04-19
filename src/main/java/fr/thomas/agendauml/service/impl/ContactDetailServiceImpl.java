package fr.thomas.agendauml.service.impl;

import fr.thomas.agendauml.exception.CustomException;
import fr.thomas.agendauml.model.*;
import fr.thomas.agendauml.model.dto.ContactDetailDTO;
import fr.thomas.agendauml.repository.ContactDetailRepository;
import fr.thomas.agendauml.service.ContactDetailService;
import fr.thomas.agendauml.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactDetailServiceImpl implements ContactDetailService {
    private final ContactDetailRepository contactDetailRepository;

    private final ContactService contactService;

    public ContactDetailServiceImpl(ContactDetailRepository contactDetailRepository, ContactService contactService) {
        this.contactDetailRepository = contactDetailRepository;
        this.contactService = contactService;
    }

    @Override
    public List<ContactDetail> getContactDetailsByContact(Long contactId) {
        return contactDetailRepository.findAllByContactId(contactId);
    }

    @Override
    public ContactDetail getContactDetail(Long contactDetailId) {
        return contactDetailRepository.findById(contactDetailId).orElseThrow(() -> new CustomException("Détail de contact inexistant"));
    }

    @Override
    public void createContactDetail(ContactDetailDTO contactDetailDTO) {
        Contact contact = contactService.getContact(contactDetailDTO.getContactId());
        ContactDetail contactDetail = null;
        switch (contactDetailDTO.getType()){
            case "address":
                contactDetail = new Address(contactDetailDTO.getValue(), contact);
                break;
            case "phone":
                contactDetail = new Phone(contactDetailDTO.getValue(), contact);
                break;
            case "email":
                contactDetail = new Email(contactDetailDTO.getValue(), contact);
                break;
            case "website":
                contactDetail = new Website(contactDetailDTO.getValue(), contact);
                break;
        }
        if(!contactDetail.validate()){
            throw new CustomException("Format invalide");
        }
        else{
            contactDetailRepository.save(contactDetail);
        }
    }

    @Override
    public void updateContactDetail(Long contactDetailId, ContactDetailDTO contactDetailDTO) {
        ContactDetail contactDetail = this.getContactDetail(contactDetailId);
        Contact contact = (contactDetailDTO.getContactId() != null) ? contactService.getContact(contactDetailDTO.getContactId()) : null;
        contactDetail.setValue((contactDetailDTO.getValue() != null) ? contactDetailDTO.getValue() : contactDetail.getValue());
        contactDetail.setContact((contact != null) ? contact : contactDetail.getContact());

        if(contactDetailDTO.getValue() != null && !contactDetail.validate()){
            throw new CustomException("Format invalide");
        }
        else {
            contactDetailRepository.save(contactDetail);
        }
    }

    @Override
    public void deleteContactDetail(Long contactDetailId) {
        contactDetailRepository.deleteById(contactDetailId);
    }
}
