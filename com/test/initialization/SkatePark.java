package com.test.initialization;

interface CycleV2 {
  void ride();
}

interface CycleFactoryV2 {
  CycleV2 getCycle();
}

class Unicycle implements CycleV2 {

  @Override
  public void ride() {
    System.out.println("Ride on one wheel.");
  }

  public static CycleFactoryV2 factory =
      new CycleFactoryV2() {
        public CycleV2 getCycle() {
          return new Unicycle();
        }
      };
}

class Bicycle implements CycleV2 {

  @Override
  public void ride() {
    System.out.println("Ride on two wheels.");
  }

  public static CycleFactoryV2 factory =
      new CycleFactoryV2() {
        public CycleV2 getCycle() {
          return new Bicycle();
        }
      };
}

class Tricycle implements CycleV2 {

  @Override
  public void ride() {
    System.out.println("Ride on three wheels.");
  }

  public static CycleFactoryV2 factory =
      new CycleFactoryV2() {
        public CycleV2 getCycle() {
          return new Tricycle();
        }
      };
}

public class SkatePark {
  public static void chooseCycle(CycleFactoryV2 factory) {
    CycleV2 cycle = factory.getCycle();
    cycle.ride();
  }

  public static void main(String[] args) {
    chooseCycle(Unicycle.factory);
    chooseCycle(Bicycle.factory);
    chooseCycle(Tricycle.factory);
  }
}
