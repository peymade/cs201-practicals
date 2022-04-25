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

        ListADT<Integer> newSort = new JavaList<>();

        // while they both still have things in them
        while (lhs.size() > 0 && rhs.size() > 0) {

            if (lhs.getFront() < rhs.getFront()) {
                newSort.addBack(lhs.removeFront());
            } else {
                newSort.addBack(rhs.removeFront());
            }

        }
        if (lhs.size() > 0) {

            if (lhs.size() == 1) {
                newSort.addBack(lhs.getFront());
            } else {
                for (int i = 0; i < lhs.size(); i++) {
                    newSort.addBack(lhs.getIndex(i));
                }
            }

        } else if (rhs.size() > 0) {

            if (rhs.size() == 1) {
                newSort.addBack(rhs.getFront());
            } else {
                for (int i = 0; i < rhs.size(); i++) {
                    newSort.addBack(rhs.getIndex(i));
                }
            }

        }

        return newSort;

        // throw new TODOErr("combineTwoSortedLists");
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

        int mid = input.size() / 2;
        ListADT<Integer> left = input.slice(0, mid);
        ListADT<Integer> right = input.slice(mid, input.size());

        // base case. if input is smaller than or equal to one, return it
        if (input.size() <= 1) {
            return input;
        } else {

            return combineTwoSortedLists(doMergeSortRecursively(left), doMergeSortRecursively(right));

        }

        // throw new TODOErr("doMergeSortRecursively mid=" + mid);
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

        ListADT<Integer> newSort = new JavaList<>();
        int i = 0;

        SLLQ<ListADT<Integer>> work = new SLLQ<>();
        while (!input.isEmpty()) {
            ListADT<Integer> job = new JavaList<>();
            job.addBack(input.removeFront());
            work.enqueue(job);
            i++;
        }

        // grab the pieces and put them together

        while (!work.isEmpty() && i > 1) {

            ListADT<Integer> piece1 = work.dequeue();
            ListADT<Integer> piece2 = work.dequeue();

            newSort = combineTwoSortedLists(piece1, piece2);

            work.enqueue(newSort);

            i--;
        }

        return newSort;

        // throw new TODOErr("doMergeSortIteratively");
    }
}
