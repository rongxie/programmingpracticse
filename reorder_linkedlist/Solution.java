/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slower = dummy;
        ListNode faster = dummy;
        while(faster != null) {
            if (faster.next == null) break;
            faster = faster.next.next;
            slower = slower.next;
        }
        faster = slower.next;
        slower.next = null;
        slower = dummy.next;
        faster = reverse(faster);
        ListNode rs = merge(slower, faster);
    }
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while (a != null || b!= null) {
            if (a != null){
                runner.next = a;
                a = a.next;
                runner = runner.next;
            }
            if (b != null) {
                runner.next = b;
                b = b.next;
                runner = runner.next;
            }
            
        }
        return dummy.next;
    }
}
