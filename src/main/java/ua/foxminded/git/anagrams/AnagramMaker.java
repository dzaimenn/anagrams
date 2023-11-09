package ua.foxminded.git.anagrams;

import java.util.StringJoiner;

public class AnagramMaker {
    private final String sourceString;

    public AnagramMaker(String sourceString) {
        this.sourceString = sourceString;
    }

    private String reverseOneWord(String word) {
        char[] initialChars = word.toCharArray();
        char[] resultChars = new char[initialChars.length];
        int startIndex = 0;
        int finalIndex = initialChars.length - 1;

        for (char ch : initialChars) {
            if (!(Character.isLetter(ch))) {
                resultChars[startIndex] = ch;
            }
            startIndex++;
        }

        for (char ch : initialChars) {
            if (Character.isLetter(ch)) {
                while (resultChars[finalIndex] != 0) {
                    finalIndex--;
                }
                resultChars[finalIndex] = ch;
                finalIndex--;
            }
        }
        return new String(resultChars);
    }

    private String reverseAllWords(String sourceString) {
        String[] words = sourceString.split(" ");
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String word : words) {
            stringJoiner.add(reverseOneWord(word));
        }
        return stringJoiner.toString();
    }

    public String resultAnagramMaker() {
        return reverseAllWords(sourceString);
    }

    public void viewAnagramMaker() {
        System.out.println(resultAnagramMaker());
    }
}
