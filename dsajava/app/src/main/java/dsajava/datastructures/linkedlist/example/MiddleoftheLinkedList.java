package dsajava.datastructures.linkedlist.example;

// Find middle of the linked list if there are 3 nodes [0,1,2] return 1
// if there are 4 nodes [0, 1, 2, 3] return 2
public class MiddleoftheLinkedList {

    Node head;
    Node tail;
    int length = 0;

    public class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public void append(int value) {
        Node node = new Node(value);
        // Empty linked list
        if (length == 0) {
            head = node;
            tail = node;
        } else if (length == 1) {
            tail = node;
            head.next = tail;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        length++;
    }

    public Node middleNode() {

        if (length == 0)
            return null;
        int midNode = length / 2;

        Node temp = head;
        while (temp != null && midNode > 0) {
            temp = temp.next;
            midNode--;
        }
        return temp;
    }

}
