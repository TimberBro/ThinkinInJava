package com.test.containers;

import com.test.util.Countries;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Exercise2 {

  public static void main(String[] args) {
    TreeSet<String> countriesSet = new TreeSet<>(Countries.names());
    TreeMap<String, String> countriesMap = new TreeMap<>(Countries.capitals());

    String string = null;
    for (String s : countriesMap.keySet()) {
      if (s.startsWith("B")) {
        string = s;
        break;
      }
    }
    Map<String, String> cutMap = countriesMap.headMap(string);
    Set<String> cutSet = countriesSet.headSet(string);
    System.out.println(cutMap);
    System.out.println(cutSet);
  }
}
