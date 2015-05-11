/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode faster = dummy;
        ListNode slower = dummy;
        for (int i = 0; i < n; i++, faster = faster.next);
        while (faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }
        faster = slower.next.next;
        slower.next = faster;
        return dummy.next;
    }
}
