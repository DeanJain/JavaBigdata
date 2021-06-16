package programs.problems;

import java.util.Arrays;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 */
public class ShuffleArray {
    int[] sa;

    public static void main(String[] args) {
        int[] i = {1, 2, 3};
        ShuffleArray sf = new ShuffleArray(i);
        int[] p1 = sf.reset();
        int[] p2 = sf.shuffle();
        System.out.println(Arrays.toString(p2));
    }

    public ShuffleArray(int[] nums) {
        this.sa = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.sa;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int len = this.sa.length;
        int rand = (int) (Math.random() * (len - 1) + 1);
        System.out.println(rand);
        int[] temp = new int[len];
        System.arraycopy(this.sa, 0, temp, 0, len);
        for (int i = 0; i < len; i++) {
            if (rand == len) rand = 0;
            temp[i] = this.sa[rand++];
        }
        return temp;
    }
}
