package LinkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode itL1 = l1;
        ListNode itL2 = l2;

        while (itL1 != null || itL2 != null) {
            if (itL1.val >= itL2.val) {
                itL1 = itL2;
                itL2 = itL2.next;
            }
        }
        return l1;
    }
}
