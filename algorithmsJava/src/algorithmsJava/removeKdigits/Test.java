package algorithmsJava.removeKdigits;

public class Test {

  public static void main(String[] args) {

    Solution solution = new Solution();
    String num = "17837605";
    int k = 1;

    String result = solution.removeKdigits(num, k);
    System.out.println(result);

  }
}
