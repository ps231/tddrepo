package com.tdd.strings.combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//given an input string, print all possible combinations, with capitalization
//eg: given abc, the possible combinations are -
//abc, abC, aBc, aBC, Abc, AbC, ABc, ABC
public class CombinationsOfStringWithCapitalization {
    public static void main(final String... args) {
        printAllCombinations("abc").forEach(System.out::println);
        printAllCombinations("abcd").forEach(System.out::println);
    }

    private static List<String> printAllCombinations(String input) {
        if (input.isEmpty())
            return null;

        List<String> temp = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            String singleChar = input.charAt(i) + "";
            if (temp.isEmpty()) {
                concatCharWithCapitalization(temp, singleChar, singleChar.toUpperCase());
            } else {
                final List<String> anotherTemp = new ArrayList<>();
                temp.forEach(concatSingleCharToAllExistingCombinations(singleChar, anotherTemp));
                temp = anotherTemp;
            }
        }
        return temp;
    }

    private static Consumer<String> concatSingleCharToAllExistingCombinations(String singleChar, List<String> anotherTemp) {
        return (final String s) -> {
            concatCharWithCapitalization(anotherTemp, s.concat(singleChar), s.concat(singleChar.toUpperCase()));};
    }

    private static void concatCharWithCapitalization(List<String> anotherTemp, String sChar, String sCharWithCaps) {
        anotherTemp.add(sChar);
        anotherTemp.add(sCharWithCaps);
    }
}
