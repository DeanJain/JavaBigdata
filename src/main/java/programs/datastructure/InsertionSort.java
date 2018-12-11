/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.datastructure;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {

        List<Integer> l = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt())
            l.add(scan.nextInt());

        System.out.println(insertSort(l));

    }

    //using linked list is much better as it gives better insert perf vs arrays
    public static List<Integer> insertSort(final List<Integer> numbers) {
        final List<Integer> sortedList = new LinkedList<>();

        originalList:
        for (Integer number : numbers) {
            for (int i = 0; i < sortedList.size(); i++) {
                if (number < sortedList.get(i)) {
                    sortedList.add(i, number);
                    continue originalList;
                }
            }
            sortedList.add(sortedList.size(), number);
        }

        return sortedList;
    }

}
