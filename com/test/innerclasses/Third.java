package com.test.innerclasses;

class NoDefault {
  private int i;

  public int getField() {
    return i;
  }

  NoDefault(int i) {
    this.i = i;
  }
}

class Second {

  NoDefault getNoDefault(int i) {
    return new NoDefault(i) {};
  }
}

public class Third {
  public static void main(String[] args) {
    NoDefault noDefault = new Second().getNoDefault(15);
  }
}
