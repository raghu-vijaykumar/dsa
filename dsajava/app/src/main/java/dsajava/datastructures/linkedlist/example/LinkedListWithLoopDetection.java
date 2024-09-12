package dsajava.datastructures.linkedlist.example;

public class LinkedListWithLoopDetection {

    Node head;
    Node tail;
    int length = 0;

    // Node class definition
    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Method to append a node to the end of the linked list
    public void append(int value) {
        Node node = new Node(value);
        // If the list is empty
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    // Method to create a loop in the list for testing purposes
    public void createLoop(int position) {
        if (position < 0 || position >= length) {
            return; // Invalid position
        }
        Node temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        tail.next = temp; // Create the loop
    }

    // Method to detect if the linked list has a loop
    public boolean hasLoop() {
        if (length <= 1) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true; // Loop detected
            }
        }
        return false; // No loop
    }

    // Method to print the linked list (for testing, it will stop at the loop if one
    // exists)
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
