package programs.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a non-empty array of integers nums, every element appears
 * twice except for one. Find that single one.
 */
public class SingleNumber {
    /**
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     */
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2,4,4,5};
        System.out.println("unique number = "+singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int num : nums) {
            hm.put(num, hm.get(num) == null ? 1 : hm.get(num) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 1)
                return key;
        }
        return -1;
    }
}
