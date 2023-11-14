package ua.foxminded.git.anagrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagramMakerTest {

    @Test
    void testAnagramMakerWithNull() {

        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            AnagramMaker maker = new AnagramMaker(null);
        });
        String expectedException = "Source string cannot be null";

        assertEquals(expectedException, actualException.getMessage());
    }

    @Test
    void testAnagramMakerWithEmptyString() {
        AnagramMaker maker = new AnagramMaker("");

        String actual = maker.resultAnagramMaker();
        String expected = "";

        assertEquals(expected, actual);
    }

    @Test
    void testAnagramMakerWithSingleSpace() {
        AnagramMaker maker = new AnagramMaker("ja17va java17");

        String actual = maker.resultAnagramMaker();
        String expected = "av17aj avaj17";

        assertEquals(expected, actual);
    }

    @Test
    void testAnagramMakerWithSeveralSpace() {
        AnagramMaker maker = new AnagramMaker("ja17va     java17");

        String actual = maker.resultAnagramMaker();
        String expected = "av17aj     avaj17";

        assertEquals(expected, actual);
    }

    @Test
    void testAnagramMakerWithSingleCharacter() {
        AnagramMaker maker = new AnagramMaker("@");

        String actual = maker.resultAnagramMaker();
        String expected = "@";

        assertEquals(expected, actual);
    }

    @Test
    void testAnagramMakerWithMultipleSameLetter() {
        AnagramMaker maker = new AnagramMaker("jjj");

        String actual = maker.resultAnagramMaker();
        String expected = "jjj";

        assertEquals(expected, actual);
    }

    @Test
    void testAnagramMakerWithSameCharacterInLowerAndUpperCasesMixed() {
        AnagramMaker maker = new AnagramMaker("AAaAaa");

        String actual = maker.resultAnagramMaker();
        String expected = "aaAaAA";

        assertEquals(expected, actual);
    }

    @Test
    void testAnagramMakerWithWordWithDifferentLetters() {
        AnagramMaker maker = new AnagramMaker("jvm");

        String actual = maker.resultAnagramMaker();
        String expected = "mvj";

        assertEquals(expected, actual);
    }

    @Test
    void testAnagramMakerWithOnlySymbols() {
        AnagramMaker maker = new AnagramMaker("17!@#");

        String actual = maker.resultAnagramMaker();
        String expected = "17!@#";

        assertEquals(expected, actual);
    }

    @Test
    void testAnagramMakerWithSeveralWords() {
        AnagramMaker maker = new AnagramMaker("java maven junit");

        String actual = maker.resultAnagramMaker();
        String expected = "avaj nevam tinuj";

        assertEquals(expected, actual);
    }
}
