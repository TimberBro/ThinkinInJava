package com.test.typeinfo.pets;

public class Cat extends Pet {

  public static class Factory implements com.test.typeinfo.factory.Factory<Cat> {
    public Cat create() {
      return new Cat();
    }
  }
} /// :~
