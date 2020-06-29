/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.Scanner;

public class StringPermutations {

    public static void main(String[] args) {

        String input = new Scanner(System.in).next();

        for (int i = 0; i < input.length(); i++) {
            String temp = String.valueOf(input.charAt(i));
            String remain = input.replace(temp, "");

            for (int j = 0; j < remain.length(); j++) {
                temp = temp + remain.charAt(j);

            }
            System.out.println(temp);
        }


    }
}