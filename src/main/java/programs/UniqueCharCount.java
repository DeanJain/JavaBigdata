/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class UniqueCharCount {

    public static void main(String[] args) {

        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();


        System.out.println(input);

        HashMap hm = new HashMap();

        for (int i = 0; i < input.length(); i++) {

            int count = 0;
            String c = String.valueOf(input.charAt(i));

            if (hm.containsKey(c))
                count = Integer.parseInt(hm.get(c).toString());

            count = count + 1;

            hm.put(c, count);

        }

        Set keys = hm.keySet();
        Iterator it = keys.iterator();

        // print the unique keys and corresponding counts via keys iterator
        while (it.hasNext()) {

            String key = it.next().toString();

            System.out.println("Key " + key + " Count = " + hm.get(key));
        }


    }
}
