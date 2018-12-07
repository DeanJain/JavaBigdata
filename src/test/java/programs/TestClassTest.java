/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClassTest {

    List<String> pairs = null;

    @BeforeMethod
    public void setUp() {
        pairs = new ArrayList<>();
        pairs.add("1:2");
    }

    @Test
    public void testGetSumPairs() {

        //   assertEquals(pairs, new TestClass(), 3));
    }
}