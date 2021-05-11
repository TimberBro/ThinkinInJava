package com.test.holding;

import com.test.util.TextFile;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortWordsInFile {

  private static void countWords(Map<String, Integer> map, List<String> list) {
    for (String s : list) {
      Integer freq = map.get(s);
      map.put(s, freq == null ? 1 : freq + 1);
    }
  }

  public static void main(String[] args) {
    List<String> words =
        new LinkedList<>(new TextFile("com\\test\\holding\\UniqueWords.java", "\\W+"));
    System.out.println(words);
    Map<String, Integer> map = new LinkedHashMap<>();
    Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
    countWords(map, words);
    System.out.println(map);
  }
}
