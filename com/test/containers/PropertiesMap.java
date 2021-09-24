package com.test.containers;

import com.test.util.CountingMapData;
import java.util.concurrent.*;
import java.util.*;

public class PropertiesMap {

  public static void printKeys(Map<Object, Object> map) {
    System.out.print("Size = " + map.size() + ", ");
    System.out.print("Keys: ");
    System.out.println(map.keySet()); // Produce a Set of the keys
  }

  public static void test(Map<Object, Object> map) {
    System.out.println(map.getClass().getSimpleName());
    map.putAll(new CountingMapData(25));
    // Map has 'Set' behavior for keys:
    map.putAll(new CountingMapData(25));
    printKeys(map);
    // Producing a Collection of the values:
    System.out.print("Values: ");
    System.out.println(map.values());
    System.out.println(map);
    System.out.println("map.containsKey(11): " + map.containsKey(11));
    System.out.println("map.get(11): " + map.get(11));
    System.out.println("map.containsValue(\"F0\"): " + map.containsValue("F0"));
    Object key = map.keySet().iterator().next();
    System.out.println("First key in map: " + key);
    map.remove(key);
    printKeys(map);
    map.clear();
    System.out.println("map.isEmpty(): " + map.isEmpty());
    map.putAll(new CountingMapData(25));
    // Operations on the Set change the Map:
    map.keySet().removeAll(map.keySet());
    System. out.println("map.isEmpty(): " + map.isEmpty());
  }

  public static void main(String[] args) {
    // new Properties() extends Hashtable<Object, Object>, so there was only few problems;
    test(new Properties());
  }
}
