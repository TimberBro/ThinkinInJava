package com.test.generics;

import java.util.ArrayList;
import java.util.List;

public class ListCovariance {
  public static void main(String[] args) {
    // incompatible types: java.util.ArrayList<java.lang.Integer> cannot be converted to java.util.List<java.lang.Number>
    // List<Number> numbers = new ArrayList<Integer>();
    List<? extends Number> numbers = new ArrayList<Integer>();
    /*
    java: no suitable method found for add(java.lang.Integer)
    java: no suitable method found for add(java.lang.Double)
    java: no suitable method found for add(java.lang.Long)
    numbers.add(new Integer(1));
    numbers.add(new Double(1.2));
    numbers.add(new Long(125151));
     */
  }
}
