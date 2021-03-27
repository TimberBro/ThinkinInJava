package com.test.interfaces.cycles;

interface Cycle {
  void ride();
}

interface CycleFactory {
  Cycle getCycle();
}

class Unicycle implements Cycle {

  @Override
  public void ride() {
    System.out.println("Ride on one wheel.");
  }
}

class UnicycleFactory implements CycleFactory {

  @Override
  public Cycle getCycle() {
    return new Unicycle();
  }
}

class Bicycle implements Cycle {

  @Override
  public void ride() {
    System.out.println("Ride on two wheels.");
  }
}

class BicycleFactory implements CycleFactory {

  @Override
  public Bicycle getCycle() {
    return new Bicycle();
  }
}

class Tricycle implements Cycle {

  @Override
  public void ride() {
    System.out.println("Ride on three wheels.");
  }
}

class TricycleFactory implements CycleFactory {

  @Override
  public Cycle getCycle() {
    return new Tricycle();
  }
}

public class SkatePark {
  public static void chooseCycle(CycleFactory factory) {
    Cycle cycle = factory.getCycle();
    cycle.ride();
  }

  public static void main(String[] args) {
    chooseCycle(new UnicycleFactory());
    chooseCycle(new BicycleFactory());
    chooseCycle(new TricycleFactory());
  }
}
