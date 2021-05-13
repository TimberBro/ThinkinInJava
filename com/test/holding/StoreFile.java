package com.test.holding;

import com.test.util.TextFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreFile {

  public static void main(String[] args) {
    Map<String, ArrayList<Integer>> container = new HashMap<>();
    int counter = 0;
    for (String s : new TextFile("Text.txt", "\\W+")) {
      ArrayList<Integer> wordLocation = container.get(s);
      if (wordLocation == null) {
        wordLocation = new ArrayList<>();
        container.put(s, wordLocation);
      }
      wordLocation.add(counter++);
    }
    System.out.println(container);
  }
}
