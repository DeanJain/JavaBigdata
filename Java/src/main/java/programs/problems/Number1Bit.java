package programs.problems;

public class Number1Bit {
    public static void main(String[] args) {
        System.out.println(get1Bits(5));
    }

    private static int get1Bits(int n) {
        String s = "";
        while (n > 0) {
            s = ((n % 2) == 0 ? "0" : "1") + s;
            n = n / 2;
        }
        return (int) s.chars().parallel().filter(c -> c == '1').count();
    }
}
