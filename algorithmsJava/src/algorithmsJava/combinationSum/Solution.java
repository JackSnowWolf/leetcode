package algorithmsJava.combinationSum;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  private List<List<Integer>> result;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    result = new LinkedList<>();
    List<Integer> currCombination = new LinkedList<>();
    dfs(candidates, target, currCombination, 0);
    return result;
  }

  private void dfs(int[] candidates, int target, List<Integer> currCombination, int pos) {
    if (target < 0) {
      return;
    } else if (target == 0) {
      List<Integer> newCombination = new LinkedList<>(currCombination);
      result.add(newCombination);
      return;
    }

    for (int i = pos; i < candidates.length; ++i) {
      currCombination.add(candidates[i]);
      dfs(candidates, target - candidates[i], currCombination, i);
      currCombination.remove(currCombination.size() - 1);
    }

  }
}
