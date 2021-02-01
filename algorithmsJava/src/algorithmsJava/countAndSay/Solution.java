package algorithmsJava.countAndSay;

public class Solution {

  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }

    String prev = countAndSay(n - 1);
    StringBuilder stringBuilder = new StringBuilder();
    Character preChar = null;
    int cnt = 0;

    for (char c : prev.toCharArray()) {
      if (preChar == null) {
        preChar = c;
      }
      if (preChar != c) {
        stringBuilder.append(cnt);
        stringBuilder.append(preChar);
        preChar = c;
        cnt = 0;
      }
      cnt++;
    }
    stringBuilder.append(cnt);
    stringBuilder.append(prev.toCharArray()[prev.length() - 1]);
    return stringBuilder.toString();
  }
}
