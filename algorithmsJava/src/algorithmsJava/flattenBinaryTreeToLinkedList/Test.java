package algorithmsJava.flattenBinaryTreeToLinkedList;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode inputTree = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5));
        solution.flatten(inputTree);

        TreeNode currentNode = inputTree;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.right;
        }
    }
}
