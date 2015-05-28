package com.tdd;

import org.junit.Assert;
import org.junit.Test;

//Shashank likes strings in which consecutive characters are different. For example, he likes ABABA,
//while he doesn't like ABAA. Given a string containing characters A and B only, he wants to change it
//into a string he likes. To do this, he is allowed to delete the characters in the string.
//Your task is to find the minimum number of required deletions.
//AAAA⟹A, 3 deletions
//BBBBB⟹B, 4 deletions
//ABABABAB⟹ABABABAB, 0 deletions
//BABABA⟹BABABA, 0 deletions
//AAABBB⟹AB, 4 deletions

public class AlternatingCharactersTest {

    @Test
    public void shouldNotAcceptEmptyOrNullString() {
        Assert.assertFalse(AlternatingCharacters.isValid(""));
        Assert.assertFalse(AlternatingCharacters.isValid(null));
    }

    @Test
    public void shouldNotAcceptCharsOtherThanAAndB() {
        Assert.assertFalse(AlternatingCharacters.isValid("ABC"));
        Assert.assertFalse(AlternatingCharacters.isValid("12AANN"));
        Assert.assertFalse(AlternatingCharacters.isValid("AB#^&ABC"));
    }

    @Test
    public void shouldAcceptAStringOnlyWithAAndBChars() {
        Assert.assertTrue(AlternatingCharacters.isValid("ABBAABBBBAAA"));
        Assert.assertTrue(AlternatingCharacters.isValid("AAAAAAAA"));
        Assert.assertTrue(AlternatingCharacters.isValid("BBBBBB"));
        Assert.assertTrue(AlternatingCharacters.isValid("BAAA"));
    }

    @Test
    public void shouldReturnMinimumCharsToDelete() {
        Assert.assertEquals(0, AlternatingCharacters.getMinimumCharsToDelete("ABABABAB"));
        Assert.assertEquals(0, AlternatingCharacters.getMinimumCharsToDelete("BABABA"));
        Assert.assertEquals(4, AlternatingCharacters.getMinimumCharsToDelete("AAABBB"));
        Assert.assertEquals(3, AlternatingCharacters.getMinimumCharsToDelete("AAAA"));
    }

}
