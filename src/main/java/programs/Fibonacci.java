/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int input = 0;

        if (s.hasNextInt())
            input = Integer.parseInt(s.next());

        System.out.println("input = " + input);

        normalFibonacci(input);
    }

    // 0 1 1 2 3 5
    private static int normalFibonacci(int input) {

        int first = 0, second = 1, total = 0;
        System.out.print(first);
        System.out.print(" ");
//        total = first + second ; // 0 + 1
        System.out.print(second);

        for (int i = 2; i <= input; i++) {
            total = first + second;
            first = second;
            second = total;
            System.out.print("  " + total + " ");
        }

        return total;
    }

}
