package algorithmsJava.findLeavesOfBinaryTree;

import java.util.List;

public class Test {
  public static void main(String[] args) {
    TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    Solution solution = new Solution();
    List<List<Integer>> result = solution.findLeaves(tree);
    for (List<Integer> line : result) {
      for (int val : line) {
        System.out.print(val);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
