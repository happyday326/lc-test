class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, prev = dummy, third = null;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}