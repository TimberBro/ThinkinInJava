package com.test.exceptions;

class NullString extends RuntimeException {
  String msg;

  NullString(String str) {
    this.msg = str;
  }

  @Override
  public String getMessage() {
    return msg;
  }
}

public class MyException {

  // Compiler won't force you to use try-catch block, if your exception inherit from
  // RuntimeException
  public static void main(String[] args) {
    throw new NullString("StringNotFound");
  }
}
