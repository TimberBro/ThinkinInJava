// : typeinfo/pets/Dog.java
package com.test.typeinfo.pets;

public class Dog extends Pet {

  public static class Factory implements com.test.typeinfo.factory.Factory<Dog> {
    public Dog create() {
      return new Dog();
    }
  }
} /// :~
