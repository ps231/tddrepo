package com.sorting;

import org.junit.Assert;
import org.junit.Test;

public class FindElementIndexTest {

    @Test
    public void classMustExist() {
        Assert.assertNotNull(new FindElementIndex(new int[] { 1 }));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForEmptyArray() {
        new FindElementIndex(new int[] {});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidArraySize() {
        final int[] inputArr = new int[1001];
        new FindElementIndex(inputArr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenArrayElementsAreInvalid() {
        final FindElementIndex unit = new FindElementIndex(new int[] { -59, 0, -4, -1000, -1001 });
        unit.getIndexOfElement(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenArrayElementsAreInvalid1() {
        final FindElementIndex unit = new FindElementIndex(new int[] { -59, -4, -1000, 1, 1000, 1001, 0 });
        unit.getIndexOfElement(0);
    }

    @Test
    public void shouldReturnCorrectIndexOfArrayElement() {
        final FindElementIndex unit = new FindElementIndex(new int[] { 1, 4, 5, 7, 9, 12 });
        Assert.assertEquals(1, unit.getIndexOfElement(4));
    }


}
