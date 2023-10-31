package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Date date = new Date(1, 1, 2023);
        System.out.println(date.renderISO());
        date.changeDate(2000);
        System.out.println(date.renderISO());

    }
}