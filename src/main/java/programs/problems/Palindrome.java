/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();

        if (StringUtils.reverse(input).equalsIgnoreCase(input))
            System.out.println("Palindrome");
        else
            System.out.println("not palindrome");

        System.out.println("is Palindrome = " + checkPalindrome(input));

    }

    /**
     * finding palindrome in place using a string builder based string reversal
     **/

    public static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        char first, last;

        for (int i = 0; i < s.length() / 2; i++) {
            last = sb.charAt(s.length() - i - 1);
            first = sb.charAt(i);
            sb.setCharAt(i, last);
            sb.setCharAt(s.length() - i - 1, first);
        }
        return sb.toString().equals(s);
    }

    public static boolean checkPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int length = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            char c = s.charAt(i);
            if (c != s.charAt(length)) {
                return false;
            }
            length--;
        }
        return true;
    }

}
