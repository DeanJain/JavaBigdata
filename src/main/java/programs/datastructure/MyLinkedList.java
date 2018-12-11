/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.datastructure;


class SLLNode {

    int data;
    SLLNode nextRef = null;

    SLLNode(int data) {
        this.data = data;
    }

    public SLLNode getNextRef() {
        return nextRef;
    }

    public void setNextRef(SLLNode nextRef) {
        this.nextRef = nextRef;
    }


}

public class MyLinkedList {

    SLLNode head;
    SLLNode current;

    public static void main(String[] args) {

        MyLinkedList newll = new MyLinkedList();

        newll.add(1);
        newll.add(2);
        newll.add(3);
        newll.add(4);
        newll.add(5);

        SLLNode temp = null;

        while ((temp = newll.current) != null) {

            System.out.println("Element = " + temp.data);

            temp = newll.traverse(temp);

            if (temp.getNextRef() == null) {
                break;
            }

        }


    }

    void add(int i) {

        if (head == null) {
            this.head = new SLLNode(i);
            this.current = this.head;
            System.out.println("added " + i);
        } else {
            while (true) {
                if (current.getNextRef() == null) {
                    current.setNextRef(new SLLNode(i));
                    break;
                } else {
                    current = current.getNextRef();
                }
            }
        }

    }

    public boolean remove(SLLNode root, SLLNode del) {
        SLLNode pointer = null;
        while (traverse(root) != null) {
            pointer = traverse(root);

            if (pointer.data == del.data) {
                root.nextRef = del.nextRef;
                return true;
            } else {
                root = pointer;
            }
        }
        return false;
    }

    public SLLNode traverse(SLLNode root) {
        if (root.nextRef != null)
            return root.nextRef;
        else
            return null;
    }


}

