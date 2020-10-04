package ru.grutsinav;
/*
Написать простой класс PhoneBook(внутри использовать HashMap):
В качестве ключа использовать фамилию
В каждой записи всего два поля: phone, e-mail
Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
и отдельный метод для поиска e-mail по фамилии.
* Следует учесть, что под одной фамилией может быть несколько записей. Итого должно получиться
3 класса Main, PhoneBook, Person.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<Person, ArrayList<String>> phonebook;

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void addPerson(Person person) {
        ArrayList<String> valuesArray = new ArrayList<>();
        valuesArray.add(person.getTelNumber());
        valuesArray.add(person.getEmail());
        phonebook.put(person, valuesArray);
    }

    public void getPhonebook() {
        for (Person s : phonebook.keySet()) {
            System.out.println(s.getLastName() + " : " + phonebook.get(s).get(0) +
                    " , " + phonebook.get(s).get(1));
        }
    }

    public ArrayList<String> getPhoneByLastName(String lastname){
        ArrayList<String> telNumbers = new ArrayList<>();
        for (Person s : phonebook.keySet()) {
            if (s.getLastName().equalsIgnoreCase(lastname)){
                telNumbers.add(s.getTelNumber());
            }
        }
        return telNumbers;
    }

    public ArrayList<String> getEmailByLastName(String lastname){
        ArrayList<String> eMailNumbers = new ArrayList<>();
        for (Person s : phonebook.keySet()) {
            if (s.getLastName().equalsIgnoreCase(lastname)){
                eMailNumbers.add(s.getEmail());
            }
        }
        return eMailNumbers;
    }

}