package com.test.containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetPerformance {

  static List<Test<Set<String>>> tests = new ArrayList<>();

  static {
    tests.add(
        new Test<Set<String>>("add") {
          int test(Set<String> set, TestParam tp) {
            int loops = tp.loops;
            int size = tp.size;
            for (int i = 0; i < loops; i++) {
              set.clear();
              for (int j = 0; j < size; j++) {
                set.add(Integer.toString(j));
              }
            }
            return loops * size;
          }
        });
    tests.add(
        new Test<Set<String>>("contains") {
          int test(Set<String> set, TestParam tp) {
            int loops = tp.loops;
            int span = tp.size * 2;
            for (int i = 0; i < loops; i++) {
              for (int j = 0; j < span; j++) {
                set.contains(Integer.toString(j));
              }
            }
            return loops * span;
          }
        });
    tests.add(
        new Test<Set<String>>("iterate") {
          int test(Set<String> set, TestParam tp) {
            int loops = tp.loops * 10;
            for (int i = 0; i < loops; i++) {
              Iterator<String> it = set.iterator();
              while (it.hasNext()) {
                it.next();
              }
            }
            return loops * set.size();
          }
        });
  }

  public static void main(String[] args) {
    if (args.length > 0) {
      Tester.defaultParams = TestParam.array(args);
    }
    Tester.fieldWidth = 10;
    Tester.run(new SimpleHashSet<>(), tests);
    Tester.run(new ArraySimpleHashSet<>(), tests);
  }
}