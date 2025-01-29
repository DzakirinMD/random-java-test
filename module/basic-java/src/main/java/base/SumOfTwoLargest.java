package base;

/**
 * Sum Of TwoLargestElements
 */
public class SumOfTwoLargest {

    public static void main(String[] args) {

        int[] inputArray = {10, 2, -2};

        System.out.println("Sum of 1st and 2nd largest => " + sumOfTwoLargestElements(inputArray));

    }

    /**
     * <p>
     *    The method will loop through array to take the 1st and 2nd largest element in the array.
     *    It will return the sum of the 2 largest elements
     * </p>
     * @param a array of integer from user
     * @return sum of two largest element from the input array
     */
    public static int sumOfTwoLargestElements(int[] a) {
        /*
         Using Integer.MIN_VALUE to cater for when INPUT is an array of negative numbers
         */
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int elements : a) {

            /*
            if -> compare elements with firstLargest if it’s greater,
            then put secondLargest = firstLargest.
            put the element into firstLargest
            else if -> compare element if greater than secondLargest and less than firstLargest then secondLargest = element
             */
            if (elements > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = elements;
            } else if (elements > secondLargest) {
                secondLargest = elements;
            }
        }

        int sum = firstLargest + secondLargest;
        System.out.println("\n1st largest => " + firstLargest + "\n2nd largest =>" + secondLargest );

        return sum;
    }
}
