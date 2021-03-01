package com.test.polymorphism;

class Unicycle extends Cycle {
  Unicycle() {
    NumberOfWheels = 1;
  }

  public void balance() {
    System.out.println("Balance on 1 wheel.");
  }
}

class Bicycle extends Cycle {
  Bicycle() {
    NumberOfWheels = 2;
  }

  public void balance() {
    System.out.println("Balance on 2 wheels.");
  }
}

class Tricycle extends Cycle {
  Tricycle() {
    NumberOfWheels = 3;
  }

  public void balance() {
    System.out.println("Balance on 3 wheels.");
  }
}

public class Cycle {
  public void ride() {
    System.out.println("This is cycle");
  }

  protected int NumberOfWheels = 0;

  protected void wheels() {
    System.out.println("Number of wheels: " + NumberOfWheels);
  }

  public static void main(String[] args) {
    Unicycle x = new Unicycle();
    Bicycle y = new Bicycle();
    Tricycle z = new Tricycle();
    x.ride();
    y.ride();
    z.ride();
    x.wheels();
    y.wheels();
    z.wheels();
    Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};
    ((Unicycle) cycles[0]).balance();
    ((Bicycle) cycles[1]).balance();
    // cycles[3].balance();
  }
}
