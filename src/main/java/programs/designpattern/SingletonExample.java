/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.designpattern;

// using enumns for singleton is best impl as it handles reflection,
// serialization and concurrency issues
public class SingletonExample {

    public static void main(String[] args) {

        Singleton st = Singleton.INSTANCE;

        System.out.println("val = " + st.getValue());
        st.setValue(1);

        System.out.println("val = " + st.getValue());


    }


}
