/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.ArrayList;
import java.util.List;


public class DuplicateNumber {

    public static void main(String a[]) {

        String[] input = new String[]{"1", "2", "3", "a", "a", "2"};
        System.out.println("length = " + input.toString());
        DuplicateNumber dn = new DuplicateNumber();
        System.out.println("Duplicate : " + dn.findDuplicateNumber(input));
    }

    public List<String> findDuplicateNumber(String[] numbers) {

        List<String> dups = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] == numbers[j]) {

                    dups.add(numbers[i]);
                }
            }

        }
        return dups;
    }
}