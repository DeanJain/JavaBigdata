package programs.problems;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,}));
    }
    public static int maxSubArray(int[] nums) {
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            max = Math.max(currSum, max);
        }
        return max;
    }
}
