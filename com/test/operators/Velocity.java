package com.test.operators;

import static com.test.util.Print.print;

public class Velocity {

  static int calculateVelocity(int distance, int time) {
    if (time == 0) {
      return 0;
    }
    return (distance / time);
  }

  static float calculateVelocity(float distance, float time) {
    if (time == 0) {
      return 0;
    }
    return (distance / time);
  }

  public static void main(String[] args) {
    float x = 12;
    float y = 3;
    print(calculateVelocity(x, y));
  }
}
