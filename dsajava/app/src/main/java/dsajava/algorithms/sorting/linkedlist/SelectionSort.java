package dsajava.algorithms.sorting.linkedlist;

public class SelectionSort {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode swapNode = head;
        while (swapNode.next != null) {
            ListNode minNode = swapNode;
            ListNode current = swapNode;
            while (current != null) {
                if (current.val < minNode.val) {
                    minNode = current;
                }
                current = current.next;
            }
            if (swapNode != minNode) {
                int val = swapNode.val;
                swapNode.val = minNode.val;
                minNode.val = val;
            }
            swapNode = swapNode.next;
        }
        return head;

    }

}
