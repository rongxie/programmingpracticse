# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @return {void} Do not return anything, modify head in-place instead.
    def reorderList(self, head):
        dummy = ListNode(0)
        dummy.next = head
        faster, slower = dummy, dummy
        while faster is not None:
            if faster.next is None:
                break
            faster = faster.next.next
            slower = slower.next
        
        faster = slower.next
        slower.next = None
        slower = dummy.next
        faster = self.reverse(faster)
        head = self.merge(slower, faster)
        
    
    def reverse(self, head):
        newHead = None
        while head is not None:
            next = head.next
            head.next = newHead
            newHead = head
            head = next
        return newHead
    
    def merge(self, a, b):
        dummy = ListNode(0)
        runner = dummy
        while a is not None or b is not None:
            if a is not None:
                runner.next = a
                a = a.next
                runner = runner.next
            if b is not None:
                runner.next = b
                b = b.next
                runner = runner.next
        return dummy.next
