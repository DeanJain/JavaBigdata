package programs.problems;

import java.util.Scanner;

public class FillBlanksString {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(input.length());
        fillBlanks(input);

    }

    public static void fillBlanks(String input) {

        System.out.println(input.length());

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(input.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
