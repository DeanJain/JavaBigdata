package programs.problems;

import java.util.*;

public class MergeArrays {

    public static void main(String[] args) {

        int[] a1 = {1, 2, 3, 4, 5, 6, 100, 150, 300, 1000};
        int[] a2 = {4, 5, 6, 9, 12, 77};

        mergeArray(a1, a2);

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

}
