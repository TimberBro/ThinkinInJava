package com.test.reusing;

public class Frog extends Amphibian {

  Frog(String color, int numberOfLegs, int length) {
    super(color, numberOfLegs, length);
  }

  public static void main(String[] args) {
    Frog frog = new Frog("Green", 4, 5);
    System.out.println(frog.getColor());
    System.out.println(frog.getNumberOfLegs());
    System.out.println(frog.getLength());
  }
}
