package com.test.interfaces.animalsV2;

public class MouseV2 implements RodentV2 {
  public void type() {
    System.out.println("This is mouse");
  }

  MouseV2() {
    System.out.println("Mouse constructor");
  }

  public static void main(String[] args) {
    System.out.println("Array declared");
    RodentV2[] rodents = {new MouseV2(), new GerbilV2(), new HamsterV2()};
    System.out.println("Array filled");
    for (RodentV2 value : rodents) {
      value.type();
    }
  }
}

class GerbilV2 implements RodentV2 {
  public void type() {
    System.out.println("This is gerbil");
  }

  GerbilV2() {
    System.out.println("Gerbil constructor");
  }
}

class HamsterV2 implements RodentV2 {
  public void type() {
    System.out.println("This is hamster");
  }

  HamsterV2() {
    System.out.println("Hamster constructor");
  }
}
