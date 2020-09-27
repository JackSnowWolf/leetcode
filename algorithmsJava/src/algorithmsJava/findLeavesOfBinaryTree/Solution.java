package algorithmsJava.findLeavesOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> leavesList = new ArrayList<>();
    maxDepth(root, leavesList);
    return leavesList;
  }

  private int maxDepth(TreeNode root, List<List<Integer>> leavesList) {
    if (root == null) return 0;
    int leftDepth = maxDepth(root.left, leavesList);
    int rightDepth = maxDepth(root.right, leavesList);
    int maxDepth = Math.max(leftDepth, rightDepth);
    if (leavesList.size() <= maxDepth) {
      List<Integer> leafList = new ArrayList<>();
      leavesList.add(leafList);
    }
    leavesList.get(maxDepth).add(root.val);
    return maxDepth + 1;
  }
}
