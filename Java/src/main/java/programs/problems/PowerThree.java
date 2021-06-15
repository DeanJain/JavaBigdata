package programs.problems;

public class PowerThree {
    public static void main(String[] args) {
        int n = 81;
        System.out.println(isPowerOfThree(n));
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 3) return false;
        int sum = 1;
        do
            sum = sum * 3;
        while (sum < n);
        return sum == n;
    }
}
