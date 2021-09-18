package com.test.containers;

import com.test.util.TextFile;

public class WordCounter {

  public static void main(String[] args) {

    AssociativeArray<String, Integer> words =
        new AssociativeArray<>(new TextFile("com\\test\\util\\test.txt", "\\W+").size());

    for (String s : new TextFile("com\\test\\util\\test.txt", "\\W+")) {
      if (words.get(s) != null) {
        words.put(s, words.get(s) + 1);
      } else {
        words.put(s, 1);
      }
    }
    System.out.println(words);
  }
}
