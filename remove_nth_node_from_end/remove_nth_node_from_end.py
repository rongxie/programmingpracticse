# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} n
    # @return {ListNode}
    def removeNthFromEnd(self, head, n):
        dummy = ListNode(0)
        dummy.next = head
        faster, slower = dummy, dummy
        for x in range(n):
            faster = faster.next
        while faster.next is not None:
            faster = faster.next
            slower = slower.next
        faster = slower.next.next
        slower.next = faster
        return dummy.next
