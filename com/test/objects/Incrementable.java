package com.test.objects;



public class Incrementable {
  static class StaticTest {
    static int i = 47;
  }

  static void increment() {
    StaticTest.i++;
  }

  public static void main(String[] args) {
    System.out.println(StaticTest.i);
    Incrementable.increment();
    System.out.println(StaticTest.i);
  }
}