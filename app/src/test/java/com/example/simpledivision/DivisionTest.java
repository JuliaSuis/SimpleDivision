package com.example.simpledivision;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DivisionTest {

    private Division division = new Division();

    @Test
    public void divisionIntByInt(){
        assertEquals(2, division.execute(10, 5), 0.0001);
    }

    @Test
    public void divisionZeroByInt(){
        assertEquals(0, division.execute(0, 5), 0);
    }

    @Test
    public void divisionIntByZero(){
        assertEquals(Double.POSITIVE_INFINITY, division.execute(5, 0), 0.0001);
    }

    @Test
    public void divisionZerobyZero(){
        assertTrue(Double.isNaN(division.execute(0, 0)));
    }

}