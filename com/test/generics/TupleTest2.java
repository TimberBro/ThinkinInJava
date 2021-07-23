package com.test.generics;

import static com.test.util.Tuple.tuple;

import com.test.util.FiveTuple;
import com.test.util.FourTuple;
import com.test.util.SixTuple;
import com.test.util.ThreeTuple;
import com.test.util.TwoTuple;

public class TupleTest2 {
  static TwoTuple<String, Integer> f() {
    return tuple("hi", 47);
  }

  static TwoTuple f2() {
    return tuple("hi", 47);
  }

  static ThreeTuple<Amphibian, String, Integer> g() {
    return tuple(new Amphibian(), "hi", 47);
  }

  static FourTuple<Vehicle, Amphibian, String, Integer> h() {
    return tuple(new Vehicle(), new Amphibian(), "hi", 47);
  }

  static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
    return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
  }

  static SixTuple<Vehicle, Amphibian, Float, String, Integer, Double> l() {
    return tuple(new Vehicle(), new Amphibian(), 42.1f, "hi", 47, 11.1);
  }

  public static void main(String[] args) {
    TwoTuple<String, Integer> ttsi = f();
    System.out.println(ttsi);
    // Same output, but compiler doesn't warn about issue.
    TwoTuple<String, Integer> stringIntegerTwoTuple = f2();
    System.out.println(stringIntegerTwoTuple);
    System.out.println(g());
    System.out.println(h());
    System.out.println(k());
    System.out.println(l());
  }
}
