package programs.datastructure;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinStackTest {

    MinStack sg;

    @BeforeMethod
    public void init() {
        this.sg = new MinStack();
    }

    @Test
    public void testPush() {
        sg.push(1);
        sg.push(2);
        sg.push(3);
        sg.push(4);
        assertEquals(sg.size(), 4);
    }

    @Test
    public void testPop() {
        sg.push(1);
        sg.push(2);
        sg.push(3);
        sg.push(4);
        sg.pop();
        Assert.assertEquals(sg.size(), 3);
    }

    @Test
    void top() {
        sg.push(1);
        sg.push(2);
        sg.push(3);
        assertEquals(sg.top(), Integer.valueOf(3));
        assertEquals(sg.size(), 3);
    }

    @Test
    void getMin() {
        sg.push(1);
        sg.push(2);
        sg.push(3);
        sg.push(-4);
        assertEquals(sg.getMin(), Integer.valueOf(-4));
    }
}