package com.test.operators;

import static com.test.util.Print.print;

public class Dog {
  String name;
  String says;

  Dog(String name, String says) {
    this.name = name;
    this.says = says;
  }

  public String getName() {
    return name;
  }

  public String voice() {
    return says;
  }

  static void compareDogs(Dog x, Dog y) {
    System.out.println("Compare " + x.getName() + " and " + y.getName());
    System.out.print(x.getName() + " == " + y.getName() + " is ");
    System.out.println(x == y);
    System.out.print(x.getName() + " equals " + y.getName() + " is ");
    System.out.println(x.equals(y));
    System.out.println();
  }

  public static void main(String[] args) {
    Dog spot = new Dog("spot", "Ruff!");
    Dog scruffy = new Dog("scruffy", "Wurf!");
    print("Dog1: name is " + spot.getName() + ", says " + spot.voice());
    print("Dog2: name is " + scruffy.getName() + ", says " + scruffy.voice());
    Dog zidan = spot;
    compareDogs(spot, scruffy);
    compareDogs(scruffy, zidan);
    compareDogs(spot, zidan);
  }
}
