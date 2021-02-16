package com.test.reusing;

class Component1 {
  Component1() {
    System.out.println("This is component1");
  }
}

class Component2 {
  Component2() {
    System.out.println("This is component2");
  }
}

class Component3 {
  Component3() {
    System.out.println("This is component3");
  }
}

public class Root {
  Root() {
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();
  }
}

class Stem extends Root {
  Stem() {
    super();
    Component1 x1 = new Component1();
    Component2 x2 = new Component2();
    Component3 x3 = new Component3();
  }

  public static void main(String[] args) {
    Stem d = new Stem();
  }
}
