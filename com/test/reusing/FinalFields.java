package com.test.reusing;

public class FinalFields {
  public final int width;
  static final int length = 100;

  FinalFields() {
    width = Integer.MAX_VALUE;
    //Final field should be initialized before use.
  }

  FinalFields(int i) {
    System.out.println("Create new object.");
    width = i;
  }

  public static void main(String[] args) {
    FinalFields x = new FinalFields(53);
    System.out.println("The final field = " + x.width
        + ". The static final field = " + length + ".");
    FinalFields y = new FinalFields();
    System.out.println("The final field = " + y.width
        + ". The static final field = " + length + ".");
    //y.width = Integer.MIN_VALUE;
    //Cannot assign a value to final variable 'width'.
  }
}
