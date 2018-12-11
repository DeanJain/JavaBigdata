/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.Enumeration;
import java.util.Hashtable;

public class Anagrams {

    static Hashtable ht;

    public static void main(String[] args) {

        ht = new Hashtable();
        String[] input = new String[]{"abc", "bca", "cad", "dac", "acd", "sdsaf", "ssadf"};

        // iterate and get hashcode for each anangram and add them to hash table
        for (String i : input)
            hashCode(i);


        Enumeration e = ht.keys();
        while (e.hasMoreElements())
            System.out.println(ht.get(e.nextElement()));

    }

    // calculates the custom hashcode for each char and sum it up so that anagrams have same hashcode
    public static int hashCode(String s) {
        int hashcode = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++)
            hashcode += String.valueOf(s.charAt(i)).hashCode();

        if (ht.get(hashcode) != null)
            temp = ht.get(hashcode).toString();

        ht.put(hashcode, temp + ", " + s);
        return hashcode;
    }
}
