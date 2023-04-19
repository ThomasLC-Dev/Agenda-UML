package fr.thomas.agendauml.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.regex.Pattern;

@Entity
@DiscriminatorValue("email")
public class Email extends ContactDetail{
    private static final String REGEX_PATTERN = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";

    public Email() {
        super();
    }

    public Email(String value, Contact contact) {
        super(value, contact);
    }

    @Override
    public boolean validate() {
        return Pattern.matches(REGEX_PATTERN, this.getValue());
    }
}
