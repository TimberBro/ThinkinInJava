package com.test.typeinfo;

class Candy {
  static {
    System.out.println("Loading Candy");
  }
}

class Gum {
  static {
    System.out.println("Loading Gum");
  }
}

class Cookie {
  static {
    System.out.println("Loading Cookie");
  }
}

public class Sweetshop {
  public static void main(String[] args) {
    try {
      Class.forName("com.test.typeinfo." + args[0]);
    } catch (ClassNotFoundException e) {
      System.out.println("Couldn't find " + args[0]);
    }
  }
}
