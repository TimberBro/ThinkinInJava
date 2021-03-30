package com.test.innerclasses.separateclasses;

public class Keyboard {

  class KeyCaps {
    int price;
    String color;

    KeyCaps(int price, String color) {
      this.color = color;
      this.price = price;
      System.out.println("KeyCaps created.");
    }
  }
}
