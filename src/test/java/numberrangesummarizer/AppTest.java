package numberrangesummarizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * Unit test for App.
 * Assumptions:
 * 1. Commas are the only delimiters used.
 * 2. String input contains valid integers.
 */
public class AppTest
{
    private App myApp;

    @Before
    public void setup() {
        myApp = new App();
    }

    @Test
    public void testCollect() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection <Integer> myCollection = myApp.collect(input);
        assertEquals(Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31), myCollection);

    }

    @Test
    public void test_SampleInput() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection <Integer> myCollection = myApp.collect(input);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", myApp.summarizeCollection(myCollection));
    }
    @Test
    public void testSummarizeCollection_SingleNumber() {
        String summary = myApp.summarizeCollection(Collections.singletonList(1));
        assertEquals("1", summary);
    }
    @Test
    public void testSummarizeCollection_NonConsecutiveNumbers() {
        String summary = myApp.summarizeCollection(Arrays.asList(1, 3, 5, 7));
        assertEquals("1, 3, 5, 7", summary);
    }
    @Test
    public void testSummarizeCollection_NegativeInputRange() {
        String input = "1,3,6,7,8,-12,-11,-10,-9,21,22,23,24,31";
        Collection <Integer> myCollection = myApp.collect(input);
        assertEquals("1, 3, 6-8, -12--9, 21-24, 31", myApp.summarizeCollection(myCollection));
    }

    @Test
    public void testSummarizeCollection_SingleInputRange() {
        String input = "1,2,3,4,5,6,7,8,9,10";
        Collection <Integer> myCollection = myApp.collect(input);
        assertEquals("1-10", myApp.summarizeCollection(myCollection));
    }

    @Test
    public void testCollection_InputWhiteSpaces() {
        String input = "1,3 ,6,  12";
        Collection <Integer> myCollection = myApp.collect(input);
        assertEquals(Arrays.asList(1, 3, 6, 12), myCollection);
    }
    @Test
    public void testSummarizeCollection_InputWhiteSpaces() {
        String input = "1,3,6,    7,8,12,13,14,     15,21,22,23,24,  31";
        Collection <Integer> myCollection = myApp.collect(input);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", myApp.summarizeCollection(myCollection));
    }

    @Test
    public void testCollection_EmptyInput() {
        String input = "";
        Collection <Integer> myCollection = myApp.collect(input);
        assertTrue(myCollection.isEmpty());
    }
    @Test
    public void testCollection_NullInput() {
        Collection<Integer> myCollection = myApp.collect(null);
        assertTrue(myCollection.isEmpty());
    }
    @Test
    public void testSummarizeCollection_EmptyInput() {
        Collection<Integer> myCollection = myApp.collect("");
        assertTrue(myCollection.isEmpty());

        String summary = myApp.summarizeCollection(myCollection);
        assertEquals("", summary);
    }


    @Test(expected = NumberFormatException.class)
    public void testCollection_InvalidValueInput() {
        String input = "1,2,3,5,5,6,7,,9,10";
        myApp.collect(input);
    }

    @Test (expected = NumberFormatException.class)
    public void testInputFormatInvalidDelimiter() {
        String input = "1,3,6,7,8,12,13,14/15,21,22,23,24,31";
        myApp.collect(input);
    }
    @Test (expected = NumberFormatException.class)
    public void testInvalidInput() {
        String input = "1,3,4,5,six";
        myApp.collect(input);

    }
    @Test
    public void testSummarizeCollection_WithDuplicateNumbers() {
        String result = myApp.summarizeCollection(Arrays.asList(1, 2, 3, 3, 4, 5));
        assertEquals("1-3, 3-5", result);
    }


}
