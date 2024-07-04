package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App implements NumberRangeSummarizer
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    /**
     * @param input
     * @return
     */
    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }
        String [] val = input.split(",");
        Collection<Integer> myCollection = new ArrayList<>();
        for (String v: val) {
            myCollection.add(Integer.parseInt(v));
        }

        return myCollection;
    }

    /**
     * @param input
     * @return
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
