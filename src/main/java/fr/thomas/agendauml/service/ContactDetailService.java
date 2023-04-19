package fr.thomas.agendauml.service;

import fr.thomas.agendauml.model.ContactDetail;
import fr.thomas.agendauml.model.dto.ContactDetailDTO;

import java.util.List;

public interface ContactDetailService {
    List<ContactDetail> getContactDetailsByContact(Long contactId);

    ContactDetail getContactDetail(Long contactDetailId);

    void createContactDetail(ContactDetailDTO contactDetailDTO);

    void updateContactDetail(Long contactDetailId, ContactDetailDTO contactDetailDTO);

    void deleteContactDetail(Long contactDetailId);
}
