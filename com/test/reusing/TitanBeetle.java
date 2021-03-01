
package com.test.reusing;

public class TitanBeetle extends Beetle {
  private int y = printInit("TitanBeetle.y initialized");

  public TitanBeetle() {
    System.out.println("y = " + y);
    System.out.println("j = " + j);
  }

  private static int x3 = printInit("static TitanBeetle.x3 initialized");

  public static void main(String[] args) {
    System.out.println("TitanBeetle constructor");
    TitanBeetle t = new TitanBeetle();
  }
}
