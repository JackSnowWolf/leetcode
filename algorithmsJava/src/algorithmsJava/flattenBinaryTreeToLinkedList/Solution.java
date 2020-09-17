package algorithmsJava.flattenBinaryTreeToLinkedList;


import java.util.*;
import java.lang.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> nodeStack = new Stack<>();

        nodeStack.push(root);
        TreeNode resultTreeNode = null;
        TreeNode tailTreeNode = null;
        while (!nodeStack.isEmpty()){
            TreeNode currentNode = nodeStack.pop();
            if (resultTreeNode == null){
                resultTreeNode = new TreeNode(currentNode.val);
                tailTreeNode = resultTreeNode;
            }
            else {
                tailTreeNode.right = new TreeNode(currentNode.val);
                tailTreeNode = tailTreeNode.right;
            }

            if (currentNode.right != null){
                nodeStack.push(currentNode.right);
            }
            if (currentNode.left != null){
                nodeStack.push(currentNode.left);
            }
        }
        if (resultTreeNode != null){
            root.left = null;
            root.right = resultTreeNode.right;
        }
    }
}