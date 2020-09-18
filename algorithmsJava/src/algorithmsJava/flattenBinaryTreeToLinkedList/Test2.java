package algorithmsJava.flattenBinaryTreeToLinkedList;

public class Test2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        TreeNode inputTree = new TreeNode(4, new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))), null);
        solution.flatten(inputTree);

        TreeNode currentNode = inputTree;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.right;
        }
    }
}