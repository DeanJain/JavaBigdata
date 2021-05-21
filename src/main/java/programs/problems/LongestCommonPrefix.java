package programs.problems;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"reflower","flow","flight"};
        System.out.println("common prefix = "+getCommonPrefix(strs));
    }

    /**
     * find smallest string in array
     * find substring of that across array and keep reducing length
     * @param strs
     * @return
     */
    private static String getCommonPrefix(String[] strs) {
        String smallestString = strs[0];
        int length = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int tmp = strs[i].length();
            if (tmp < length) {
                smallestString = strs[i];
                length = tmp;
            }
        }
        System.out.println("initial smallest string = "+ smallestString);
        int tmp = smallestString.length();
        for (int j = 0; j < tmp; j++) {
            System.out.println("str = "+smallestString);
            for (String str : strs ) {
                if (!str.startsWith(smallestString)) {
                    smallestString = smallestString.substring(0, smallestString.length()-1);
                    System.out.println("in loop reduced = "+smallestString);
                    break;
                }
            }

        }
        return smallestString;
    }

}
