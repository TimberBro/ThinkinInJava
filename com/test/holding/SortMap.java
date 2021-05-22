package com.test.holding;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortMap {

  static Map<String, Integer> sort(Map<String, Integer> unsortedMap) {
    String[] keys = unsortedMap.keySet().toArray(new String[0]);
    Arrays.sort(keys);
    Map<String, Integer> sortedMap = new LinkedHashMap<>();
    for (String key : keys) {
      sortedMap.put(key, unsortedMap.get(key));
    }
    return sortedMap;
  }

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("Bob", 1);
    map.put("Jack", 2);
    map.put("Alex", 3);
    map.put("Jean", 4);
    map.put("Rose", 5);
    map.put("Jenny", 6);
    System.out.println("HashMap:");
    System.out.println(map);
    System.out.println("Sorted LinkedHashMap:");
    System.out.println(sort(map));
  }
}
