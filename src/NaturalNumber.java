import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NaturalNumber {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int index = 1;

        for (int i = 2; index <= 1500; i++) {
            ArrayList<Integer> remainder = new ArrayList<>();
            int number = i;
            while (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) {
                if (number % 2 == 0) {
                    number = number / 2;
                    remainder.add(2);
                } else if (number % 3 == 0) {
                    number = number / 3;
                    remainder.add(3);
                } else if (number % 5 == 0) {
                    number = number / 5;
                    remainder.add(5);
                }
            }

            if (number != 1) {
                remainder.add(10);
            } else {
                System.out.println("No. " + index + " -> " + i + ":" + remainder);
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
        // tested on M1 took avg of 26s
    }
}