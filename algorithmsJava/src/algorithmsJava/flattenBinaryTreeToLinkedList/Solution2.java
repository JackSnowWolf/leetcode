package algorithmsJava.flattenBinaryTreeToLinkedList;

import java.lang.*;
import java.util.*;

public class Solution2 {
    public void flatten(TreeNode root) {
        TreeNode currentNode = root;
        TreeNode leftNode, lastNode;
        while (currentNode != null) {
            if (currentNode.left != null) {
                leftNode = currentNode.left;
                currentNode.left = null;
                lastNode = last(leftNode);
                lastNode.right = currentNode.right;
                currentNode.right = leftNode;
            }
            currentNode = currentNode.right;
        }
    }

    private TreeNode last(TreeNode root) {
        TreeNode currentNode = root;
        TreeNode nextNode = currentNode.right;
        while (nextNode != null) {
            currentNode = nextNode;
            nextNode = currentNode.right;
        }
        return currentNode;
    }
}
