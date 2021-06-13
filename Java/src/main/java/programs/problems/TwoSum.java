/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.Arrays;

/**
 *
 */
public class PairIntegerSumEqualNumber {

    public static void main(String[] args) {

        PairIntegerSumEqualNumber pn = new PairIntegerSumEqualNumber();
        int[] input = {1,2,3,4,5};
        System.out.println(Arrays.toString(pn.getSumPairs(input, 88)));

    }

    public int[] getSumPairs(int[] nums, int target) {
        int[] out = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    out[0]=i;
                    out[1]=j;
                    return out;
                }
            }
        }
        return out;
    }
}
