package com.test.polymorphism.animals;


import com.test.polymorphism.Shared;

class Tail {
  public int length;

  Tail() {
    System.out.println("Tail constructor");
  }
}

public class Rodent {
  private final Shared shared;
  void type() {
    System.out.println("This is base type");
  }

  private Tail tail = new Tail();

  Rodent(Shared shared) {
    System.out.println("Rodent constructor");
    tail.length = 15;
    this.shared = shared;
    this.shared.addRef();
  }

  public static void main(String[] args) {
    System.out.println("Array declared");
    Shared shared = new Shared();
    Rodent[] rodents = {new Mouse(shared), new Gerbil(shared), new Hamster(shared), new Rodent(shared)};
    System.out.println("Array filled");
    shared.showRefcount();
    for (Rodent value : rodents) {
      value.type();
    }
  }
}

class Mouse extends Rodent {
  private Tail tail = new Tail();
  private final Shared shared;

  void type() {
    System.out.println("This is mouse");
  }

  Mouse(Shared shared) {
    super(shared);
    System.out.println("Mouse constructor");
    tail.length = 5;
    this.shared = shared;
  }
}

class Gerbil extends Rodent {
  private Tail tail = new Tail();
  private final Shared shared;

  void type() {
    System.out.println("This is gerbil");
  }

  Gerbil(Shared shared) {
    super(shared);
    this.shared = shared;
    System.out.println("Gerbil constructor");
    tail.length = 2;
  }
}

class Hamster extends Rodent {
  private Tail tail = new Tail();
  private final Shared shared;

  void type() {
    System.out.println("This is hamster");
  }

  Hamster(Shared shared) {
    super(shared);
    this.shared = shared;
    System.out.println("Hamster constructor");
    tail.length = 1;
  }
}
