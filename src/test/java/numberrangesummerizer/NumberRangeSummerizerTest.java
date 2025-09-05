package numberrangesummerizer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberRangeSummerizerTest {

    @Test
    void testCollectCaseGibberish() {
        NumberRangeSummerizer summerizer_obj = new NumberRangeSummerizer();
        String input = " dalfkdasjlf a;sldkfja;lskd";

        assertThrows(NumberFormatException.class, () -> {
            summerizer_obj.collect(input);
        });
    }

    @Test
    void testCollectCaseEmpty() {
        NumberRangeSummerizer summerizer_obj = new NumberRangeSummerizer();
        String input = "";

        Collection<Integer> out_col = summerizer_obj.collect(input);
        assertEquals(0, out_col.size());
    }

    @Test
    void testCollectCaseOneNumber() {
        NumberRangeSummerizer summarizer = new NumberRangeSummerizer();
        String input = "1";
        Collection<Integer> result = summarizer.collect(input);

        int expectedSize = 1;
        assertEquals(expectedSize, result.size());
        assertTrue(result.contains(1));
    }

    @Test
    void testCollectOrderedAndUnique() {
        NumberRangeSummerizer summarizer = new NumberRangeSummerizer();
        String input = "1,3,2,3,1,4,2";
        Collection<Integer> result = summarizer.collect(input);

        TreeSet<Integer> expected = new TreeSet<>();
        expected.addAll(List.of(1, 2, 3, 4));

        assertEquals(expected, new TreeSet<>(result));
    }

    @Test
    void testSummarizeCollectionCaseImpactExample() {
        NumberRangeSummerizer summerizer_obj = new NumberRangeSummerizer();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        Collection<Integer> out_col = summerizer_obj.collect(input);
        String out_str = summerizer_obj.summarizeCollection(out_col);

        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", out_str);
    }

    @Test
    void testSummarizeCollectionCaseSimple() {
        NumberRangeSummerizer summerizer_obj = new NumberRangeSummerizer();
        String input = "1,2,3,4,7,8,9,10";

        Collection<Integer> out_col = summerizer_obj.collect(input);
        String out_str = summerizer_obj.summarizeCollection(out_col);

        assertEquals("1-4, 7-10", out_str);
    }

    @Test
    void testSummarizeCollectionConsequtive() {
        NumberRangeSummerizer summerizer_obj = new NumberRangeSummerizer();
        String input = "1,2,4,7,8";

        Collection<Integer> out_col = summerizer_obj.collect(input);
        String out_str = summerizer_obj.summarizeCollection(out_col);

        // Instruction ambiguous. At least this is what I think it should be.
        assertEquals("1-2, 4, 7-8", out_str);

    }

    @Test
    void testSummarizeCollectionCaseEmpty() {
        NumberRangeSummerizer summerizer_obj = new NumberRangeSummerizer();
        String input = "";

        Collection<Integer> out_col = summerizer_obj.collect(input);
        assertEquals("", summerizer_obj.summarizeCollection(out_col));
    }

    @Test
    void testCollectWithSpaces() {
        NumberRangeSummerizer summarizer = new NumberRangeSummerizer();
        String input = "1, 2, 3";
        Collection<Integer> result = summarizer.collect(input);

        assertEquals(3, result.size());
        assertTrue(result.containsAll(List.of(1, 2, 3)));
    }

    @Test
    void testCollectWithNegativeNumbers() {
        NumberRangeSummerizer summarizer = new NumberRangeSummerizer();
        String input = "-1,0,1,2";
        Collection<Integer> result = summarizer.collect(input);

        assertEquals(4, result.size());
        assertTrue(result.containsAll(List.of(-1, 0, 1, 2)));
    }

    @Test
    void testSummarizeCollectionSingleRange() {
        NumberRangeSummerizer summarizer = new NumberRangeSummerizer();
        String input = "1,2,3,4,5";

        Collection<Integer> result = summarizer.collect(input);
        String summary = summarizer.summarizeCollection(result);

        assertEquals("1-5", summary);
    }
}