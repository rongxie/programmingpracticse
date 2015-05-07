## Reverse Linked List

## Reverse a singly linked list

class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None
	def visit(self):
		l = []
		cur = self
		while cur is not None:
			l.append(cur.val)
			cur = cur.next
		return l

class Solution:
	# @param {ListNode} head
	# @return {ListNode}
	def reverseList(self, head):
		new_head = None
		while head is not None:
			next = head.next
			head.next = new_head
			new_head = head
			head = next
		return new_head



head = ListNode(2)
a = ListNode(1)
head.next = a

s = Solution()

print s.reverseList(head).visit()
