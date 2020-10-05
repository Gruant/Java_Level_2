package ru.grutsinav;

import java.util.Objects;

public class Person<P> {
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
        return Objects.hash(this.getLastName(), identifier);
    }

    @Override
    public String toString() {
        return getLastName();
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

