package com.test.holding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Gerbil17 {
  private int number;

  Gerbil17(int i) {
    this.number = i;
  }

  void hop() {
    System.out.println("This is gerbil number = " + number);
    System.out.println("Hop!");
  }

  public static void main(String[] args) {
    Map<String, Gerbil17> map = new HashMap<String, Gerbil17>();
    map.put("Fuzz", new Gerbil17(1));
    map.put("Fizz", new Gerbil17(2));
    map.put("Buzz", new Gerbil17(3));
    map.put("Jack", new Gerbil17(4));
    map.put("Joe", new Gerbil17(5));
    map.put("Sally", new Gerbil17(6));
    Iterator<Entry<String, Gerbil17>> it = map.entrySet().iterator();
    while (it.hasNext()) {
      Entry<String, Gerbil17> entry = it.next();
      System.out.print(entry.getKey() + ": ");
      entry.getValue().hop();
    }
  }
}
