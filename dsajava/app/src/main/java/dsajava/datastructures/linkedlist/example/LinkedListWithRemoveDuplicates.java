package dsajava.datastructures.linkedlist.example;

import java.util.HashSet;

public class LinkedListWithRemoveDuplicates {
    Node head; // Head of the list
    Node tail; // Tail of the list
    int length = 0;

    // Node class
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Method to append a new node at the end of the list
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // Method to remove duplicates from the linked list
    public void removeDuplicates() {
        if (head == null)
            return;

        Node temp = head;
        HashSet<Integer> hSet = new HashSet<>();
        hSet.add(temp.value); // Add the first element to the set

        while (temp.next != null) {
            if (hSet.contains(temp.next.value)) {
                // Skip the next node if it's a duplicate
                temp.next = temp.next.next;
                length--;
            } else {
                // Add the next node's value to the set
                hSet.add(temp.next.value);
                temp = temp.next;
            }
        }
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

    // Method to get the current length of the list
    public int getLength() {
        return length;
    }

    // Method to clear the list
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }
}
