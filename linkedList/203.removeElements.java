class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head, prev = dummy;
        while (cur!=null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = prev.next
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}