class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode notNine = dummy;
        while (head != null) {
            if (head.val != 9) {
                notNine = head;
            }
            head = head.next;
        }
        notNine.val += 1;
        notNine = notNine.next;
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }
        if (dummy.next.val == 0) {
            return dummy;
        }
        return dummy.next;
    }
}