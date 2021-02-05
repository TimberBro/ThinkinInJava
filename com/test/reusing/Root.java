package com.test.reusing;

class Component1 {
  Component1(int i) {
    System.out.println("This is component 1");
  }
}

class Component2 {
  Component2(double f) {
    System.out.println("This is component 2");
  }
}

class Component3 {
  Component3(char c) {
    System.out.println("This is component 3");
  }
}

public class Root {
  Root(String x) {
    Component1 c1 = new Component1(1);
    Component2 c2 = new Component2(2.3);
    Component3 c3 = new Component3('a');
  }
}

class Stem extends Root {
  Stem() {
    super("2");
    Component1 x1 = new Component1(2);
    Component2 x2 = new Component2(3.5);
    Component3 x3 = new Component3('2');
  }

  public static void main(String[] args) {
    Stem d = new Stem();
  }
}
