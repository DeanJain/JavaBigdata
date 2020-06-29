package programs.problems;


public class StringCompression {

    public static void main(String[] args) {

        String input = "AABBcccCCCCAAAA"; //

        System.out.println(Compress(input));

    }

    public static String Compress(String s) {


        StringBuilder sb = new StringBuilder();
        int count = 1;
        int pointer = 0;
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(pointer) == s.charAt(i))
                count++;
            else {
                sb.append(s.charAt(pointer) + Integer.toString(count));
                // sb.append(count);
                count = 1;
                pointer = i;
            }
        }
        sb.append(s.charAt(pointer));
        sb.append(count);
        return sb.toString();
    }
}
