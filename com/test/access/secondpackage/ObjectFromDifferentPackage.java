package com.test.access.secondpackage;

public class ObjectFromDifferentPackage {
  public static void main(String[] args) {
    com.test.access.firstpackage.ClassInsidePackage pc =
        new com.test.access.firstpackage.ClassInsidePackage();
  }
}
