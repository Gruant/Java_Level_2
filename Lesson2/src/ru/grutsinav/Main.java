package ru.grutsinav;

public class Main {

    public static void main(String[] args) {
        StringToMatrix newString = new StringToMatrix("10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0");

        try{
            System.out.println(newString.getDivision());
        }
        catch (IndexOutOfBoundsException | NumberFormatException e){
            System.out.println(e.getMessage());
        }

    }

}
