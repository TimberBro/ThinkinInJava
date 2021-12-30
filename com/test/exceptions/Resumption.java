package com.test.exceptions;

public class Resumption {
  public static void main(String[] args) {
    int j = 0;
    while (j < 10) {
      try {
        if (j < 5) {
          throw new IllegalArgumentException("value of j less than 5.");
        } else {
          System.out.println("J is ready to use.");
        }
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      }
      j++;
    }
  }
}
