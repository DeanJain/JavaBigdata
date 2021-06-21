package programs.problems;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    // total is equal to nth fibnocchi number with series starting from 1 and 2
    public static int climbStairs(int n) {
        if(n==1) return 1;
        int first = 1, second =2;
        for (int i = 3; i <= n ; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;

    }

}
