package dsajava.algorithms.sorting.linkedlist;

public class BubbleSort {

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

        ListNode sortedUntil = null;
        while (sortedUntil != head.next) {
            ListNode temp = head;
            while (temp.next != sortedUntil) {
                if (temp.val > temp.next.val) {
                    int swap = temp.val;
                    temp.val = temp.next.val;
                    temp.next.val = swap;
                }
                temp = temp.next;
            }
            sortedUntil = temp;
        }
        return head;

    }
}
