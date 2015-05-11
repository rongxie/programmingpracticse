# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} k
    # @return {ListNode}
    def rotateRight(self, head, k):
        len = self.getLen(head)
        if len == 0 or k % len == 0:
            return head
        k = k % len
        dummy = ListNode(0)
        dummy.next = head
        faster, slower = dummy, dummy
        for i in range(k):
            faster = faster.next
        while faster.next is not None:
            faster = faster.next
            slower = slower.next
        newHead = slower.next
        dummy.next = newHead
        faster.next = head
        slower.next = None
        return newHead
    
    def getLen(self, head):
        i = 0
        while head is not None:
            i += 1
            head = head.next 
        return i
