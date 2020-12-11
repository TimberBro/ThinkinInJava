package com.test.operators;


import static com.test.util.Print.*;

public class Aliasing {

  public static void main(String[] args) {
    Tank t1 = new Tank();
    Tank t2 = new Tank();
    t1.level = 22.3f;
    t2.level = 876575.5f;
    print("1: t1.level: " + t1.level + ", t2.level: " + t2.level);
    t1 = t2;
    print("2: t1.level: " + t1.level + ", t2.level: " + t2.level);
    t1.level = -387f;
    print("3: t1.level: " + t1.level + ", t2.level: " + t2.level);
  }
}
