package com.test.interfaces;

interface BaseInterface {
  void f();
}

interface FirstNode extends BaseInterface {
  void f();
}

interface SecondNode extends BaseInterface {
  void f();
}

interface ThirdNode extends FirstNode, SecondNode {
  void f();
}

class Worker implements ThirdNode {
  public void f() {
    System.out.println("ThirdNode.f()"); //class must reimplement the method,
    // or the ambiguity will be rejected as a compile error
  }
}

public class DiamondProblem {
  public static void main(String[] args) {
    Worker worker = new Worker();
    worker.f();
  }
}
