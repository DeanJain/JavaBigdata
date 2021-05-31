/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

public class FizzBuzz {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("fizzbuzz");
            else if (i % 3 == 0)
                System.out.println("fizz");
            else if (i % 5 == 0)
                System.out.println("FizzBuzz");
            else
                System.out.println(i);
        }
    }
}
