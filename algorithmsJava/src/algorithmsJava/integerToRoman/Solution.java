package algorithmsJava.integerToRoman;

import java.lang.*;

public class Solution {

    private static int[] bins = {1000, 100, 10, 1};
    private static char[] chars = {'M', 'C', 'X', 'I'};
    private static char[] pairChars = {'D', 'L', 'V'};


    public String intToRoman(int num) {
        assert num < 4999;
        int rest = num;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < bins.length; ++i) {
            int value = rest / bins[i];
            rest = rest % bins[i];
            if (value == 4) {
                out.append(chars[i]);
                out.append(pairChars[i - 1]);
            } else if (value == 9) {
                out.append(chars[i]);
                out.append(chars[i - 1]);
            } else if (value >= 5) {
                out.append(pairChars[i - 1]);
                for (int j = 0; j < (value - 5); j++) {
                    out.append(chars[i]);
                }
            } else if (value != 0) {
                for (int j = 0; j < value; j++) {
                    out.append(chars[i]);
                }
            }
        }

        return out.toString();

    }
}
