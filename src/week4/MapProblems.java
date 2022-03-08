package week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapProblems {

    /**
     * Given no input, return a list of roman numeral values for each letter.
     * 
     * See the corresponding test case for answers: -
     * {@link MapProblemsTest#testRomanValues}
     * 
     * @return capitalized letter keys, numeric values.
     */
    public static Map<Character, Integer> getRomanNumeralValues() {
        Map<Character, Integer> values = new HashMap<>();
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
        // put X=10, V=5, I=1
        return values;
    }

    /**
     * Given a list of words (strings), count how many times each occurs in the
     * input list.
     * 
     * @param words - the input to process
     * @return - a map containing how many times each unique word occurs.
     */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            int before = counts.getOrDefault(word, 0);
            counts.put(word, before + 1);
            // Every time you see a word, add it to 'counts' or increment its value.
            // HINT: use counts.getOrDefault(key, defaultValue)
            // Every word will be mapped to a list of positions you put it in
            // counts.put(word, 1);
        }
        return counts;
    }

    /**
     * Given a list of words (strings), record the positions where they occur in the
     * input list.
     * 
     * @param words - the input to process
     * @return - a map containing the indices that each unique word occurs.
     */
    public static Map<String, List<Integer>> indexWords(List<String> words) {

        // Create a map called index that stores string and list of positions
        Map<String, List<Integer>> index = new HashMap<>();

        // Loop through the words we get as input
        for (int i = 0; i < words.size(); i++) {

            // Find what the current location of the word is
            String word = words.get(i);

            // If we have already stored a value for this key, add the new value to the
            // preexisting list
            if (index.containsKey(word)) {

                index.get(word).add(i);

            }
            // If we have not seen this value, create a list called positions, add the
            // value, and put it in the index map
            else {
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                index.put(word, positions);
            }
        }
        return index;
    }

    /**
     * Given a map of counted strings, filter the keys to only those whose value
     * indicates they occur more than n times.
     * 
     * @param counts - map of string->int
     * @param n      - the count cutoff (not inclusive)
     * @return the output words that passed the test.
     */
    public static Set<String> countsLargerThan(Map<String, Integer> counts, int n) {
        Set<String> output = new HashSet<>();

        for (String word : counts.keySet()) {
            // Look up word in counts and see if it's large enough

            if (counts.get(word) > n) {
                output.add(word);
            }
        }

        return output;
    }

}
