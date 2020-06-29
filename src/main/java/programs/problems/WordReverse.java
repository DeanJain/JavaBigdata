/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class WordReverse {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        //  wordReverse(input);

        System.out.println("reverse in place = " + reverseStringInPlace(input));
    }

    private static void wordReverse(String input) {

        String[] inputArray = input.split(" ");

        // using stack and pop for reverse
        Stack<String> stack = new Stack<>();

        stack.addAll(Arrays.asList(inputArray));

        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }


    private static String reverseStringInPlace(String input) {

        StringBuilder sb = new StringBuilder(input);

        for (int i = 0; i < sb.length() / 2; i++) {
            char c = sb.charAt(i);
            int otherEnd = sb.length() - i - 1;
            sb.setCharAt(i, sb.charAt(otherEnd));
            sb.setCharAt(otherEnd, c);
        }

        return sb.toString();

    }


}
