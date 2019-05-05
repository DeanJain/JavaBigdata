package programs.problems;

import java.util.Scanner;

public class ReverseList {

    public static void main(String[] args) {


        Scanner scanner = new Scanner("3 9 1 2 3 4 5 6 7 8 9\n" +
                "2 9 1 2 3 4 5 6 7 8 9");
        while (scanner.hasNextInt()) {
            int k = scanner.nextInt();
            // read the linked-list from console
            Node<Integer> start = new Node<>(null);
            Node<Integer> current = start;
            int n = scanner.nextInt();
            System.out.print("Input: ");
            for (int i = 1; i <= n; i++) {
                current.next = new Node<>(scanner.nextInt());
                current = current.next;
                System.out.print(current.data + " ");
            }
            System.out.println("| k = " + k);
            // reverse the list
            reverseByBlock(start, k);

            // display the list
            System.out.print("Result: ");
        }
    }

    static <T> void reverseByBlock(Node<T> start, int k) {
        // reverse the complete list
        start.next = reverse(start.next, Integer.MAX_VALUE)[0];
        // reverse the individual blocks
        Node<T>[] output;
        Node<T> current = start;
        while (current.next != null) {
            output = reverse(current.next, k);
            current.next = output[0];
            current = output[1];
        }
    }

    static class Node<T> {
        Node next;
        T data;

        Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // reverses a linked-list starting at 'start', ending at min(end, len-th element)
    // returns {first element, last element} with (last element).next = (len+1)-th element
    static <T> Node<T>[] reverse(Node<T> start, int len) {
        Node<T> current = start;
        Node<T> prev = null;
        while (current != null && len > 0) {
            Node<T> temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            len--;
        }
        start.next = current;
        return new Node[]{prev, start};

    }
}
