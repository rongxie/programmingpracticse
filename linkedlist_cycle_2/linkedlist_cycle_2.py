# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a list node
    def detectCycle(self, head):
        faster, slower = head, head
        while faster is not None:
            if faster.next is None:
                return None
            faster = faster.next.next
            slower = slower.next
            if faster is slower:
                break
        if faster is None:
            return None
        slower = head
        while faster is not slower:
            faster = faster.next
            slower = slower.next
        return faster
