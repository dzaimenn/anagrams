package ua.foxminded.git.anagrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagramMakerTest {

    @Test
    void testAnagramMakerWithNull() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            AnagramMaker maker = new AnagramMaker(null);
        });

        assertEquals("Source string cannot be null", exception.getMessage());
    }

    @Test
    void testAnagramMakerWithEmptyString() {
        AnagramMaker maker = new AnagramMaker("");
        assertEquals("", maker.resultAnagramMaker());
    }

    @Test
    void testAnagramMakerWithSingleSpace() {
        AnagramMaker maker = new AnagramMaker("ja17va java17");
        assertEquals("av17aj avaj17", maker.resultAnagramMaker());
    }

    @Test
    void testAnagramMakerWithSeveralSpace() {
        AnagramMaker maker = new AnagramMaker("ja17va     java17");
        assertEquals("av17aj     avaj17", maker.resultAnagramMaker());
    }

    @Test
    void testAnagramMakerWithSingleCharacter() {
        AnagramMaker maker = new AnagramMaker("@");
        assertEquals("@", maker.resultAnagramMaker());
    }

    @Test
    void testAnagramMakerWithMultipleSameLetter() {
        AnagramMaker maker = new AnagramMaker("jjj");
        assertEquals("jjj", maker.resultAnagramMaker());
    }

    @Test
    void testAnagramMakerWithSameCharacterInLowerAndUpperCasesMixed() {
        AnagramMaker maker = new AnagramMaker("AAaAaa");
        assertEquals("aaAaAA", maker.resultAnagramMaker());
    }

    @Test
    void testAnagramMakerWithWordWithDifferentLetters() {
        AnagramMaker maker = new AnagramMaker("jvm");
        assertEquals("mvj", maker.resultAnagramMaker());
    }

    @Test
    void testAnagramMakerWithOnlySymbols() {
        AnagramMaker maker = new AnagramMaker("17!@#");
        assertEquals("17!@#", maker.resultAnagramMaker());
    }

    @Test
    void testAnagramMakerWithSeveralWords() {
        AnagramMaker maker = new AnagramMaker("java maven junit");
        assertEquals("avaj nevam tinuj", maker.resultAnagramMaker());
    }
}
