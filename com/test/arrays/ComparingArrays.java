package com.test.arrays;

import java.util.Arrays;
import java.util.Objects;

class House {
  int id;

  House(int i) {
    id = i;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    House house = (House) o;
    return id == house.id;
  }
}

public class ComparingArrays {
  public static void main(String[] args) {
    House[] house1 = new House[5];
    House[] house2 = new House[5];
    Arrays.fill(house1, new House(1));
    Arrays.fill(house2, new House(1));
    // Will return false, if you comment or delete equals method.
    System.out.println(Arrays.equals(house1, house2));
  }
}
