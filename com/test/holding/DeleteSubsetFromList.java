package com.test.holding;

import java.util.*;

class Car {
  private int id;
  private static int counter = 0;

  Car() {
    this.id = counter++;
  }

  @Override
  public String toString() {
    return "{Car" + " id=" + id + '}';
  }
}

public class DeleteSubsetFromList {

  public static void main(String[] args) {
    List<Car> cars = Arrays.asList(new Car(), new Car(), new Car(), new Car(), new Car());
    //Created an initialized array of my objects and filled a List from my array.
    System.out.println("1: cars: " + cars);
    //Created a subset of my List by using subList()
    List<Car> cars1 = cars.subList(1, 4);
    System.out.println("2: sub: " + cars1);
    // cars.removeAll(cars1); will give java.lang.UnsupportedOperationException
    // Because Arrays.asList returns a fixed-size list backed by the specified array.
    // We cannot delete from fixed-size list.
    List<Car> copy = new ArrayList<>(cars);
    copy.removeAll(cars1);
    cars = copy;
    System.out.println("3: cars: " + cars);
  }
}
