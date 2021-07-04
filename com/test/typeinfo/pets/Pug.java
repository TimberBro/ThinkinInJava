// : typeinfo/pets/Pug.java
package com.test.typeinfo.pets;

public class Pug extends Dog {

  public static class Factory implements com.test.typeinfo.factory.Factory<Pug> {
    public Pug create() {
      return new Pug();
    }
  }
} /// :~
