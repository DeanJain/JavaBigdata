package programs.problems;

/**
 * input = "3322251" output = 23321511
 */
public class CountAndSay {
    public static void main(String[] args) {
        int n = 3322251;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        if (s.length() == 1) return sb.append(count).append(s).toString();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i));
                count = 1;
            }
            if (i == s.length() - 2)
                sb.append(count).append(s.charAt(i + 1));
        }
        return sb.toString();
    }
}
