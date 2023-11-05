package ua.foxminded.git.anagrams;

public class Main {
    public static void main(String[] args) {

        String testWords = "doom s1ayer bfg8000";

        AnagramMaker maker = new AnagramMaker(testWords);
        maker.anagramMaker();

    }
}