package programs.problems;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] input = {1,3,4,4,4,5,6};
        System.out.println("Deduped Array Length = "+deDupe(input));
        System.out.println(Arrays.toString(input));
    }

    private static int deDupe(int[] nums){
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i])
                continue;
            nums[++i] = nums[j];
        }
        return i + 1;
    }
}
