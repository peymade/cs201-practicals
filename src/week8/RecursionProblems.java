package week8;

import adt.ListADT;
import adt.errors.TODOErr;

/**
 * Comment this, complete methods; complete recursiveMin test.
 * 
 * 
 * This function takes in an integer and prints out the current int as the
 * recursive function decreases n by 1.
 *
 */
public class RecursionProblems {
    public static void countDown(int n) {
        if (n > 0) {
            System.out.println("Count: " + n);
            countDown(n - 1);
        } else {
            System.out.println("Done!");
        }
    }

    /**
     * 
     * This function takes an integer n and after using a for loop to loop through
     * the values and multiply, returns the factorial
     * 
     */

    public static long factorialLoop(int n) {
        long fact = 1;
        for (int i = n; i > 0; i--) {
            fact *= i;
        }
        return fact;
    }

    /**
     * 
     * This function takes n, and uses recursion to repeatedly multiply the current
     * value of n by n -1. When n is no longer larger than 0, it returns the
     * factorial value.
     * 
     */

    public static long recursiveFactorial(int n) {
        long fact = 0;
        if (n == 1) {
            fact = 1;
        } else if (n > 0) {
            fact = n * recursiveFactorial(n - 1);
        }

        return fact;

        // throw new TODOErr("recursiveFactorial");
    }

    /**
     * 
     * This function takes in a list of numbers, and finds the smallest integer by
     * comparing the first number to the minimum of all the rest.
     * 
     */
    public static int recursiveMin(ListADT<Integer> numbers) {
        if (numbers.size() <= 1) {
            return numbers.getFront();
        }
        int first = numbers.getFront();
        int minRest = recursiveMin(numbers.slice(1, numbers.size()));
        return Math.min(first, minRest);
    }

    /**
     * 
     * This function takes a word, and returns True, it is a palindrome, if it is
     * empty or has only one character.
     * 
     * It returns false if there is a mismatch of beginning and ending characters
     * 
     * It uses recursion to repeat the checks if the first and last characters are
     * the same, looking at everything except those two characters.
     * 
     */

    public static boolean isPalindrome(String word) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        } else if (word.charAt(0) != word.charAt(word.length() - 1)) {
            System.out.println(word);
            return false;
        } else {
            return isPalindrome(word.substring(1, word.length() - 1));
        }
        // throw new TODOErr("isPalindrome; outer letters match.");
    }

    public static void main(String[] args) {
        countDown(10);
        System.out.println("Check the tests for your recursive functions.");
    }
}
