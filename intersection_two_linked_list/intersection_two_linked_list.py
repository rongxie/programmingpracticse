#intersection_two_linked_list

# Definition for singly-linked list.
class ListNode:
  def __init__(self, x):
    self.val = x
    self.next = None

class Solution:
  # @param two ListNodes
  # @return the intersected ListNode
  def getIntersectionNode(self, headA, headB):
  	a, b = headA, headB
  	lenA, lenB = 0, 0
  	while a is not None or b is not None:
  	  if a is not None:
  	  	a = a.next
  	  	lenA += 1
  	  if b is not None:
  	  	b = b.next
  	  	lenB += 1
  	longer = headA if lenA > lenB else headB
  	shorter = headB if lenA > lenB else headA
  	for i in range(abs(lenA - lenB)):
  	  longer = longer.next
  	while (longer is not None) and (shorter is not None):
  		if longer == shorter:
  			return longer
  		longer = longer.next
  		shorter = shorter.next
  	return None

a = ListNode(1)
b = ListNode(2)
#c = ListNode(3)
#d = ListNode(4)
#e = ListNode(5)
#a.next = b
#b.next = c
#c.next = d
#e.next = c

s = Solution()

rs = s.getIntersectionNode(a, b)
if rs is not None:
	print rs.val
else:
	print "None"


