# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} x
    # @return {ListNode}
    def partition(self, head, x):
        smaller = ListNode(0)
        greater = ListNode(0)
        sr, gr, r = smaller, greater, head
        while r is not None:
            if r.val < x:
                sr.next = r
                sr = sr.next
            else:
                gr.next = r
                gr = gr.next
            r = r.next
        sr.next = greater.next
        gr.next = None
        return smaller.next
