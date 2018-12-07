/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;

public class SingletonExample {

    public static void main(String[] args) {

        Singleton st = Singleton.INSTANCE;

        System.out.println("val = " + st.getValue());
        st.setValue(1);

        System.out.println("val = " + st.getValue());

        // exchange values without using temp var
        int x = 1, y = 2;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println(x + " " + y);

    }


}
