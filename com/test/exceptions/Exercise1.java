package com.test.exceptions;

public class Exercise1 {
  public static void main(String[] args) {
    try {
      throw new Exception("This is exception in main.");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      System.out.println("Finally.");
    }
  }
}
