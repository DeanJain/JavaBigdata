/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.datastructure;

public class MyLinkedList {

    Node head = null;
    int size = 0;

    void addNodeAtEnd(int value) {
        Node node = new Node(value);
        if (head == null)
            head = node;
        else {
            Node nextNode = head;
            while (nextNode.next != null)
                nextNode = nextNode.next;
            nextNode.next = node;
        }
        size++;
    }

    void removeLastNode() {
        if (head != null) {
            Node secondLastNode = head;
            Node nextNode = head.next;
            while (nextNode.next != null) {
                secondLastNode = nextNode;
                nextNode = nextNode.next;
            }
            secondLastNode.next = null;
        }
        size--;
    }

    public void printList(){
        if (head == null)
            System.out.println("empty");
        else {
            System.out.println("Next Node Val = "+head.val);
            Node nextNode = head.next;
            while (nextNode != null) {
                System.out.println("Next Node Val = "+nextNode.val);
                nextNode = nextNode.next;
            }

        }
    }

    public Node searchNode(int value) {
        if (head != null) {
            if(head.val==value) return head;
            Node nextNode = head.next;
            while (nextNode.next != null) {
                if(nextNode.val==value) return nextNode;
                nextNode = nextNode.next;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return head==null;
    }


}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
