package programs.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {

        List<Integer> l = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt())
            l.add(scan.nextInt());

        System.out.println(quicksort(l));
    }

    public static List<Integer> quicksort(List<Integer> numbers) {
        if (numbers.size() < 2) {
            return numbers;
        }

        final Integer pivot = numbers.get(0);
        final List<Integer> lower = new ArrayList<>();
        final List<Integer> higher = new ArrayList<>();

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < pivot) {
                lower.add(numbers.get(i));
            } else {
                higher.add(numbers.get(i));
            }
        }

        final List<Integer> sorted = quicksort(lower);

        sorted.add(pivot);
        sorted.addAll(quicksort(higher));

        return sorted;
    }
}
