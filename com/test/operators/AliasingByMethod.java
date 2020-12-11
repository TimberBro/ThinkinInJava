package com.test.operators;

import static com.test.util.Print.print;

public class AliasingByMethod {

  static void f(Tank x) {
    x.level = 45678.90f;
  }

  public static void main(String[] args) {
    Tank tank = new Tank();
    tank.level = 3.5f;
    print("1: tank.level: " + tank.level);
    f(tank);
    print("2: tank.level: " + tank.level);
  }
}
