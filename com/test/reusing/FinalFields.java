package com.test.reusing;

public class FinalFields {
  final int width;
  static final int length = 100;

  FinalFields(int i) {
    System.out.println("Create new object.");
    width = i;
  }

  public static void main(String[] args) {
    FinalFields x = new FinalFields(53);
    System.out.println("The final field = " + x.width + ". The static final field = " + length + ".");
    FinalFields y = new FinalFields(68);
    System.out.println("The final field = " + y.width + ". The static final field = " + length + ".");
    /*
    Final field might be unique for every object and will be not changeable.
    Static final field will be the same for every object and will not be changeable.
     */
  }
}
