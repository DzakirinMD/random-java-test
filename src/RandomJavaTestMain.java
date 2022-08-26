import java.util.Arrays;

public class RandomJavaTestMain {

    public static void main(String[] args) {

        int[] largestElement = {21, 5, 200, 77, 88, 102,200};

        System.out.println("The sum of 2 Largest element is : " +
                sumOfTwoLargestElements(largestElement)
        );
    }

    /*
    Please implement this method to return the sum of the
    two largest integer numbers in a given array.
    */
    public static int sumOfTwoLargestElements(int[] a) {

        // creating variable to hold the 2 largest number and the output
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int j : a) {
            if (j > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = j;
            } else if (j > secondLargest) {
                secondLargest = j;
            }
        }

        return firstLargest + secondLargest;
    }

    /*
    Please implement this method to return the integer number in a
    given array that is closest to zero.
    If there are two equally closest to zero elements like 2 and -2
    consider the positive element, i.e. 2, to be "closer" to zero.
    */
    public static int getClosestToZero(int[] a) {

        return 1;
    }
}
