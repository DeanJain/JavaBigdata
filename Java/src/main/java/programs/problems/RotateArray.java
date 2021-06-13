package programs.problems;

import java.util.Arrays;

public class RotateArray {
//    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]

    public static void main(String[] args) {
      //  int[] inputArray = {1,2,3,4,5,6,7};
        //  [5,6,7,1,2,3,4]
        int[] inputArray = {-1,-100,3,99};
        //  [99,-1,-100,3]
        int k=2;
        rotate(inputArray, k);
    }

    public static void rotate(int[] nums, int k){
        int[] tempArray = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            k++;
            if (k == nums.length)
                k=0;
            tempArray[i]=nums[k];

        }
        System.arraycopy(tempArray, 0, nums, 0, tempArray.length);
        System.out.println(Arrays.toString(nums));
    }

}
