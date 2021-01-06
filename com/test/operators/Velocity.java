package com.test.operators;

import static com.test.util.Print.print;

public class Velocity {
  static float calculateVelocity(float distance, float time) {
    return (distance / time);
  }

  public static void main(String[] args) {
    float x = 12;
    float y = 0;
    print(calculateVelocity(x, y));
  }
}
