package com.test.reusing;

public class Final {
  public final int Number;

  Final() {
    Number = 1;
  }

  Final(int i) {
    Number = i;
  }

  public static void main(String[] args) {
    Final x = new Final(2);
    System.out.println(x.Number);
  }
}
