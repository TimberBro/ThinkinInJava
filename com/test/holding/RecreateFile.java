package com.test.holding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RecreateFile {

  public static void main(String[] args) {
    Map<String, ArrayList<Integer>> container =
        StoreFile.textFileToMap("com\\test\\holding\\Text.txt");
    Map<Integer, String> sortedContainer = new HashMap<>();
    for (Entry<String, ArrayList<Integer>> entry : container.entrySet()) {
      for (Integer counter : entry.getValue()) {
        sortedContainer.put(counter, entry.getKey());
      }
    }
    System.out.println(sortedContainer.values());
  }
}
