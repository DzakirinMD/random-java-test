package base.questions;

import java.util.Arrays;

/**
 * Positive number closest to Zero
 */
public class Question2 {

    public static void main(String[] args) {

        int[] inputArray = {10, 2, -2};

        System.out.println("Number closest to 0 => " + getClosestToZero(inputArray));

    }

    /**
     * <p>
     *    The method will loop through array to find which number close to zero.
     *    It will only return positive number the closest to 0. negative number will be excluded from the output.
     * </p>
     * @param a array of integer from user
     * @return the value in array close to 0
     */
    public static int getClosestToZero(int[] a) {

        int currentValue = 0;
        int nearZero = a[0];

        /*
            Using Java Util Array to sort the array from the lowest value to the highest value number,
            so that the last number will be positive.
         */
        Arrays.sort(a);
        System.out.println("\nSorted array => " + Arrays.toString(a));

        for (int value : a) {
            currentValue = value * value;
            if (currentValue <= (nearZero * nearZero)) {
                nearZero = value;
            }
        }

        return nearZero;
    }
}
