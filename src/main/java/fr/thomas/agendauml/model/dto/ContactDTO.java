package fr.thomas.agendauml.model.dto;

public class ContactDTO {
    private String firstName;

    private String lastName;

    private Long agendaId;

    public ContactDTO(String firstName, String lastName, Long agendaId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.agendaId = agendaId;
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

    public Long getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(Long agendaId) {
        this.agendaId = agendaId;
    }
}
