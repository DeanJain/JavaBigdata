/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumOfNumber {

    public static void main(String[] args) {

        new Scanner(System.in).hasNextInt();

        int[] validNumber = {1, 2, 3, 4, 5, 6, 8, 12, 76};
        int sum = 9;

        // using extra heap for this object
        Set al = new HashSet<>();

        for (int i = 0; i < validNumber.length - 1; i++) {

            if (al.contains(sum - validNumber[i])) {
                System.out.println("true");
                System.exit(0);
            }

            al.add(validNumber[i]);

//            for (int j = i+1; j < validNumber.length; j++) {
//                if(validNumber[i] + validNumber[j] == sum)
//                {
//                    System.out.println("true");
//                    System.exit(1);
//                }
//            }

        }
        System.out.println("false");
    }
}



