package com.test.reusing;

class Component1 {
  Component1(int i) {
    System.out.println("This is component1 " + i);
  }

  void dispose() {
    System.out.println("Component1 was disposed.");
  }
}

class Component2 {
  Component2(double f) {
    System.out.println("This is component2 " + f);
  }

  void dispose() {
    System.out.println("Component2 was disposed.");
  }
}

class Component3 {
  Component3(char c) {
    System.out.println("This is component3 " + c);
  }

  void dispose() {
    System.out.println("Component3 was disposed.");
  }
}

public class Root {
  Component1 c1 = new Component1(1);
  Component2 c2 = new Component2(2.3);
  Component3 c3 = new Component3('♂');

  Root(String x) {}

  void dispose() {
    c1.dispose();
    c2.dispose();
    c3.dispose();
    System.out.println("Root was disposed.");
  }
}

class Stem extends Root {
  Component1 x1 = new Component1(2);
  Component2 x2 = new Component2(3.5);
  Component3 x3 = new Component3('▲');

  Stem(boolean b) {
    super("string");
  }

  @Override
  void dispose() {
    super.dispose();
    x1.dispose();
    x2.dispose();
    x3.dispose();
    System.out.println("Stem was disposed.");
  }

  public static void main(String[] args) {
    Stem d = new Stem(true);
    d.dispose();
  }
}
