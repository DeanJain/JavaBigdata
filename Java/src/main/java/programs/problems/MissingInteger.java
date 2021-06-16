/*
 * NO Copyright (c) @Dean.Jain 2021. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is
 * missing from the array.
 */
public class MissingInteger {
    public static void main(String[] args) {
        int[] a = {44, 26, 34, 25, 23, 42, 0, 43, 38, 14, 47, 19, 49, 6, 16, 41, 24, 35, 10, 4, 32, 5, 8, 15, 31, 3, 46, 22, 2, 30, 28, 37, 1, 21
                , 39, 45, 9, 48, 36, 17, 7, 27, 18, 29, 13, 40, 11, 20, 12};
        System.out.println(getAllMissingInt(a));
    }

    private static int getAllMissingInt(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 1; i <= nums.length; i++)
            if (!set.contains(i))
                return i;
        return 0;
    }
}
