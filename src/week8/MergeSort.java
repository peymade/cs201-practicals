package week8;

import adt.ListADT;
import adt.errors.TODOErr;
import adt.impl.JavaList;
import week7.SLLQ;

public class MergeSort {
    /**
     * This method walks through two sorted input lists and creates an output list
     * that contains all elements from the two inputs.
     * 
     * @param lhs - a sorted list.
     * @param rhs - a sorted list.
     * @return a sorted list containing all of the items from lhs and rhs.
     */
    public static ListADT<Integer> combineTwoSortedLists(ListADT<Integer> lhs, ListADT<Integer> rhs) {
        throw new TODOErr("combineTwoSortedLists");
    }

    /**
     * Recursively sort this list by breaking it in half and piecing it back
     * together. You will need to call
     * {@linkplain #combineTwoSortedLists(ListADT, ListADT)}.
     *
     * @param input - the input list.
     * @return a new list containing the sorted output.
     */
    public static ListADT<Integer> doMergeSortRecursively(ListADT<Integer> input) {

        // base case
        if (input.size() <= 1) {
            return input;
        }

        // decide where the middle index is
        int mid = input.size() / 2;

        // slice each list
        // do merge sort recursively on each list
        //
        throw new TODOErr("doMergeSortRecursively mid=" + mid);
    }

    /**
     * Iteratively sort this list by breaking into lists of size 1 and adding them
     * to a ListADT<ListADT<Integer>> todo; The ``todo`` list only ever contains
     * sorted lists. We can now take two of them at a time, and combine them until
     * we only have 1 sorted list remaining; this is our output.
     * 
     * You will need to call {@linkplain #combineTwoSortedLists(ListADT, ListADT)}.
     * 
     * @param input - the input list.
     * @return a new list containing the sorted output.
     */
    public static ListADT<Integer> doMergeSortIteratively(ListADT<Integer> input) {
        // Create singleton lists as "work" queue.
        // sslq of integer lists. delete from input one at a time, and add to the back
        // of a temporary list
        // while(work.size > 1)
        // if using a list, don't call work.size many times
        // if front and back are same, there must be only one thing in list
        SLLQ<ListADT<Integer>> work = new SLLQ<>();
        while (!input.isEmpty()) {
            ListADT<Integer> job = new JavaList<>();
            job.addBack(input.removeFront());
            work.enqueue(job);
        }

        // grab the pieces and put them together
        throw new TODOErr("doMergeSortIteratively");
    }
}
