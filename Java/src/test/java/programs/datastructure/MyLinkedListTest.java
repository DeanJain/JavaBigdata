package programs.datastructure;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MyLinkedListTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("setting up test ng");
    }

    @Test
    public void testAdd() {

        MyLinkedList<Integer> newll = new MyLinkedList(1);

        newll.add(2);
        newll.add(4);
        newll.add(5);
        newll.add(5);
        newll.add(5);
        newll.add(5);
        newll.add(5);

        assertEquals(newll.size(), 8);
    }

    @Test
    public void testRemove() {

        MyLinkedList<Integer> newll = new MyLinkedList(1);

        newll.add(2);
        newll.add(3);
        newll.add(4);
        newll.add(5);

        newll.remove(2);
        newll.remove(4);

        assertEquals(newll.size(), 3);

    }

    @Test
    public void testReverseLinkedList() {

        MyLinkedList input = new MyLinkedList(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);

        MyLinkedList lhs = input.reverseLinkedList();


        MyLinkedList rhs = new MyLinkedList(5);
        rhs.add(4);
        rhs.add(3);
        rhs.add(2);
        rhs.add(1);

        Assert.assertEquals(lhs, rhs);

    }
}