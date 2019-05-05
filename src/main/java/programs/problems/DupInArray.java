package programs.problems;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Dean.Jain @sjain106.
 * Date: 2/17/19
 */
public class DupInArray {

    public static void main(String[] args) {

        int[] input = {3, 4, 6, 7, 33, 5, 3, 3, 5, -1};
        Arrays.sort(input);
        findInSorted(input);

        //   findDupInArray(input);
    }

    public static void findInSorted(int[] input) {

        for (int i = 0; i < input.length - 1; i++) {

            if (input[i] == input[i + 1]) {
                System.out.println("found dups =" + input[i] + " & " + input[i + 1]);
                //return;
            }
        }
    }

    public static void findDupInArray(int[] input) {

        HashSet hs = new HashSet(input.length);
        for (int i = 0; i < input.length; i++) {
            if (hs.contains(input[i]))
                System.out.println("found dups for = " + input[i]);
            else
                hs.add(input[i]);
        }

    }


}
