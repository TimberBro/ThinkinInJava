package com.test.holding;

import java.util.*;
import java.util.Map.Entry;

public class Statistics {

  private static Integer getFirstKeyBySortedValue(Map<Integer, Integer> map) {
    List<Integer> sortedByValueExperiment = new LinkedList<>(map.values());
    Collections.sort(sortedByValueExperiment, Collections.reverseOrder());
    for (Entry<Integer, Integer> i : map.entrySet()) {
      if (i.getValue().equals(sortedByValueExperiment.get(0))) {
        return i.getKey();
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    Random rand = new Random(47);
    int numberOfExperiments = 10;
    Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
    for (int i = 0; i < numberOfExperiments; i++) {
      Map<Integer, Integer> experiment = new HashMap<Integer, Integer>();
      for (int j = 0; j < 10000; j++) {
        // Produce a number between 0 and 20:
        int r = rand.nextInt(20);
        Integer freq = experiment.get(r);
        experiment.put(r, freq == null ? 1 : freq + 1);
      }
      result.put(i, getFirstKeyBySortedValue(experiment));
    }
    System.out.println(
        "Map of most often generated numbers between 0-19 of 10k picks in 10 tests:");
    System.out.println(result);
  }
}
