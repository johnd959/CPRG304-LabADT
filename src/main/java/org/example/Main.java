package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Date dummy = new Date(1, 1, 2010);
        dummy.getWeekDays(args[0], Integer.parseInt(args[1]));

    }
}