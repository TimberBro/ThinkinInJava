package com.test.exceptions;

class IncorrectName extends Exception {}

class DisposableObject {
  private static int counter;
  private final int id;

  DisposableObject() {
    id = ++counter;
  }

  void dispose() {
    System.out.println("Object " + id + " was disposed.");
    counter--;
  }
}

public class FailingConstructor {
  private String name;

  DisposableObject disposable1;
  DisposableObject disposable2;

  FailingConstructor(String name, boolean correctName) throws IncorrectName {
    disposable1 = new DisposableObject();
    try {
      if (correctName) {
        throw new IncorrectName();
      }
    } catch (IncorrectName e) {
      disposable1.dispose();
      throw e;
    }
    disposable2 = new DisposableObject();
  }

  void dispose() {
    disposable1.dispose();
    disposable2.dispose();
    System.out.println("Main object was disposed");
  }

  public static void main(String[] args) {
    boolean[] b = {true, false};
    for (boolean bool : b) {
      try {
        System.out.println("Before constructor call");
        FailingConstructor constructor = new FailingConstructor("John", bool);
        try {
          System.out.println("Inner try");
        } finally {
          System.out.println("Finally");
          constructor.dispose();
        }
      } catch (IncorrectName e) {
        System.out.println("Caught error: " + e);
      }
    }
  }
}
