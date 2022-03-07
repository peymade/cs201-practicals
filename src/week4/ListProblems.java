package week4;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a collection of static methods. You run it by going to
 * {@link ListProblemsTest}.
 */
public class ListProblems {

    /**
     * Make a list with the strings "A", "B", "C", and "D".
     * 
     * @return a mutable list (no List.of for you)
     */
    public static List<String> makeABCD() {
        // throw new RuntimeException();

        List<String> abcd = new ArrayList<>();
        abcd.add("A");
        abcd.add("B");
        abcd.add("C");
        abcd.add("D");

        return abcd;
    }

    /**
     * Create a new list that is a reversed copy of the input list.
     * 
     * @param input a list of strings.
     * @return a new list containing the reversed input.
     */
    public static List<String> reverseList(List<String> input) {
        // throw new RuntimeException();

        // loop through the list backwards, and add the number to the new list

        List<String> reversed = new ArrayList<>();

        for (int y = input.size(); y >= 1; y--) {
            Integer arraySpot = y - 1;
            reversed.add(input.get(arraySpot));
        }

        return reversed;

    }

    /**
     * Given a list, find the index of its minimum value.
     * 
     * @param numbers - a list of doubles, e.g., [3.0, 2.0, 1.0]
     * @return the position of the minimum value, e.g., 2.
     */
    public static int findMinimumPosition(List<Double> numbers) {
        // throw new RuntimeException();

        Integer minValPos = -1;
        Double checkingLowest;

        if (numbers.size() > 0) {
            minValPos = 0;
            Double currentLowest = numbers.get(0);

            for (int y = 1; y < numbers.size(); y++) {
                checkingLowest = numbers.get(y);
                if (checkingLowest < currentLowest) {
                    currentLowest = checkingLowest;
                    minValPos = y;
                }
            }
        }

        return minValPos;
    }

    /**
     * Create a new list multiplying each element by 'multiple'
     * 
     * @param numbers  the input list. e.g., [1,2,3]
     * @param multiple the scale to multiply each number by, e.g., 2
     * @return a list with multiplied values, e.g., [2, 4, 6]
     */
    public static List<Integer> multiplyItems(List<Integer> numbers, int multiple) {
        // throw new RuntimeException();

        List<Integer> multipliedVals = new ArrayList<>();

        for (int y = 0; y < numbers.size(); y++) {
            Integer multValue = (numbers.get(y) * multiple);
            multipliedVals.add(multValue);
        }

        return multipliedVals;
    }
}
