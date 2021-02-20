package com.test.reusing;

class Amphibian {

  /***
   * Color of the skin
   */
  private String color;
  private int numberOfLegs;
  /***
   * Length in cm
   */
  private int length;

  public int getLength() {
    return length;
  }

  public int getNumberOfLegs() {
    return numberOfLegs;
  }

  public String getColor() {
    return color;
  }

  /***
   *
   * @param color Color of the skin
   * @param numberOfLegs Number of legs
   * @param length Length in cm
   */
  Amphibian(String color, int numberOfLegs, int length) {
    this.color = color;
    this.numberOfLegs = numberOfLegs;
    this.length = length;
  }
}
