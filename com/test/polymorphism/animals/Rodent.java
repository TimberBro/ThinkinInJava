package com.test.polymorphism.animals;

public class Rodent {
  void type() {
    System.out.println("This is base type");
  }

  Rodent() {
    System.out.println("Rodent constructor");
  }

  public static void main(String[] args) {
    System.out.println("Array declared");
    Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster(), new Rodent()};
    System.out.println("Array filled");
    for (Rodent value : rodents) {
      value.type();
    }
  }
}

class Mouse extends Rodent {
  void type() {
    System.out.println("This is mouse");
  }

  Mouse() {
    System.out.println("Mouse constructor");
  }
}

class Gerbil extends Rodent {
  void type() {
    System.out.println("This is gerbil");
  }

  Gerbil() {
    System.out.println("Gerbil constructor");
  }
}

class Hamster extends Rodent {
  void type() {
    System.out.println("This is hamster");
  }

  Hamster() {
    System.out.println("Hamster constructor");
  }
}
