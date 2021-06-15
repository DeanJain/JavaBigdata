package programs.problems;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrime {
    public static void main(String[] args) {
        int input = 100;
        System.out.println(countPrimes(input));
    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (findPrime(i))
                count++;
        }
        return count;
    }

    private static boolean findPrime(int n) {
        if (n == 2 || n == 3) return true;
        if (n == 1) return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0) return false;
        return true;
    }
}
