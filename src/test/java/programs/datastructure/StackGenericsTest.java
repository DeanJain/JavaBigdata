package programs.datastructure;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StackGenericsTest {

    @Test
    public void testPush() {
        StackGenerics<Integer> sg = new StackGenerics<>();

        sg.push(1);
        sg.push(2);
        sg.push(3);
        sg.push(4);

        assertEquals(4, sg.size());

    }

    @Test
    public void testPop() {
        StackGenerics<String> sg = new StackGenerics<>();

        sg.push("1");
        sg.push("2");
        sg.push("3");
        sg.push("4");

        assertEquals("4", sg.pop());

    }
}