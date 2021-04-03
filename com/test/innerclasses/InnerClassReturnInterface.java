package com.test.innerclasses;

interface Airplane {
  void fly();
}

public class InnerClassReturnInterface {

  Airplane getAirplane() {
      {
      class Airport implements Airplane {
        @Override
        public void fly() {
          System.out.println("Flying away!");
        }
      }

      return new Airport();
      }
  }

  public static void main(String[] args) {
    InnerClassReturnInterface innerClassReturnInterface = new InnerClassReturnInterface();
    innerClassReturnInterface.getAirplane().fly();
  }
}
