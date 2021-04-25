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
class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode it = head;
        int length = 1;
        while (it.next != null) {
            length++;
            it = it.next;
        }
        it.next = head;
        it = head;
        k = k % length;
        int cut = length - k - 1;
        while (cut > 0) {
            it = it.next;
            cut--;
        }
        head = it.next;
        it.next = null;
        return head;
    }
}
