package com.test.containers;

import com.test.util.Countries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffledList {
  public static void main(String[] args) {
    List<String> countries = new ArrayList<>(Countries.names());
    System.out.println("Original list: " + countries);
    Collections.sort(countries);
    System.out.println("Sorted list: " + countries);
    Collections.shuffle(countries);
    System.out.println(countries);
    Collections.shuffle(countries);
    System.out.println(countries);
    Collections.shuffle(countries);
    System.out.println(countries);
    Collections.shuffle(countries);
  }
}
