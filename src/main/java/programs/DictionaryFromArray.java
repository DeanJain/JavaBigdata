/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class DictionaryFromArray {

    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList();
        Scanner scan = new Scanner(System.in);

        // read from console integers and add to array list
        while (scan.hasNextInt()) {
            input.add(scan.nextInt());
        }

        // check in hashmap for key and increment count if not add as new key with 1 count
        HashMap<Integer, Integer> hm = new HashMap();
        for (int j = 0; j < input.size(); j++) {
            if (hm.containsKey(input.get(j))) {
                hm.put(input.get(j), hm.get(input.get(j)) + 1);
            } else {
                hm.put(input.get(j), 1);
            }
        }

        // iterate over hashmap and print the keys in dictionary and their counts
        Iterator it = hm.keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            System.out.println("Key = " + key + " Count =" + hm.get(key));
        }

    }
}
