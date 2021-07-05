class Test {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p=l1, q=l2, cur=dummy;
        int add = 0;
        while (p!=null || q!=null) {
            int x = (p!=null) ? p.val:0;
            int y = (q!=null) ? q.val:0;
            int sum = x+y+add;
            add = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            if (p!=null) {
                p = p.next;
            }
            if (q!=null) {
                q = q.next;
            }
        }
        if (add != 0) {
            cur.next = new ListNode(add);
        }
        return dummy.next;
    }
}