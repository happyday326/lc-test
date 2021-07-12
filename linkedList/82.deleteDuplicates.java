class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head, prev = dummy;
        while (cur != null) {
            if (cur.next!=null && cur.val==cur.next.val) {
                while (cur.next!=null && cur.val==cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                prev.next = cur;
//                prev = prev.next;
            } else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}