package algorithmsJava.permutationSequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  int[] factorial;

  public String getPermutation(int n, int k) {
    factorial = new int[n];
    factorial[0] = 1;
    for (int i = 1; i < n; i++) {
      factorial[i] = factorial[i - 1] * i;
    }
    List<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      arr.add(i + 1);
    }

    return getCurrentPermutation(arr, k);
  }

  private String getCurrentPermutation(List<Integer> arr, int k) {
    if (arr.size() == 1) {
      return String.valueOf(arr.get(0));
    }

    int permutationAmount = factorial[arr.size() - 1];

    int index = (int) Math.ceil((double) k / permutationAmount) - 1;
    int val = arr.get(index);

    arr.remove(index);
    int nextK = k % permutationAmount == 0 ? permutationAmount : k % permutationAmount;
    return val + getCurrentPermutation(arr, nextK);
  }
}
