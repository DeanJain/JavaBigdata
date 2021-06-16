package programs.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid. O(N)
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String input = "[()]";
        System.out.println(isValid(input));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c;
            try {
                switch (s.charAt(i)) {
                    case '(':
                        stack.push('(');
                        break;
                    case '{':
                        stack.push('{');
                        break;
                    case '[':
                        stack.push('[');
                        break;
                    case ')':
                        c = stack.pop();
                        if (c != '(')
                            return false;
                        break;
                    case '}':
                        c = stack.pop();
                        if (c != '{')
                            return false;
                        break;
                    case ']':
                        c = stack.pop();
                        if (c != '[')
                            return false;
                        break;
                    default:
                        return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
