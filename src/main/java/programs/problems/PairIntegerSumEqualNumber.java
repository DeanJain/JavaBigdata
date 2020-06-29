/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class PairIntegerSumEqualNumber {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] input = s.nextLine().split(" ");

        int count = s.nextInt();

        PairIntegerSumEqualNumber pn = new PairIntegerSumEqualNumber();

        System.out.println(pn.getSumPairs(input, count));

    }

    public List<String> getSumPairs(String[] input, int count) {

        List<String> pairs = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < input.length - 1; i++) {
            int temp = Integer.parseInt(input[i]);
            for (int j = i + 1; j < input.length; j++) {
                if (count == temp + Integer.parseInt(input[j]))
                    pairs.add(input[i] + ":" + input[j]);
            }
        }

        return pairs;
    }
}
