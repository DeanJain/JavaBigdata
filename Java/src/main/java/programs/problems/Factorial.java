/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.math.BigInteger;
import java.util.Scanner;

// Factorial program for large numbers
public class Factorial {

    public static void main(String[] args) {

        int input = 0;

        Scanner s = new Scanner(System.in);

        if (s.hasNextInt())
            input = Integer.parseInt(s.next());

        System.out.println("input = " + input);

        System.out.println(factorialRecursion(BigInteger.valueOf(input)));

    }

    private static BigInteger factorial(int input) {
        BigInteger temp = BigInteger.valueOf(1);

        for (int i = 1; i <= input; i++) {

            temp = temp.multiply(BigInteger.valueOf(i));

        }
        return temp;
    }

    private static BigInteger factorialRecursion(BigInteger i) {

        if (i.intValue() <= 1)
            return i;

        return i.multiply(factorialRecursion(i.subtract(BigInteger.valueOf(1))));

    }


}
