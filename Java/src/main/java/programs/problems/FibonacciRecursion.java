package programs.problems;

import java.math.BigInteger;
import java.util.HashMap;

// Fibonacci program for large numbers,

public class FibonacciRecursion {

    private static HashMap<Integer, BigInteger> hm = new HashMap();

    public static void main(String[] args) {

        System.out.println(FibR(45));

    }

    public static BigInteger FibR(int n) {
// 1 1 2 3 5 8 13 21
        if (n == 1) return BigInteger.valueOf(1);
        if (n == 0) return BigInteger.valueOf(0);

        if (hm.containsKey(n))
            return hm.get(n);

        BigInteger temp = FibR(n - 1).add(FibR(n - 2));
        // Memoization is the process to cache expensive function result
        hm.put(n, temp);

        return temp;
    }
}
