package com.test.containers;

import com.test.util.CollectionData;
import com.test.util.RandomGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformance {

  static Random rand = new Random();
  static int reps = 1000;
  static List<Test<List<Integer>>> tests = new ArrayList<>();

  static {
    tests.add(new Test<List<Integer>>("sort()") {
      int test(List<Integer> list, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for (int i = 0; i < loops; i++) {
          list.clear();
          list.addAll(CollectionData.list(new RandomGenerator.Integer(), size));
        }
        Collections.sort(list);
        return loops * size;
      }
    });
  }

  static class ListTester extends Tester<List<Integer>> {

    public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
      super(container, tests);
    }

    // Fill to the appropriate size before each test:
    @Override
    protected List<Integer> initialize(int size) {
      container.clear();
      container.addAll(new CountingIntegerList(size));
      return container;
    }

    // Convenience method:
    public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
      new ListTester(list, tests).timedTest();
    }
  }

  public static void main(String[] args) {
    if (args.length > 0) {
      Tester.defaultParams = TestParam.array(args);
    }
    Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
    if (args.length > 0) {
      Tester.defaultParams = TestParam.array(args);
    }
    ListTester.run(new ArrayList<>(), tests);
    ListTester.run(new LinkedList<>(), tests);
  }
}