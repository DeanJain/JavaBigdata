/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

// groups of anagrams from an array with a set of inputs strings
public class ClassifyAnagrams {

    // using hashmap as key value pair as we dont a
    static HashMap ht;

    public static void main(String[] args) {
        ht = new HashMap();
        String[] input = new String[]{"abc", "bca", "cad", "dac", "acd", "sdsaf", "ssadf"};

        // iterate and get hashcode for each anangram and add them to hash table
        for (String i : input)
            hashCode(i);

        Iterator e = ht.keySet().iterator();

        while (e.hasNext()) {
            Object key = e.next();
            System.out.println("Signature =" + key + " Anagrams = " + ht.get(key));
        }
    }

    // calculates the custom hashcode for each char and sum it up so that anagrams have same hashcode
    public static int hashCode(String s) {
        int hashcode = 0;

        // another implementation to generate a unique signature for anagrams using sorted bytes
        byte[] b = s.getBytes();
        Arrays.sort(b);
        String signature = new String(b);
        System.out.println("sorted =" + signature);

        String temp = "";
        for (int i = 0; i < s.length(); i++)
            hashcode += String.valueOf(s.charAt(i)).hashCode();

        if (ht.get(hashcode) != null)
            temp = ht.get(hashcode).toString();

        ht.put(hashcode, temp + ", " + s);
        return hashcode;
    }
}
