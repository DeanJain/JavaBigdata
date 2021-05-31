/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class VowelConsonants {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String input = StringUtils.deleteWhitespace(s.nextLine());


        System.out.println("input string =" + input);

        ArrayList<String> vowels = new ArrayList<String>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        char[] c = new char[]{'a', 'e', 'i', 'o', 'u'};

        int vowelCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (vowels.contains(String.valueOf(input.charAt(i)))) {
                vowelCount++;
            }
        }
        System.out.println("vowel count = " + vowelCount);
        System.out.println("consonent count = " + (input.length() - vowelCount));

    }
}
