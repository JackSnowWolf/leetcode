package algorithmsJava.minimumWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public String minWindow(String s, String t) {
    int start = 0, end = 0;
    int minLen = Integer.MAX_VALUE;
    int i = 0, j = 0;

    Set<Character> target = new HashSet<>();
    for (char c : t.toCharArray()) {
      target.add(c);
    }

    Set<Character> notContains = new HashSet<>(target);
    Map<Character, Integer> counter = new HashMap<>();
    for (char c : t.toCharArray()) {
      if (counter.containsKey(c)) {
        counter.put(c, counter.get(c) - 1);
      } else {
        counter.put(c, 0);
      }

    }

    while (i <= j && j < s.length()) {
      while (!notContains.isEmpty() && j < s.length()) {
        char curr = s.charAt(j);
        if (target.contains(curr)) {
          if (counter.get(curr) == 0) {
            notContains.remove(curr);
          }
          counter.put(curr, counter.get(curr) + 1);
        }
        j++;
      }
      if (j > s.length()) {
        break;
      }
      while (i <= j && i < s.length() && notContains.isEmpty()) {
        if (minLen > j - i) {
          start = i;
          end = j;
          minLen = j - i;
        }
        char curr = s.charAt(i);
        if (target.contains(curr)) {
          if (counter.get(curr) == 1) {
            notContains.add(curr);
          }
          counter.put(curr, counter.get(curr) - 1);
        }
        i++;
        while (i <= j && i < s.length() && !target.contains(s.charAt(i))) {
          i++;
        }

      }
    }
    return s.substring(start, end);
  }
}
