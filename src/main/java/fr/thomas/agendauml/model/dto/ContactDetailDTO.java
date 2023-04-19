package fr.thomas.agendauml.model.dto;

public class ContactDetailDTO {
    private String value;

    private String type;

    private Long contactId;

    public ContactDetailDTO(String value, String type, Long contactId) {
        this.value = value;
        this.type = type;
        this.contactId = contactId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
}
