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
    void changeDateTest()
    {
        date.changeDate(365);
        Date newDate = new Date(1, 1, 2024);
        assertEquals();

    }
}