package com.test.arrays;

import java.util.ArrayList;

class Banana {
  private final int id;
  private static int counter;

  Banana() {
    id = counter++;
  }

  public String toString() {
    return "Banana " + id;
  }
}

public class Peel<T> {
  T plant;

  Peel(T plant) {
    this.plant = plant;
  }

  void peel() {
    System.out.println(plant + " is peeled.");
  }

  public static void main(String[] args) {
    // java: generic array creation
    // Peel<Banana>[] a = new Peel<Banana>[5];
    ArrayList<Peel<Banana>> arrayList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      arrayList.add(new Peel<Banana>(new Banana()));
    }
    for (Peel<Banana> banana : arrayList) {
      banana.peel();
    }
  }
}
