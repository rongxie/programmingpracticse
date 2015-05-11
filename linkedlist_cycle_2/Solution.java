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
    public ListNode detectCycle(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;
        
        while(faster != null) {
            if (faster.next == null) return null;
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower) break;
        }
        
        if (faster == null) return null;
        slower = head;
        while (slower != faster) {
            slower = slower.next;
            faster = faster.next;
        }
        
        return faster;
    }
}
