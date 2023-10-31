package org.example;

public abstract class AbsDate implements Comparable {
    //fields for holding the date information
    private int day;
    private int month;
    private int year;
    private int dayCount;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day % dayCount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract int getDayCount(int month, int year);
    /**
     *
     * @param month
     * Takes in an integer for a day, a month, and a year to construct a date. Any values for the standard
     * definitions of a month or a year will be a modulo of the respective definitions.
     */

    public AbsDate()
    {

    }
    public AbsDate(int day, int month, int year)
    {
        setMonth(month);
        setDay(day);
        setYear(year);
        this.dayCount = getDayCount(month, year);
    }

    /**
     *
     * @param date
     * @return An integer greater than one if the provided date is in the past<br/>
     * 0 - If the dates are exactly the same<br/>
     * A negative integer if the date provided is in the future
     */
    @Override
    public int compareTo(Object date)
    {
        if (getYear() - year == 0)
            if (getMonth() - month == 0)
                return getDay() - day;
            else
                return getMonth() - month;
        else
            return getYear() - year;
    }

    /**
     *
     * @return A string with the date formatted in the YYYY-MM-DD format
     */
    public abstract String renderISO();

    public abstract void changeDate(int change);

    public abstract int calcDays();


}
