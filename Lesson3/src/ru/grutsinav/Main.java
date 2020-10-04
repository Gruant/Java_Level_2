package ru.grutsinav;

import java.util.Arrays;

public class Main {
    // поаторяющиеся слова "gift" - 3, "solo" - 2, "raw" - 2,
    static final String[] WORDS = {"gift", "service", "craftsman", "hemisphere", "declaration", "solo", "gift",
            "admission", "cassette", "develop", "loud", "husband", "raw", "damage", "miserable",
            "eyebrow", "regulation", "courage", "sigh", "provoke", "bend", "surface", "authorise",
            "pioneer", "fibre", "raw", "solo", "merchant", "ice", "gift"};

    static final String[] LASTNAME = {"Сидоров", "Иванов"};


    public static void main(String[] args) {
        //Задача 1
        WorkWithArray work = new WorkWithArray(WORDS);
        System.out.print("Исходный массив слов " + Arrays.toString(Arrays.stream(WORDS).toArray()));
        System.out.println();
        System.out.println("Без дублирования " + work.arrayWithOutDuplicate());
        System.out.println("Подсчет повторов " + work.volumeOfWordsInArray());

        System.out.print("\n\n");

        //*Задача 2
        PhoneBook phoneBook = new PhoneBook();
        Person person1 = new Person("Иванов", "+7-977-157-67-78", "mail@mail.ru");
        Person person2 = new Person("Иванов", "+7-900-770-66-99", "yandex@mail.ru");
        Person person3 = new Person("Сидоров", "+7-905-000-77-77", "gmail@mail.ru");
        phoneBook.addPerson(person1);
        phoneBook.addPerson(person2);
        phoneBook.addPerson(person3);

        System.out.println("Записна книжка:");
        phoneBook.getPhonebook();
        System.out.println();

        System.out.println("Поиск телефонов по фамилии: " + LASTNAME[1]);
        System.out.println(phoneBook.getPhoneByLastName(LASTNAME[1]));
        System.out.println();

        System.out.println("Поиск e-mail по фамилии: " + LASTNAME[1]);
        System.out.println(phoneBook.getEmailByLastName(LASTNAME[1]));

    }
}
