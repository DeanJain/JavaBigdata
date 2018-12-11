/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

public class PowerTwo {

    public static void main(String[] args) {

        int i = 3, temp;

        if (i == 0 || i == 1) {
            System.out.println("no power 2");
            System.exit(0);
        }
        while ((temp = i % 2) == 0) {
            i = i / 2;
        }

        if (i == 1)
            System.out.println("power 2");
        else
            System.out.println("no power 2");

    }

}
