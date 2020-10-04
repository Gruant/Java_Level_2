package ru.grutsinav;

import java.util.Objects;

public class Person {
    private final String lastName;
    private final String telNumber;
    private final String eMail;
    private static int identifier;

    Person(String lastName, String telNumber, String eMail){
        this.lastName = lastName;
        this.telNumber = telNumber;
        this.eMail = eMail;
        identifier++;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lastName, identifier);
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getEmail() {
        return eMail;
    }
}

