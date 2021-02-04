package com.test.access.secondpackage;

import com.test.access.ProtectedMethod;

public class ProtectedMethodOutsidePackage {
  public static void main(String[] args) {
    //ProtectedMethod.bark(); // 'bark()' has protected access in 'com.test.access.ProtectedBark'
  }
}
