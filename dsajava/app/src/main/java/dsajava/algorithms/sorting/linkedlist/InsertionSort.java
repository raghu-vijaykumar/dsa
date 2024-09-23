package dsajava.algorithms.sorting.linkedlist;

class InsertionSort {

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

        ListNode sortedListHead = head;
        ListNode unsortedListHead = head.next;
        sortedListHead.next = null;

        while (unsortedListHead != null) {
            ListNode current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;

            if (current.val < sortedListHead.val) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                ListNode searchPointer = sortedListHead;
                while (searchPointer.next != null && current.val > searchPointer.next.val) {
                    searchPointer = searchPointer.next;
                }
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        head = sortedListHead;
        return head;

    }
}