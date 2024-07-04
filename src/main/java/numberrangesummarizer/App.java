package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The App class implements the NumberRangeSummarizer interface. It takes a comma-separated
 * string of numbers as input and returns a string summarizing the numbers with ranges.
 */
public class App implements NumberRangeSummarizer
{
    public static void main( String[] args )
    {
        App nrs = new App();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> myCollection = nrs.collect(input);
        String summary = nrs.summarizeCollection(myCollection);
        System.out.println(summary);

    }

    /**
     * Collects a comma-separated string of numbers into a collection of integers.
     * @param input The comma-separated string of numbers.
     * @return A collection of integers representing the numbers.
     */
    @Override
    public Collection<Integer> collect(String input) {

        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }
        input = input.replaceAll(" ", "");
        String [] val = input.split(",");
        Collection<Integer> myCollection = new ArrayList<>();
        for (String v: val) {
            try {
                myCollection.add(Integer.parseInt(v));
            } catch (NumberFormatException e){
                throw new NumberFormatException("Invalid input: " + e.getMessage());
            }
        }

        return myCollection;
    }

    /**
     * Summarizes a collection of integers into a string with ranges for consecutive numbers.
     * @param input The collection of integers to summarize.
     * @return A string summarizing the numbers with ranges.
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        List<Integer> numbers = new ArrayList<>(input);
        int numSize = numbers.size();
        StringBuilder output = new StringBuilder();

        for (int i= 0; i < numSize; i++) {
            int start = numbers.get(i);
            int end = start;
            while (i + 1 < numSize && numbers.get(i+1) == numbers.get(i) + 1) {
                end = numbers.get(i+1);
                i++;
            }
            if (start == end) {
                if(i + 1 < numSize) {
                    output.append(start).append(", ");
                } else {
                    output.append(start);
                }
            } else {
                if(i + 1 < numSize) {
                    output.append(start).append("-").append(end).append(", ");
                } else {
                    output.append(start).append("-").append(end);
                }
            }
        }

        return output.toString();
    }
}
