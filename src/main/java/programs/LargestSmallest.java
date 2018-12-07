/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;

public class LargestSmallest {

    public static void main(String[] args) {

        int[] input = new int[]{-89, -7, 2, 3, 4, 45676, 5, 6, 7, 8, 9, 99, -3, -678};

        int min = input[0], max = input[0];

        for (int i = 0; i < input.length - 1; i++) {

            if (min > input[i + 1]) {
                min = input[i + 1];
            }
            if (max < input[i + 1])
                max = input[i + 1];


        }

        System.out.println(min);
        System.out.println(max);

    }
}
