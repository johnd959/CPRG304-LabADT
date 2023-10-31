package org.example;

public class Date extends AbsDate implements Comparable {

    //fields for holding the date information
    private int day;
    private int month;
    private int year;
    private int dayCount;
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day % (dayCount + 1);
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

    public int getDayCount(int month, int year) {

        int dayCount;

        int newMonth = month > 7 ? month - 7 : month;

        if (newMonth % 2 == 0)
        {
            if (month == 2)
            {
                if (year % 100 == 0 && year != 0)
                {
                    if(year % 400 == 0)
                        dayCount = 29;
                    else
                        dayCount = 28;
                }
                else if (year % 4 == 0 && year != 0)
                {
                    dayCount = 29;
                }
                else
                    dayCount = 28;
            }
            else
                dayCount = 30;
        }
        else
            dayCount = 31;

        return dayCount;
    }
    /**
     *
     * @param day
     * @param month
     * @param year
     * Takes in an integer for a day, a month, and a year to construct a date. Any values for the standard
     * definitions of a month or a year will be a modulo of the respective definitions.
     */
    public Date(int day, int month, int year)
    {
        this.dayCount = getDayCount(month, year);
        setMonth(month);
        setDay(day);
        setYear(year);
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
    public String renderISO()
    {
        return this.year + "-" + this.month + "-" + this.day;
    }

    public void changeDate(int change)
    {
        int totalDays = calcDays();
        totalDays += change;
        Date newDate = convertDate(totalDays);
        setDay(newDate.getDay());
        setMonth(newDate.getMonth());
        setYear(newDate.getYear());

    }

    public int calcDays()
    {
        int days = this.day;
        int month = this.month;
        int year = this.year;
        while(month > 1)
        {
            days += getDayCount(month, year);
            month--;
        }
        while (year > 0)
        {
            days+= (7 * 31);
            days+= (4 * 30);


            if (year % 100 == 0)
            {
                if(year % 400 == 0)
                    days += 29;
                else
                    days += 28;
            }
            else if (year % 4 == 0)
            {
                days += 29;
            }
            else
                days += 28;


            year--;
        }

        return days;
    }

    public Date convertDate(int days)
    {
        //pointers to the cuurent month and year
        int currMonth = 1;
        int currYear = 0;
        while(days > getDayCount(currMonth, currYear))
        {
            days -= getDayCount(currMonth, currYear);
            currMonth++;
            if(currMonth > 12)
            {
                currMonth = 1;
                currYear++;
            }
        }
        if(currMonth > 12)
        {
            currMonth = 1;
            currYear++;
        }
        Date newDate = new Date(days, currMonth, currYear);
        return newDate;
    }

}
