package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        // date demo
        Date date = new Date(2,11,2023);
        Date christmas = new Date(25, 12,2023);
        System.out.println("Days until christmas from Nov 2, 2023: " + (christmas.calcDays() - date.calcDays()));
        System.out.println("Date of date object: " + date.renderISO());
        System.out.println("Moving date the required number of days until it is Christmas");
        date.changeDate(christmas.calcDays() - date.calcDays());
        System.out.println("Date of date object: " + date.renderISO());
        date.changeDate(-3425);
        System.out.println("What is the date 3425 days before Christmas?" );
        System.out.println("It's: " + date.renderISO()+ "\n Let's advance it back to Christmas eve");
        date.changeDate(3424);
        System.out.println(date.renderISO());


        System.out.println("Every " + args[0] + " for the year " + args[1]);
        Date dummy = new Date(1, 1, 2010);
        dummy.getWeekDays(args[0], Integer.parseInt(args[1]));

    }
}