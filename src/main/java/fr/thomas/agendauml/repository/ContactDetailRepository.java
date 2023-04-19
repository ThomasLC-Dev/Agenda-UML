package fr.thomas.agendauml.repository;

import fr.thomas.agendauml.model.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDetailRepository extends JpaRepository<ContactDetail, Long> {
    List<ContactDetail> findAllByContactId(Long contactId);
}
