package com.tdd;

import org.junit.Assert;
import org.junit.Test;

public class RomanToIntegerTest {

    private final RomanToInteger r = new RomanToInteger();

    @Test
    public void shouldReturnZeroForNullInput() {
        verify(0, r.convert(null));
    }

    @Test
    public void shouldReturnZeroForEmptyInput() {
        verify(0, r.convert(""));
    }

    @Test
    public void shouldReturnOneForCorrectInput() {
        verify(1, r.convert("I"));
    }

    @Test
    public void shouldReturnOneForIrrespectiveOfCaseAndWhiteSpaces() {
        verify(1, r.convert(" i "));
    }

    @Test
    public void shouldReturnTwoForCorrectInput() {
        verify(2, r.convert("II"));
    }

    @Test
    public void shouldReturnThreeForCorrectInput() {
        verify(3, r.convert("IIi"));
    }

    @Test
    public void shouldReturnFourForCorrectInput() {
        verify(4, r.convert("iV"));
    }

    @Test
    public void shouldReturnFiveForCorrectInput() {
        verify(5, r.convert("V"));
    }

    @Test
    public void shouldReturnSixForCorrectInput() {
        verify(6, r.convert("Vi"));
    }

    @Test
    public void shouldReturnTenForCorrectInput() {
        verify(10, r.convert("X"));
    }

    @Test
    public void shouldReturnSixteenForCorrectInput() {
        verify(16, r.convert("XVI"));
    }

    @Test
    public void shouldReturnFourteenForCorrectInput() {
        verify(14, r.convert("XIV"));
    }

    @Test
    public void shouldReturnNineForCorrectInput() {
        verify(9, r.convert("IX"));
    }


    private void verify(final int expected, final int actual) {
        Assert.assertEquals(expected, actual);
    }
}
