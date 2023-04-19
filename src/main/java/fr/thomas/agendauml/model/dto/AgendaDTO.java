package fr.thomas.agendauml.model.dto;

public class AgendaDTO {
    private String name;

    private Long userId;

    public AgendaDTO(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
