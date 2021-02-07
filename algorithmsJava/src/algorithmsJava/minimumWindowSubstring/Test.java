package algorithmsJava.minimumWindowSubstring;

public class Test {

  public static void main(String[] args) {
    Solution solution = new Solution();

    String s = "ADOBECODEBANC";
    String t = "ABC";

    String result = solution.minWindow(s, t);
    System.out.println(result);
  }
}
