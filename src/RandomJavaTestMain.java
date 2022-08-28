import java.util.Arrays;

public class RandomJavaTestMain {

    public static void main(String[] args) {

        int[] arrayInt = {10, 2, -2};

        sumOfTwoLargestElements(arrayInt);
        getClosestToZero(arrayInt);
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
        System.out.println(
                "\n1st largest => " + firstLargest +
                "\n2nd largest =>" + secondLargest +
                "\nSum of 1st and 2nd largest => " + sum);

        return sum;
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

        for (int j : a) {

            currentValue = j * j;
            if (currentValue <= (nearZero * nearZero)) {
                nearZero = j;
            }
        }

        System.out.println("Number closest to 0 => " + nearZero);

        return nearZero;
    }
}
