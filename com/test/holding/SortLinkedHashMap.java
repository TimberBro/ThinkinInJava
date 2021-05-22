package com.test.holding;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class SortLinkedHashMap {
  public static void main(String[] args) {
    Map<String, Integer> unsortedMap = new LinkedHashMap<>();
    unsortedMap.put("Bob", 1);
    unsortedMap.put("Jack", 2);
    unsortedMap.put("Alex", 3);
    unsortedMap.put("Jean", 4);
    unsortedMap.put("Rose", 5);
    unsortedMap.put("Jenny", 6);
    LinkedList<String> keys = new LinkedList<>(unsortedMap.keySet());
    Collections.sort(keys);
    Map<String, Integer> sortedMap = new LinkedHashMap<>();
    for (String s : keys) {
      sortedMap.put(s, unsortedMap.get(s));
    }
    System.out.println(sortedMap);
  }
}
