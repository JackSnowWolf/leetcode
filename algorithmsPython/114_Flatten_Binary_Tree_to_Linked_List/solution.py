# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        def helper(curr):
            if curr is None:
                return
            nonlocal last
            helper(curr.right)
            helper(curr.left)
            if last:
                curr.right = last
                curr.left = None
            last = curr

        last = None
        helper(root)
