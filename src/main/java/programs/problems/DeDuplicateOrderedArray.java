package programs.problems;

import java.util.Arrays;

public class DeDuplicateOrderedArray {

    public static void main(String[] args) {
        int[] input = {1,3,4,4,4,5,6};
        System.out.println("Deduped Array Length = "+deDupe(input));
        System.out.println(Arrays.toString(input));
    }

    private static int deDupe(int[] input){
        if (input.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < input.length; j++) {
            if (input[j] == input[i])
                continue;
            input[++i] = input[j];
            System.out.println(Arrays.toString(input));
        }
        return i + 1;
    }
}
