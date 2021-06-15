package com.test.typeinfo;

class A {}

class B extends A {}

class C extends B {}

public class ObjectHierarchy {

  static void getHierarchy(Object object) {
    if (object.getClass().getSuperclass() != null) {
      System.out.println(object.getClass());
      try {
        getHierarchy(object.getClass().getSuperclass().newInstance());
      } catch (IllegalAccessException e) {
        System.err.println("Unable to access.");
        e.printStackTrace();
      } catch (InstantiationException e) {
        System.err.println("Unable to initiate.");
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    getHierarchy(new C());
  }
}
