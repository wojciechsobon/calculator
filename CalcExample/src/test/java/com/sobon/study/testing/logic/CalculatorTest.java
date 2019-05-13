package com.sobon.study.testing.logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void simpleAdd() {
        assertEquals(4,Calculator.add("2","2"),0);
        assertEquals(10,Calculator.add("-20","30"),0);
    }

    @Test (expected=NumberFormatException.class)
    public void addFail() {
        assertEquals(4,Calculator.add("b","a"),0);
    }

    @Test
    public void simpleDivide() {
        assertEquals(10,Calculator.divide("20","2"),0);
        assertEquals(2,Calculator.divide("-20","-10"),0);
    }

    @Test (expected=RuntimeException.class)
    public void divideFail() {
        assertEquals(10,Calculator.divide("100","0"),0);
    }

    @Test
    public void simpleSubtract() {
        assertEquals(0,Calculator.subtract("100","100"),0);
        assertEquals(100,Calculator.subtract("-100","-200"),0);
    }

    @Test (expected=NumberFormatException.class)
    public void subtractFail() {
        assertEquals(4,Calculator.subtract("five","1"),0);
    }
}