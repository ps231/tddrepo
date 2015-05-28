package com.tdd;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

//You are given an integer N. Find the digits in this number that exactly divide N(division that leaves 0 as remainder)
//and display their count. For N=24, there are 2 digits − 2 & 4. Both of these digits exactly divide 24. So our answer is 2.

//If the same number is repeated twice at different positions, it should be counted twice, e.g., For N=122, 2 divides 122
//exactly and occurs at ones' and tens' position. So for this case, our answer is 3.

//Division by 0 is undefined.
public class FindDigitsTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegativeNumbers() {
        FindDigits.validateNumber(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForZero() {
        FindDigits.validateNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForExcessivelyLargeNumbersOfTheOrderTo10() {
        FindDigits.validateNumber(100000000001L);
    }

    @Test
    public void shouldReturnNumberOfDigitsInANumber() {
        Assert.assertEquals(createList(2, 1), FindDigits.getDigitsListExceptZero(12));
        Assert.assertEquals(createList(3, 2, 1), FindDigits.getDigitsListExceptZero(123));
    }

    @Test
    public void shouldReturnNumberOfDigitsInANumberExceptZero() {
        Assert.assertEquals(createList(2, 1), FindDigits.getDigitsListExceptZero(120));
        Assert.assertEquals(createList(1), FindDigits.getDigitsListExceptZero(100));
    }

    @Test
    public void shouldReturnNumberOfDigitsThatExactlyDivideTheNumber() {
        Assert.assertEquals(2, FindDigits.getDigitsThatExactlyDivideTheNumber(120));
        Assert.assertEquals(3, FindDigits.getDigitsThatExactlyDivideTheNumber(1012));
        Assert.assertEquals(1, FindDigits.getDigitsThatExactlyDivideTheNumber(25));
        Assert.assertEquals(2, FindDigits.getDigitsThatExactlyDivideTheNumber(520));
    }

    private List<Integer> createList(final int... digits) {
        final List<Integer> digitList = new ArrayList<Integer>();
        for (final int digit : digits) {
            digitList.add(digit);
        }
        return digitList;
    }

}
