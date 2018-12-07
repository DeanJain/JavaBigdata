/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContainsDigit {

    public static void main(String[] args) {

        Character[] digits = {'0', '1', '2', '3', '9', '4', '5', '6', '7', '8'};

        String input = new Scanner(System.in).next();

        List<Character> al = Arrays.asList(digits);
        for (int i = 0; i < input.length(); i++) {
            if (!al.contains(input.charAt(i))) {
                System.out.println("has non digits = " + input.charAt(i));
                break;
            }
        }
    }
}
