package com.tdd.strings;

import com.tdd.strings.Pangram;
import org.junit.Assert;
import org.junit.Test;

public class PangramTest {

    @Test
    public void pangramMustExist() {
        Assert.assertNotNull("pangram must exist", new Pangram("a"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfInputStringLengthIsGreaterThanExpected() {
        new Pangram(new String(new char[1001]));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfInputStringIsNull() {
        new Pangram(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfInputStringIsEmpty() {
        new Pangram(" ");
    }

    @Test
    public void shouldReturnTrueIfStringIsPangram() {
        final Pangram p = new Pangram("The quick brown fox jumps over the lazy dog");
        Assert.assertTrue("should have returned true for pangram string", p.isPangram());
    }

    @Test
    public void shouldReturnFalseIfStringIsNotPangram() {
        final Pangram p = new Pangram("The quick brown fox jumps over the dog");
        Assert.assertFalse("should have returned false for non pangram string", p.isPangram());
    }

    @Test
    public void shouldIgnoreCasesWhileEvaulatingPangram() {
        final Pangram p = new Pangram("THE quick BROWN fox JUMPS over THE lazy DoG");
        Assert.assertTrue("should have returned true for pangram string", p.isPangram());
    }
}
