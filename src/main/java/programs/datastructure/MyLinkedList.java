/*
 * NO Copyright (c) @Dean.Jain 2018. Feel free to reuse, The world is much better with Reuse. Go Green :)
 */

package programs.datastructure;


import java.util.LinkedList;

public class MyLinkedList<T> {

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    private T element;

    public MyLinkedList<T> getNext() {
        return this.next;
    }

    public void setNext(MyLinkedList<T> next) {
        this.next = next;
    }

    private MyLinkedList<T> next = null, current = this;

    public MyLinkedList(T t) {
        this.setElement(t);
    }

    public boolean add(T e) {

        MyLinkedList<T> temp = new MyLinkedList<>(e);

        LinkedList l = new LinkedList();

        if (this.getNext() == null) {
            this.setNext(temp);
            System.out.println("added element " + e);
            return true;
        } else {

            // traversing for finding null next
            MyLinkedList<T> current = this.getNext();

            while (true) {
                if (current.getNext() != null) {
                    current = current.getNext();
                } else {
                    current.setNext(temp);
                    System.out.println("added element " + e);
                    return true;
                }
            }
        }

    }

    public boolean remove(T e) {

        if (this.getElement() == e) {
            this.current = this.getNext();
            System.out.println("removed element " + e);
            return true;
        } else {

            // traversing for finding null next
            MyLinkedList<T> next = this.getNext();

            while (next != null) {
                if (next.getElement() == e) {
                    current.setNext(next.getNext());
                    System.out.println("removed element " + e);
                    break;
                } else {
                    current = next;
                    next = next.getNext();
                }
            }
        }
        return false;
    }

    public MyLinkedList<T> reverseLinkedList() {

        MyLinkedList current = this, next = null, previous = null;

        while (current != null) {
            next = current.getNext();

            current.setNext(previous);

            previous = current;
            current = next;
        }
        return previous;
    }

    public int size() {
        int count = 1;
        MyLinkedList current = this;

        while (current.getNext() != null) {
            ++count;
            current = current.getNext();
        }

        return count;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof MyLinkedList)) {
            return false;
        }

        MyLinkedList lhs = this, rhs = (MyLinkedList) obj;


        do {
            if (lhs.getElement() != rhs.getElement())
                return false;
            lhs = lhs.getNext();
            rhs = rhs.getNext();

        } while (rhs != null);

        return true;

    }
}
