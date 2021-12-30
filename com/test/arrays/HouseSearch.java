package com.test.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class HouseSearch {

  public static void main(String[] args) {
    Comparator<House> comparator =
        new Comparator<House>() {
          @Override
          public int compare(House o1, House o2) {
            return (Integer.compare(o1.id, o2.id));
          }
        };

    House[] houses = new House[10];
    // Array created in descending order.
    for (int i = houses.length - 1; i >= 0; i--) {
      houses[i] = new House(i);
    }
    // Array should be sorted in ascending order.
    Arrays.sort(houses, comparator);
    // Now we can find, what we want.
    System.out.println(
        "Order of House[3] in sorted array = "
            + Arrays.binarySearch(houses, houses[3], comparator));
  }
}
