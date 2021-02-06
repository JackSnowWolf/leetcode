package algorithmsJava.wordAbbreviation;

import java.util.Arrays;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] words = {"like", "god", "internal", "me", "internet", "interval", "intension", "face",
        "intrusion"};

    List<String> dict = Arrays.asList(words.clone());
    List<String> abbrs = solution.wordsAbbreviation(dict);

    for (String abbr : abbrs) {
      System.out.println(abbr);
    }

  }
}
