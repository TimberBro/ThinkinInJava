package com.test.holding;

import com.test.util.TextFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreFile {
  static Map<String, ArrayList<Integer>> textFileToMap(String fullPath) {
    Map<String, ArrayList<Integer>> container = new HashMap<>();
    int counter = 0;
    for (String s : new TextFile(fullPath, "\\W+")) {
      ArrayList<Integer> wordLocation = container.get(s);
      if (wordLocation == null) {
        wordLocation = new ArrayList<>();
        container.put(s, wordLocation);
      }
      wordLocation.add(counter++);
    }
    return (container);
  }

  public static void main(String[] args) {
    System.out.println(textFileToMap("Text.txt"));
  }
}
