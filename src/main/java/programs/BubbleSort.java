/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;

public class BubbleSort {

    public static void main(String[] args) {

        int[] input = {2, 4, 5, 7, 2, 1};

        for (int i = 0; i < input.length; i++) {
            boolean switched = false;
            for (int j = i + 1; j < input.length; j++) {
                int temp;
                if (input[i] > input[j]) {
                    temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                    switched = true;
                }
            }
            if (!switched)
                break;
        }

        for (int i = 0; i < input.length; i++)
            System.out.print(input[i]);

    }
}
