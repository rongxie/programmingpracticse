/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode sr = smaller;
        ListNode gr = greater;
        ListNode r = head;
        while (r != null) {
            if (r.val < x) {
                sr.next = r;
                sr = sr.next;
            } else {
                gr.next = r;
                gr = gr.next;
            }
            r = r.next;
        }
        sr.next = greater.next;
        gr.next = null;
        return smaller.next;
    }
}
