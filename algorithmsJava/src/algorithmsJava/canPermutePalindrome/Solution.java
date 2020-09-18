package algorithmsJava.canPermutePalindrome;

import java.util.*;
import java.lang.*;

class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
            } else {
                charMap.put(s.charAt(i), 1);
            }
        }

        int flag = 0;
        for (Map.Entry pair : charMap.entrySet()) {
            System.out.println(pair);
            if ((int) pair.getValue() % 2 == 1) {
                flag++;
                if (flag > 1) return false;
            }
        }
        return true;
    }
}