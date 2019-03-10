package com.example.simpledivision;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionTest {

    @Test
    public void divisionIntByInt(){
        assertEquals(2, Division.makeDivision(10,5), 0.0001);
    }

    @Test
    public void divisionZeroByInt(){
        assertEquals(0, Division.makeDivision(0, 5), 0);
    }

    @Test
    public void divisionIntByZero(){
        assertEquals(Double.POSITIVE_INFINITY, Division.makeDivision(5, 0), 0.0001);
    }

    @Test
    public void divisionZerobyZero(){
        assertTrue(Double.isNaN(Division.makeDivision(0, 0)));
    }

}