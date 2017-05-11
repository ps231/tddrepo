package com.tdd.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllCombinationsOfMobileKeypad {

    public static void main(final String... args) {
        Map<Character, String> keypad = new HashMap<>();
        keypad.put('1', "abc");
        keypad.put('2', "def");
        keypad.put('3', "ghi");

        List<String> combinations = new ArrayList<>();
        char[] chars = new char[3];
        getAllCombinations("123", keypad, combinations, chars, 0);
        combinations.stream().forEach(System.out::println);
    }

    private static void getAllCombinations(String num, Map<Character, String> keypad, List<String> combinations, char[] chars, int level) {
        for (int j = 0; j < keypad.get(num.charAt(level)).length(); j++) {
            chars[level] = keypad.get(num.charAt(level)).charAt(j);
            if (level == num.length() - 1)
                combinations.add(Arrays.toString(chars));
            else
                getAllCombinations(num, keypad, combinations, chars, level + 1);

        }
    }
}
