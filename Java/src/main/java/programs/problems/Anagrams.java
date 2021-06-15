package programs.problems;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise. Input: s = "anagram", t =
 * "nagaram" Output: true
 */
public class Anagrams {
    public static void main(String[] args) {
        String s1 = "abcde", s2 = "bcdae";
        System.out.println(isAnagram(s1, s2));
    }

    public static boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.toString(c1).equals(Arrays.toString(c2));
    }
}
