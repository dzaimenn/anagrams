package ua.foxminded.git.anagrams;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnagramMakerTest {

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

}
