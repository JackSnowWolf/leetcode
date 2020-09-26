package algorithmsJava.pathSumThree;

public class Solution {

  public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;
    int pathSum = 0;
    pathSum += pathSum(root.left, sum);
    pathSum += pathSum(root.right, sum);
    pathSum += pathSumFromRoot(root, sum);

    return pathSum;
  }

  public int pathSumFromRoot(TreeNode root, int sum) {
    if (root == null) return 0;
    int pathSum = 0;
    if (root.val == sum) pathSum++;
    pathSum += pathSumFromRoot(root.left, sum - root.val);
    pathSum += pathSumFromRoot(root.right, sum - root.val);
    return pathSum;
  }
}
