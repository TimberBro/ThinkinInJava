package com.test.reusing;

public class NameHiding {
  void sound(int i) {
      System.out.println("Bark");
  }
  void sound(float f) {
    System.out.println("Squawk");
  }
  void sound(char c) {
    System.out.println("Meow");
  }
}

class Animal extends NameHiding {
  void sound(String x) {
    System.out.println("Honk!");
  }

  public static void main(String[] args) {
    Animal x = new Animal();
    x.sound(3);
    x.sound('a');
    x.sound(2.3f);
    x.sound("FS");
  }
}
