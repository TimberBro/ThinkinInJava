package com.test.exceptions;

class IncorrectName extends Exception {}

class FailingConstructor {
  private String name;

  FailingConstructor(String name, boolean correctName) throws IncorrectName {
    if (correctName) {
      throw new IncorrectName();
    }
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
        }
      } catch (IncorrectName e) {
        System.out.println("Caught error: " + e);
      }
    }
  }
}
