/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;
        while (faster != null) {
            if (faster.next == null) return false;
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower) return true;
        }
        return false;
    }
}
