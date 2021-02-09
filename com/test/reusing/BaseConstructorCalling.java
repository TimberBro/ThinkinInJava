package com.test.reusing;

public class BaseConstructorCalling {
  BaseConstructorCalling(int i) {
    System.out.println("This is non-default constructor in base class with argument = " + i);
  }
}

class DerivedClass extends BaseConstructorCalling {
  DerivedClass(int i) {
    super(i);
    System.out.println("This is non-default constructor in derived class with argument = " + i);
  }

  DerivedClass() {
    super(11);
    System.out.println("This is default constructor in derived class without argument");
  }

  public static void main(String[] args) {
    DerivedClass x = new DerivedClass(2);
    DerivedClass y = new DerivedClass();
  }
}
