package com.test.reusing;

public class NameHiding {
  void bark(int i) {
    for (int x = 0; x < i; x++) {
      System.out.println("Bark");
    }
  }

  void bark(float f) {
    System.out.println("Squawk");
  }

  void bark(char c) {
    System.out.println("Meow!");
  }
}

class Animal extends NameHiding {
  void bark(String x) {
    System.out.println("Honk!");
  }

  public static void main(String[] args) {
    Animal x = new Animal();
    x.bark(3);
    x.bark('a');
    x.bark(2.3f);
    x.bark("FS");
  }
}
