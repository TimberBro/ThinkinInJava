package com.test.innerclasses;

interface U {
  void f();

  void g();

  void h();
}

class A {
  public U getU() {
    return new U() {
      @Override
      public void f() {
        System.out.println("A.f()");
      }

      @Override
      public void g() {
        System.out.println("A.g()");
      }

      @Override
      public void h() {
        System.out.println("A.h()");
      }
    };
  }
}

class B {
  U[] arrayU;

  B(int i) {
    arrayU = new U[i];
  }

  boolean putItem(U u) {
    for (int i = 0; i < arrayU.length; i++) {
      if (arrayU[i] == null) {
        arrayU[i] = u;
        return true;
      }
    }
    return false;
  }

  boolean deleteItem(int i) {
    if (i < 0 || i >= arrayU.length) {
      return false;
    }
    arrayU[i] = null;
    return true;
  }

  void callU() {
    for (int i = 0; i < arrayU.length; i++) {
      if (arrayU[i] != null) {
        arrayU[i].f();
        arrayU[i].g();
        arrayU[i].h();
      }
    }
  }
}

public class C {

  public static void main(String[] args) {
    A[] arrayA = {new A(), new A(), new A(), new A()};
    B b = new B(5);
    for (int i = 0; i < arrayA.length; i++) {
      b.putItem(arrayA[i].getU());
    }
    b.callU();
    System.out.println("Delete item 0");
    b.deleteItem(0);
    b.deleteItem(3);
    b.callU();
  }
}
