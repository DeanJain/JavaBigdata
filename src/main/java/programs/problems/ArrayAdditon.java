/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.Scanner;

/**
 * <p>
 * input as series ints and sum, prints which two numbers adds up to sum
 */
public class ArrayAdditon {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] input = s.nextLine().split(" ");

        int count = s.nextInt();

        for (int start = 0; start <= input.length; start++) {
            int sum = 0;
            for (int j = start; j < input.length; j++) {
                sum += Integer.parseInt(input[j]);
                if (sum == count) {
                    System.out.println("found sum");
                    return;
                }
                if (sum > count)
                    break;

            }
        }

    }
}
