// : typeinfo/pets/Hamster.java
package com.test.typeinfo.pets;

public class Hamster extends Rodent {

  public static class Factory implements com.test.typeinfo.factory.Factory<Hamster> {
    public Hamster create() {
      return new Hamster();
    }
  }
} /// :~
