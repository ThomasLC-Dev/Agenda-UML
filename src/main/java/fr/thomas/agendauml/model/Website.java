package fr.thomas.agendauml.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.regex.Pattern;

@Entity
@DiscriminatorValue("website")
public class Website extends ContactDetail{
    private static final String REGEX_PATTERN = "(https|http)?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)";

    public Website() {
        super();
    }

    public Website(String value, Contact contact) {
        super(value, contact);
    }

    @Override
    public boolean validate() {
        return Pattern.matches(REGEX_PATTERN, this.getValue());
    }
}
