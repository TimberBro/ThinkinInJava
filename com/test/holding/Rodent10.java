package com.test.holding;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Rodent10 {
  void type() {
    System.out.println("This is base type");
  }

  Rodent10() {
    System.out.println("Rodent10 constructor");
  }

  public static void main(String[] args) {
    List<Rodent10> rodents = Arrays.asList(new Mouse10(), new Gerbil10(),
        new Hamster10(), new Rodent10());
    System.out.println("List declared and filled");
    Iterator<Rodent10> iterator = rodents.iterator();
    while (iterator.hasNext()) {
      iterator.next().type();
    }
  }
}

class Mouse10 extends Rodent10 {
  void type() {
    System.out.println("This is mouse");
  }

  Mouse10() {
    System.out.println("Mouse10 constructor");
  }
}

class Gerbil10 extends Rodent10 {
  void type() {
    System.out.println("This is gerbil");
  }

  Gerbil10() {
    System.out.println("Gerbil10 constructor");
  }
}

class Hamster10 extends Rodent10 {
  void type() {
    System.out.println("This is hamster");
  }

  Hamster10() {
    System.out.println("Hamster10 constructor");
  }
}
