package algorithmsJava.combinationSum;

import java.util.List;

public class Test {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = {2, 3, 5};
    int target = 8;

    List<List<Integer>> result = solution.combinationSum(arr, target);
    for (List<Integer> line : result) {
      System.out.print("[");
      for (int num : line) {
        System.out.print(num);
      }
      System.out.println("]");
    }
  }
}
