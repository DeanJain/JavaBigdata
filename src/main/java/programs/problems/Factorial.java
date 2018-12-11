/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.Scanner;

public class Factorial {

    int temp = 1;

    public static void main(String[] args) {

        int input = 0;

        Scanner s = new Scanner(System.in);

        if (s.hasNextInt())
            input = Integer.parseInt(s.next());

        System.out.println("input = " + input);

        System.out.println(factorial(input));

        System.out.println(factorialRecursion(input));

    }

    private static int factorial(int input) {
        int temp = 1;
        for (int i = 1; i <= input; i++) {

            temp = i * temp;

        }
        return temp;
    }

    private static int factorialRecursion(int i) {

        if (i <= 1)
            return i;

        return i * factorialRecursion(i - 1);

    }


}
