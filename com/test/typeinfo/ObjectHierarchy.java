package com.test.typeinfo;

import java.util.Arrays;

class A {
  int number;
  long price;
}

class B extends A {
  String name;
}

class C extends B {
  String forname;
  String status;
}

public class ObjectHierarchy {

  static void getHierarchy(Object object) {
    if (object.getClass().getSuperclass() != null) {
      System.out.println(object.getClass());
      System.out.println(Arrays.toString(object.getClass().getDeclaredFields()));
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
