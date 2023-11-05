package ua.foxminded.git.anagrams;

public class AnagramMaker {
    private String sourceString;

    public AnagramMaker(String sourceString) {
        this.sourceString = sourceString;
    }

    private String reverseWord(String word) {
        char[] charactersSource = word.toCharArray();
        char[] charactersFinal = new char[charactersSource.length];

        for (int i = 0; i < charactersSource.length; i++) {
            if (Character.isLetter(charactersSource[i])) {
                charactersFinal[charactersFinal.length - 1 - i] = charactersSource[i];
            } else {
                charactersFinal[i] = charactersSource[i];
            }
        }
        return new String(charactersFinal);
    }

    private String reverseString(String sourceString) {
        String[] words = sourceString.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(reverseWord(words[i]));
            if (i < words.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void anagramMaker() {
        String result = reverseString(sourceString);
        System.out.println(result);
    }


}
