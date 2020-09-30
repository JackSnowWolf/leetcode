package validParanthesisString;

public class Solution {

  public boolean checkValidString(String s) {
    int minStack = 0;
    int maxStack = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        minStack++;
        maxStack++;
      } else if (c == ')') {
        minStack--;
        maxStack--;
        if (maxStack < 0) {
          return false;
        }
        if (minStack < 0) {
          minStack = 0;
        }
      } else if (c == '*') {
        if (minStack > 0) {
          minStack--;
        }
        maxStack++;
      }
    }

    return minStack == 0;
  }
}