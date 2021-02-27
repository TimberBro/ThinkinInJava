package com.test.reusing;

class WithFinals {
  // Identical to "private" alone:
  private void f() {
    System.out.println("WithFinals.f()");
  }
  // Also automatically "final":
  private void g() {
    System.out.println("WithFinals.g()");
  }
}

class OverridingPrivate extends WithFinals {
  //@Override will give "method does not override or implement a method from a supertype" on compilation
  private void f() {
    System.out.println("OverridingPrivate.f()");
  }

  //@Override will give "method does not override or implement a method from a supertype" on compilation
  private void g() {
    System.out.println("OverridingPrivate.g()");
  }
}

class OverridingPrivate2 extends OverridingPrivate {
  //@Override will give "method does not override or implement a method from a supertype" on compilation
  public final void f() {
    System.out.println("OverridingPrivate2.f()");
  }

  //@Override will give "method does not override or implement a method from a supertype" on compilation
  public void g() {
    System.out.println("OverridingPrivate2.g()");
  }

  public class FinalOverridingIllusion {}
}

public class FinalOverridingIllusion {
  public static void main(String[] args) {
    OverridingPrivate2 op2 = new OverridingPrivate2();
    op2.f();
    op2.g();
    // You can upcast:
    OverridingPrivate op = op2;
    // But you can't call the methods:
    // ! op.f();
    // ! op.g();
    // Same here:
    WithFinals wf = op2;
    // ! wf.f () ;
    // ! wf.g();
  }
}
