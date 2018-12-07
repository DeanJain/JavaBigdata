/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;


public class InsertionSort {

    public static void main(String[] args) {

        int[] is = {3, 98, 54, 22, 2};

        int[] sorted = new int[5];

        int index = 0;

        sorted[index] = is[index];


        for (int i = index + 1; i < is.length; i++)
            if (is[index] > is[i]) {
                sorted[index] = is[i];
                sorted[index + 1] = is[i - 1];
                index++;
            }

        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }

    }
}
