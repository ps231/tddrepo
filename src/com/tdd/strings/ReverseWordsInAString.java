package com.tdd.strings;

public class ReverseWordsInAString {
    public static void main(final String... args) {
        System.out.println("'" + ReverseWordsInAString.reverseWords("how are you") + "'");
        System.out.println("'" + ReverseWordsInAString.reverseWords("  how are you  ") + "'");
        System.out.println("'" + ReverseWordsInAString.reverseWords("  how     are   you  ") + "'");
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder reversedWords = new StringBuilder();
        for(int i = words.length-1; i>0; i--) {
            reversedWords.append(words[i].trim());
            reversedWords.append(" ");
        }
        reversedWords.append(words[0].trim());
        return reversedWords.toString();
    }
}
