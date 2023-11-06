package ua.foxminded.git.anagrams;

import java.util.StringJoiner;

public class AnagramMaker {
    private final String sourceString;

    public AnagramMaker(String sourceString) {
        this.sourceString = sourceString;
    }

    private String reverseOneWord(String word) {
        char[] charSource = word.toCharArray();
        char[] charFinal = new char[charSource.length];
        int finalIndex = charSource.length - 1;

        for (int i = 0; i < charSource.length; i++) {
            if (!(Character.isLetter(charSource[i]))) {
                charFinal[i] = charSource[i];
            }
        }

        for (int i = 0; i < charSource.length; i++) {
            if (Character.isLetter(charSource[i])) {
                // Checking if the character at charFinal[finalIndex] is a null character
                if (charFinal[finalIndex] == '\u0000') {
                    charFinal[finalIndex] = charSource[i];
                } else {
                    charFinal[finalIndex - 1] = charSource[i];
                }
                finalIndex--;
            }
        }

        return new String(charFinal);
    }

    private String reverseAllWords(String sourceString) {
        String[] words = sourceString.split(" ");
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String word : words) {
            stringJoiner.add(reverseOneWord(word));
        }
        return stringJoiner.toString();
    }

    public void viewAnagramMaker() {
        String result = reverseAllWords(sourceString);
        System.out.println(result);
    }
}
