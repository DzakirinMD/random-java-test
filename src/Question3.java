import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Natural Number - Write a Java program to list out the first 1500 natural numbers whose factor(s) is/are either ONLY 2, 3, or 5.
 * The faster your program can complete the calculation the better, but it should not run more than 2 minute.
 */
public class Question3 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int index = 1;

        for (int i = 2; index <= 1500; i++) {

            ArrayList<Integer> factors = new ArrayList<>();
//            int[] factors = new int[10];
            int number = i;
            while (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) {
                if (number % 2 == 0) {
                    number = number / 2;
                    factors.add(2);
//                    factors[0] = 2;
                } else if (number % 3 == 0) {
                    number = number / 3;
                    factors.add(3);
//                    factors[1] = 3;
                } else if (number % 5 == 0) {
                    number = number / 5;
//                    factors[2] = 5;
                    factors.add(5);
                }
            }

            if (number != 1) {
                /*
                    Adding this condition to not print out number that don't have 2,3,5 as factors
                 */
            } else {
//                factors = Arrays.stream(factors).filter(element -> element != 0).toArray();
//                System.out.println("No. " + index + " -> " + i + ":" + Arrays.toString(factors));
                System.out.println("No. " + index + " -> " + i + ":" + factors);
                index++;
            }
        }


        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        /*
            convert from millis to minute and second
         */
        long minutes = TimeUnit.MILLISECONDS.toMinutes(timeElapsed);
        long seconds = (TimeUnit.MILLISECONDS.toSeconds(timeElapsed) % 60);

        System.out.println("This program took => " + minutes + " minutes and "  +  seconds + " seconds to complete !");
        // tested on Macbook M1 took avg of 22s to complete
    }
}
