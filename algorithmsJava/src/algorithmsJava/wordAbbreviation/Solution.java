package algorithmsJava.wordAbbreviation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<String> wordsAbbreviation(List<String> words) {
    Map<String, List<IndexedWord>> groups = new HashMap();
    String[] ans = new String[words.size()];

    int index = 0;
    for (String word : words) {
      String ab = abbrev(word, 0);
      if (!groups.containsKey(ab)) {
        groups.put(ab, new ArrayList());
      }
      groups.get(ab).add(new IndexedWord(word, index));
      index++;
    }

    for (List<IndexedWord> group : groups.values()) {
      TrieNode trie = new TrieNode();
      for (IndexedWord iw : group) {
        TrieNode cur = trie;
        for (char letter : iw.word.substring(1).toCharArray()) {
          if (cur.children[letter - 'a'] == null) {
            cur.children[letter - 'a'] = new TrieNode();
          }
          cur.count++;
          cur = cur.children[letter - 'a'];
        }
      }

      for (IndexedWord iw : group) {
        TrieNode cur = trie;
        int i = 1;
        for (char letter : iw.word.substring(1).toCharArray()) {
          if (cur.count == 1) {
            break;
          }
          cur = cur.children[letter - 'a'];
          i++;
        }
        ans[iw.index] = abbrev(iw.word, i - 1);
      }
    }

    return Arrays.asList(ans);
  }

  public String abbrev(String word, int i) {
    int N = word.length();
    if (N - i <= 3) {
      return word;
    }
    return word.substring(0, i + 1) + (N - i - 2) + word.charAt(N - 1);
  }

  public int longestCommonPrefix(String word1, String word2) {
    int i = 0;
    while (i < word1.length() && i < word2.length()
        && word1.charAt(i) == word2.charAt(i)) {
      i++;
    }
    return i;
  }
}

class TrieNode {

  TrieNode[] children;
  int count;

  TrieNode() {
    children = new TrieNode[26];
    count = 0;
  }
}

class IndexedWord {

  String word;
  int index;

  IndexedWord(String w, int i) {
    word = w;
    index = i;
  }
}

