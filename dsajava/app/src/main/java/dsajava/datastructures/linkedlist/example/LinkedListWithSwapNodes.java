package dsajava.datastructures.linkedlist.example;

public class LinkedListWithSwapNodes {

    Node head; // Head of the list

    // Node class
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Method to swap two nodes in the linked list
    public void swapNodeValue(int x, int y) {
        if (head == null)
            return;

        Node temp = head;
        while (temp != null) {
            if (temp.value == x) {
                temp.value = y;
            } else if (temp.value == y) {
                temp.value = x;
            }
            temp = temp.next;
        }
    }

    public void swapNode(int x, int y) {
        if (head == null || x == y)
            return;

    }

    // Method to insert a new node at the end of the list
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Method to print the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
