package LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode aux = new ListNode(0);
        ListNode crt = aux;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                crt.next = l1;
                l1 = l1.next;
            } else {
                crt.next = l2;
                l2 = l2.next;
            }
            crt = crt.next;
        }
        crt.next = (l1 == null) ? l2 : l1;
        return aux.next;
    }
}
