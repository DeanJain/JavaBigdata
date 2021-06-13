package programs.problems;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer,
 * increment one to the integer.
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] a = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        System.out.println(Arrays.toString(plusOne(a)));
    }
    public static int[] plusOne(int[] digits) {
            int length = digits.length;
            BigInteger total = BigInteger.valueOf(0);
            for (int i : digits)
                total = total.add(BigInteger.valueOf((long) (i * Math.pow(10,--length))));
            total = total.add(BigInteger.valueOf(1));
            String s = total.toString();
            int[] out = new int[s.length()];
            int counter = 0;
            for (char c:s.toCharArray())
                out[counter++] = c - '0';
            return out;
    }
}
