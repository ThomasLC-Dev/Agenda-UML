package fr.thomas.agendauml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "agenda_id", referencedColumnName = "id", nullable = false)
    private Agenda agenda;

    @OneToMany(mappedBy = "contact")
    private List<ContactDetail> contactDetailList;

    public Contact() {
    }

    public Contact(String firstName, String lastName, Agenda agenda) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.agenda = agenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public List<ContactDetail> getContactDetailList() {
        return contactDetailList;
    }

    public void setContactDetailList(List<ContactDetail> contactDetailList) {
        this.contactDetailList = contactDetailList;
    }
}
