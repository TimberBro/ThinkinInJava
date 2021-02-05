package com.test.reusing;

class Lake {
  int Depth = 5;

  Lake() {
    System.out.println("Lake created");
  }
}

public class Duck {
  private Lake Baikal;

  public void swim() {
    if (Baikal == null) Baikal = new Lake();
    System.out.println("Swimming on the Lake");
  }

  public static void main(String[] args) {
    Duck X = new Duck();
    System.out.println("Before function");
    X.swim();
  }
}
