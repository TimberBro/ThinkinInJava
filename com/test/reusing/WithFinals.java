package com.test.reusing;

class WithFinals {
  public void f() {
    System.out.println("WithFinals.f()");
  }

  public void g() {
    System.out.println("WithFinals.g()");
  }
}

class OverridingPrivate extends WithFinals {
  @Override
  public void f() {
    System.out.println("OverridingPrivate.f()");
  }

  @Override
  public void g() {
    System.out.println("OverridingPrivate.g()");
  }
}
