/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.HashMap;
import java.util.Scanner;


public class AlphaDigit {

    private static HashMap hm = new HashMap();

    public AlphaDigit() {
        char alpha = 'a';
        for (int i = 1; i <= 26; i++) {

            hm.put(String.valueOf(i), alpha);
            hm.put(String.valueOf(alpha), i);
            alpha++;

        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        AlphaDigit ad = new AlphaDigit();

        for (int i = 0; i < input.length(); i++) {
            // System.out.print(input.charAt(i));
            System.out.println(hm.get(String.valueOf(input.charAt(i))));
        }


    }
}
