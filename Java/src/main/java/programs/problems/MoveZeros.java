package programs.problems;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] input = {1,0,0,3,5,0,3,0,6}; // 10004562002
        moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
    public static void moveZeroes(int[] nums) {
        for (int i = 0, j=0; i < nums.length; i++) {
           if(nums[i]!=0)
           {
               int temp = nums[i];
               nums[i] = 0;
               nums[j++]=temp;
            }
        }
    }
}
