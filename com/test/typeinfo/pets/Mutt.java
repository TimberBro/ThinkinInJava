// : typeinfo/pets/Mutt.java
package com.test.typeinfo.pets;

public class Mutt extends Dog {

  public static class Factory implements com.test.typeinfo.factory.Factory<Mutt> {
    public Mutt create() {
      return new Mutt();
    }
  }
} /// :~
