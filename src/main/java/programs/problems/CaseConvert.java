/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.Scanner;

public class CaseConvert {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        int number = 0, upper = 0, lower = 0;
        String temp;

        System.out.println("total = " + input.length());

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);
            System.out.println(c);
            temp = String.valueOf(c);

            if (temp.matches("[A-Z]"))
                upper++;
            else if (temp.matches("[a-z]"))
                lower++;
            else if (temp.matches("[0-9]"))
                number++;
        }

        System.out.println("upper = " + upper + " lower = " + lower + " numbers= " + number);

    }
}
