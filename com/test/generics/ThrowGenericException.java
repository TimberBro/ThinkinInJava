package com.test.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Processor<T, E extends Exception, R extends Exception> {
  void process(List<T> resultCollector) throws E, R;
}

class ProcessRunner<T, E extends Exception, R extends Exception>
    extends ArrayList<Processor<T, E, R>> {
  List<T> processAll() throws E, R {
    List<T> resultCollector = new ArrayList<T>();
    for (Processor<T, E, R> processor : this) {
      processor.process(resultCollector);
    }
    return resultCollector;
  }
}

class Failure1 extends Exception {}

class Failure3 extends Exception {}

class Processor1 implements Processor<String, Failure1, Failure3> {
  static final Random rand = new Random(47);
  static int count = 3;

  public void process(List<String> resultCollector) throws Failure1, Failure3 {
    if (count-- > 1) {
      resultCollector.add("Hep!");
    } else {
      resultCollector.add("Ho!");
    }
    if (count < 0) {
      if (rand.nextInt(100) > 50) {
        throw new Failure3();
      } else {
        throw new Failure1();
      }
    }
  }
}

class Failure2 extends Exception {}

class Failure4 extends Exception {}

class Processor2 implements Processor<Integer, Failure2, Failure4> {
  static final Random rand = new Random(47);
  static int count = 2;

  public void process(List<Integer> resultCollector) throws Failure2, Failure4 {
    if (count-- == 0) {
      resultCollector.add(47);
    } else {
      resultCollector.add(11);
    }
    if (count < 0) {
      if (rand.nextInt(100) > 50) {
        throw new Failure4();
      } else {
        throw new Failure2();
      }
    }
  }
}

public class ThrowGenericException {
  public static void main(String[] args) {
    ProcessRunner<String, Failure1, Failure3> runner = new ProcessRunner<>();
    for (int i = 0; i < 3; i++) {
      runner.add(new Processor1());
    }
    try {
      System.out.println(runner.processAll());
    } catch (Failure1 | Failure3 e) {
      System.out.println(e);
    }

    ProcessRunner<Integer, Failure2, Failure4> runner2 = new ProcessRunner<>();
    for (int i = 0; i < 3; i++) {
      runner2.add(new Processor2());
    }
    try {
      System.out.println(runner2.processAll());
    } catch (Failure2 | Failure4 e) {
      System.out.println(e);
    }
  }
}
