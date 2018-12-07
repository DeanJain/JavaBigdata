/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class WordReverse {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] inputArray = input.split(" ");

        // standard array based reversal
        for (int i = inputArray.length - 1; i >= 0; i--) {
            System.out.println(inputArray[i]);
        }

        // using stack and pop for reverse
        Stack<String> stack = new Stack<>();

        stack.addAll(Arrays.asList(inputArray));

        while (!stack.isEmpty())
            System.out.println(stack.pop());


    }

}
