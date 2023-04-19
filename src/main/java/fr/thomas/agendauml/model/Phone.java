package fr.thomas.agendauml.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.regex.Pattern;

@Entity
@DiscriminatorValue("phone")
public class Phone extends ContactDetail{
    private static final String REGEX_PATTERN = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";

    public Phone() {
        super();
    }

    public Phone(String value, Contact contact) {
        super(value, contact);
    }

    @Override
    public boolean validate() {
        return Pattern.matches(REGEX_PATTERN, this.getValue());
    }
}
