package programs.problems;

import java.util.Scanner;

/**
 * Created by Dean.Jain @sjain106.
 * Date: 2/11/19
 */
public class Palindrome2 {

    public static void main(String[] args) {

        String input = new Scanner(System.in).next();


        System.out.println("input string " + input + " palindrome = " + checkPalindrome(input));
    }

    public static boolean checkPalindrome(String input) {

        int length = input.length() - 1;

        for (int i = 0; i < input.length() / 2; i++) {

            char c = input.charAt(i);

            if (c != input.charAt(length)) {
                return false;
            }

            length--;

        }

        return true;
    }


}
