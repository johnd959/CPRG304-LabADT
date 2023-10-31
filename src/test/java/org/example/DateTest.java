package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    Date date;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        date =  new Date(1, 1, 2023);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        date = null;
    }

    @Test
    void dateComparisonTest()
    {
        Date newDate = new Date(2, 1, 2023);
        assertTrue(date.compareTo(newDate) < 0);
    }

    @Test
    void renderISOTest()
    {
        assertEquals(date.renderISO(), "2023-1-1");
    }

    @Test
    void changeDateTestNegative()
    {
        date.changeDate(-4523);
        Date newDate = new Date(14, 8, 2010);
        assertEquals(date.compareTo(newDate), 0);
    }

    @Test
    void changeDateTestPositive()
    {
        date.changeDate(2000);
        Date newDate = new Date(23, 6, 2028);
        assertEquals(date.compareTo(newDate), 0);
    }
    @Test
    void changeDateTestZero()
    {
        date.changeDate(0);
        Date newDate = new Date(1, 1, 2023);
        assertEquals(date.compareTo(newDate), 0);
    }
}