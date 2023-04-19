package fr.thomas.agendauml.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.regex.Pattern;

@Entity
@DiscriminatorValue("address")
public class Address extends ContactDetail{
    private static final String REGEX_PATTERN = "(([a-zA-Z-éÉèÈàÀùÙâÂêÊîÎôÔûÛïÏëËüÜçÇæœ'.]*\\s)\\d*(\\s[a-zA-Z-éÉèÈàÀùÙâÂêÊîÎôÔûÛïÏëËüÜçÇæœ']*)*,)*\\d*(\\s[a-zA-Z-éÉèÈàÀùÙâÂêÊîÎôÔûÛïÏëËüÜçÇæœ']*)+,\\s([\\d]{5})\\s[a-zA-Z-éÉèÈàÀùÙâÂêÊîÎôÔûÛïÏëËüÜçÇæœ']+";

    public Address() {
        super();
    }

    public Address(String value, Contact contact) {
        super(value, contact);
    }

    @Override
    public boolean validate() {
        return Pattern.matches(REGEX_PATTERN, this.getValue());
    }
}
