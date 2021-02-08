package algorithmsJava.removeKdigits;

public class Solution {

  public String removeKdigits(String num, int k) {
    if (k == num.length()) {
      return "0";
    }
    char[] rest = num.substring(k).toCharArray();
    for (int i = k - 1; i >= 0; --i) {
      char curr = num.charAt(i);
      for (int j = 0; j < num.length() - k; j++) {
        if (curr < rest[j]) {
          char temp = rest[j];
          rest[j] = curr;
          curr = temp;
        } else if (curr > rest[j]) {
          break;
        }
      }
    }
    // remove leading zero
    int i = 0;
    while (i < num.length() - k && rest[i] == '0') {
      i++;
    }
    if (i == num.length() - k) {
      return "0";
    } else {
      return String.valueOf(rest).substring(i);
    }
  }
}
