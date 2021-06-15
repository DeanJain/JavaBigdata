package programs.problems;

/**
 * String to Integer (atoi) Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
 * (similar to C/C++'s atoi function).
 */
public class Atoi {
    public static void main(String[] args) {
        String s = " 42word";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        char[] ca = s.toCharArray();
        boolean sign = true;
        int signCount = 0;
        long i = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : ca) {
            if (signCount > 1) break;
            if (c == '+') {
                signCount++;
                continue;
            }
            if (c == '-') {
                sign = false;
                signCount++;
                continue;
            }
            if (!Character.isDigit(c)) break;
            else sb.append(c);
        }
        try {
            i = Long.parseLong(sb.toString());
            i = sign ? i : i * -1;
            if (i > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (i < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        } catch (NumberFormatException nfe) {
            return 0;
        }
        return (int) i;
    }
}
