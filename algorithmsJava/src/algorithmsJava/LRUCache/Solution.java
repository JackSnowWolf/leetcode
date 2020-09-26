package algorithmsJava.LRUCache;

public class Solution {

  private LRUCache lruCache;

  public String[] executor(String[] cmds, int[][] args) {

    String[] output = new String[cmds.length];
    for (int i = 0; i < cmds.length; i++) {
      String cmd = cmds[i];
      int[] arg = args[i];
      switch (cmd) {
        case "LRUCache":
          lruCache = new LRUCache(arg[0]);
          output[i] = "null";
          System.out.println(lruCache.print());
          break;
        case "put":
          lruCache.put(arg[0], arg[1]);
          output[i] = "null";
          System.out.println(lruCache.print());
          break;
        case "get":
          int result = lruCache.get(arg[0]);
          output[i] = Integer.toString(result);
          System.out.println(lruCache.print());
      }
    }
    return output;
  }
}
