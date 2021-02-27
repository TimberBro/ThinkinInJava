package com.test.reusing;

public class Frog extends Amphibian {

  Frog(String color, int numberOfLegs, int length) {
    super(color, numberOfLegs, length);
  }

  /***
   *
   * @return Body length in mm
   */
  @Override
  public int getLength() {
    return 100*super.getLength();
  }

  @Override
  public int getNumberOfLegs() {
    return  super.getNumberOfLegs();
  }

  @Override
  public String getColor() {
    return "Frog color = " + super.getColor();
  }

  public static void main(String[] args) {
    Frog frog = new Frog("Green", 4, 5);
    System.out.println(frog.getColor());
    System.out.println(frog.getNumberOfLegs());
    System.out.println(frog.getLength());
  }
}
