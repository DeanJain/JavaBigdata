package programs.datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        List<Integer> l = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt())
            l.add(scan.nextInt());

        System.out.println(binarySearch(l, 5));
    }

    //inputs a sorted list of integers and value to find
    public static boolean binarySearch(final List<Integer> numbers,
                                       final Integer value) {
        if (numbers == null || numbers.isEmpty()) {
            return false;
        }
// find middle number of the sorted list of ints
        final Integer comparison = numbers.get(numbers.size() / 2);
        System.out.println("comparison = " + comparison);
        if (value.equals(comparison)) {
            return true;
        }
// if less then recursively search again with sublist 0 to mid else mid to end
        if (value < comparison) {
            return binarySearch(
                    numbers.subList(0, numbers.size() / 2),
                    value);
        } else {
            return binarySearch(
                    numbers.subList(numbers.size() / 2 + 1, numbers.size()),
                    value);
        }
    }
}
