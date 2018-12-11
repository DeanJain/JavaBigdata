/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.Scanner;


public class Concat {

    public static void main(String[] args) {
        String fn = "dean";
        String ln = "jain";

        Scanner s = new Scanner(System.in);

        fn = s.nextLine();

        ln = s.nextLine();

        int n = s.nextInt();

        concat(fn, ln, n);


    }

    private static void concat(String fn, String ln, int n) {
        ln = ln + ", " + n + " " + fn;

        System.out.println(ln);

    }
}
