# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} m
    # @param {integer} n
    # @return {ListNode}
    def reverseBetween(self, head, m, n):
        dummy = ListNode(0)
        dummy.next = head
        prev, cur, first, next = dummy, head, None, None
        i = 1
        while i <= n:
            if i < m:
                cur = cur.next
                prev = prev.next
            elif i == m:
                first = prev
                prev = prev.next
                cur = cur.next
            else:
                next = cur.next
                cur.next = first.next
                first.next = cur
                prev.next = next
                cur = next
            i += 1
        return dummy.next
