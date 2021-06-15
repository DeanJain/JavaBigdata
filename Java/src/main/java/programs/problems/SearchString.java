package programs.problems;

/**
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class SearchString {
    public static void main(String[] args) {
        String hayStack = "mississippi", needle = "issip";
        System.out.println(strStr(hayStack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
