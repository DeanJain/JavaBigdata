package programs.problems;

import java.util.*;

/**
 * Given two integer arrays nums1 and nums2,
 * return an array of their intersection.
 * Each element in the result must appear as many times as
 * it shows in both arrays and you may return the result in any order.
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 */
public class ArrayIntersection {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm1 = new HashMap<>();
        Map<Integer, Integer> hm2 = new HashMap<>();
        for (int i: nums1){
               hm1.put(i, hm1.get(i) == null ? 1:hm1.get(i)+1);
            }
        for (int i: nums2){
            hm2.put(i, hm2.get(i) == null ? 1:hm2.get(i)+1);
        }
        List<Integer> al = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: hm1.entrySet()){
            int key = entry.getKey();
            int value1 = entry.getValue();
            if(hm2.containsKey(key)){
                int value2 = hm2.get(key);
                int smallerCount = Math.min(value1, value2);
                for (int i = 0; i < smallerCount; i++) {
                    al.add(key);
                }
            }
        }
        return al.stream().mapToInt(i -> i).toArray();
    }
}
