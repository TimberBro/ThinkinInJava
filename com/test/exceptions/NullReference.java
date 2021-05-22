package com.test.exceptions;

public class NullReference {

  public static void main(String[] args) {
    String string = null;
    try {
      string.toString();
    } catch (NullPointerException e) {
      System.out.println("Catch an error:");
      e.printStackTrace();
    }
  }

  public static void main() {
    String string = null;
    string.toString();
  }
}
