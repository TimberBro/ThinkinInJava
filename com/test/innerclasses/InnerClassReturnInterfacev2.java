package com.test.innerclasses;

interface Airplanev2 {
  void fly();
}

public class InnerClassReturnInterfacev2 {

  Airplanev2 getAirplane() {
    return new Airplanev2() {
      @Override
      public void fly() {
        System.out.println("Flying away!");
      }
    };
  }

  public static void main(String[] args) {
    InnerClassReturnInterfacev2 innerClassReturnInterfacev2 = new InnerClassReturnInterfacev2();
    innerClassReturnInterfacev2.getAirplane().fly();
  }
}
