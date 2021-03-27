package com.test.interfaces;

public abstract class AbstractPrint {
  abstract void print();

  AbstractPrint() {
    print();
  }
}

class OverriddenPrint extends AbstractPrint {

  int x = 365;

  @Override
  void print() {
    System.out.println(x);
  }

  public static void main(String[] args) {
    OverriddenPrint y = new OverriddenPrint();
    y.print();
    // Java allocate space for a new OverriddenPrint object. Then, to create a derived object,
    // we need to create (= call constructors) of all the super classes.
    // When we called AbstractPrint() it called print(), that should print value of x.
    // Because we're called it before our derived class was created
    // Java initialized integer value to 0.
  }
}
