package algorithmsJava.wallsAndGates;



public class Test {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] inputArr = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};

    solution.wallsAndGates(inputArr);

    for (int i = 0; i < inputArr.length; i++) {
      for (int j = 0; j < inputArr[0].length; j++) {
        System.out.print(inputArr[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }


  }
}

