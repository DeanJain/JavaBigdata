package programs.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle. In Pascal's triangle, each number is the sum
 * of the two numbers directly above it
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int input = 30;
        System.out.println(generate(input).toString());
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pt = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        pt.add(l);
        for (int i = 1; i < numRows; i++) {
            List<Integer> ll = new ArrayList<>();
            for (int j = 1; j <= i + 1; j++) {
                if (j == 1 || j == i + 1)
                    ll.add(1);
                else
                    ll.add(pt.get(i - 1).get(j - 2) + pt.get(i - 1).get(j - 1));
            }
            pt.add(ll);
        }
        return pt;
    }
}
