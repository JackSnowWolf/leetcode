package algorithmsJava.wallsAndGates;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  private int[][] rooms;
  private int height;
  private int width;

  public void wallsAndGates(int[][] rooms) {
    this.rooms = rooms;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
      return;
    }
    height = rooms.length;
    width = rooms[0].length;

    Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[2]));

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (rooms[i][j] == 0) {
          int[] state = {i, j, 0};
          queue.add(state);
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int[] dir : dirs) {
        int nextX = curr[1] + dir[1];
        int nextY = curr[0] + dir[0];
        int nextVal = curr[2] + 1;
        if (isValid(nextX, nextY, nextVal)) {
          int[] state = {nextY, nextX, nextVal};
          queue.add(state);
//          print();
        }
      }
    }
  }

  private boolean isValid(int nextX, int nextY, int val) {
    if (nextX < 0 || nextX >= width) {
      return false;
    }
    if (nextY < 0 || nextY >= height) {
      return false;
    }
    if (rooms[nextY][nextX] > val) {
      rooms[nextY][nextX] = val;
      return true;
    }
    return false;
  }

  private void print() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(rooms[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
