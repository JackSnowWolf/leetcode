class Node:
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def treeToDoublyList(self, root: 'Node') -> 'Node':
        def toList(curr: 'Node'):
            nonlocal first, last
            if curr is None:
                return
            if curr.left is not None:
                toList(curr.left)
            if last:
                last.right = curr
                curr.left = last
            else:
                first = curr
            last = curr
            if curr.right is not None:
                toList(curr.right)

        first, last = None, None
        toList(root)
        first.left = last
        last.right = first
        return first
