package com.test.containers;

import com.test.util.CountingGenerator;
import com.test.util.Generator;
import java.util.HashMap;

public class HashMapLoadFactor {

  public static void main(String[] args) {
    HashMap<Integer, String> map1 = new HashMap<>();
    Generator<String> gen = new CountingGenerator.String();
    // Initial size = 16
    for (int i = 0; i < 10; i++) {
      map1.put(i, gen.next());
    }
    System.out.println("Loadfactor of map1 = " + map1.size() / 16f);
    // Reset generator
    gen = new CountingGenerator.String();
    HashMap<Integer, String> map2 = new HashMap<>(32);
    for (int i = 0; i < 10; i++) {
      map2.put(i, gen.next());
    }
    System.out.println("Loadfactor of map2 = " + map2.size() / 32f);
    long t1 = System.currentTimeMillis();
    for (int j = 0; j < 100000; j++) {
      for (int i = 0; i < 10; i++) {
        map1.get(i);
      }
    }
    long t2 = System.currentTimeMillis();
    long execTime = t2 - t1;
    System.out.println("Map1 execution time = " + execTime);

    t1 = System.currentTimeMillis();
    for (int j = 0; j < 100000; j++) {
      for (int i = 0; i < 10; i++) {
        map2.get(i);
      }
    }
    t2 = System.currentTimeMillis();
    execTime = t2 - t1;
    System.out.println("Map2 execution time = " + execTime);
  }
}
