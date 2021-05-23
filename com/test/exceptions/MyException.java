package com.test.exceptions;

class NullString extends Exception {
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

  public static void main(String[] args) {
    try {
      throw new NullString("StringNotFound");
    } catch (NullString e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
