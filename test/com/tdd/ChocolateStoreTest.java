package com.tdd;

import org.junit.Assert;
import org.junit.Test;

public class ChocolateStoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void storeShouldThrowExceptionOnInvalidAmount() {
        ChocolateStore.getMaxChocolates(1, 2, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void storeShouldThrowExceptionOnInvalidPricePerChocolate() {
        ChocolateStore.getMaxChocolates(2, 0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void storeShouldThrowExceptionOnInvalidWrappers() {
        ChocolateStore.getMaxChocolates(2, 1, 1);
    }

    // @Test
    // public void storeShouldReturnChocolatesThatCanBeBought() {
    // final int randomWrappers = 2;
    // Assert.assertEquals(5, ChocolateStore.getMaxChocolates(10, 2,
    // randomWrappers));
    // Assert.assertEquals(6, ChocolateStore.getMaxChocolates(6, 1,
    // randomWrappers));
    // Assert.assertEquals(3, ChocolateStore.getMaxChocolates(15, 5,
    // randomWrappers));
    // }

    @Test
    public void storeShouldReturnCorrectChocolates() {
        Assert.assertEquals(3, ChocolateStore.getMaxChocolates(12, 4, 4));
        Assert.assertEquals(6, ChocolateStore.getMaxChocolates(10, 2, 5));
        Assert.assertEquals(5, ChocolateStore.getMaxChocolates(6, 2, 2));
        Assert.assertEquals(19, ChocolateStore.getMaxChocolates(15, 1, 4));
    }

}
