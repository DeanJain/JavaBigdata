package programs.problems;

import java.util.*;

public class MergeArrays {

    public static void main(String[] args) {

        int[] a1 = {1,2,3,0,0,0};
        int[] a2 = {2,5,6};

        //  mergeArray(a1, a2);
            merge(a1,3, a2,3);
        System.out.println(Arrays.toString(a1));
    }

    private static void mergeArray(int[] a1, int[] a2) {

        List<Integer> ll = new LinkedList<>();

        // Converting int array into Integer array
        Integer[] boxedArray = Arrays.stream(a1).boxed().toArray(Integer[]::new);
        Collections.addAll(ll, boxedArray);
        boxedArray = Arrays.stream(a2).boxed().toArray(Integer[]::new);
        Collections.addAll(ll, boxedArray);
        // merge sort
        Collections.sort(ll);

        Iterator it = ll.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");

    }

    // [1,2,3,0,0,0],  [2,5,6]
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = m + n + 1; i >=0; i--) {
            int a = m >=0 ? nums1[m]:Integer.MIN_VALUE;
            int b = n >=0 ? nums2[n]:Integer.MIN_VALUE;
            if (a > b) {
                nums1[i] = a;
                m--;
            }
            else {
                nums1[i] = b;
                n--;
            }
        }
    }


}
