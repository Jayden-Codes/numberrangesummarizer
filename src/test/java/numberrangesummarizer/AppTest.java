package numberrangesummarizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private App myApp;
    /**
     * Rigorous Test :-)
     */
    @Before
    public void setup() {
        myApp = new App();
    }

    @Test
    public void testCollect() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection <Integer> myCollection = myApp.collect(input);
        List<Integer> expectedCollection = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        assertEquals(expectedCollection, myCollection);

    }

    @Test
    public void summarizeCollection() {

    }


    @Test
    public void testSampleInput() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection <Integer> myCollection = myApp.collect(input);
        assertEquals(myApp.summarizeCollection(myCollection), "1, 3, 6-8, 12-15, 21-24, 31");
    }

    @Test
    public void testNoCollectInput() {
        String input = "";
        Collection <Integer> myCollection = myApp.collect(input);
        assertEquals(myApp.summarizeCollection(myCollection), "");
    }


}
