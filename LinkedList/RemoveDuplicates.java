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
class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode it = head;
        while (it != null && it.next != null) {
            if (it.val == it.next.val) {
                it.next = it.next.next;
            } else {
                it = it.next;
            }
        }
        return head;
    }
}
