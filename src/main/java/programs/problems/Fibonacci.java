/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

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
    private static List normalFibonacci(int n) {

        int first = 0, second = 1, total = 0;

        if (n < 0) {
            throw new IllegalArgumentException(
                    "n must not be less than zero");
        }

        if (n == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            return Arrays.asList(0);
        }

        if (n == 2) {
            return Arrays.asList(0, 1);

        }

        final List<Integer> seq = new ArrayList<>(n);
        seq.add(0);
        seq.add(1);

        for (int i = 2; i < n; i++) {
            first = seq.get(seq.size() - 1);
            second = seq.get(seq.size() - 2);
            total = first + second;
            seq.add(total);
        }
        System.out.println(seq.toString());
        return seq;
    }

    @Test
    public void FibnocciTest() {
        assertEquals(0, normalFibonacci(0).size());

        assertEquals(Arrays.asList(0, 1, 1, 2), normalFibonacci(4));

        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8), normalFibonacci(7));
    }

}
