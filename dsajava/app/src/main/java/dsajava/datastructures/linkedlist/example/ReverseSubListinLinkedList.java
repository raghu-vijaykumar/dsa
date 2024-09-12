package dsajava.datastructures.linkedlist.example;

public class ReverseSubListinLinkedList {
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

    // Method to reverse a sublist in the linked list
    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null)
            return;

        // Create a dummy node to handle edge cases where the reversal happens at the
        // head
        Node dummy = new Node(0);
        dummy.next = head;

        Node previousNode = dummy;

        // Traverse to the node just before the startIndex
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        // Reverse the sublist
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummy.next; // Update the head of the list
    }

    // Method to insert a new node at the end of the list
    public void insert(int value) {
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
