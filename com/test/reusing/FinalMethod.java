package com.test.reusing;

public class FinalMethod {
  int height;

  final void printHeight() {
    System.out.println(height);
  }

  FinalMethod(int i) {
    height = i;
  }
}

class FinalMethod2 extends FinalMethod {

  FinalMethod2(int i) {
    super(i);
  }

  /*
  @Override
  void printHeight() {
    System.out.println(height);
  }
  Get an error: 'printHeight()' cannot override 'printHeight()' in
  'com.test.reusing.FinalMethod'; overridden method is final
  */

  public static void main(String[] args) {

  }
}
