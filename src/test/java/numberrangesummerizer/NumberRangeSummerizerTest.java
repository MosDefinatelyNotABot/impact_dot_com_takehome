package numberrangesummerizer;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberRangeSummerizerTest {

    @Test
    void testCollectCaseGibberish() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = " dalfkdasjlf a;sldkfja;lskd";

        assertThrows(NumberFormatException.class, () -> summarizerObj.collect(input));
    }

    @Test
    void testCollectCaseEmpty() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = "";

        Collection<Integer> outCol = summarizerObj.collect(input);
        assertEquals(0, outCol.size());
    }

    @Test
    void testCollectCaseOneNumber() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = "1";
        Collection<Integer> result = summarizerObj.collect(input);

        int expectedSize = 1;
        assertEquals(expectedSize, result.size());
        assertTrue(result.contains(1));
    }

    @Test
    void testCollectOrderedAndUnique() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = "1,3,2,3,1,4,2";
        Collection<Integer> result = summarizerObj.collect(input);

        TreeSet<Integer> expected = new TreeSet<>(List.of(1, 2, 3, 4));

        assertEquals(expected, new TreeSet<>(result));
    }

    @Test
    void testSummarizeCollectionCaseImpactExample() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        Collection<Integer> outCol = summarizerObj.collect(input);
        String outStr = summarizerObj.summarizeCollection(outCol);

        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", outStr);
    }

    @Test
    void testSummarizeCollectionCaseSimple() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = "1,2,3,4,7,8,9,10";

        Collection<Integer> outCol = summarizerObj.collect(input);
        String outStr = summarizerObj.summarizeCollection(outCol);

        assertEquals("1-4, 7-10", outStr);
    }

    @Test
    void testSummarizeCollectionConsequtive() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = "1,2,4,7,8";

        Collection<Integer> outCol = summarizerObj.collect(input);
        String outStr = summarizerObj.summarizeCollection(outCol);

        // Instruction ambiguous. At least this is what I think it should be.
        assertEquals("1-2, 4, 7-8", outStr);

    }

    @Test
    void testSummarizeCollectionCaseEmpty() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = "";

        Collection<Integer> outCol = summarizerObj.collect(input);
        assertEquals("", summarizerObj.summarizeCollection(outCol));
    }

    @Test
    void testCollectWithSpaces() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = "1, 2, 3";
        Collection<Integer> result = summarizerObj.collect(input);

        assertEquals(3, result.size());
        assertTrue(result.containsAll(List.of(1, 2, 3)));
    }

    @Test
    void testCollectWithNegativeNumbers() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = "-1,0,1,2";
        Collection<Integer> result = summarizerObj.collect(input);

        assertEquals(4, result.size());
        assertTrue(result.containsAll(List.of(-1, 0, 1, 2)));
    }

    @Test
    void testSummarizeCollectionSingleRange() {
        NumberRangeSummerizer summarizerObj = new NumberRangeSummerizer();
        String input = "1,2,3,4,5";

        Collection<Integer> result = summarizerObj.collect(input);
        String summary = summarizerObj.summarizeCollection(result);

        assertEquals("1-5", summary);
    }
}