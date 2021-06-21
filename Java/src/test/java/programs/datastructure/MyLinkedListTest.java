package programs.datastructure;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MyLinkedListTest {

    @Test
    public void testAdd() {

        MyLinkedList newll = new MyLinkedList();

        newll.addNodeAtEnd(2);
        newll.addNodeAtEnd(4);
        newll.addNodeAtEnd(5);
        newll.addNodeAtEnd(8);
        assertEquals(newll.size, 4);
    }

    @Test
    public void testRemove() {

        MyLinkedList newll = new MyLinkedList();

        newll.addNodeAtEnd(2);
        newll.addNodeAtEnd(4);
        newll.addNodeAtEnd(5);
        newll.addNodeAtEnd(8);

        newll.removeLastNode();
        newll.removeLastNode();

        assertEquals(newll.size, 2);

    }

    @Test
    public void testPrint() {

        MyLinkedList newll = new MyLinkedList();

        newll.addNodeAtEnd(2);
        newll.addNodeAtEnd(4);
        newll.addNodeAtEnd(5);
        newll.addNodeAtEnd(8);

        newll.removeLastNode();
        newll.removeLastNode();

        newll.printList();

    }

    @Test
    public void testSearchNode() {
        MyLinkedList newll = new MyLinkedList();
        newll.addNodeAtEnd(2);
        newll.addNodeAtEnd(4);
        newll.addNodeAtEnd(5);
        newll.addNodeAtEnd(8);
        Assert.assertEquals(newll.searchNode(5).val,5);
    }

    @Test
    public void testReverseLinkedList() {

//        MyLinkedList input = new MyLinkedList(1);
//        input.add(2);
//        input.add(3);
//        input.add(4);
//        input.add(5);
//
//        MyLinkedList lhs = input.reverseLinkedList();
//
//
//        MyLinkedList rhs = new MyLinkedList(5);
//        rhs.add(4);
//        rhs.add(3);
//        rhs.add(2);
//        rhs.add(1);
//
//        Assert.assertEquals(lhs, rhs);

    }


}