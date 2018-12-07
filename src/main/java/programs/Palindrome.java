/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        String input = new Scanner(System.in).next();

        if (StringUtils.reverse(input).equalsIgnoreCase(input))
            System.out.println("Palindrome");
        else
            System.out.println("not palindrome");

    }
}
