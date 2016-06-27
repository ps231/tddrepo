package com.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombination {

    public static void main(final String... args) {
        final HashMap<Character, String[]> numberMap = createNumberToAlphabetsMap();
        final LetterCombination lc = new LetterCombination();
        printCombinations(lc.getLetterCombinations("234", numberMap));
    }

    private static HashMap<Character, String[]> createNumberToAlphabetsMap() {
        final HashMap<Character, String[]> numberMap = new HashMap<>();
        numberMap.put('2', new String[] {"a", "b", "c"});
        numberMap.put('3', new String[] {"d", "e", "f"});
        numberMap.put('4', new String[] {"g", "h", "i"});
        numberMap.put('5', new String[] {"j", "k", "l"});
        numberMap.put('6', new String[] {"m", "n", "o"});
        numberMap.put('7', new String[] {"p", "q", "r", "s"});
        numberMap.put('8', new String[] {"t", "u", "v"});
        numberMap.put('9', new String[] {"w", "x", "y", "z"});
        return numberMap;
    }

    public List<String> getLetterCombinations (final String digits, final HashMap<Character, String[]> numberMap) {
        List<String> initialCombinations = null;
        if (digits.contains("1") || digits.contains("0") || digits.length() == 0 || digits.trim().length() == 0) {
            initialCombinations = new ArrayList<>();
        } else if (digits.length() == 1) {
            initialCombinations = Arrays.asList(numberMap.get(digits.charAt(0)));
        } else {
            initialCombinations = getCombinationForTwoNumbers(numberMap.get(digits.charAt(0)), numberMap.get(digits.charAt(1)));
            for(int i = 2; i < digits.length(); i++) {
                initialCombinations = getCombinationForTwoNumbers(initialCombinations.toArray(new String[initialCombinations.size()]), numberMap.get(digits.charAt(i)));
            }
        }
        return initialCombinations;
    }

    private List<String> getCombinationForTwoNumbers(String[] firstString, String[] secondString) {
        final List<String> combinations = new ArrayList<>();

        for(final String alphabet1 : firstString) {
            for(final String alphabet2 : secondString) {
                combinations.add(alphabet1 + alphabet2);
            }
        }
        return combinations;
    }

    private static void printCombinations(final List<String> letterCombinations) {
        for(final String comb : letterCombinations) {
            System.out.println(comb);
        }
    }
}