package algorithmsJava.LRUCache;

public class Test {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] cmd = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
    int[][] num = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};

    String[] outputs = solution.executor(cmd, num);
    for (String out : outputs) {
      System.out.println(out);
    }
  }
}
