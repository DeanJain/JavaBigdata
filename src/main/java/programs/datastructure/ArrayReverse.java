/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.datastructure;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class ArrayReverse {


    public static void main(String[] args) {

        Character[] iArray = {'0', '1', '2', '3', '9', '4', '5', '6', '7', '8'};

        Arrays.sort(iArray);
        System.out.println(Arrays.toString(iArray));

        ArrayUtils.reverse(iArray);
        System.out.println(Arrays.toString(iArray));

        for (int i = iArray.length - 1; i >= 0; i--)
            System.out.print(iArray[i]);


    }
}
