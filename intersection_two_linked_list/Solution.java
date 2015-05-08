public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while(a != null || b != null) {
            if (a != null) {
                lenA += 1;
                a = a.next;
            }
            if (b != null) {
                lenB += 1;
                b = b.next;
            }
        }
        ListNode longer = lenA > lenB ? headA : headB;
        ListNode shorter = lenA > lenB ? headB : headA;
        for (int i = 0; i < Math.abs(lenA - lenB) ; i++)
            longer = longer.next;
        while(longer != null && shorter != null) {
            if (longer == shorter) return longer;
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }
}
