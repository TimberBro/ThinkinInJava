package com.test.polymorphism;

class Unicycle extends Cycle {
  Unicycle() {
    numberOfWheels = 1;
  }

  void balance() {
    System.out.println("Balance on one wheel.");
  }
}

class Bicycle extends Cycle {
  Bicycle() {
    numberOfWheels = 2;
  }

  void balance() {
    System.out.println("Balance on two wheels.");
  }
}

class Tricycle extends Cycle {
  Tricycle() {
    numberOfWheels = 3;
  }
}

public class Cycle {
  public void ride() {
    System.out.println("This is cycle");
    System.out.println("Number of wheels = " + wheels());
  }

  public int wheels() {
    return numberOfWheels;
  }

  protected int numberOfWheels = 0;

  public static void main(String[] args) {
    Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};
    /*
    for (Cycle i : cycles) {
      i.balance(); // Compile error: Method not found.
    }
    */
    ((Unicycle) cycles[0]).balance();
    ((Bicycle) cycles[1]).balance();
    //((Tricycle)cycles[2]).balance(); // Compile error: Method not found.
    //((Unicycle)cycles[2]).balance(); // Run Time Error: Tricycle cannot be cast to Unicycle error

  }
}
