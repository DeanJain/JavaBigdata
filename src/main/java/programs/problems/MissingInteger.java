/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;


import java.util.stream.IntStream;

// finds the missing integer from an array of integers with a pre defined range and prints it
public class MissingInteger {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 9, 7, 10};

        int max = 10;

        for (int i = 1; i <= max; i++) {
            int finalI = i;
            if (!IntStream.of(array).anyMatch(x -> x == finalI)) {
                System.out.println(finalI);
            }
        }


    }
}
