package com.test.reusing;

class Art {
  Art() {
    System.out.println("Art constructor");
  }
}

class Drawing extends Art {
  Drawing() {
    System.out.println("Drawing constructor");
  }
}

public class Cartoon extends Drawing {
  // Compiler will synthesize default constructor.

  public static void main(String[] args) {
    Cartoon x = new Cartoon();
  }
}
