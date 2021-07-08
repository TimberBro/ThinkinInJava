package com.test.exceptions;

class Annoyance extends RuntimeException {}

class Sneeze extends Annoyance {}

public class Human {

  static void throwRuntimeException(int type) {
    try {
      switch (type) {
        case 0:
          throw new Sneeze();
        case 1:
          throw new Annoyance();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    try {
      throwRuntimeException(0);
    } catch (RuntimeException re) {
      try {
        throw re.getCause();
      } catch (Sneeze s) {
        System.out.println("Caught Sneeze");
      } catch (Annoyance a) {
        System.out.println("Caught Annoyance");
      } catch (Throwable t) {
        System.out.println("Throwable: " + t);
      }
    }
  }
}
