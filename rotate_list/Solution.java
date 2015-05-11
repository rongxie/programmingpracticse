/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = getLen(head);
        if (len == 0) return head;
        k = k % len;
        if (k == 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode faster = dummy;
        ListNode slower = dummy;
        for (int i = 0; i < k; i++, faster = faster.next);
        while (faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }
        ListNode newHead = slower.next;
        dummy.next = newHead;
        faster.next = head;
        slower.next = null;
        return dummy.next;
    }
    
    private int getLen(ListNode head) {
        int i = 0;
        for (ListNode p = head; p != null; p = p.next, i+=1);
        return i;
    }
}
