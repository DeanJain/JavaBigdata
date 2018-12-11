/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;


public class BitwiseOpr {

    public static void main(String[] args) {

        // ^ XOR, & AND, | OR, ~ Complement
        // exchange values without using temp variable using bitwise XOR ^ operator
        int x = 1, // 0001
                y = 2; //0010
        x = x ^ y; // 0011 = 3
        System.out.println("x = " + x);
        y = x ^ y;
        System.out.println("y = " + y);
        x = x ^ y;

        System.out.println(x + " " + y);
    }
}
