package week9;

import adt.ListADT;
import adt.errors.TODOErr;

public class SortedSearch {

    /**
     * Find an integer in the sorted list dataset by linear search.
     * 
     * @param findMe
     * @param dataset
     * @return -1 if not found or the position if found.
     */
    public static int linearSearch(int findMe, ListADT<Integer> dataset) {
        for (int i = 0; i < dataset.size(); i++) {
            if (dataset.getIndex(i) == findMe) {
                return i;
            } else if (dataset.getIndex(i) > findMe) {
                // In a sorted list, we can stop as soon as it's no longer possibly in this
                // list!
                return -1;
            }
        }
        return -1;
    }

    /**
     * Find an integer in the sorted list dataset by iterative binary search.
     * 
     * HINT: Try a while loop.
     *
     * @param findMe  - the integer you're looking for!
     * @param dataset - the list you're searching!
     * @return -1 if not found or the position if found.
     */
    public static int binarySearchIterative(int findMe, ListADT<Integer> dataset) {
        int left = 0;
        int right = dataset.size();

        while (left <= right) {

            // protect against specific case
            if ((left == right) && (left == dataset.size())) {
                return -1;
            }

            int middle = (left + right) / 2;
            // System.out.println("target num " + findMe + " left position: " + left + "
            // middle position " + middle
            // + " right position " + right);

            // if the value we are looking for is equal to the value at the middle index,
            // return the position of middle
            if (findMe == dataset.getIndex(middle)) {
                return dataset.getIndex(middle);
            }

            else if (findMe > dataset.getIndex(middle)) {
                left = middle + 1;
            }

            else {
                right = middle - 1;
            }
            // throw new TODOErr("binarySearchIter");
        }

        // couldn't find it:
        return -1;
    }

    /**
     * Find an integer in the sorted list dataset by recursive binary search.
     * 
     * @param findMe  - the integer you're looking for!
     * @param dataset - the list you're searching!
     * @param left    - the farthest left index it could possibly be (default=0).
     * @param right   - the farthest right index it could possibly be
     *                (default=dataset.size()).
     * @return -1 if not found, or the index of findMe in dataset.
     */
    private static int binarySearchR(int findMe, ListADT<Integer> dataset, int left, int right) {

        System.out.println(left + "  " + right);

        if (left <= right) {

            if ((left == right) && (left == dataset.size())) {
                System.out.println("Yo, you're in here");
                return -1;
            }

            // System.out.println("target: " + findMe + " left: " + left + " middle: " +
            // dataset.getIndex(middle)
            // + " right: " + right);

            // System.out.println(findMe + "hey" + middle);
            // if it's equal, return

            System.out.println((left + right) / 2);
            if (findMe == ((left + right) / 2)) {
                System.out.println("QUEEN");
                return dataset.getIndex((left + right) / 2);
            }

            // int middle = (left + right) / 2;

            // if the middle is smaller, start over
            else if (findMe > dataset.getIndex((left + right) / 2)) {
                binarySearchR(findMe, dataset, (((left + right) / 2) + 1), right);
            }

            // if the middle is bigger, start over
            else {
                return binarySearchR(findMe, dataset, left, (((left + right) / 2) - 1));
            }

            // throw new TODOErr("binarySearchR");
        }

        // Couldn't find it.
        System.out.println("you got out");
        return -1;
    }

    /**
     * Find an integer in the sorted list dataset by recursive binary search.
     *
     * @param findMe  - the integer you're looking for!
     * @param dataset - the list you're searching!
     * @return -1 if not found or the position if found.
     */
    public static int binarySearchRecursive(int findMe, ListADT<Integer> dataset) {
        // Having a private method like this is very common with recursion.

        return binarySearchR(findMe, dataset, 0, dataset.size());
    }
}
