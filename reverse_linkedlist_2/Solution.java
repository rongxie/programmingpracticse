/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode first = null;
        ListNode next = null;
        int i = 1;
        while (i <= n) {
            if (i < m) {
                cur = cur.next;
                prev = prev.next;
            } else if (i == m) {
                first = prev;
                cur = cur.next;
                prev = prev.next;
            } else {
                next = cur.next;
                cur.next = first.next;
                first.next = cur;
                prev.next = next;
                cur = next;
            }
            i += 1;
        }
        return dummy.next;
        
    }
    
    
}
